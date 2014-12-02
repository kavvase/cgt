package kavvase.cgt.core.algorithm

import kavvase.cgt.core.{PrRandom, CGTAlgorithm}

class PrRandomAlgorithm[A](implicit random: RandomAlgorithm)
  extends CGTAlgorithm[PrRandom[A]] {

  def execute(cgt: PrRandom[A]): (A, A) = ???

}
