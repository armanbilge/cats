package cats.algebra.laws

import cats.platform.Platform
import org.scalacheck.Prop
import org.scalacheck.Prop._
import scala.util.control.NonFatal
import scala.util.DynamicVariable

/**
 * Object with a dynamic variable that allows users to skip the
 * serialization tests for certain instances.
 */
private[laws] object IsSerializable {
  val runTests = new DynamicVariable[Boolean](true)
  def apply(): Boolean = Platform.isJvm && runTests.value

  def testSerialization[M](m: M): Prop.Result =
    if (Platform.isJvm) {
      import java.io._
      val baos = new ByteArrayOutputStream()
      val oos = new ObjectOutputStream(baos)
      var ois: ObjectInputStream = null // scalastyle:ignore null
      try {
        oos.writeObject(m)
        oos.close()
        val bais = new ByteArrayInputStream(baos.toByteArray())
        ois = new ObjectInputStream(bais)
        ois.readObject() // just ensure we can read it back
        ois.close()
        Result(status = Proof)
      } catch {
        case NonFatal(t) =>
          Result(status = Exception(t))
      } finally {
        oos.close()
        if (ois != null) ois.close() // scalastyle:ignore null
      }
    } else {
      Result(status = Proof)
    }
}
