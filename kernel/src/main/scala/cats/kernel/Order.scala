// package cats.kernel

// import scala.{specialized => sp}

// /**
//  * The `Order` type class is used to define a total ordering on some type `A`.
//  * An order is defined by a relation <=, which obeys the following laws:
//  *
//  * - either x <= y or y <= x (totality)
//  * - if x <= y and y <= x, then x == y (antisymmetry)
//  * - if x <= y and y <= z, then x <= z (transitivity)
//  *
//  * The truth table for compare is defined as follows:
//  *
//  * x <= y    x >= y      Int
//  * true      true        = 0     (corresponds to x == y)
//  * true      false       < 0     (corresponds to x < y)
//  * false     true        > 0     (corresponds to x > y)
//  *
//  * By the totality law, x <= y and y <= x cannot be both false.
//  */
