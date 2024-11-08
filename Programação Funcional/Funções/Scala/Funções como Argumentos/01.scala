//Essa abordagem torna a função filtrarPedidos reutilizável para qualquer critério de filtragem.
object Main extends App {
    case class Pedido(id: Int, valor: Double, status: String)

    val pedidos = List(
        Pedido(1, 50, "pendente"), 
        Pedido(2, 200, "concluido"), 
        Pedido(3, 150, "pendente")
    )
    
    def filtrarPedidos(pedidos: List[Pedido], criterio: Pedido => Boolean): List[Pedido] = {
        pedidos.filter(criterio)
    }

    // Definindo critérios específicos
    val pendentes = (pedido: Pedido) => pedido.status == "pendente"
    val acimaDeCem = (pedido: Pedido) => pedido.valor > 100

    // Aplicando os critérios
    println(filtrarPedidos(pedidos, pendentes)) // Filtra os pedidos pendentes
    println(filtrarPedidos(pedidos, acimaDeCem)) // Filtra os pedidos acima de 100
}