package kavvase.cgt.core

import scalaz.Scalaz._

class AdditiveGroupCheck extends GroupCheck {

  checkAll(group.laws[Int])

}
