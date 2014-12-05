package kavvase.cgt.core.algorithm

import kavvase.cgt.core.{Group, PrRandom, CGTAlgorithm}

class PrRandomAlgorithm[A >: G : Group, G](implicit random: RandomAlgorithm)
  extends CGTAlgorithm[PrRandom[A]] {

  def execute(cgt: PrRandom[A]): (A, A) = ???

}
