package kavvase.cgt.core

import scalaz.Equal
import scalaz.Scalaz._

case class Permutation(cycle: Map[Int, Int]) {

  require(cycle.keySet == cycle.values.toSet)

  def simplify: Permutation = Permutation.reduce(cycle)

}

object Permutation {

  private def reduce(cycle: Map[Int, Int]): Permutation = {
    Permutation(cycle.filter { case (k, v) => k != v })
  }

  implicit object PermutationEqual extends Equal[Permutation] {

    def equal(a1: Permutation, a2: Permutation): Boolean = {
      a1.simplify.cycle == a2.simplify.cycle
    }

  }

  implicit object PermutationGroup extends Group[Permutation] {

    def inverse(a: Permutation): Permutation = reduce(
      for {
        (k, v) <- a.cycle
      } yield (v, k)
    )

    def zero: Permutation = Permutation(Map.empty[Int, Int])

    def append(f1: Permutation, f2: => Permutation): Permutation = reduce(
      (for {
        (key, _) <- f1.cycle |+| f2.cycle
        image = f2.cycle.getOrElse(key, key)
        value = f1.cycle.getOrElse(image, image)
      } yield (key, value)).toMap
    )

  }

}
