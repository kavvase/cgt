package kavvase.cgt.core.algorithm

import kavvase.cgt.core._

import scala.annotation.tailrec

class PrInitializeAlgorithm[A >: G : Group, G](implicit group: Group[A], prRandom: PrRandomAlgorithm[A, G])
  extends CGTAlgorithm[PrInitialize[A]] {

  def execute(cgt: PrInitialize[A]): (Vector[A], Vector[SLP[A]]) = {
    val k = cgt.genSetX.length
    val (xs, ws) = loopInitialize(cgt.genSetX, cgt.genSetX.map(SLP(_)), 0, cgt.r - k)
    loopRandom(group.zero +: xs, SLP(group.zero) +: ws, cgt.n)
  }

  @tailrec
  private def loopInitialize(xs: Vector[A], ws: Vector[SLP[A]], index: Int, maxIndex: Int): (Vector[A], Vector[SLP[A]]) = {
    if (index < maxIndex) loopInitialize(xs :+ xs(index), ws :+ ws(index), index + 1, maxIndex)
    else (xs, ws)
  }

  @tailrec
  private def loopRandom(listX: Vector[A], listW: Vector[SLP[A]], n: Int): (Vector[A], Vector[SLP[A]]) = {
    val (x, w) = prRandom.execute(PrRandom(listX, listW))
    if (n > 0) loopRandom(x, w, n - 1)
    else (x, w)
  }

}
