public class ArvorePreOrdem {
    No raiz;

    public void preOrdem(No node) {
        if (node == null) return;

        System.out.print(node.dados + " ");

        preOrdem(node.esquerda);

        preOrdem(node.direita);
    }
}

