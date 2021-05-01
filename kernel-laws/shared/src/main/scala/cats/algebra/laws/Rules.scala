package cats.algebra.laws

import cats.kernel._
import org.scalacheck.Prop._
import org.scalacheck.{Arbitrary, Prop}
import cats.kernel.instances.boolean._

object Rules {

  // Comparison operators for testing are supplied by CheckEqOps and
  // CheckOrderOps in package.scala. They are:
  //
  //    ?==  Ensure that x equals y
  //    ?!=  Ensure that x does not equal y
  //    ?<   Ensure that x < y
  //    ?<=  Ensure that x <= y
  //    ?>   Ensure that x > y
  //    ?>=  Ensure that x >= y
  //
  // The reason to prefer these operators is that when tests fail, we
  // will get more detaild output about what the failing values were
  // (in addition to the input values generated by ScalaCheck).

  def associativity[A: Arbitrary: Eq](f: (A, A) => A): (String, Prop) =
    "associativity" -> forAll { (x: A, y: A, z: A) =>
      f(f(x, y), z) ?== f(x, f(y, z))
    }

  def leftIdentity[A: Arbitrary: Eq](id: A)(f: (A, A) => A): (String, Prop) =
    "leftIdentity" -> forAll { (x: A) =>
      f(id, x) ?== x
    }

  def rightIdentity[A: Arbitrary: Eq](id: A)(f: (A, A) => A): (String, Prop) =
    "rightIdentity" -> forAll { (x: A) =>
      f(x, id) ?== x
    }

  def leftInverse[A: Arbitrary: Eq](id: A)(f: (A, A) => A)(inv: A => A): (String, Prop) =
    "left inverse" -> forAll { (x: A) =>
      id ?== f(inv(x), x)
    }

  def rightInverse[A: Arbitrary: Eq](id: A)(f: (A, A) => A)(inv: A => A): (String, Prop) =
    "right inverse" -> forAll { (x: A) =>
      id ?== f(x, inv(x))
    }

  def commutative[A: Arbitrary: Eq](f: (A, A) => A): (String, Prop) =
    "commutative" -> forAll { (x: A, y: A) =>
      f(x, y) ?== f(y, x)
    }

  def idempotence[A: Arbitrary: Eq](f: (A, A) => A): (String, Prop) =
    "idempotence" -> forAll { (x: A) =>
      f(x, x) ?== x
    }

  def consistentInverse[A: Arbitrary: Eq](name: String)(m: (A, A) => A)(f: (A, A) => A)(inv: A => A): (String, Prop) =
    s"consistent $name" -> forAll { (x: A, y: A) =>
      m(x, y) ?== f(x, inv(y))
    }

  def repeat0[A: Arbitrary: Eq](name: String, sym: String, id: A)(r: (A, Int) => A): (String, Prop) =
    s"$name(a, 0) == $sym" -> forAll { (a: A) =>
      r(a, 0) ?== id
    }

  def repeat1[A: Arbitrary: Eq](name: String)(r: (A, Int) => A): (String, Prop) =
    s"$name(a, 1) == a" -> forAll { (a: A) =>
      r(a, 1) ?== a
    }

  def repeat2[A: Arbitrary: Eq](name: String, sym: String)(r: (A, Int) => A)(f: (A, A) => A): (String, Prop) =
    s"$name(a, 2) == a $sym a" -> forAll { (a: A) =>
      r(a, 2) ?== f(a, a)
    }

  def collect0[A: Arbitrary: Eq](name: String, sym: String, id: A)(c: Seq[A] => A): (String, Prop) =
    s"$name(Nil) == $sym" -> forAll { (a: A) =>
      c(Nil) ?== id
    }

  def isId[A: Arbitrary: Eq](name: String, id: A)(p: A => Boolean): (String, Prop) =
    name -> forAll { (x: A) =>
      Eq.eqv(x, id) ?== p(x)
    }

  def distributive[A: Arbitrary: Eq](a: (A, A) => A)(m: (A, A) => A): (String, Prop) =
    "distributive" -> forAll { (x: A, y: A, z: A) =>
      (m(x, a(y, z)) ?== a(m(x, y), m(x, z))) &&
      (m(a(x, y), z) ?== a(m(x, z), m(y, z)))
    }

  // ugly platform-specific code follows

  def serializable[M](m: M): (String, Prop) =
    "serializable" -> (if (IsSerializable()) {
                         Prop(_ => Result(status = Proof))
                       } else {
                         Prop(_ => IsSerializable.testSerialization(m))
                       })
}
