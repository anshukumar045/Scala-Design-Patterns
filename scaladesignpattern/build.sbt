name := "scaladesignpattern"

version := "0.1"

scalaVersion := "2.12.18"

// https://mvnrepository.com/artifact/org.scalatest/scalatest
libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % "3.0.1" % Test,
  "com.github.scopt" %% "scopt" % "4.1.0"
)