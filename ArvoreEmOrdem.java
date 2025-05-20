public class ArvoreEmOrdem {
    No raiz;

    public void emOrdem(No node) {
        if (node == null) return;

        emOrdem(node.esquerda);
        System.out.print(node.dados + " ");
        emOrdem(node.direita);
    }
}

