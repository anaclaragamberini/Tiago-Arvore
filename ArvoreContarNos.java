public class Arvore {
    No raiz;

public int somarNos (No node){
    if (node == null) return 0;
    return 1 + somarNos(node.esquerda) + somarNos(node.direita);
   }
}
