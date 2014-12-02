package kavvase.cgt.core.algorithm

import kavvase.cgt.core.{Random, CGTAlgorithm}

class RandomAlgorithm
  extends CGTAlgorithm[Random] {

  def execute(cgt: Random): Int = {
    cgt.l(util.Random.nextInt(cgt.l.length))
  }

}
