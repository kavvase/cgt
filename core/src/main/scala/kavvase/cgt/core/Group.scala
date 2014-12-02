package kavvase.cgt.core

import scalaz.Monoid

trait Group[A] extends Monoid[A] {

  def inverse(a: A): A

}