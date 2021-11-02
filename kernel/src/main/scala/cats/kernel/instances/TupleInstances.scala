// auto-generated boilerplate

package cats.kernel
package instances

private[kernel] trait TupleOrderInstances extends TuplePartialOrderInstances {
  implicit def catsKernelOrderForTuple1[A0](implicit A0: Order[A0]): Order[Tuple1[A0]] = new Order[Tuple1[A0]] {
    def compare(x: Tuple1[A0], y: Tuple1[A0]): Int =
      Array(A0.compare(x._1, y._1)).find(_ != 0).getOrElse(0)
  }
  implicit def catsKernelOrderForTuple2[A0, A1](implicit A0: Order[A0], A1: Order[A1]): Order[(A0, A1)] = new Order[(A0, A1)] {
    def compare(x: (A0, A1), y: (A0, A1)): Int =
      Array(A0.compare(x._1, y._1), A1.compare(x._2, y._2)).find(_ != 0).getOrElse(0)
  }
  implicit def catsKernelOrderForTuple3[A0, A1, A2](implicit A0: Order[A0], A1: Order[A1], A2: Order[A2]): Order[(A0, A1, A2)] = new Order[(A0, A1, A2)] {
    def compare(x: (A0, A1, A2), y: (A0, A1, A2)): Int =
      Array(A0.compare(x._1, y._1), A1.compare(x._2, y._2), A2.compare(x._3, y._3)).find(_ != 0).getOrElse(0)
  }
  implicit def catsKernelOrderForTuple4[A0, A1, A2, A3](implicit A0: Order[A0], A1: Order[A1], A2: Order[A2], A3: Order[A3]): Order[(A0, A1, A2, A3)] = new Order[(A0, A1, A2, A3)] {
    def compare(x: (A0, A1, A2, A3), y: (A0, A1, A2, A3)): Int =
      Array(A0.compare(x._1, y._1), A1.compare(x._2, y._2), A2.compare(x._3, y._3), A3.compare(x._4, y._4)).find(_ != 0).getOrElse(0)
  }
  implicit def catsKernelOrderForTuple5[A0, A1, A2, A3, A4](implicit A0: Order[A0], A1: Order[A1], A2: Order[A2], A3: Order[A3], A4: Order[A4]): Order[(A0, A1, A2, A3, A4)] = new Order[(A0, A1, A2, A3, A4)] {
    def compare(x: (A0, A1, A2, A3, A4), y: (A0, A1, A2, A3, A4)): Int =
      Array(A0.compare(x._1, y._1), A1.compare(x._2, y._2), A2.compare(x._3, y._3), A3.compare(x._4, y._4), A4.compare(x._5, y._5)).find(_ != 0).getOrElse(0)
  }
  implicit def catsKernelOrderForTuple6[A0, A1, A2, A3, A4, A5](implicit A0: Order[A0], A1: Order[A1], A2: Order[A2], A3: Order[A3], A4: Order[A4], A5: Order[A5]): Order[(A0, A1, A2, A3, A4, A5)] = new Order[(A0, A1, A2, A3, A4, A5)] {
    def compare(x: (A0, A1, A2, A3, A4, A5), y: (A0, A1, A2, A3, A4, A5)): Int =
      Array(A0.compare(x._1, y._1), A1.compare(x._2, y._2), A2.compare(x._3, y._3), A3.compare(x._4, y._4), A4.compare(x._5, y._5), A5.compare(x._6, y._6)).find(_ != 0).getOrElse(0)
  }
  implicit def catsKernelOrderForTuple7[A0, A1, A2, A3, A4, A5, A6](implicit A0: Order[A0], A1: Order[A1], A2: Order[A2], A3: Order[A3], A4: Order[A4], A5: Order[A5], A6: Order[A6]): Order[(A0, A1, A2, A3, A4, A5, A6)] = new Order[(A0, A1, A2, A3, A4, A5, A6)] {
    def compare(x: (A0, A1, A2, A3, A4, A5, A6), y: (A0, A1, A2, A3, A4, A5, A6)): Int =
      Array(A0.compare(x._1, y._1), A1.compare(x._2, y._2), A2.compare(x._3, y._3), A3.compare(x._4, y._4), A4.compare(x._5, y._5), A5.compare(x._6, y._6), A6.compare(x._7, y._7)).find(_ != 0).getOrElse(0)
  }
  implicit def catsKernelOrderForTuple8[A0, A1, A2, A3, A4, A5, A6, A7](implicit A0: Order[A0], A1: Order[A1], A2: Order[A2], A3: Order[A3], A4: Order[A4], A5: Order[A5], A6: Order[A6], A7: Order[A7]): Order[(A0, A1, A2, A3, A4, A5, A6, A7)] = new Order[(A0, A1, A2, A3, A4, A5, A6, A7)] {
    def compare(x: (A0, A1, A2, A3, A4, A5, A6, A7), y: (A0, A1, A2, A3, A4, A5, A6, A7)): Int =
      Array(A0.compare(x._1, y._1), A1.compare(x._2, y._2), A2.compare(x._3, y._3), A3.compare(x._4, y._4), A4.compare(x._5, y._5), A5.compare(x._6, y._6), A6.compare(x._7, y._7), A7.compare(x._8, y._8)).find(_ != 0).getOrElse(0)
  }
  implicit def catsKernelOrderForTuple9[A0, A1, A2, A3, A4, A5, A6, A7, A8](implicit A0: Order[A0], A1: Order[A1], A2: Order[A2], A3: Order[A3], A4: Order[A4], A5: Order[A5], A6: Order[A6], A7: Order[A7], A8: Order[A8]): Order[(A0, A1, A2, A3, A4, A5, A6, A7, A8)] = new Order[(A0, A1, A2, A3, A4, A5, A6, A7, A8)] {
    def compare(x: (A0, A1, A2, A3, A4, A5, A6, A7, A8), y: (A0, A1, A2, A3, A4, A5, A6, A7, A8)): Int =
      Array(A0.compare(x._1, y._1), A1.compare(x._2, y._2), A2.compare(x._3, y._3), A3.compare(x._4, y._4), A4.compare(x._5, y._5), A5.compare(x._6, y._6), A6.compare(x._7, y._7), A7.compare(x._8, y._8), A8.compare(x._9, y._9)).find(_ != 0).getOrElse(0)
  }
  implicit def catsKernelOrderForTuple10[A0, A1, A2, A3, A4, A5, A6, A7, A8, A9](implicit A0: Order[A0], A1: Order[A1], A2: Order[A2], A3: Order[A3], A4: Order[A4], A5: Order[A5], A6: Order[A6], A7: Order[A7], A8: Order[A8], A9: Order[A9]): Order[(A0, A1, A2, A3, A4, A5, A6, A7, A8, A9)] = new Order[(A0, A1, A2, A3, A4, A5, A6, A7, A8, A9)] {
    def compare(x: (A0, A1, A2, A3, A4, A5, A6, A7, A8, A9), y: (A0, A1, A2, A3, A4, A5, A6, A7, A8, A9)): Int =
      Array(A0.compare(x._1, y._1), A1.compare(x._2, y._2), A2.compare(x._3, y._3), A3.compare(x._4, y._4), A4.compare(x._5, y._5), A5.compare(x._6, y._6), A6.compare(x._7, y._7), A7.compare(x._8, y._8), A8.compare(x._9, y._9), A9.compare(x._10, y._10)).find(_ != 0).getOrElse(0)
  }
  implicit def catsKernelOrderForTuple11[A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10](implicit A0: Order[A0], A1: Order[A1], A2: Order[A2], A3: Order[A3], A4: Order[A4], A5: Order[A5], A6: Order[A6], A7: Order[A7], A8: Order[A8], A9: Order[A9], A10: Order[A10]): Order[(A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10)] = new Order[(A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10)] {
    def compare(x: (A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10), y: (A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10)): Int =
      Array(A0.compare(x._1, y._1), A1.compare(x._2, y._2), A2.compare(x._3, y._3), A3.compare(x._4, y._4), A4.compare(x._5, y._5), A5.compare(x._6, y._6), A6.compare(x._7, y._7), A7.compare(x._8, y._8), A8.compare(x._9, y._9), A9.compare(x._10, y._10), A10.compare(x._11, y._11)).find(_ != 0).getOrElse(0)
  }
  implicit def catsKernelOrderForTuple12[A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11](implicit A0: Order[A0], A1: Order[A1], A2: Order[A2], A3: Order[A3], A4: Order[A4], A5: Order[A5], A6: Order[A6], A7: Order[A7], A8: Order[A8], A9: Order[A9], A10: Order[A10], A11: Order[A11]): Order[(A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11)] = new Order[(A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11)] {
    def compare(x: (A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11), y: (A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11)): Int =
      Array(A0.compare(x._1, y._1), A1.compare(x._2, y._2), A2.compare(x._3, y._3), A3.compare(x._4, y._4), A4.compare(x._5, y._5), A5.compare(x._6, y._6), A6.compare(x._7, y._7), A7.compare(x._8, y._8), A8.compare(x._9, y._9), A9.compare(x._10, y._10), A10.compare(x._11, y._11), A11.compare(x._12, y._12)).find(_ != 0).getOrElse(0)
  }
  implicit def catsKernelOrderForTuple13[A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12](implicit A0: Order[A0], A1: Order[A1], A2: Order[A2], A3: Order[A3], A4: Order[A4], A5: Order[A5], A6: Order[A6], A7: Order[A7], A8: Order[A8], A9: Order[A9], A10: Order[A10], A11: Order[A11], A12: Order[A12]): Order[(A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12)] = new Order[(A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12)] {
    def compare(x: (A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12), y: (A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12)): Int =
      Array(A0.compare(x._1, y._1), A1.compare(x._2, y._2), A2.compare(x._3, y._3), A3.compare(x._4, y._4), A4.compare(x._5, y._5), A5.compare(x._6, y._6), A6.compare(x._7, y._7), A7.compare(x._8, y._8), A8.compare(x._9, y._9), A9.compare(x._10, y._10), A10.compare(x._11, y._11), A11.compare(x._12, y._12), A12.compare(x._13, y._13)).find(_ != 0).getOrElse(0)
  }
  implicit def catsKernelOrderForTuple14[A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13](implicit A0: Order[A0], A1: Order[A1], A2: Order[A2], A3: Order[A3], A4: Order[A4], A5: Order[A5], A6: Order[A6], A7: Order[A7], A8: Order[A8], A9: Order[A9], A10: Order[A10], A11: Order[A11], A12: Order[A12], A13: Order[A13]): Order[(A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13)] = new Order[(A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13)] {
    def compare(x: (A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13), y: (A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13)): Int =
      Array(A0.compare(x._1, y._1), A1.compare(x._2, y._2), A2.compare(x._3, y._3), A3.compare(x._4, y._4), A4.compare(x._5, y._5), A5.compare(x._6, y._6), A6.compare(x._7, y._7), A7.compare(x._8, y._8), A8.compare(x._9, y._9), A9.compare(x._10, y._10), A10.compare(x._11, y._11), A11.compare(x._12, y._12), A12.compare(x._13, y._13), A13.compare(x._14, y._14)).find(_ != 0).getOrElse(0)
  }
  implicit def catsKernelOrderForTuple15[A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14](implicit A0: Order[A0], A1: Order[A1], A2: Order[A2], A3: Order[A3], A4: Order[A4], A5: Order[A5], A6: Order[A6], A7: Order[A7], A8: Order[A8], A9: Order[A9], A10: Order[A10], A11: Order[A11], A12: Order[A12], A13: Order[A13], A14: Order[A14]): Order[(A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14)] = new Order[(A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14)] {
    def compare(x: (A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14), y: (A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14)): Int =
      Array(A0.compare(x._1, y._1), A1.compare(x._2, y._2), A2.compare(x._3, y._3), A3.compare(x._4, y._4), A4.compare(x._5, y._5), A5.compare(x._6, y._6), A6.compare(x._7, y._7), A7.compare(x._8, y._8), A8.compare(x._9, y._9), A9.compare(x._10, y._10), A10.compare(x._11, y._11), A11.compare(x._12, y._12), A12.compare(x._13, y._13), A13.compare(x._14, y._14), A14.compare(x._15, y._15)).find(_ != 0).getOrElse(0)
  }
  implicit def catsKernelOrderForTuple16[A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15](implicit A0: Order[A0], A1: Order[A1], A2: Order[A2], A3: Order[A3], A4: Order[A4], A5: Order[A5], A6: Order[A6], A7: Order[A7], A8: Order[A8], A9: Order[A9], A10: Order[A10], A11: Order[A11], A12: Order[A12], A13: Order[A13], A14: Order[A14], A15: Order[A15]): Order[(A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15)] = new Order[(A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15)] {
    def compare(x: (A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15), y: (A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15)): Int =
      Array(A0.compare(x._1, y._1), A1.compare(x._2, y._2), A2.compare(x._3, y._3), A3.compare(x._4, y._4), A4.compare(x._5, y._5), A5.compare(x._6, y._6), A6.compare(x._7, y._7), A7.compare(x._8, y._8), A8.compare(x._9, y._9), A9.compare(x._10, y._10), A10.compare(x._11, y._11), A11.compare(x._12, y._12), A12.compare(x._13, y._13), A13.compare(x._14, y._14), A14.compare(x._15, y._15), A15.compare(x._16, y._16)).find(_ != 0).getOrElse(0)
  }
  implicit def catsKernelOrderForTuple17[A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16](implicit A0: Order[A0], A1: Order[A1], A2: Order[A2], A3: Order[A3], A4: Order[A4], A5: Order[A5], A6: Order[A6], A7: Order[A7], A8: Order[A8], A9: Order[A9], A10: Order[A10], A11: Order[A11], A12: Order[A12], A13: Order[A13], A14: Order[A14], A15: Order[A15], A16: Order[A16]): Order[(A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16)] = new Order[(A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16)] {
    def compare(x: (A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16), y: (A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16)): Int =
      Array(A0.compare(x._1, y._1), A1.compare(x._2, y._2), A2.compare(x._3, y._3), A3.compare(x._4, y._4), A4.compare(x._5, y._5), A5.compare(x._6, y._6), A6.compare(x._7, y._7), A7.compare(x._8, y._8), A8.compare(x._9, y._9), A9.compare(x._10, y._10), A10.compare(x._11, y._11), A11.compare(x._12, y._12), A12.compare(x._13, y._13), A13.compare(x._14, y._14), A14.compare(x._15, y._15), A15.compare(x._16, y._16), A16.compare(x._17, y._17)).find(_ != 0).getOrElse(0)
  }
  implicit def catsKernelOrderForTuple18[A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17](implicit A0: Order[A0], A1: Order[A1], A2: Order[A2], A3: Order[A3], A4: Order[A4], A5: Order[A5], A6: Order[A6], A7: Order[A7], A8: Order[A8], A9: Order[A9], A10: Order[A10], A11: Order[A11], A12: Order[A12], A13: Order[A13], A14: Order[A14], A15: Order[A15], A16: Order[A16], A17: Order[A17]): Order[(A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17)] = new Order[(A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17)] {
    def compare(x: (A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17), y: (A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17)): Int =
      Array(A0.compare(x._1, y._1), A1.compare(x._2, y._2), A2.compare(x._3, y._3), A3.compare(x._4, y._4), A4.compare(x._5, y._5), A5.compare(x._6, y._6), A6.compare(x._7, y._7), A7.compare(x._8, y._8), A8.compare(x._9, y._9), A9.compare(x._10, y._10), A10.compare(x._11, y._11), A11.compare(x._12, y._12), A12.compare(x._13, y._13), A13.compare(x._14, y._14), A14.compare(x._15, y._15), A15.compare(x._16, y._16), A16.compare(x._17, y._17), A17.compare(x._18, y._18)).find(_ != 0).getOrElse(0)
  }
  implicit def catsKernelOrderForTuple19[A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18](implicit A0: Order[A0], A1: Order[A1], A2: Order[A2], A3: Order[A3], A4: Order[A4], A5: Order[A5], A6: Order[A6], A7: Order[A7], A8: Order[A8], A9: Order[A9], A10: Order[A10], A11: Order[A11], A12: Order[A12], A13: Order[A13], A14: Order[A14], A15: Order[A15], A16: Order[A16], A17: Order[A17], A18: Order[A18]): Order[(A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18)] = new Order[(A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18)] {
    def compare(x: (A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18), y: (A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18)): Int =
      Array(A0.compare(x._1, y._1), A1.compare(x._2, y._2), A2.compare(x._3, y._3), A3.compare(x._4, y._4), A4.compare(x._5, y._5), A5.compare(x._6, y._6), A6.compare(x._7, y._7), A7.compare(x._8, y._8), A8.compare(x._9, y._9), A9.compare(x._10, y._10), A10.compare(x._11, y._11), A11.compare(x._12, y._12), A12.compare(x._13, y._13), A13.compare(x._14, y._14), A14.compare(x._15, y._15), A15.compare(x._16, y._16), A16.compare(x._17, y._17), A17.compare(x._18, y._18), A18.compare(x._19, y._19)).find(_ != 0).getOrElse(0)
  }
  implicit def catsKernelOrderForTuple20[A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19](implicit A0: Order[A0], A1: Order[A1], A2: Order[A2], A3: Order[A3], A4: Order[A4], A5: Order[A5], A6: Order[A6], A7: Order[A7], A8: Order[A8], A9: Order[A9], A10: Order[A10], A11: Order[A11], A12: Order[A12], A13: Order[A13], A14: Order[A14], A15: Order[A15], A16: Order[A16], A17: Order[A17], A18: Order[A18], A19: Order[A19]): Order[(A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19)] = new Order[(A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19)] {
    def compare(x: (A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19), y: (A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19)): Int =
      Array(A0.compare(x._1, y._1), A1.compare(x._2, y._2), A2.compare(x._3, y._3), A3.compare(x._4, y._4), A4.compare(x._5, y._5), A5.compare(x._6, y._6), A6.compare(x._7, y._7), A7.compare(x._8, y._8), A8.compare(x._9, y._9), A9.compare(x._10, y._10), A10.compare(x._11, y._11), A11.compare(x._12, y._12), A12.compare(x._13, y._13), A13.compare(x._14, y._14), A14.compare(x._15, y._15), A15.compare(x._16, y._16), A16.compare(x._17, y._17), A17.compare(x._18, y._18), A18.compare(x._19, y._19), A19.compare(x._20, y._20)).find(_ != 0).getOrElse(0)
  }
  implicit def catsKernelOrderForTuple21[A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20](implicit A0: Order[A0], A1: Order[A1], A2: Order[A2], A3: Order[A3], A4: Order[A4], A5: Order[A5], A6: Order[A6], A7: Order[A7], A8: Order[A8], A9: Order[A9], A10: Order[A10], A11: Order[A11], A12: Order[A12], A13: Order[A13], A14: Order[A14], A15: Order[A15], A16: Order[A16], A17: Order[A17], A18: Order[A18], A19: Order[A19], A20: Order[A20]): Order[(A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20)] = new Order[(A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20)] {
    def compare(x: (A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20), y: (A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20)): Int =
      Array(A0.compare(x._1, y._1), A1.compare(x._2, y._2), A2.compare(x._3, y._3), A3.compare(x._4, y._4), A4.compare(x._5, y._5), A5.compare(x._6, y._6), A6.compare(x._7, y._7), A7.compare(x._8, y._8), A8.compare(x._9, y._9), A9.compare(x._10, y._10), A10.compare(x._11, y._11), A11.compare(x._12, y._12), A12.compare(x._13, y._13), A13.compare(x._14, y._14), A14.compare(x._15, y._15), A15.compare(x._16, y._16), A16.compare(x._17, y._17), A17.compare(x._18, y._18), A18.compare(x._19, y._19), A19.compare(x._20, y._20), A20.compare(x._21, y._21)).find(_ != 0).getOrElse(0)
  }
  implicit def catsKernelOrderForTuple22[A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21](implicit A0: Order[A0], A1: Order[A1], A2: Order[A2], A3: Order[A3], A4: Order[A4], A5: Order[A5], A6: Order[A6], A7: Order[A7], A8: Order[A8], A9: Order[A9], A10: Order[A10], A11: Order[A11], A12: Order[A12], A13: Order[A13], A14: Order[A14], A15: Order[A15], A16: Order[A16], A17: Order[A17], A18: Order[A18], A19: Order[A19], A20: Order[A20], A21: Order[A21]): Order[(A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21)] = new Order[(A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21)] {
    def compare(x: (A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21), y: (A0, A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, A16, A17, A18, A19, A20, A21)): Int =
      Array(A0.compare(x._1, y._1), A1.compare(x._2, y._2), A2.compare(x._3, y._3), A3.compare(x._4, y._4), A4.compare(x._5, y._5), A5.compare(x._6, y._6), A6.compare(x._7, y._7), A7.compare(x._8, y._8), A8.compare(x._9, y._9), A9.compare(x._10, y._10), A10.compare(x._11, y._11), A11.compare(x._12, y._12), A12.compare(x._13, y._13), A13.compare(x._14, y._14), A14.compare(x._15, y._15), A15.compare(x._16, y._16), A16.compare(x._17, y._17), A17.compare(x._18, y._18), A18.compare(x._19, y._19), A19.compare(x._20, y._20), A20.compare(x._21, y._21), A21.compare(x._22, y._22)).find(_ != 0).getOrElse(0)
  }
}
private[kernel] trait TuplePartialOrderInstances {
}
