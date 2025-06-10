import java.util.Random;

public class Embarcacao {
    private char tipo;
    private int tamanho;
    private int vida;
    private char direcao;
    private int linha;
    private int coluna;

    public static void causarDano(Embarcacao embarcacao) {
        embarcacao.setVida(embarcacao.getVida() - 1);
    }

    public static Embarcacao criarEmbarcacao(Embarcacao[][] tabelaA, char tipoDoNavio, int tamanhoDoNavio) {
        Random random = new Random();
        Embarcacao embarcacao = new Embarcacao();

        embarcacao.setTipo(tipoDoNavio);
        embarcacao.setTamanho(tamanhoDoNavio);
        embarcacao.setVida(tamanhoDoNavio);

        boolean isInvalido = true;
        int linha = 0;
        int coluna = 0;

        int valorNumericoDaOrientacaoDaEmbarcacao = random.nextInt(2);
        if (valorNumericoDaOrientacaoDaEmbarcacao == 0) {
            embarcacao.setDirecao('D'); // Para direita
        } else {
            embarcacao.setDirecao('B'); // Para baixo
        }

        while (isInvalido) { // Só adicionará a embarcação quando as posições forem validas
            boolean isValido = true;

            // Garante que a embarcação não saía dos limites do tabuleiro
            if (valorNumericoDaOrientacaoDaEmbarcacao == 0) { // Para direita
                linha = random.nextInt(10);
                coluna = random.nextInt(11 - tamanhoDoNavio);
            } else { // Para baixo
                linha = random.nextInt(11 - tamanhoDoNavio);
                coluna = random.nextInt(10);
            }

            // Verifica se as posições que a embarcação vai ocupar estão vazias
            for (int i = 0; i < tamanhoDoNavio; i++) {
                if (valorNumericoDaOrientacaoDaEmbarcacao == 0) { // Para direita
                    if (tabelaA[linha][coluna + i] != null) {
                        isValido = false;
                    }
                } else { // Para baixo
                    if (tabelaA[linha + i][coluna] != null) {
                        isValido = false;
                    }
                }
            }
            isInvalido = !isValido; // Caso todas as posições sejam válidas, quebrará o loop
        }

        embarcacao.setLinha(linha);
        embarcacao.setColuna(coluna);

        // Retorna uma embarcação com todas as posições válidas, para ser adicionada de fato no tabuleiro
        return embarcacao;
    }

    public boolean isVivo() {
        return vida > 0;
    }

    public static String getNomeDoNavio(char tipo) { // com base no tipo, retorna o nome do navio em questão
        return switch (tipo) {
            case 'P' -> "\u001B[35mPorta-Aviões\u001B[0m";
            case 'E' -> "\u001B[35mEncouraçado\u001B[0m";
            case 'C' -> "\u001B[35mCruzador\u001B[0m";
            case 'S' -> "\u001B[35mSubmarino\u001B[0m";
            default -> "\u001B[35mHidroavião\u001B[0m";
        };
    }

    // Getters, Setters e Construtor
    public Embarcacao() {
    }

    public char getTipo() {
        return tipo;
    }

    public void setTipo(char tipo) {
        this.tipo = tipo;
    }

    public int getTamanho() {
        return tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public char getDirecao() {
        return direcao;
    }

    public void setDirecao(char direcao) {
        this.direcao = direcao;
    }

    public int getLinha() {
        return linha;
    }

    public void setLinha(int linha) {
        this.linha = linha;
    }

    public int getColuna() {
        return coluna;
    }

    public void setColuna(int coluna) {
        this.coluna = coluna;
    }
}
