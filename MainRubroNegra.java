public class MainRubroNegra {
    public static void main(String[] args) {
        ArvoreRubroNegra arvore = new ArvoreRubroNegra();

        arvore.inserir(10);
        arvore.inserir(20);
        arvore.inserir(30);
        arvore.inserir(15);
        arvore.inserir(25);
        arvore.inserir(5);

        System.out.print("Árvore em ordem após inserções: ");
        arvore.imprimirEmOrdem();

        arvore.remover(20);

        System.out.print("Árvore em ordem após remoção do 20: ");
        arvore.imprimirEmOrdem();

        No buscado = arvore.buscar(15);
        System.out.println("Busca 15: " + (buscado != null ? "Encontrado" : "Não encontrado"));
    }
}
