package kavvase.cgt.core

sealed trait CGT { type Result }

case class Append[A](
  l: Vector[A],
  x: A
) extends CGT { type Result = Vector[A] }

case class Random(
  l: Vector[Int]
) extends CGT { type Result = Int }

case class PrInitialize[A](
  genSetX: Vector[A],
  r: Int,
  n: Int
) extends CGT { type Result = (Vector[A], Vector[SLP[A]]) }

case class PrRandom[A](
  listX: Vector[A],
  listW: Vector[SLP[A]]
) extends CGT { type Result = (Vector[A], Vector[SLP[A]]) }

case class Power()
  extends CGT

case class OrderBounded()
  extends CGT

case class NormalClosure()
  extends CGT

case class ImageKernel()
  extends CGT

case class Orbit()
  extends CGT

case class OrbitStabilizer()
  extends CGT

case class OrbitSv()
  extends CGT

case class UBeta()
  extends CGT

case class RandomStab()
  extends CGT

case class MinimalBlock()
  extends CGT

case class Rep()
  extends CGT

case class Merge()
  extends CGT

case class MinimalBlock2()
  extends CGT

case class Strip()
  extends CGT

case class SchereierSims()
  extends CGT

case class RemoveGens()
  extends CGT

case class ShallowOrbitSv()
  extends CGT

case class RandomSchereier()
  extends CGT

case class NormalizingGenerator()
  extends CGT

case class SNormalClosure()
  extends CGT

case class SolvableBSGS()
  extends CGT

case class NormalFormExponents()
  extends CGT

case class BaseSwap()
  extends CGT

case class NumberBlocks()
  extends CGT

case class BlockStabilizer()
  extends CGT

case class BlockImageKernel()
  extends CGT

case class PrintElements()
  extends CGT

case class SymmetricGroupElements()
  extends CGT

case class GeneralSearch()
  extends CGT

case class SubgroupSearch()
  extends CGT

case class Sylow()
  extends CGT

case class PCore()
  extends CGT
