import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class BatalhaNaval {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int navioAfundados = 0;
        int ataquesFeitos = 0;

        Embarcacao[][] tabelaA = Tabuleiro.criarTabuleiroVazioA();
        char[][] tabelaB = Tabuleiro.criarTabuleiroVazioB(); // matriz que o usuário irá ver

        Embarcacao portaAviao1 = Embarcacao.criarEmbarcacao(tabelaA, 'P', 4);
        Tabuleiro.adicionarEmbarcacaoNoTabuleiroA(portaAviao1, tabelaA);

        Embarcacao encouracado1 = Embarcacao.criarEmbarcacao(tabelaA, 'E', 3);
        Tabuleiro.adicionarEmbarcacaoNoTabuleiroA(encouracado1, tabelaA);

        Embarcacao encouracado2 = Embarcacao.criarEmbarcacao(tabelaA, 'E', 3);
        Tabuleiro.adicionarEmbarcacaoNoTabuleiroA(encouracado2, tabelaA);

        Embarcacao cruzador1 = Embarcacao.criarEmbarcacao(tabelaA, 'C', 2);
        Tabuleiro.adicionarEmbarcacaoNoTabuleiroA(cruzador1, tabelaA);

        Embarcacao cruzador2 = Embarcacao.criarEmbarcacao(tabelaA, 'C', 2);
        Tabuleiro.adicionarEmbarcacaoNoTabuleiroA(cruzador2, tabelaA);

        Embarcacao cruzador3 = Embarcacao.criarEmbarcacao(tabelaA, 'C', 2);
        Tabuleiro.adicionarEmbarcacaoNoTabuleiroA(cruzador3, tabelaA);

        Embarcacao submarino1 = Embarcacao.criarEmbarcacao(tabelaA, 'S', 1);
        Tabuleiro.adicionarEmbarcacaoNoTabuleiroA(submarino1, tabelaA);

        Embarcacao submarino2 = Embarcacao.criarEmbarcacao(tabelaA, 'S', 1);
        Tabuleiro.adicionarEmbarcacaoNoTabuleiroA(submarino2, tabelaA);

        Embarcacao submarino3 = Embarcacao.criarEmbarcacao(tabelaA, 'S', 1);
        Tabuleiro.adicionarEmbarcacaoNoTabuleiroA(submarino3, tabelaA);

        Embarcacao submarino4 = Embarcacao.criarEmbarcacao(tabelaA, 'S', 1);
        Tabuleiro.adicionarEmbarcacaoNoTabuleiroA(submarino4, tabelaA);

        Embarcacao hidroAviao1 = Embarcacao.criarEmbarcacao(tabelaA, 'A', 1);
        Tabuleiro.adicionarEmbarcacaoNoTabuleiroA(hidroAviao1, tabelaA);

        Embarcacao hidroAviao2 = Embarcacao.criarEmbarcacao(tabelaA, 'A', 1);
        Tabuleiro.adicionarEmbarcacaoNoTabuleiroA(hidroAviao2, tabelaA);

        Embarcacao hidroAviao3 = Embarcacao.criarEmbarcacao(tabelaA, 'A', 1);
        Tabuleiro.adicionarEmbarcacaoNoTabuleiroA(hidroAviao3, tabelaA);

        Embarcacao hidroAviao4 = Embarcacao.criarEmbarcacao(tabelaA, 'A', 1);
        Tabuleiro.adicionarEmbarcacaoNoTabuleiroA(hidroAviao4, tabelaA);

        Embarcacao hidroAviao5 = Embarcacao.criarEmbarcacao(tabelaA, 'A', 1);
        Tabuleiro.adicionarEmbarcacaoNoTabuleiroA(hidroAviao5, tabelaA);

        while (navioAfundados < 15) { // Loop principal, só acaba quando todos as embarcações forem afundadas
            Tabuleiro.mostrarCampoDeBatalha(tabelaB);
//            Tabuleiro.mostrarCampoDeDebug(tab_A);
            try { // Tenta receber um input do usuário
                System.out.print("Informe a linha e a coluna: ");
                String valoresNaoFormatados = entrada.nextLine();
                String[] valoresFormatados = valoresNaoFormatados.split(" ");
                int linhaAtaque = Integer.parseInt(valoresFormatados[0]) - 1;
                int colunaAtaque = Integer.parseInt(valoresFormatados[1]) - 1;

                if (tabelaB[linhaAtaque][colunaAtaque] != '.') { // "." é uma região vazia
                    System.out.println("Você já atingiu essa região do tabuleiro.");

                } else if (tabelaA[linhaAtaque][colunaAtaque] == null) {
                    System.out.println("Você acertou: " + "\u001B[34m" + "Água" + "\u001B[0m");
                    tabelaB[linhaAtaque][colunaAtaque] = '*';
                    ataquesFeitos++;
                    TimeUnit.MILLISECONDS.sleep(750);

                } else if (tabelaA[linhaAtaque][colunaAtaque] != null) {
                    Embarcacao.causarDano(tabelaA[linhaAtaque][colunaAtaque]);
                    tabelaB[linhaAtaque][colunaAtaque] = tabelaA[linhaAtaque][colunaAtaque].getTipo();
                    ataquesFeitos++;
                    System.out.println("Você acertou o navio: " + Embarcacao.getNomeDoNavio(tabelaA[linhaAtaque][colunaAtaque].getTipo()));
                    TimeUnit.MILLISECONDS.sleep(750);
                    if (!tabelaA[linhaAtaque][colunaAtaque].isVivo()) {
                        System.out.println("Navio " + Embarcacao.getNomeDoNavio(tabelaA[linhaAtaque][colunaAtaque].getTipo()) + " " +
                                "afundado!");
                        navioAfundados++;
                        System.out.println("Navios restantes: " + (15 - navioAfundados));
                    }
                    TimeUnit.MILLISECONDS.sleep(750);
                }
            } catch (Exception Erro) {
                System.out.println("\u001B[31mValores inválidos utilize valores de 1-10 e use formato: x y\u001B[0m");
            }
        }
        System.out.println("--------------------------------------------------------------");
        System.out.println("\u001B[33mFIM DO JOGO\u001B[0m");
        Tabuleiro.mostrarPontuacaoFinalBaseadaNaQuantidadeDeAtaques(ataquesFeitos);
        System.out.println("Tabuleiro Final: ");
        Tabuleiro.mostrarCampoDeBatalha(tabelaB);
    }
}
