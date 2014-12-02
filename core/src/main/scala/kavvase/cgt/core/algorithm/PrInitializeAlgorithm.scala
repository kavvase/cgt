package kavvase.cgt.core.algorithm

import kavvase.cgt.core.{CGTAlgorithm, PrInitialize}

class PrInitializeAlgorithm[A](implicit prRandom: PrRandomAlgorithm[A])
  extends CGTAlgorithm[PrInitialize[A]] {

  def execute(cgt: PrInitialize[A]): (List[A], List[A]) = ???

}
