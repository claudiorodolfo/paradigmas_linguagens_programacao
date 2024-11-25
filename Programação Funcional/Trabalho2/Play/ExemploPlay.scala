//http://localhost:9000
import javax.inject._
import play.api._
import play.api.mvc._

@Injectable
class HomeController @Inject()(cc: ControllerComponents) extends AbstractController(cc) {

  def index() = Action { implicit request: Request[AnyContent] =>
    Ok("Olá, Play Framework com Scala!")
  }

}
