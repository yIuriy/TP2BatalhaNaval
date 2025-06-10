public class Tabuleiro {
    public static char[][] criarTabuleiroVazioB() { // Considere vazio como preenchido somente por "."
        char[][] tabuleiro = new char[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                tabuleiro[i][j] = '.';
            }
        }
        return tabuleiro;
    }

    public static Embarcacao[][] criarTabuleiroVazioA() { // Considere vazio como preenchida somente por "null"
        Embarcacao[][] tabuleiro = new Embarcacao[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                tabuleiro[i][j] = null;
            }
        }
        return tabuleiro;
    }

    public static void mostrarCampoDeBatalha(char[][] matrizDoCampoDeBatalha) {
        System.out.println("    1  2  3  4  5  6  7  8  9  10");
        for (int linha = 0; linha < 10; linha++) {
            System.out.print((linha + 1) + ((linha + 1 != 10) ? "  " : " "));
            for (int coluna = 0; coluna < 10; coluna++) {
                String caracterNaPosicao = String.valueOf(matrizDoCampoDeBatalha[linha][coluna]);
                if (caracterNaPosicao.equals("*")) {
                    System.out.print(" \u001B[34m" + "#" + "\u001B[0m ");
                } else if (!caracterNaPosicao.equals(".")) {
                    System.out.print(" " + caracterNaPosicao + " ");
                } else {
                    System.out.print("   ");
                }
            }
            System.out.println();
        }
    }

    public static void mostrarCampoDeDebug(Embarcacao[][] matriz) {
        System.out.println("    1  2  3  4  5  6  7  8  9  10");
        for (int linha = 0; linha < 10; linha++) {
            System.out.print((linha + 1) + ((linha + 1 != 10) ? "  " : " "));
            for (int coluna = 0; coluna < 10; coluna++) {
                if (matriz[linha][coluna] == null) {
                    System.out.print(" " + "." + " ");
                } else {
                    String caracterNaPosicao = String.valueOf(matriz[linha][coluna].getTipo());
                    System.out.print(" " + caracterNaPosicao + " ");
                }
            }
            System.out.println();
        }
    }

    public static void adicionarEmbarcacaoNoTabuleiroA(Embarcacao embarcacao, Embarcacao[][] tabuleiroA) {
        for (int i = 0; i < embarcacao.getTamanho(); i++) {
            if (embarcacao.getDirecao() == 'D') { // Direita
                tabuleiroA[embarcacao.getLinha()][embarcacao.getColuna() + i] = embarcacao;
            } else if (embarcacao.getDirecao() == 'B') { // Baixo
                tabuleiroA[embarcacao.getLinha() + i][embarcacao.getColuna()] = embarcacao;
            }
        }
    }

    public static void mostrarPontuacaoFinalBaseadaNaQuantidadeDeAtaques(int ataques) {
        System.out.printf("Você precisou de %d ataques para destruir as 15 embarcações!%n", ataques);
        if (ataques == 25) {
            System.out.println("Você não errou nenhum ataque! Isso é surpreendente...");
        } else if (ataques < 50) {
            System.out.println("Parabéns! Você é o verdadeiro mestre da Batalha Naval!");
        } else if (ataques < 60) {
            System.out.println("Você jogou bem, parabéns.");
        } else if (ataques < 90) {
            System.out.println("Você está no caminho certo, continue jogando e melhorando!");
        } else {
            System.out.println("Não se preocupe, nós sabemos que o jogo é difícil, quem sabe na próxima você se saia melhor.");
        }

    }
}
