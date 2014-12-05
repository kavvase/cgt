import sbt._
import sbt.Keys._

object BuildSettings {

  lazy val basicSettings = Seq(
    scalaVersion := Dependencies.scalaVersion,
    resolvers += "sonatypeSnapshots" at "http://oss.sonatype.org/content/repositories/snapshots",
    fork in run := true,
    javaOptions in run ++= Seq("-cp",
      Attributed.data((fullClasspath in Runtime).value).mkString(":")),
    scalacOptions := Seq(
      "-encoding", "UTF-8",
      "-feature",
      "-unchecked",
      "-deprecation",
      "-language:_"))

  lazy val customLibsSettings = Seq(unmanagedBase := baseDirectory.value / "libs")

}