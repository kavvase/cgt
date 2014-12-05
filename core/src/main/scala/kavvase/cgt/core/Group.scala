package kavvase.cgt.core

import scalaz.Monoid

trait Group[A] extends Monoid[A] {

  def inverse(a: A): A

}

trait GroupSyntax {

  implicit class GroupOps[A](a: A)(implicit group: Group[A]) {

    def inverse: A = group.inverse(a)

  }

}