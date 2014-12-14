package kavvase.cgt.core.algorithm

import kavvase.cgt.core._

import scala.annotation.tailrec

class OrderBoundedAlgorithm[A >: G : Group, G](implicit
                                               group: Group[A],
                                               primeDivisors: PrimeDivisorsAlgorithm,
                                               power: PowerAlgorithm[A, G])
  extends CGTAlgorithm[OrderBounded[A]] {

  def execute(cgt: OrderBounded[A]): Int = {
    loopOrder(cgt.g, cgt.n)
  }

  @tailrec
  private def loopOrder(g: A, n: Int): Int = {
    if (n > 1) {
      primeDivisors.execute(PrimeDivisors(n)).find(p => power.execute(Power(g, n / p)) == group.zero) match {
        case Some(p0) => loopOrder(g, n / p0)
        case None     => n
      }
    } else 1
  }

}
