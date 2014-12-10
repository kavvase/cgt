package kavvase.cgt.core.algorithm

import kavvase.cgt.core.Random
import org.specs2.mutable.Specification

class RandomSpec extends Specification {

  "random algorithm" should {

    import kavvase.cgt.core.cgt._

    "select group element from given list" in {
      val l = Vector(1, 2, 3)

      Random(l).run must beAnyOf(1, 2, 3)
    }

  }

}
