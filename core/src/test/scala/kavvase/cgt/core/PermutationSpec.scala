package kavvase.cgt.core

import org.specs2.mutable.Specification
import scalaz.Scalaz._

class PermutationSpec extends Specification {

  "permutation" should {

    "act on arbitrary element of a set" in {
      val permutation = Permutation(Map(1 -> 2, 2 -> 1))
      permutation.act(1) mustEqual 2
      permutation.act(2) mustEqual 1
      permutation.act(3) mustEqual 3
    }

    "support composition" in {
      val permutation1 = Permutation(Map(1 -> 2, 2 -> 4, 3 -> 1, 4 -> 3, 5 -> 5))
      val permutation2 = Permutation(Map(1 -> 5, 2 -> 4, 3 -> 3, 4 -> 2, 5 -> 1))
      permutation2 |+| permutation1 mustEqual Permutation(Map(1 -> 4, 3 -> 5, 4 -> 3, 5 -> 1))
    }

  }

}
