//Java
//Uso de Biblioteca
import java.util.HashMap;

public class Associativas {
    public static void main(String[] args) {
        HashMap<String, Integer> matriz = new HashMap<>();

        // Definição e inicialização
        matriz.put("um", 1);
        matriz.put("dois", 2);
        matriz.put("tres", 3);

        // Acessar elementos
        System.out.println("Valor para 'dois': " + matriz.get("dois"));

        // Remover um elemento
        matriz.remove("tres");

        // Iterar pela matriz
        for (String chave : matriz.keySet()) {
            System.out.println(chave + ": " + matriz.get(chave));
        }
    }
}
