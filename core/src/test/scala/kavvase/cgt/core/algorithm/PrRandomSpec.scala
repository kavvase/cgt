package kavvase.cgt.core.algorithm

import kavvase.cgt.core.{PrRandom, Permutation, SLP}
import org.specs2.mock.Mockito
import org.specs2.mutable.Specification

class PrRandomSpec extends Specification
  with Mockito {

  "pr-random algorithm" should {

    import kavvase.cgt.core.cgt._

    "shuffle group elements as expected" in {
      val p0 = Permutation.PermutationGroup.zero
      val p1 = Permutation(Map(1 -> 2, 2 -> 1))
      val p2 = Permutation(Map(2 -> 3, 3 -> 2))
      val p3 = Permutation(Map(3 -> 1, 1 -> 3))
      val p4 = Permutation(Map(1 -> 2, 2 -> 3, 3 -> 1))
      val p5 = Permutation(Map(2 -> 1, 3 -> 2, 1 -> 3))

      val listX0 = Vector(p0, p1, p1, p2, p2, p3, p4, p5)
      val listW0 = Vector(SLP(p0), SLP(p1), SLP(p1), SLP(p2), SLP(p2), SLP(p3), SLP(p4), SLP(p5))

      val (listX1, listW1) = PrRandom(listX0, listW0).run
      val (listX2, listW2) = PrRandom(listX1, listW1).run
      val (listX3, listW3) = PrRandom(listX2, listW2).run
      val (listX4, listW4) = PrRandom(listX3, listW3).run
      val (listX5, listW5) = PrRandom(listX4, listW4).run

      listX5.head must anyOf(p0, p1, p2, p3, p4, p5)
    }

  }

}
