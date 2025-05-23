import java.util.Stack;

public class ArvorePosOrdemSemRecursividade {
    No raiz;

    public void posOrdem(No node) {
        if (node == null) return;

        Stack<No> pilha1 = new Stack<>();
        Stack<No> pilha2 = new Stack<>();

        pilha1.push(node);

        while (!pilha1.isEmpty()) {
            No atual = pilha1.pop();
            pilha2.push(atual);

            // Empilha esquerda e direita na pilha1
            if (atual.esquerda != null) pilha1.push(atual.esquerda);
            if (atual.direita != null) pilha1.push(atual.direita);
        }

        // Imprime na ordem pós-ordem (reverte a ordem)
        while (!pilha2.isEmpty()) {
            System.out.print(pilha2.pop().dados + " ");
        }
    }
}
