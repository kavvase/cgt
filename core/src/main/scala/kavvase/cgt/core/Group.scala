package kavvase.cgt.core

import scalaz.Monoid

trait Group[A] extends Monoid[A] {

  def inverse(a: A): A

  def power(a: A, n: Int): A = List.fill(n)(a).foldLeft(zero)(append(_, _))

}

trait GroupSyntax {

  implicit class GroupOps[A](a: A)(implicit group: Group[A]) {

    def inverse: A = group.inverse(a)

  }

}

case class SLP[A](x: A)

object SLP {

  implicit def SLPGroup[A : Group]: Group[SLP[A]] = new Group[SLP[A]] {

    val group = implicitly[Group[A]]

    override def inverse(a: SLP[A]): SLP[A] = SLP(group.inverse(a.x))

    override def zero: SLP[A] = SLP(group.zero)

    override def append(f1: SLP[A], f2: => SLP[A]): SLP[A] = SLP(group.append(f1.x, f2.x))

  }

}