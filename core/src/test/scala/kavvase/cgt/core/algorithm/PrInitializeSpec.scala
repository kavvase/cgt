package kavvase.cgt.core.algorithm

import kavvase.cgt.core.{Permutation, PrInitialize}
import org.specs2.mutable.Specification

class PrInitializeSpec extends Specification {

  "pr-initialize algorithm" should {

    import kavvase.cgt.core.cgt._

    "execute initialization for product replacement algorithm" in {
      val p0 = Permutation.PermutationGroup.zero
      val p1 = Permutation(Map(1 -> 2, 2 -> 1))
      val p2 = Permutation(Map(2 -> 3, 3 -> 2))
      val p3 = Permutation(Map(3 -> 1, 1 -> 3))
      val p4 = Permutation(Map(1 -> 2, 2 -> 3, 3 -> 1))
      val p5 = Permutation(Map(2 -> 1, 3 -> 2, 1 -> 3))

      val genSetX = Vector(p0, p1, p2, p3, p4, p5)
      val r = 10
      val n = 5

      val result = PrInitialize(genSetX, r, n).run
      result._1.length mustEqual 11
      result._2.length mustEqual 11
    }

  }

}
