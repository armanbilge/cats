package cats.kernel

private[kernel] trait ScalaVersionSpecificOrderInstances extends ScalaVersionSpecificPartialOrderInstances {
  implicit def catsKernelOrderForStream[A: Order]: Order[Stream[A]] =
    ???
}

private[kernel] trait ScalaVersionSpecificPartialOrderInstances extends ScalaVersionSpecificHashInstances {
  implicit def catsKernelPartialOrderForStream[A: PartialOrder]: PartialOrder[Stream[A]] =
    ???
}

private[kernel] trait ScalaVersionSpecificHashInstances extends ScalaVersionSpecificEqInstances {
  implicit def catsKernelHashForStream[A: Hash]: Hash[Stream[A]] =
    ???
}

private[kernel] trait ScalaVersionSpecificEqInstances {
  implicit def catsKernelEqForStream[A: Eq]: Eq[Stream[A]] = ???
}

private[kernel] trait ScalaVersionSpecificMonoidInstances {
  implicit def catsKernelMonoidForStream[A]: Monoid[Stream[A]] =
    ???
}
