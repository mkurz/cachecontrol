import Dependencies._
import sbt.Keys._
import sbt._
import sbt.plugins.JvmPlugin

object Common extends AutoPlugin {

  override def trigger = noTrigger

  override def requires = JvmPlugin

  val repoName = "cachecontrol"

  val javacParameters = Seq(
    "--release",
    "17",
    "-Xlint:deprecation",
    "-Xlint:unchecked",
  )

  val scalacParameters = Seq(
    "-release",
    "17",
    "-encoding",
    "utf8",
    "-deprecation",
    "-feature",
    "-unchecked",
    "-Xlint",
    "-Ywarn-unused:imports",
    "-Xlint:nullary-unit",
    "-Ywarn-dead-code"
  )

  override def globalSettings =
    Seq(
      organization         := "org.playframework",
      organizationName     := "The Play Framework Project",
      organizationHomepage := Some(url("https://playframework.com/")),
      homepage             := Some(url(s"https://github.com/playframework/${repoName}")),
      licenses             := Seq("Apache-2.0" -> url("https://www.apache.org/licenses/LICENSE-2.0.html")),
      scalaVersion         := Scala212,
      crossScalaVersions   := ScalaVersions,
      scalacOptions ++= scalacParameters,
      javacOptions ++= javacParameters,
      developers += Developer(
        "playframework",
        "The Play Framework Contributors",
        "contact@playframework.com",
        url("https://github.com/playframework")
      ),
      description := "Cachecontrol - Minimal HTTP cache management library in Scala"
    )

}
