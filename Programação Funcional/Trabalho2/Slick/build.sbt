name := "slick-example"

version := "1.0"

scalaVersion := "2.13.8"  // Versão do Scala

libraryDependencies ++= Seq(
  "com.typesafe.slick" %% "slick" % "3.3.3",  // Dependência do Slick
  "org.xerial" % "sqlite-jdbc" % "3.34.0",  // Dependência do driver SQLite
  "com.typesafe.akka" %% "akka-actor" % "2.6.18", // Dependência do Akka (opcional)
  "com.typesafe.akka" %% "akka-stream" % "2.6.18"  // Dependência do Akka Stream (opcional)
)

resolvers += "Typesafe Releases" at "https://repo.typesafe.com/typesafe/releases/"  // Repositório adicional
