import java.util.LinkedList;
import java.util.Queue;

public class ArvoreContarNosSemRecursividade {
        No raiz;

        public int somarNos() {
            if (raiz == null) return 0;

            int contador = 0;
            Queue<No> fila = new LinkedList<>();
            fila.add(raiz);

            while (!fila.isEmpty()) {
                No atual = fila.poll();
                contador++;

                if (atual.esquerda != null) {
                    fila.add(atual.esquerda);
                }
                if (atual.direita != null) {
                    fila.add(atual.direita);
                }
            }

            return contador;
        }
    }
