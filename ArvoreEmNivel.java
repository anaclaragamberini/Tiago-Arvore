import java.util.LinkedList;
import java.util.Queue;

public class ArvoreEmNivel {
    No raiz;
    

    public void emNivel(No node) {
        if (node == null) return;

        Queue<No> fila = new LinkedList<>();
        fila.add(node);

        while (!fila.isEmpty()) {
            No atual = fila.poll();
            System.out.print(atual.dados + " ");

            if (atual.esquerda != null) fila.add(atual.esquerda);
            if (atual.direita != null) fila.add(atual.direita);
        }
    }
}

