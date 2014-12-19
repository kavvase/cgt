package kavvase.cgt.core

import kavvase.cgt.core.algorithm._

trait CGTAlgorithm[A <: CGT] {

  def execute(cgt: A): A#Result

}

object CGTAlgorithm {

  implicit def appendAlgorithm[A]: AppendAlgorithm[A] = new AppendAlgorithm[A]

  implicit def randomAlgorithm: RandomAlgorithm = new RandomAlgorithm

  implicit def prInitializeAlgorithm[A](implicit g: Group[A]): PrInitializeAlgorithm[A] = new PrInitializeAlgorithm[A]

  implicit def prRandomAlgorithm[A](implicit g: Group[A]): PrRandomAlgorithm[A] = new PrRandomAlgorithm[A]

  implicit def powerAlgorithm[A](implicit g: Group[A]): PowerAlgorithm[A] = new PowerAlgorithm[A]

  implicit def primeDivisorAlgorithm: PrimeDivisorsAlgorithm = new PrimeDivisorsAlgorithm

  implicit def orderBoundedAlgorithm[A](implicit g: Group[A]): OrderBoundedAlgorithm[A] = new OrderBoundedAlgorithm[A]

}

trait CGTAlgorithmSyntax {

  implicit class CGTAlgorithmOps[A <: CGT](cgt: A)(implicit algorithm: CGTAlgorithm[A]) {

    def run: A#Result = algorithm.execute(cgt)

  }

}