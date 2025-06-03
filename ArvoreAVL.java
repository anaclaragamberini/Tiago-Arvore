public class ArvoreAVL {
    private No raiz;

    public void inserir(Integer chave) {
        raiz = inserir(raiz, chave);
    }

    public void remover(Integer chave) {
        raiz = remover(raiz, chave);
    }

    public boolean buscar(Integer chave) {
        return buscar(raiz, chave);
    }

    // Imprime a árvore em ordem crescente (esquerda -> raiz -> direita)
    public void imprimir() {
        emOrdem(raiz);
        System.out.println();
    }

    private int altura(No n) {
        return n == null ? 0 : n.altura;
    }

    // Calcula o fator de balanceamento do nó (altura esquerda - altura direita)
    private int balance(No n) {
        return (n == null) ? 0 : altura(n.esquerda) - altura(n.direita);
    }

    // Atualiza a altura do nó após modificações
    private void atualizarAltura(No n) {
        n.altura = 1 + Math.max(altura(n.esquerda), altura(n.direita));
    }

    // Rotação simples à direita para rebalancear
    private No rotDir(No y) {
        No x = y.esquerda;
        y.esquerda = x.direita;
        x.direita = y;

        atualizarAltura(y);
        atualizarAltura(x);

        return x; // Novo topo da subárvore
    }

    // Rotação simples à esquerda para rebalancear
    private No rotEsq(No x) {
        No y = x.direita;
        x.direita = y.esquerda;
        y.esquerda = x;

        atualizarAltura(x);
        atualizarAltura(y);

        return y;
    }

    // Função que verifica o balanceamento do nó e realiza rotações se necessário
    private No balancear(No n) {
        atualizarAltura(n);
        int bf = balance(n);

        // Caso esquerda pesada
        if (bf > 1) {
            // Caso esquerda-direita
            if (balance(n.esquerda) < 0)
                n.esquerda = rotEsq(n.esquerda);
            return rotDir(n); // Rotação direita
        }

        // Caso direita pesada
        if (bf < -1) {
            // Caso direita-esquerda
            if (balance(n.direita) > 0)
                n.direita = rotDir(n.direita);
            return rotEsq(n); // Rotação esquerda
        }

        return n; // Nó balanceado, sem alterações
    }


    private No inserir(No n, Integer chave) {
        if (n == null) return new No(chave); // Criar nó folha

        if (chave < n.dados)
            n.esquerda = inserir(n.esquerda, chave);
        else if (chave > n.dados)
            n.direita = inserir(n.direita, chave);
        else
            return n; // Valor duplicado não é inserido

        return balancear(n); // Rebalanceia após inserção
    }


    private No remover(No n, Integer chave) {
        if (n == null) return null;

        if (chave < n.dados)
            n.esquerda = remover(n.esquerda, chave);
        else if (chave > n.dados)
            n.direita = remover(n.direita, chave);
        else {
            // Nó com zero ou um filho
            if (n.esquerda == null) return n.direita;
            if (n.direita == null) return n.esquerda;

            // Nó com dois filhos: substitui pelo menor da subárvore direita
            No temp = menor(n.direita);
            n.dados = temp.dados;
            n.direita = remover(n.direita, temp.dados);
        }

        return balancear(n); // Rebalanceia após remoção
    }

    // Encontra o nó com menor valor (mais à esquerda)
    private No menor(No n) {
        while (n.esquerda != null)
            n = n.esquerda;
        return n;
    }

    // Busca recursiva de um valor na subárvore a partir do nó n
    private boolean buscar(No n, Integer chave) {
        if (n == null) return false;

        if (chave.equals(n.dados)) return true;
        else if (chave < n.dados) return buscar(n.esquerda, chave);
        else return buscar(n.direita, chave);
    }

    // Impressão em ordem crescente (in-order traversal)
    private void emOrdem(No n) {
        if (n != null) {
            emOrdem(n.esquerda);
            System.out.print(n.dados + " ");
            emOrdem(n.direita);
        }
    }
}
