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

trait EqToEquivConversion {

  /**
   * Implicitly derive a `scala.math.Equiv[A]` from a `Eq[A]`
   * instance.
   */
  implicit def catsKernelEquivForEq[A](implicit ev: Eq[A]): Equiv[A] =
    new Equiv[A] {
      def equiv(a: A, b: A) = ev.eqv(a, b)
    }
}

@suppressUnusedImportWarningForScalaVersionSpecific
object Eq
    extends EqFunctions[Eq]
    with EqToEquivConversion
    with ScalaVersionSpecificOrderInstances
    with instances.TupleOrderInstances
    with OrderInstances0 {

  /**
   * Access an implicit `Eq[A]`.
   */
  @inline final def apply[A](implicit ev: Eq[A]): Eq[A] = ev

  /**
   * Convert an implicit `Eq[B]` to an `Eq[A]` using the given
   * function `f`.
   */
  def by[@sp A, @sp B](f: A => B)(implicit ev: Eq[B]): Eq[A] =
    new Eq[A] {
      def eqv(x: A, y: A) = ev.eqv(f(x), f(y))
    }

  /**
   * Return an Eq that gives the result of the and of eq1 and eq2
   * note this is idempotent
   */
  def and[@sp A](eq1: Eq[A], eq2: Eq[A]): Eq[A] =
    new Eq[A] {
      def eqv(x: A, y: A) = eq1.eqv(x, y) && eq2.eqv(x, y)
    }

  /**
   * Return an Eq that gives the result of the or of this and that
   * Note this is idempotent
   */
  def or[@sp A](eq1: Eq[A], eq2: Eq[A]): Eq[A] =
    new Eq[A] {
      def eqv(x: A, y: A) = eq1.eqv(x, y) || eq2.eqv(x, y)
    }

  /**
   * Create an `Eq` instance from an `eqv` implementation.
   */
  def instance[A](f: (A, A) => Boolean): Eq[A] =
    new Eq[A] {
      def eqv(x: A, y: A) = f(x, y)
    }

  /**
   * An `Eq[A]` that delegates to universal equality (`==`).
   *
   * This can be useful for case classes, which have reasonable `equals`
   * implementations
   */
  def fromUniversalEquals[A]: Eq[A] =
    new Eq[A] {
      def eqv(x: A, y: A) = x == y
    }

  /**
   * Everything is the same
   */
  def allEqual[A]: Eq[A] =
    new Eq[A] {
      def eqv(x: A, y: A) = true
    }

  /**
   * This is a monoid that creates an Eq that
   * checks that all equality checks pass
   */
  def allEqualBoundedSemilattice[A]: BoundedSemilattice[Eq[A]] =
    new BoundedSemilattice[Eq[A]] {
      def empty = allEqual[A]
      def combine(e1: Eq[A], e2: Eq[A]): Eq[A] = Eq.and(e1, e2)
      override def combineAllOption(es: IterableOnce[Eq[A]]): Option[Eq[A]] =
        if (es.iterator.isEmpty) None
        else {
          val materialized = es.iterator.toVector
          Some(new Eq[A] {
            def eqv(x: A, y: A) = materialized.forall(_.eqv(x, y))
          })
        }
    }

  /**
   * This is a monoid that creates an Eq that
   * checks that at least one equality check passes
   */
  def anyEqualSemilattice[A]: Semilattice[Eq[A]] =
    new Semilattice[Eq[A]] {
      def combine(e1: Eq[A], e2: Eq[A]): Eq[A] = Eq.or(e1, e2)
      override def combineAllOption(es: IterableOnce[Eq[A]]): Option[Eq[A]] =
        if (es.iterator.isEmpty) None
        else {
          val materialized = es.iterator.toVector
          Some(new Eq[A] {
            def eqv(x: A, y: A) = materialized.exists(_.eqv(x, y))
          })
        }
    }

  implicit def catsKernelInstancesForBitSet: PartialOrder[BitSet] with Hash[BitSet] =
    ???
  implicit def catsKernelPartialOrderForSet[A]: PartialOrder[Set[A]] =
    ???
  implicit def catsKernelOrderForEither[A: Order, B: Order]: Order[Either[A, B]] =
    ???

  implicit def catsKernelInstancesForUnit: Order[Unit] with Hash[Unit] =
    ???
  implicit def catsKernelInstancesForBoolean: Order[Boolean] with Hash[Boolean] =
    ???
  implicit def catsKernelInstancesForByte: Order[Byte] with Hash[Byte] =
    ???
  implicit def catsKernelInstancesForShort: Order[Short] with Hash[Short] =
    ???
  implicit def catsKernelInstancesForInt: Order[Int] with Hash[Int] = ???
  implicit def catsKernelInstancesForLong: Order[Long] with Hash[Long] =
    ???
  implicit def catsKernelInstancesForBigInt: Order[BigInt] with Hash[BigInt] =
    ???
  implicit def catsKernelInstancesForBigDecimal: Order[BigDecimal] with Hash[BigDecimal] =
    ???
  implicit def catsKernelInstancesForDuration: Order[Duration] with Hash[Duration] =
    ???
  implicit def catsKernelInstancesForFiniteDuration: Order[FiniteDuration] with Hash[FiniteDuration] =
    ???
  implicit def catsKernelInstancesForChar: Order[Char] with Hash[Char] =
    ???
  implicit def catsKernelInstancesForSymbol: Order[Symbol] with Hash[Symbol] =
    ???
  implicit def catsKernelInstancesForString: Order[String] with Hash[String] =
    ???
  implicit def catsKernelInstancesForUUID: Order[UUID] with Hash[UUID] =
    ???
  implicit def catsKernelInstancesForDouble: Order[Double] with Hash[Double] =
    ???
  implicit def catsKernelInstancesForFloat: Order[Float] with Hash[Float] =
    ???

  implicit def catsKernelOrderForOption[A: Order]: Order[Option[A]] =
    ???
  implicit def catsKernelOrderForList[A: Order]: Order[List[A]] =
    ???
  implicit def catsKernelOrderForVector[A: Order]: Order[Vector[A]] =
    ???
  implicit def catsKernelOrderForQueue[A: Order]: Order[Queue[A]] =
    ???
  implicit def catsKernelOrderForSortedSet[A: Order]: Order[SortedSet[A]] =
    ???
  implicit def catsKernelOrderForFunction0[A: Order]: Order[() => A] =
    ???

  /**
   * you may wish to do equality by making `implicit val eqT: Eq[Throwable] = Eq.allEqual`
   * doing a fine grained equality on Throwable can make the code very execution
   * order dependent
   */
  implicit def catsStdEqForTry[A, T](implicit A: Eq[A], T: Eq[Throwable]): Eq[Try[A]] =
    new Eq[Try[A]] {
      def eqv(x: Try[A], y: Try[A]): Boolean =
        (x, y) match {
          case (Success(a), Success(b)) => A.eqv(a, b)
          case (Failure(a), Failure(b)) => T.eqv(a, b)
          case _                        => false
        }
    }
}

private[kernel] trait OrderInstances0 extends PartialOrderInstances {
  implicit def catsKernelOrderForSeq[A: Order]: Order[Seq[A]] =
    ???
}

private[kernel] trait PartialOrderInstances extends PartialOrderInstances0 {
  implicit def catsKernelPartialOrderForOption[A: PartialOrder]: PartialOrder[Option[A]] =
    ???
  implicit def catsKernelPartialOrderForList[A: PartialOrder]: PartialOrder[List[A]] =
    ???
  implicit def catsKernelPartialOrderForVector[A: PartialOrder]: PartialOrder[Vector[A]] =
    ???
  implicit def catsKernelPartialOrderForQueue[A: PartialOrder]: PartialOrder[Queue[A]] =
    ???
  implicit def catsKernelPartialOrderForFunction0[A: PartialOrder]: PartialOrder[() => A] =
    ???
}

private[kernel] trait PartialOrderInstances0 extends HashInstances {
  implicit def catsKernelPartialOrderForSeq[A: PartialOrder]: PartialOrder[Seq[A]] =
    ???
}

private[kernel] trait HashInstances extends HashInstances0 {
  implicit def catsKernelHashForSet[A]: Hash[Set[A]] = ???
  implicit def catsKernelHashForOption[A: Hash]: Hash[Option[A]] =
    ???
  implicit def catsKernelHashForList[A: Hash]: Hash[List[A]] = ???
  implicit def catsKernelHashForVector[A: Hash]: Hash[Vector[A]] =
    ???
  implicit def catsKernelHashForQueue[A: Hash]: Hash[Queue[A]] =
    ???
  implicit def catsKernelHashForSortedSet[A: Hash]: Hash[SortedSet[A]] =
    ???
  implicit def catsKernelHashForFunction0[A: Hash]: Hash[() => A] =
    ???
  implicit def catsKernelHashForMap[K: Hash, V: Hash]: Hash[Map[K, V]] =
    ???
  implicit def catsKernelHashForSortedMap[K: Hash, V: Hash]: Hash[SortedMap[K, V]] =
    ???
  implicit def catsKernelHashForEither[A: Hash, B: Hash]: Hash[Either[A, B]] =
    ???
}

private[kernel] trait HashInstances0 extends EqInstances {
  implicit def catsKernelHashForSeq[A: Hash]: Hash[Seq[A]] = ???
}

private[kernel] trait EqInstances extends EqInstances0 {
  implicit def catsKernelEqForOption[A: Eq]: Eq[Option[A]] = ???
  implicit def catsKernelEqForList[A: Eq]: Eq[List[A]] = ???
  implicit def catsKernelEqForVector[A: Eq]: Eq[Vector[A]] = ???
  implicit def catsKernelEqForQueue[A: Eq]: Eq[Queue[A]] = ???
  implicit def catsKernelEqForFunction0[A: Eq]: Eq[() => A] = ???
  implicit def catsKernelEqForMap[K, V: Eq]: Eq[Map[K, V]] = ???
  implicit def catsKernelEqForSortedMap[K, V: Eq]: Eq[SortedMap[K, V]] =
    ???
  implicit def catsKernelEqForEither[A: Eq, B: Eq]: Eq[Either[A, B]] =
    ???
}

private[kernel] trait EqInstances0 {
  implicit def catsKernelEqForSeq[A: Eq]: Eq[Seq[A]] = ???
}
