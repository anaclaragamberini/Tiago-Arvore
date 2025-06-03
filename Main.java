public class Main {
    public static void main(String[] args) {
        ArvoreAVL avl = new ArvoreAVL();


        avl.inserir(5);
        avl.inserir(3);
        avl.inserir(7);
        avl.inserir(2);
        avl.inserir(4);
        avl.inserir(6);
        avl.inserir(8);

        // Imprime os números em ordem crescente
        System.out.print("Árvore em ordem: ");
        avl.imprimir();

        avl.remover(3);

        System.out.print("Após remover 3: ");
        avl.imprimir();

        // Testa busca na árvore
        System.out.println("Existe 5? " + avl.buscar(5));   // true
        System.out.println("Existe 100? " + avl.buscar(100)); // false
    }
}
