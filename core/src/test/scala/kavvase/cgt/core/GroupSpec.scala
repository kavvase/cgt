package kavvase.cgt.core

import org.specs2.mutable.Specification

class GroupSpec extends Specification {

  "power" should {

    import kavvase.cgt.core.group._

    "be equivalent to multiplication for additive group" in {
      2.power(3) mustEqual 6
      2.power(0) mustEqual 0
      2.power(-3) mustEqual -6
    }

  }

}
