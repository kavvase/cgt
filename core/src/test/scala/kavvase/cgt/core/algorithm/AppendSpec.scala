package kavvase.cgt.core.algorithm

import kavvase.cgt.core.Append
import org.specs2.mutable.Specification

class AppendSpec extends Specification {

  "append algorithm" should {

    import kavvase.cgt.core.cgt._

    "append new element to given list" in {
      val l = Vector(1, 2, 3)
      val x = 4

      Append(l, x).run mustEqual Vector(1, 2, 3, 4)
    }

  }

}
