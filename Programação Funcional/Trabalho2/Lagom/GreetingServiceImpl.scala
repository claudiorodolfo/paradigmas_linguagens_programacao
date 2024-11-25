package com.example.greeting.impl

import akka.NotUsed
import com.example.greeting.api.GreetingService
import lagom.scaladsl.api.ServiceCall
import scala.concurrent.Future

class GreetingServiceImpl extends GreetingService {

  // Implementando o método greet, que retorna uma saudação
  override def greet(name: String): ServiceCall[NotUsed, String] = ServiceCall { _ =>
    Future.successful(s"Olá, $name!")
  }
}
