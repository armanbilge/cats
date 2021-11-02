// package cats.kernel

// import java.util.UUID

// import scala.collection.immutable.{BitSet, Queue, Seq, SortedMap, SortedSet}
// import scala.concurrent.duration.{Duration, FiniteDuration}
// import scala.math.Equiv
// import scala.util.{Failure, Success, Try}
// import scala.{specialized => sp}

// /**
//  * A type class used to determine equality between 2 instances of the same
//  * type. Any 2 instances `x` and `y` are equal if `eqv(x, y)` is `true`.
//  * Moreover, `eqv` should form an equivalence relation.
//  */
