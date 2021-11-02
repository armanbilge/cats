package cats.kernel

import java.util.UUID

import cats.kernel.compat.scalaVersionSpecific._

import scala.collection.immutable.{BitSet, Queue, Seq, SortedMap, SortedSet}
import scala.concurrent.duration.{Duration, FiniteDuration}
import scala.math.Equiv
import scala.util.{Failure, Success, Try}
import scala.{specialized => sp}

/**
 * A type class used to determine equality between 2 instances of the same
 * type. Any 2 instances `x` and `y` are equal if `eqv(x, y)` is `true`.
 * Moreover, `eqv` should form an equivalence relation.
 */
trait Eq[@sp A] extends Any with Serializable { self =>

  /**
   * Returns `true` if `x` and `y` are equivalent, `false` otherwise.
   */
  def eqv(x: A, y: A): Boolean

  /**
   * Returns `false` if `x` and `y` are equivalent, `true` otherwise.
   */
  def neqv(x: A, y: A): Boolean = !eqv(x, y)
}

abstract class EqFunctions[E[T] <: Eq[T]] {
  def eqv[@sp A](x: A, y: A)(implicit ev: E[A]): Boolean =
    ev.eqv(x, y)

  def neqv[@sp A](x: A, y: A)(implicit ev: E[A]): Boolean =
    ev.neqv(x, y)

}

@suppressUnusedImportWarningForScalaVersionSpecific
object Eq extends instances.TupleOrderInstances 
