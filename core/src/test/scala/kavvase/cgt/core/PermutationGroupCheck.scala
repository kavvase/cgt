package kavvase.cgt.core

import org.scalacheck.{Arbitrary, Gen}

class PermutationGroupCheck extends GroupCheck {

  implicit val arbitraryPermutation = Arbitrary {
    for {
      x <- Gen.choose(1, 10)
      y <- Gen.choose(1, 10)
    } yield Permutation(Map(x -> y, y -> x))
  }

  checkAll(group.laws[Permutation[Int]])

}
