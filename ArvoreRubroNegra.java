public class ArvoreRubroNegra {
    private No raiz;

    public void inserir(int dado) {
        No novo = new No(dado);
        inserirBST(novo);
        fixInsercao(novo);
    }

    // Inserção na BST normal (sem balanceamento)
    private void inserirBST(No novo) {
        No y = null;
        No x = raiz;

        while (x != null) {
            y = x;
            if (novo.dado < x.dado)
                x = x.esquerda;
            else
                x = x.direita;
        }

        novo.pai = y;
        if (y == null)
            raiz = novo;
        else if (novo.dado < y.dado)
            y.esquerda = novo;
        else
            y.direita = novo;
    }

    // Corrigir propriedades após inserção
    private void fixInsercao(No z) {
        while (z.pai != null && z.pai.cor == CorRubroNegra.VERMELHO) {
            if (z.pai == z.pai.pai.esquerda) {
                No y = z.pai.pai.direita;
                if (y != null && y.cor == CorRubroNegra.VERMELHO) {
                    z.pai.cor = CorRubroNegra.PRETO;
                    y.cor = CorRubroNegra.PRETO;
                    z.pai.pai.cor = CorRubroNegra.VERMELHO;
                    z = z.pai.pai;
                } else {
                    if (z == z.pai.direita) {
                        z = z.pai;
                        rotacaoEsquerda(z);
                    }
                    z.pai.cor = CorRubroNegra.PRETO;
                    z.pai.pai.cor = CorRubroNegra.VERMELHO;
                    rotacaoDireita(z.pai.pai);
                }
            } else {
                No y = z.pai.pai.esquerda;
                if (y != null && y.cor == CorRubroNegra.VERMELHO) {
                    z.pai.cor = CorRubroNegra.PRETO;
                    y.cor = CorRubroNegra.PRETO;
                    z.pai.pai.cor = CorRubroNegra.VERMELHO;
                    z = z.pai.pai;
                } else {
                    if (z == z.pai.esquerda) {
                        z = z.pai;
                        rotacaoDireita(z);
                    }
                    z.pai.cor = CorRubroNegra.PRETO;
                    z.pai.pai.cor = CorRubroNegra.VERMELHO;
                    rotacaoEsquerda(z.pai.pai);
                }
            }
        }
        raiz.cor = CorRubroNegra.PRETO;
    }

    public No buscar(int valor) {
        return buscar(raiz, valor);
    }

    private No buscar(No no, int valor) {
        if (no == null || no.dado == valor)
            return no;
        if (valor < no.dado)
            return buscar(no.esquerda, valor);
        else
            return buscar(no.direita, valor);
    }

    private void transplantar(No u, No v) {
        if (u.pai == null) {
            raiz = v;
        } else if (u == u.pai.esquerda) {
            u.pai.esquerda = v;
        } else {
            u.pai.direita = v;
        }
        if (v != null) {
            v.pai = u.pai;
        }
    }

    private No minimo(No no) {
        while (no.esquerda != null) {
            no = no.esquerda;
        }
        return no;
    }

    // Remover nó com rebalanceamento
    public void remover(int valor) {
        No z = buscar(raiz, valor);
        if (z == null) return;

        No y = z;
        CorRubroNegra yOriginalCor = y.cor;
        No x;
        No xPai;

        if (z.esquerda == null) {
            x = z.direita;
            xPai = z.pai;
            transplantar(z, z.direita);
        } else if (z.direita == null) {
            x = z.esquerda;
            xPai = z.pai;
            transplantar(z, z.esquerda);
        } else {
            y = minimo(z.direita);
            yOriginalCor = y.cor;
            x = y.direita;
            if (y.pai == z) {
                xPai = y;
                if (x != null) x.pai = y;
            } else {
                transplantar(y, y.direita);
                y.direita = z.direita;
                y.direita.pai = y;
                xPai = y.pai;
            }
            transplantar(z, y);
            y.esquerda = z.esquerda;
            y.esquerda.pai = y;
            y.cor = z.cor;
        }

        if (yOriginalCor == CorRubroNegra.PRETO) {
            fixRemocao(x, xPai);
        }
    }

    private void fixRemocao(No x, No parent) {
        while (x != raiz && (x == null || x.cor == CorRubroNegra.PRETO)) {
            if (x == parent.esquerda) {
                No w = parent.direita;
                if (w != null && w.cor == CorRubroNegra.VERMELHO) {
                    w.cor = CorRubroNegra.PRETO;
                    parent.cor = CorRubroNegra.VERMELHO;
                    rotacaoEsquerda(parent);
                    w = parent.direita;
                }
                if ((w.esquerda == null || w.esquerda.cor == CorRubroNegra.PRETO) &&
                        (w.direita == null || w.direita.cor == CorRubroNegra.PRETO)) {
                    if (w != null) w.cor = CorRubroNegra.VERMELHO;
                    x = parent;
                    parent = x.pai;
                } else {
                    if (w.direita == null || w.direita.cor == CorRubroNegra.PRETO) {
                        if (w.esquerda != null) w.esquerda.cor = CorRubroNegra.PRETO;
                        w.cor = CorRubroNegra.VERMELHO;
                        rotacaoDireita(w);
                        w = parent.direita;
                    }
                    if (w != null) w.cor = parent.cor;
                    parent.cor = CorRubroNegra.PRETO;
                    if (w.direita != null) w.direita.cor = CorRubroNegra.PRETO;
                    rotacaoEsquerda(parent);
                    x = raiz;
                }
            } else {
                No w = parent.esquerda;
                if (w != null && w.cor == CorRubroNegra.VERMELHO) {
                    w.cor = CorRubroNegra.PRETO;
                    parent.cor = CorRubroNegra.VERMELHO;
                    rotacaoDireita(parent);
                    w = parent.esquerda;
                }
                if ((w.direita == null || w.direita.cor == CorRubroNegra.PRETO) &&
                        (w.esquerda == null || w.esquerda.cor == CorRubroNegra.PRETO)) {
                    if (w != null) w.cor = CorRubroNegra.VERMELHO;
                    x = parent;
                    parent = x.pai;
                } else {
                    if (w.esquerda == null || w.esquerda.cor == CorRubroNegra.PRETO.PRETO) {
                        if (w.direita != null) w.direita.cor = CorRubroNegra.PRETO;
                        w.cor = CorRubroNegra.VERMELHO;
                        rotacaoEsquerda(w);
                        w = parent.esquerda;
                    }
                    if (w != null) w.cor = parent.cor;
                    parent.cor = CorRubroNegra.PRETO;
                    if (w.esquerda != null) w.esquerda.cor = CorRubroNegra.PRETO;
                    rotacaoDireita(parent);
                    x = raiz;
                }
            }
        }
        if (x != null) x.cor = CorRubroNegra.PRETO;
    }

    private void rotacaoEsquerda(No x) {
        No y = x.direita;
        x.direita = y.esquerda;
        if (y.esquerda != null) y.esquerda.pai = x;
        y.pai = x.pai;

        if (x.pai == null) raiz = y;
        else if (x == x.pai.esquerda) x.pai.esquerda = y;
        else x.pai.direita = y;

        y.esquerda = x;
        x.pai = y;
    }

    private void rotacaoDireita(No x) {
        No y = x.esquerda;
        x.esquerda = y.direita;
        if (y.direita != null) y.direita.pai = x;
        y.pai = x.pai;

        if (x.pai == null) raiz = y;
        else if (x == x.pai.direita) x.pai.direita = y;
        else x.pai.esquerda = y;

        y.direita = x;
        x.pai = y;
    }

    public void imprimirEmOrdem() {
        imprimirEmOrdem(raiz);
        System.out.println();
    }

    private void imprimirEmOrdem(No no) {
        if (no != null) {
            imprimirEmOrdem(no.esquerda);
            System.out.print(no.dado + "(" + no.cor + ") ");
            imprimirEmOrdem(no.direita);
        }
    }

    public No getRaiz() {
        return raiz;
    }
}
