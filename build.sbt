val scala213    = "2.13.1"
val tastyReader = "2.13.2-SNAPSHOT-withtastyreader"

lazy val `zio-demo` = (project in file("zio")).settings(
  scalaVersion        := scala213,
  libraryDependencies += "dev.zio" % "zio_2.13" % "1.0.0-RC17+184-5db6514b"
)

lazy val publishTastyReader = taskKey[Int]("Publish a local version of scala with the tasty-reader")

publishTastyReader := scala.sys.process.Process(
  Seq("sbt", """;set baseVersionSuffix in Global := "SNAPSHOT-withTASTyReader"; publishLocal"""),
  new java.io.File("community-projects/tasty-reader")
).!

ThisBuild / scalaVersion := scala213
ThisBuild / version      := "0.1.0-SNAPSHOT"
