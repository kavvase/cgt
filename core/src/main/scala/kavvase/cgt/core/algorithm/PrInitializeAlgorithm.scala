package kavvase.cgt.core.algorithm

import kavvase.cgt.core.{CGTAlgorithm, Group, PrInitialize}

class PrInitializeAlgorithm[A >: G : Group, G](implicit prRandom: PrRandomAlgorithm[A, G])
  extends CGTAlgorithm[PrInitialize[A]] {

  def execute(cgt: PrInitialize[A]): (List[A], List[A]) = ???

}
