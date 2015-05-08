name := """CloudStore"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.11.1"

libraryDependencies ++= Seq(
  javaJdbc,
  javaEbean,
  cache,
  javaWs,
  javaJpa,
  javaCore,
  "org.eclipse.persistence" % "eclipselink" % "2.5.2",
  "com.fasterxml.jackson.core" % "jackson-core" % "2.5.3"
)
