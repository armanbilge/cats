package cats.kernel

import scala.collection.immutable.ArraySeq

private[kernel] trait ScalaVersionSpecificOrderInstances extends ScalaVersionSpecificPartialOrderInstances {
  @deprecated("Use catsKernelOrderForLazyList", "3.0.0")
  implicit def catsKernelOrderForStream[A: Order]: Order[Stream[A]] =
    ???

  implicit def catsKernelOrderForLazyList[A: Order]: Order[LazyList[A]] =
    ???

  implicit def catsKernelOrderForArraySeq[A: Order]: Order[ArraySeq[A]] =
    ???
}

private[kernel] trait ScalaVersionSpecificPartialOrderInstances extends ScalaVersionSpecificHashInstances {
  @deprecated("Use catsKernelPartialOrderForLazyList", "3.0.0")
  implicit def catsKernelPartialOrderForStream[A: PartialOrder]: PartialOrder[Stream[A]] =
    ???

  implicit def catsKernelPartialOrderForLazyList[A: PartialOrder]: PartialOrder[LazyList[A]] =
    ???

  implicit def catsKernelPartialOrderForArraySeq[A: PartialOrder]: PartialOrder[ArraySeq[A]] =
    ???
}

private[kernel] trait ScalaVersionSpecificHashInstances extends ScalaVersionSpecificEqInstances {
  @deprecated("Use catsKernelHashForLazyList", "3.0.0")
  implicit def catsKernelHashForStream[A: Hash]: Hash[Stream[A]] =
    ???

  implicit def catsKernelHashForLazyList[A: Hash]: Hash[LazyList[A]] =
    ???

  implicit def catsKernelHashForArraySeq[A: Hash]: Hash[ArraySeq[A]] =
    ???
}

private[kernel] trait ScalaVersionSpecificEqInstances {
  @deprecated("Use catsKernelEqForLazyList", "3.0.0")
  implicit def catsKernelEqForStream[A: Eq]: Eq[Stream[A]] = ???

  implicit def catsKernelEqForLazyList[A: Eq]: Eq[LazyList[A]] =
    ???

  implicit def catsKernelEqForArraySeq[A: Eq]: Eq[ArraySeq[A]] =
    ???
}

private[kernel] trait ScalaVersionSpecificMonoidInstances {
  @deprecated("Use catsKernelMonoidForLazyList", "3.0.0")
  implicit def catsKernelMonoidForStream[A]: Monoid[Stream[A]] =
    ???

  implicit def catsKernelMonoidForLazyList[A]: Monoid[LazyList[A]] =
    ???

  implicit def catsKernelMonoidForArraySeq[A]: Monoid[ArraySeq[A]] =
    ???
}
