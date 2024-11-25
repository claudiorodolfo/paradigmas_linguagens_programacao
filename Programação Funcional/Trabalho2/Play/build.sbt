name := "play-rest-api"

version := "1.0"

scalaVersion := "2.13.8"

libraryDependencies ++= Seq(
  guice,
  "com.typesafe.play" %% "play" % "2.8.8",
  "com.typesafe.play" %% "play-json" % "2.9.2"
)

enablePlugins(PlayScala)
