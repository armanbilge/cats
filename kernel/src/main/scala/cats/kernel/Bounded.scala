package cats.kernel

import java.util.UUID
import scala.concurrent.duration.{Duration, FiniteDuration}
import scala.{specialized => sp}

/**
 * A type class used to name the lower limit of a type.
 */
trait LowerBounded[@sp A] {
  def partialOrder: PartialOrder[A]

  /**
   * Returns the lower limit of a type.
   */
  def minBound: A
}

trait LowerBoundedFunctions[L[T] <: LowerBounded[T]] {
  def minBound[@sp A](implicit ev: L[A]): A = ev.minBound
}

object LowerBounded extends LowerBoundedFunctions[LowerBounded] {
  @inline def apply[A](implicit l: LowerBounded[A]): LowerBounded[A] = l

  implicit def catsKernelLowerBoundedForUnit: LowerBounded[Unit] = ???
  implicit def catsKernelLowerBoundedForBoolean: LowerBounded[Boolean] =
    ???
  implicit def catsKernelLowerBoundedForByte: LowerBounded[Byte] = ???
  implicit def catsKernelLowerBoundedForInt: LowerBounded[Int] = ???
  implicit def catsKernelLowerBoundedForShort: LowerBounded[Short] =
    ???
  implicit def catsKernelLowerBoundedForLong: LowerBounded[Long] = ???
  implicit def catsKernelLowerBoundedForDuration: LowerBounded[Duration] =
    ???
  implicit def catsKernelLowerBoundedForFiniteDuration: LowerBounded[FiniteDuration] =
    ???
  implicit def catsKernelLowerBoundedForChar: LowerBounded[Char] = ???
  implicit def catsKernelLowerBoundedForString: LowerBounded[String] =
    ???
  implicit def catsKernelLowerBoundedForSymbol: LowerBounded[Symbol] =
    ???
  implicit def catsKernelLowerBoundedForUUID: LowerBounded[UUID] = ???
}

/**
 * A type class used to name the upper limit of a type.
 */
trait UpperBounded[@sp A] {
  def partialOrder: PartialOrder[A]

  /**
   * Returns the upper limit of a type.
   */
  def maxBound: A
}

trait UpperBoundedFunctions[U[T] <: UpperBounded[T]] {
  def maxBound[@sp A](implicit ev: U[A]): A = ev.maxBound
}

object UpperBounded extends UpperBoundedFunctions[UpperBounded] {
  @inline def apply[A](implicit u: UpperBounded[A]): UpperBounded[A] = u

  implicit def catsKernelUpperBoundedForUnit: UpperBounded[Unit] = ???
  implicit def catsKernelUpperBoundedForBoolean: UpperBounded[Boolean] =
    ???
  implicit def catsKernelUpperBoundedForByte: UpperBounded[Byte] = ???
  implicit def catsKernelUpperBoundedForInt: UpperBounded[Int] = ???
  implicit def catsKernelUpperBoundedForShort: UpperBounded[Short] =
    ???
  implicit def catsKernelUpperBoundedForLong: UpperBounded[Long] = ???
  implicit def catsKernelUpperBoundedForDuration: UpperBounded[Duration] =
    ???
  implicit def catsKernelUpperBoundedForFiniteDuration: UpperBounded[FiniteDuration] =
    ???
  implicit def catsKernelUpperBoundedForChar: UpperBounded[Char] = ???
  implicit def catsKernelUpperBoundedForUUID: UpperBounded[UUID] = ???
}
