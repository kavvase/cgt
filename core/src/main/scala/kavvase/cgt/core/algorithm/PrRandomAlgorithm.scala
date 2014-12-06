package kavvase.cgt.core.algorithm

import kavvase.cgt.core._

class PrRandomAlgorithm[A >: G : Group, G](implicit group: Group[A], grSlp: Group[SLP[A]], random: RandomAlgorithm)
  extends CGTAlgorithm[PrRandom[A]] {

  def execute(cgt: PrRandom[A]): (Vector[A], Vector[SLP[A]]) = {
    val r = cgt.listX.length
    val sRange = Vector.range(1, r + 1)
    val s = random.execute(Random(sRange))
    val rRange = sRange.updated(r - 1, s).updated(s - 1, r)
    val t = random.execute(Random(rRange))
    val x = random.execute(Random(Vector(1, 2)))
    val e = random.execute(Random(Vector(-1, 1)))
    val (xs, x0, ws, w0) = x match {
      case 1 => (
        group.append(cgt.listX(s), group.power(cgt.listX(t), e)),
        group.append(cgt.listX(0), cgt.listX(s)),
        grSlp.append(cgt.listW(s), grSlp.power(cgt.listW(t), e)),
        grSlp.append(cgt.listW(0), cgt.listW(s)))
      case _ => (
        group.append(cgt.listX(s), group.power(cgt.listX(t), e)),
        group.append(cgt.listX(0), cgt.listX(s)),
        grSlp.append(cgt.listW(s), grSlp.power(cgt.listW(t), e)),
        grSlp.append(cgt.listW(0), cgt.listW(s)))
    }
    (cgt.listX.updated(0, x0).updated(s, xs), cgt.listW.updated(0, w0).updated(s, ws))
  }

}
