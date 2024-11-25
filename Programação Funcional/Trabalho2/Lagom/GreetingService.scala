package com.example.greeting.api

import akka.actor.typed.ActorSystem
import lagom.scaladsl.api.{Descriptor, Service, ServiceCall}
import play.api.libs.streams.ActorFlow
import akka.http.scaladsl.model.StatusCodes
import akka.stream.Materializer

trait GreetingService extends Service {

  // Um simples endpoint HTTP que retorna uma saudação
  def greet(name: String): ServiceCall[NotUsed, String]

  // Para definir o serviço
  override final def descriptor: Descriptor = {
    import Service._
    named("greeting-service")
      .withCalls(
        pathCall("/api/greet/:name", greet _)
      ).withAutoAcl(true)
  }
}
