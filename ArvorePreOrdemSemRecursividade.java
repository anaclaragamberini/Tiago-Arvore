import java.util.Stack;

public class ArvorePreOrdemSemRecursividade {
    No raiz;

    public void preOrdem(No node) {
        if (node == null) return;

        Stack<No> pilha = new Stack<>();
        pilha.push(node);

        while (!pilha.isEmpty()) {
            No atual = pilha.pop();
            System.out.print(atual.dados + " ");

            // Primeiro empilha o da direita, depois o da esquerda
            // pois a pilha é LIFO (último entra, primeiro sai)
            if (atual.direita != null) {
                pilha.push(atual.direita);
            }
            if (atual.esquerda != null) {
                pilha.push(atual.esquerda);
            }
        }
    }
}
