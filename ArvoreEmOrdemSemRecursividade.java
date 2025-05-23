import java.util.Stack;

public class ArvoreEmOrdemSemRecursividade {
    No raiz;

    public void emOrdem(No node) {
        Stack<No> pilha = new Stack<>();
        No atual = node;

        while (atual != null || !pilha.isEmpty()) {
            // Vai até o nó mais à esquerda
            while (atual != null) {
                pilha.push(atual);
                atual = atual.esquerda;
            }

            // Pega o nó do topo da pilha
            atual = pilha.pop();
            System.out.print(atual.dados + " ");

            // Agora visita o lado direito
            atual = atual.direita;
        }
    }
}

