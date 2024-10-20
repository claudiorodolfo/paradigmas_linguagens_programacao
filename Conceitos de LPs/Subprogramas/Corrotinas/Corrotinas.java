//Java
// Java ainda não possui co-rotinas nativas, mas pode-se usar o CompletableFuture para implementar tarefas assíncronas.

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class Corrotinas {
    public static void main(String[] args) throws Exception {
        CompletableFuture<Void> tarefa1 = Tarefa1();
        CompletableFuture<Void> tarefa2 = Tarefa2();

        CompletableFuture.allOf(tarefa1, tarefa2).join();
    }

    public static CompletableFuture<Void> Tarefa1() {
        return CompletableFuture.runAsync(() -> {
            try {
                for (int i = 0; i < 3; i++) {
                    System.out.println("Tarefa 1 - execução " + (i + 1));
                    TimeUnit.SECONDS.sleep(1);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }

    public static CompletableFuture<Void> Tarefa2() {
        return CompletableFuture.runAsync(() -> {
            try {
                for (int i = 0; i < 2; i++) {
                    System.out.println("Tarefa 2 - execução " + (i + 1));
                    TimeUnit.SECONDS.sleep(2);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }
}
