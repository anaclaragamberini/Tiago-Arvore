import java.util.LinkedList;
import java.util.Queue;


public class Arvore {
    No raiz;


    public int contarNosFolha() {
        if (raiz == null) return 0;

        int folhas = 0;
        Queue<No> fila = new LinkedList<>();
        fila.add(raiz);

        while (!fila.isEmpty()) {
            No atual = fila.poll();

            // Verifica se é nó folha (sem filhos)
            if (atual.esquerda == null && atual.direita == null) {
                folhas++;
            }

            if (atual.esquerda != null) {
                fila.add(atual.esquerda);
            }
            if (atual.direita != null) {
                fila.add(atual.direita);
            }
        }

        return folhas;
    }
}
