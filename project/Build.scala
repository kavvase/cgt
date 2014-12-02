import sbt.Keys._
import sbt._

object Build extends Build {
  import BuildSettings._
  import Dependencies._

  override lazy val settings = super.settings :+ {
    shellPrompt := { s =>
      (scala.Console.CYAN + "%s > " + scala.Console.RESET) format {
        Project.extract(s).currentProject.id
      }
    }
  }
  
  lazy val cgt = Project("cgt", file("."))
    .aggregate(
      `benchmark`,
      `core`)
    .settings(basicSettings: _*)

  lazy val `benchmark` = Project("benchmark", file("benchmark"))
    .settings(basicSettings: _*)
    .dependsOn(`core`)

  lazy val `core` = Project("core", file("core"))
    .settings(basicSettings: _*)
    .settings(libraryDependencies ++= compile(scalazCore) ++ test(specs2))

}
