import sbt.Keys.libraryDependencies

import scala.collection.Seq

ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.8"

val scalactic = "org.scalactic" %% "scalactic" % "3.2.12"
val scalatest = "org.scalatest" %% "scalatest" % "3.2.12" % "test"

lazy val root = (project in file("."))
  .settings(
    name := "ScalaTests",
    libraryDependencies ++=Seq(scalactic,scalatest)
  )




