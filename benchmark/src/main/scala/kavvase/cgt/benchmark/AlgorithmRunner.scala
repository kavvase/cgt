package kavvase.cgt.benchmark

import kavvase.cgt.core.{CGTAlgorithm, CGT}

abstract class AlgorithmRunner[A <: CGT] {

  val target: A

  def run(implicit algorithm: CGTAlgorithm[A]) = {
    algorithm.execute(target)
  }

}

object AlgorithmRunner {

  def apply[A <: CGT](cgt: A): AlgorithmRunner[A] = new AlgorithmRunner[A] {
    val target = cgt
  }

}