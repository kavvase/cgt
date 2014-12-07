package kavvase.cgt.core

import scalaz.{Equal, Monoid}

trait Group[A] extends Monoid[A] {

  def inverse(a: A): A

  def power(a: A, n: Int): A = List.fill(n)(a).foldLeft(zero)(append(_, _))

  trait GroupLaw extends MonoidLaw {
    def leftInverse(a: A)(implicit e: Equal[A]) = e.equal(append(inverse(a), a), zero)
    def rightInverse(a: A)(implicit e: Equal[A]) = e.equal(append(a, inverse(a)), zero)
    def doubleInverse(a: A)(implicit e: Equal[A]) = e.equal(inverse(inverse(a)), a)
    def inverseIdentity(implicit e: Equal[A]) = e.equal(inverse(zero), zero)
    def inverseDistrFlipped(a: A, b: A)(implicit e: Equal[A]) = e.equal(inverse(append(a, b)), append(inverse(b), inverse(a)))
  }
  def groupLaw = new GroupLaw {}

}

object Group {

  implicit def AdditiveGroup[A](implicit e: Numeric[A]): Group[A] = new Group[A] {

    import scala.math.Numeric.Implicits._

    def inverse(a: A): A = - a

    def zero: A = e.zero

    def append(f1: A, f2: => A): A = f1 + f2

  }

}

trait GroupSyntax {

  implicit class GroupOps[A](a: A)(implicit group: Group[A]) {

    def inverse: A = group.inverse(a)

  }

}

case class SLP[A](x: A)

object SLP {

  implicit def SLPGroup[A : Group](implicit group: Group[A]): Group[SLP[A]] = new Group[SLP[A]] {

    def inverse(a: SLP[A]): SLP[A] = SLP(group.inverse(a.x))

    def zero: SLP[A] = SLP(group.zero)

    def append(f1: SLP[A], f2: => SLP[A]): SLP[A] = SLP(group.append(f1.x, f2.x))

  }

}