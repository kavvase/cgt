package kavvase.cgt.core

import scalaz.Equal

case class Permutation[A](cycle: Map[A, A]) {

  require(cycle.keySet == cycle.values.toSet)

  def act(a: A): A = cycle.getOrElse(a, a)

  def simplify: Permutation[A] = Permutation.reduce(cycle)

}

object Permutation {

  private def reduce[A](cycle: Map[A, A]): Permutation[A] = {
    Permutation(cycle.filter { case (k, v) => k != v })
  }

  implicit def PermutationEqual[A]: Equal[Permutation[A]] = new Equal[Permutation[A]] {

    def equal(a1: Permutation[A], a2: Permutation[A]): Boolean = {
      a1.simplify.cycle == a2.simplify.cycle
    }

  }

  implicit def PermutationGroup[A]: Group[Permutation[A]] = new Group[Permutation[A]] {

    def inverse(a: Permutation[A]): Permutation[A] = reduce(
      for {
        (k, v) <- a.cycle
      } yield (v, k)
    )

    def zero: Permutation[A] = Permutation(Map.empty[A, A])

    def append(f1: Permutation[A], f2: => Permutation[A]): Permutation[A] = reduce(
      (for {
        key <- f1.cycle.keySet union f2.cycle.keySet
        image = f2.act(key)
        value = f1.act(image)
      } yield (key, value)).toMap
    )

  }

}
