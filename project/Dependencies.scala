import sbt._

object Dependencies {

  val scalaVersion = "2.11.4"

  def compile   (deps: ModuleID*): Seq[ModuleID] = deps map (_ % "compile")
  def provided  (deps: ModuleID*): Seq[ModuleID] = deps map (_ % "provided")
  def test      (deps: ModuleID*): Seq[ModuleID] = deps map (_ % "test")

  val caliper    = "com.google.caliper"  % "caliper"     % "1.0-beta-1"
  val jerseyCore = "com.sun.jersey"      % "jersey-core" % "1.11"
  val scalazCore = "org.scalaz"         %% "scalaz-core" % "7.1.0"
  val specs2     = "org.specs2"         %% "specs2"      % "2.4"

}