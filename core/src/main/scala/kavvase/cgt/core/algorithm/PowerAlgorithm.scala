package kavvase.cgt.core.algorithm

import kavvase.cgt.core.{CGTAlgorithm, Group, Power}

import scala.annotation.tailrec

class PowerAlgorithm[A >: G : Group, G](implicit group: Group[A])
  extends CGTAlgorithm[Power[A]] {

  def execute(cgt: Power[A]): A = {
    val x = cgt.n % 2 match {
      case 1 => cgt.g
      case _ => group.zero
    }
    loopPower(x, cgt.g, cgt.n)
  }

  @tailrec
  private def loopPower(x: A, g: A, n: Int): A = {
    if (n > 1) {
      val g1 = group.power(g, 2)
      val n1 = n / 2
      n1 % 2 match {
        case 1 => loopPower(group.append(x, g1), g1, n1)
        case _ => loopPower(x, g1, n1)
      }
    } else x
  }

}
