name := "lagom-example"

version := "1.0"

scalaVersion := "2.13.8"

lazy val root = (project in file("."))
  .enablePlugins(LagomPlugin)
  .settings(
    name := "lagom-example",
    libraryDependencies ++= Seq(
      lagom.scaladsl.api,                // Dependência para a API do Lagom
      lagom.scaladsl.client,             // Dependência para o cliente do Lagom
      lagom.scaladsl.testkit,            // Dependência para testes
      "com.typesafe.akka" %% "akka-actor-typed" % "2.6.14", // Dependência para o Akka
      "com.typesafe.akka" %% "akka-http" % "10.2.6",      // Dependência para comunicação HTTP
      "org.scala-lang.modules" %% "scala-parser-combinators" % "1.1.2", // Dependência para Lagom
      "com.typesafe.akka" %% "akka-stream" % "2.6.14"     // Dependência para processamento reativo com Akka Streams
    ),
    resolvers += "Typesafe repository" at "https://repo.typesafe.com/typesafe/releases/"
  )
