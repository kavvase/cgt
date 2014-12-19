package kavvase.cgt.core.algorithm

import kavvase.cgt.core._

class PrRandomAlgorithm[A](implicit group: Group[A], grSlp: Group[SLP[A]], random: RandomAlgorithm)
  extends CGTAlgorithm[PrRandom[A]] {

  def execute(cgt: PrRandom[A]): (Vector[A], Vector[SLP[A]]) = {
    val r = cgt.listX.length
    val sRange = Vector.range(1, r)
    val s = random.execute(Random(sRange))
    val rRange = sRange.updated(s - 1, r - 1).take(r - 2)
    val t = random.execute(Random(rRange))
    val x = random.execute(Random(Vector(1, 2)))
    val e = random.execute(Random(Vector(-1, 1)))
    val (xs, x0, ws, w0) = x match {
      case 1 => (
        group.append(cgt.listX(s), group.power(cgt.listX(t), e)),
        group.append(cgt.listX(0), cgt.listX(s)),
        grSlp.append(cgt.listW(s), grSlp.power(cgt.listW(t), e)),
        grSlp.append(cgt.listW(0), cgt.listW(s)))
      case 2 => (
        group.append(group.power(cgt.listX(t), e), cgt.listX(s)),
        group.append(cgt.listX(s), cgt.listX(0)),
        grSlp.append(grSlp.power(cgt.listW(t), e), cgt.listW(s)),
        grSlp.append(cgt.listW(s), cgt.listW(0)))
    }
    (cgt.listX.updated(0, x0).updated(s, xs), cgt.listW.updated(0, w0).updated(s, ws))
  }

}
