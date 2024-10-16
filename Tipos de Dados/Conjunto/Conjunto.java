//Java
import java.util.HashSet;
import java.util.Set;

public class Conjunto {
    public static void main(String[] args) {
        // Definindo e inicializando conjuntos
        Set<Integer> conjuntoA = new HashSet<>();
        Set<Integer> conjuntoB = new HashSet<>();

        for (int i = 1; i <= 5; i++) conjuntoA.add(i);
        for (int i = 4; i <= 8; i++) conjuntoB.add(i);

        // União
        Set<Integer> uniao = new HashSet<>(conjuntoA);
        uniao.addAll(conjuntoB);

        // Intersecção
        Set<Integer> intersecao = new HashSet<>(conjuntoA);
        intersecao.retainAll(conjuntoB);

        // Diferença
        Set<Integer> diferenca = new HashSet<>(conjuntoA);
        diferenca.removeAll(conjuntoB);

        // Exibindo resultados
        System.out.println("União: " + uniao);
        System.out.println("Intersecção: " + intersecao);
        System.out.println("Diferença: " + diferenca);
    }
}
