package kavvase.cgt.core.algorithm

import kavvase.cgt.core.{PrRandom, SLP}
import org.specs2.mock.Mockito
import org.specs2.mutable.Specification

class PrRandomSpec extends Specification
  with Mockito {

  "pr-random algorithm" should {

    import kavvase.cgt.core.cgt._

    "shuffle group elements as expected" in {
      val listX = Vector(0)
      val listW = Vector(SLP(0))

      PrRandom(listX, listW).run mustEqual (Vector(0), Vector(SLP(0)))
    }

  }

}
