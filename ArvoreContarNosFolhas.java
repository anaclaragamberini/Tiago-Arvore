public class ArvoreContarNosFolhas {
    No raiz;

    public int somarNosFolha() {
        return somarNosFolha(raiz);
    }

    private int somarNosFolha(No node) {
        if (node == null) return 0;

        // Se for folha (sem filhos), retorna 1
        if (node.esquerda == null && node.direita == null) {
            return 1;
        }

        // Soma folhas à esquerda e à direita
        return somarNosFolha(node.esquerda) + somarNosFolha(node.direita);
    }
}
