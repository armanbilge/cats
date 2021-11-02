import cats.kernel.Eq
import cats.kernel.Order

trait EqSyntax {
  implicit def catsSyntaxEq[A: Eq](a: A): EqOps[A] = ???
}

final class EqOps[A]

object eq extends EqSyntax

import eq.*

sealed abstract class Foo[A]
object Foo:
  given [A: Eq]: Eq[Foo[A]] = ???

opaque type FooT[F[_], A] = F[Foo[A]]
object FooT:
  def liftF[F[_], A](fa: F[A]): FooT[F, A] =
    fa.map(???)

  extension [F[_], A](ffa: FooT[F, A])
    def map[B](f: A => B): FooT[F, B] =
      ???
  
  given [F[_], A](using Ord: Order[F[Foo[A]]]): Order[FooT[F, A]] = ???  
