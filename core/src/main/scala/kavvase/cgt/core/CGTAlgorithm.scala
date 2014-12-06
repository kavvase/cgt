package kavvase.cgt.core

import kavvase.cgt.core.algorithm.{PrInitializeAlgorithm, PrRandomAlgorithm, AppendAlgorithm, RandomAlgorithm}

trait CGTAlgorithm[A <: CGT] {

  def execute(cgt: A): A#Result

}

object CGTAlgorithm {

  implicit def appendAlgorithm[A]: AppendAlgorithm[A] = new AppendAlgorithm[A]

  implicit def randomAlgorithm: RandomAlgorithm = new RandomAlgorithm

  implicit def prInitializeAlgorithm[A >: G : Group, G]: PrInitializeAlgorithm[A, G] = new PrInitializeAlgorithm[A, G]

  implicit def prRandomAlgorithm[A >: G : Group, G]: PrRandomAlgorithm[A, G] = new PrRandomAlgorithm[A, G]

}

trait CGTAlgorithmSyntax {

  implicit class CGTAlgorithmOps[A <: CGT](cgt: A)(implicit algorithm: CGTAlgorithm[A]) {

    def run: A#Result = algorithm.execute(cgt)

  }

}