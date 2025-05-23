public class ArvoreEmNivel {
    No raiz;

    public void emNivel(No node) {
        int altura = altura(node);
        for (int nivel = 1; nivel <= altura; nivel++) {
            imprimirNivel(node, nivel);
        }
    }

    // Calcula a altura da árvore
    private int altura(No node) {
        if (node == null) return 0;
        int alturaEsq = altura(node.esquerda);
        int alturaDir = altura(node.direita);
        return Math.max(alturaEsq, alturaDir) + 1;
    }

    // Imprime todos os nós de um nível específico
    private void imprimirNivel(No node, int nivel) {
        if (node == null) return;
        if (nivel == 1) {
            System.out.print(node.dados + " ");
        } else {
            imprimirNivel(node.esquerda, nivel - 1);
            imprimirNivel(node.direita, nivel - 1);
        }
    }
}
