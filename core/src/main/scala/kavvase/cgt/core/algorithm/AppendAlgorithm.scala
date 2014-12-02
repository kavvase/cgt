package kavvase.cgt.core.algorithm

import kavvase.cgt.core.{CGTAlgorithm, Append}

class AppendAlgorithm[A]
  extends CGTAlgorithm[Append[A]] {

  def execute(cgt: Append[A]): List[A] = {
    cgt.l :+ cgt.x
  }

}
