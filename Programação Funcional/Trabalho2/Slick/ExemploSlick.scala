//Para BD SQLite
import slick.jdbc.SQLiteProfile.api._
import scala.concurrent.{Await, Future}
import scala.concurrent.duration._
import slick.lifted.Tag
import slick.jdbc.JdbcBackend.Database

// Definir o modelo da tabela usando Slick
class Usuarios(tag: Tag) extends Table[(Int, String, String)](tag, "USUARIOS") {
  def id = column[Int]("ID", O.PrimaryKey, O.AutoInc)
  def nome = column[String]("NOME")
  def email = column[String]("EMAIL")

  def * = (id, nome, email)
}

object Main extends App {
  
  // Criando o banco de dados em memória com SQLite
  val db = Database.forConfig("sqlite")

  // Definindo a tabela de usuários
  val usuarios = TableQuery[Usuarios]

  // Função para criar a tabela no banco de dados
  def criarTabela(): Future[Unit] = db.run(DBIO.seq(
    usuarios.schema.createIfNotExists
  ))

  // Função para inserir um usuário no banco de dados
  def inserirUsuario(nome: String, email: String): Future[Int] = {
    val usuario = (0, nome, email)
    val action = usuarios.returning(usuarios.map(_.id)) += usuario
    db.run(action)
  }

  // Função para consultar todos os usuários
  def consultarUsuarios(): Future[Seq[(Int, String, String)]] = {
    db.run(usuarios.result)
  }

  // Função para rodar as operações de exemplo
  def executarExemplo(): Unit = {
    // Criar a tabela
    val criar = criarTabela()
    
    // Esperar a criação da tabela
    Await.result(criar, 2.seconds)
    
    // Inserir dados
    val idInserido = Await.result(inserirUsuario("João", "joao@email.com"), 2.seconds)
    println(s"Usuário inserido com ID: $idInserido")
    
    // Consultar usuários
    val usuariosConsultados = Await.result(consultarUsuarios(), 2.seconds)
    println("Usuários no banco de dados:")
    usuariosConsultados.foreach {
      case (id, nome, email) => println(s"ID: $id, Nome: $nome, Email: $email")
    }
  }

  // Executando as operações
  executarExemplo()
}