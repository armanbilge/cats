/*
 * Copyright (c) 2015 Typelevel
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of
 * this software and associated documentation files (the "Software"), to deal in
 * the Software without restriction, including without limitation the rights to
 * use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of
 * the Software, and to permit persons to whom the Software is furnished to do so,
 * subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
 * FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
 * COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER
 * IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN
 * CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package cats
package instances

import org.typelevel.scalaccompat.annotation.threadUnsafe3

import scala.annotation.tailrec

trait EqInstances extends kernel.instances.EqInstances {
  implicit val catsContravariantMonoidalForEq: ContravariantMonoidal[Eq] =
    new ContravariantMonoidal[Eq] {

      /**
       * Defaults to the trivial equivalence relation
       * contracting the type to a point
       */
      def unit: Eq[Unit] = Eq.allEqual

      /**
       * Derive an `Eq` for `B` given an `Eq[A]` and a function `B => A`.
       *
       * Note: resulting instances are law-abiding only when the functions used are injective (represent a one-to-one mapping)
       */
      def contramap[A, B](fa: Eq[A])(f: B => A): Eq[B] =
        Eq.by(f)(fa)

      def product[A, B](fa: Eq[A], fb: Eq[B]): Eq[(A, B)] =
        (left, right) => fa.eqv(left._1, right._1) && fb.eqv(left._2, right._2)
    }

  implicit def catsDeferForEq: Defer[Eq] = EqInstances.catsDeferForEqCache
}
object EqInstances {
  private val catsDeferForEqCache: Defer[Eq] =
    new Defer[Eq] {
      case class Deferred[A](fa: () => Eq[A]) extends Eq[A] {
        @threadUnsafe3
        private lazy val resolved: Eq[A] = {
          @tailrec
          def loop(f: () => Eq[A]): Eq[A] =
            f() match {
              case Deferred(f) => loop(f)
              case next        => next
            }

          loop(fa)
        }
        override def eqv(x: A, y: A): Boolean = resolved.eqv(x, y)
      }

      override def defer[A](fa: => Eq[A]): Eq[A] = {
        @threadUnsafe3 lazy val cachedFa = fa
        Deferred(() => cachedFa)
      }
    }
}
