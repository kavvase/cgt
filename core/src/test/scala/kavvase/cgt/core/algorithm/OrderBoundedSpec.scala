package kavvase.cgt.core.algorithm

import kavvase.cgt.core.{OrderBounded, Permutation}
import org.specs2.mutable.Specification

class OrderBoundedSpec extends Specification {

  "order-bounded algorithm" should {

    import kavvase.cgt.core.cgt._

    "calculate order of group element g" in {
      val g0 = Permutation.PermutationGroup.zero
      val g1 = Permutation(Map(1 -> 2, 2 -> 1))
      val g2 = Permutation(Map(2 -> 3, 3 -> 2))
      val g3 = Permutation(Map(3 -> 1, 1 -> 3))
      val g4 = Permutation(Map(1 -> 2, 2 -> 3, 3 -> 1))
      val g5 = Permutation(Map(2 -> 1, 3 -> 2, 1 -> 3))

      val n = 6

      OrderBounded(g0, n).run mustEqual 1
      OrderBounded(g1, n).run mustEqual 2
      OrderBounded(g2, n).run mustEqual 2
      OrderBounded(g3, n).run mustEqual 2
      OrderBounded(g4, n).run mustEqual 3
      OrderBounded(g5, n).run mustEqual 3
    }

  }

}
