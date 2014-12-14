package kavvase.cgt.core.algorithm

import kavvase.cgt.core.{CGTAlgorithm, PrimeDivisors}

import scala.annotation.tailrec

class PrimeDivisorsAlgorithm
  extends CGTAlgorithm[PrimeDivisors] {

  def execute(cgt: PrimeDivisors): List[Int] = {
    loopPrime(cgt.n, Nil)
  }

  @tailrec
  private def loopPrime(n: Int, acc: List[Int]): List[Int] = {
    Stream.from(2).take(n - 1).find(n % _ == 0) match {
      case Some(m) => loopPrime(n / m, m :: acc)
      case None    => acc
    }
  }

}
