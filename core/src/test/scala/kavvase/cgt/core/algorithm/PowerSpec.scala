package kavvase.cgt.core.algorithm

import kavvase.cgt.core.{Permutation, Power}
import org.specs2.mutable.Specification

class PowerSpec extends Specification {

  "power algorithm" should {

    import kavvase.cgt.core.cgt._
    import kavvase.cgt.core.group._

    "calculate n-th power of group element g" in {
      val g1 = 2
      val n1 = 5

      Power(g1, n1).run mustEqual g1.power(n1)

      val g2 = Permutation(Map(1 -> 2, 2 -> 3, 3 -> 1))
      val n2 = 5
      Power(g2, n2).run mustEqual g2.power(n2)
    }

  }

}
