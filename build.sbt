lazy val root = project
  .in(file("."))
  .settings(
    name := "udemy-scala-beginners-empty",
    description := "Example sbt project that compiles using Scala 3",
    version := "0.1.0",
    scalaVersion := "3.6.4",
    scalacOptions ++= Seq("-deprecation"),
    libraryDependencies += "org.scalameta" %% "munit" % "1.1.1" % Test
  )