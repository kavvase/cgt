package kavvase.cgt.core

import org.scalacheck.Prop._
import org.scalacheck.{Arbitrary, Prop, Properties}
import org.specs2.scalaz.Spec

import scalaz.Equal
import scalaz.scalacheck.ScalazProperties.monoid

trait GroupCheck extends Spec {

  object group {

    def leftInverse[A](implicit A: Group[A], eqa: Equal[A], arb: Arbitrary[A]) = forAll(A.groupLaw.leftInverse _)

    def rightInverse[A](implicit A: Group[A], eqa: Equal[A], arb: Arbitrary[A]) = forAll(A.groupLaw.rightInverse _)

    def doubleInverse[A](implicit A: Group[A], eqa: Equal[A], arb: Arbitrary[A]) = forAll(A.groupLaw.doubleInverse _)

    def inverseIdentity[A](implicit A: Group[A], eqa: Equal[A]): Prop = A.groupLaw.inverseIdentity

    def inverseDistrFlipped[A](implicit A: Group[A], eqa: Equal[A], arb: Arbitrary[A]) = forAll(A.groupLaw.inverseDistrFlipped _)

    def laws[A](implicit A: Group[A], eqa: Equal[A], arb: Arbitrary[A]) = new Properties("group") {
      include(monoid.laws[A])
      property("left inverse") = leftInverse[A]
      property("right inverse") = rightInverse[A]
      property("double inverse") = doubleInverse[A]
      property("inverse identity") = inverseIdentity[A]
      property("inverse distr flipped") = inverseDistrFlipped[A]
    }

  }

}
