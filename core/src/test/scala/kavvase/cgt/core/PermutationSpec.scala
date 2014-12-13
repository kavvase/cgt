package kavvase.cgt.core

import org.specs2.mutable.Specification
import scalaz.Scalaz._

class PermutationSpec extends Specification {

  "permutation" should {

    "support composition" in {
      val permutation1 = Permutation(Map(1 -> 2, 2 -> 4, 3 -> 1, 4 -> 3, 5 -> 5))
      val permutation2 = Permutation(Map(1 -> 5, 2 -> 4, 3 -> 3, 4 -> 2, 5 -> 1))
      permutation2 |+| permutation1 mustEqual Permutation(Map(1 -> 4, 3 -> 5, 4 -> 3, 5 -> 1))
    }

  }

}
