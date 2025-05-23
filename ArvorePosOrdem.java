public class ArvorePosOrdem {
    No raiz;

    public void posOrdem(No node) {
        if (node == null) return;

        posOrdem(node.esquerda);
        posOrdem(node.direita);
        System.out.print(node.dados + " ");
    }
}
