//http://localhost:9000
//Testar
//Listar todos os usuários
//GET http://localhost:9000/users

//Obter usuario com id 1
//GET http://localhost:9000/users/1

import javax.inject._
import play.api.mvc._
import play.api.libs.json._
import models.User

@Singleton
class UserController @Inject()(cc: ControllerComponents) extends AbstractController(cc) {

  // Dados simulados, no mundo real, você usaria um banco de dados
  var users: List[User] = List(
    User(1, "Alice", "alice@example.com"),
    User(2, "Bob", "bob@example.com")
  )

  // Método para converter a classe User para JSON
  implicit val userFormat: OFormat[User] = Json.format[User]

  // Endpoint para listar todos os usuários
  def getAllUsers = Action {
    Ok(Json.toJson(users))
  }

  // Endpoint para obter um usuário específico pelo id
  def getUser(id: Long) = Action {
    users.find(_.id == id) match {
      case Some(user) => Ok(Json.toJson(user))
      case None => NotFound(Json.obj("message" -> "User not found"))
    }
  }
}