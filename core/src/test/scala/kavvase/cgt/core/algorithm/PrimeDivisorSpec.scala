package kavvase.cgt.core.algorithm

import kavvase.cgt.core.PrimeDivisors
import org.specs2.mutable.Specification

class PrimeDivisorSpec extends Specification {

  "prime-divisors algorithm" should {

    import kavvase.cgt.core.cgt._

    "calculate the prime divisors of given number" in {
      val n = 756

      PrimeDivisors(n).run must contain(exactly(2, 2, 3, 3, 3, 7))
    }

  }

}
