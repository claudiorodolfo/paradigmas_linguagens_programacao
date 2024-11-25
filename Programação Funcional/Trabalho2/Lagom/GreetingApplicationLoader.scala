//http://localhost:9000

package com.example

import com.example.greeting.api.GreetingService
import com.example.greeting.impl.GreetingServiceImpl
import lagom.scaladsl.application.LagomApplicationContext
import lagom.scaladsl.application.LagomApplication
import lagom.scaladsl.server.{LagomApplicationLoader, LagomServerComponents}
import play.api.libs.ws.ahc.AhcWSComponents
import play.api.routing.Router
import play.api.routing.sird._

class GreetingApplicationLoader extends LagomApplicationLoader {
  override def load(context: LagomApplicationContext): LagomApplication = new GreetingApplication(context)
}

class GreetingApplication(context: LagomApplicationContext) extends LagomApplication(context) with LagomServerComponents with AhcWSComponents {

  // Carregar o serviço e expô-lo via HTTP
  override lazy val lagomServer = serverFor[GreetingService](new GreetingServiceImpl)

  // Roteamento opcional
  override def router: Router = {
    import play.api.mvc._
    import play.api.routing.sird._
    // Aqui você pode configurar rotas adicionais se necessário
    Router.from {
      case GET(p"/api/greet/$name") => Action {
        Ok(s"Olá, $name!")
      }
    }
  }
}
