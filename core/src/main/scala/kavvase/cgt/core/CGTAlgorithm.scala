package kavvase.cgt.core

import kavvase.cgt.core.algorithm.{PrRandomAlgorithm, PrInitializeAlgorithm, RandomAlgorithm, AppendAlgorithm}

trait CGTAlgorithm[A <: CGT] {

  def execute(cgt: A): A#Result

}

object CGTAlgorithm {

  implicit def appendAlgorithm[A]: AppendAlgorithm[A] = new AppendAlgorithm[A]

  implicit def randomAlgorithm: RandomAlgorithm = new RandomAlgorithm

  implicit def prInitializeAlgorithm[A]: PrInitializeAlgorithm[A] = new PrInitializeAlgorithm[A]

  implicit def prRandomAlgorithm[A]: PrRandomAlgorithm[A] = new PrRandomAlgorithm[A]

}