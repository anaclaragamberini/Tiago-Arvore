public class No {
    int dado;
    CorRubroNegra cor;
    No esquerda;
    No direita;
    No pai;

    public No(int dado) {
        this.dado = dado;
        this.cor = CorRubroNegra.VERMELHO; // Novos nós são vermelhos por padrão
        this.esquerda = null;
        this.direita = null;
        this.pai = null;
    }

    // Métodos auxiliares
    public boolean Vermelho(){
        return this.cor == CorRubroNegra.VERMELHO;
    }

    public boolean Preto() {
        return this.cor == cor.PRETO;
    }
}
