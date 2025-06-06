import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Utilitarios {

    public static final String BG_BLACK = "\u001B[40m";
    public static final String RESET = "\u001B[0m";

    public static String[][] criarMatrizVazia() { // Considere vazia como preenchida somente por "."
        String[][] matriz = new String[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                matriz[i][j] = ".";
            }
        }
        return matriz;
    }

    public static void mostrarCampoDeBatalha(String[][] matrizDoCampoDeBatalha) {
        System.out.println(BG_BLACK);
        System.out.println("     1  2  3  4  5  6  7  8  9  10");
        for (int linha = 0; linha < 10; linha++) {
            System.out.print((linha + 1) + ((linha + 1 != 10) ? "   " : "  "));
            for (int coluna = 0; coluna < 10; coluna++) {
                System.out.print(" " + matrizDoCampoDeBatalha[linha][coluna] + " ");
            }
            System.out.println();
        }
        System.out.println(RESET);
    }

    public static int[] receberLinhaColunaDoUsuario() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Informe a linha e a coluna: ");
        String input = scan.nextLine();
        String[] split = input.split(" ");
        int[] valores = new int[2];
        for (int i = 0; i < valores.length; i++) {
            valores[i] = Integer.parseInt(split[i]);
        }
        return valores;
    }

    public static String definirLocalizacao() {
        int posicao = ThreadLocalRandom.current().nextInt(1, 3);
        if (posicao == 1) {
            return "VERTICAL";
        } else {
            return "HORIZONTAL";
        }
    }

//    public static String[][] posicionarEmbarcacao(String[][] matriz, int quantidadeDaEmbarcacao, String[] formatoDaEmbarcao) {
//        Embarcacoes embarcacoes = new Embarcacoes();
//        for (int i = 0; i < quantidadeDaEmbarcacao; i++) {
//            int linha = ThreadLocalRandom.current().nextInt(0, 10);
//            int coluna = ThreadLocalRandom.current().nextInt(0, 10);
//            if (matriz[linha][coluna].equals(".")) {
//                System.out.println(i);
//                if (definirLocalizacao().equals("VERTICAL")) {
//                    for (int j = 0; j < formatoDaEmbarcao.length; j++) {
//                        matriz[linha + j][coluna] = formatoDaEmbarcao[j];
//                    }
//                } else {
//                    for (int j = 0; j < formatoDaEmbarcao.length; j++) {
//                        matriz[linha][coluna + j] = formatoDaEmbarcao[j];
//                    }
//                }
//            }
//        }
//        return matriz;
//    }

    public static String[][] posicionarEmbarcacao(String[][] matriz, int quantidadeDaEmbarcacao, String[] formatoDaEmbarcao) {
        Embarcacoes embarcacoes = new Embarcacoes();
        int linha = ThreadLocalRandom.current().nextInt(0, 10);
        int coluna = ThreadLocalRandom.current().nextInt(0, 10);
        if (matriz[linha][coluna].equals(".")) {
            if (definirLocalizacao().equals("VERTICAL")) {
                for (int j = 0; j < formatoDaEmbarcao.length; j++) {
                    if ((linha + j) > 9 || coluna > 9) {
                        break;
                    }
                    matriz[linha + j][coluna] = formatoDaEmbarcao[j];
                    System.out.print("[" + (linha + j + 1) + ", " + (coluna + 1) + "]");
                }
            } else {
                for (int j = 0; j < formatoDaEmbarcao.length; j++) {
                    if (linha > 9 || (coluna + j) > 9) {
                        break;
                    }
                    matriz[linha][coluna + j] = formatoDaEmbarcao[j];
                    System.out.print("[" + (linha + 1) + ", " + (coluna + j + 1) + "]");
                }
            }
        }
        return matriz;
    }

    public static String[][] posicionarPortaAviao(String[][] matriz) {
        Embarcacoes embarcacoes = new Embarcacoes();
        String[] formato = embarcacoes.getFormatoPortaAviao();
        int quantidade = embarcacoes.getQuantidadePortaAvioes();
        int quantidadePosicionado = 0;
        int[] linhas = new int[4];
        int[] colunas = new int[4];
        boolean permitir = true;
        while (quantidadePosicionado < quantidade) {
            int linha = ThreadLocalRandom.current().nextInt(0, 10);
            int coluna = ThreadLocalRandom.current().nextInt(0, 10);
            if (matriz[linha][coluna].equals(".")) {
                permitir = true;
                if (definirLocalizacao().equals("VERTICAL")) {
                    for (int j = 0; j < formato.length; j++) {
                        System.out.print("[" + (linha + j) + ", " + (coluna) + "]");
                        linhas[j] = linha + j;
                        colunas[j] = coluna;
                    }
                    for (int k = 0; k < 4; k++) {
                        if (linhas[k] > 9 || colunas[k] > 9) {
                            permitir = false;
                        }
                    }
                    if (permitir) {
                        for (int l = 0; l < 4; l++) {
                            matriz[linhas[l]][colunas[l]] = formato[l];
                        }
                        quantidadePosicionado++;
                    }
                } else {
                    if (matriz[linha][coluna].equals(".")) {
                        if (definirLocalizacao().equals("VERTICAL")) {
                            for (int j = 0; j < formato.length; j++) {
                                System.out.print("[" + (linha) + ", " + (coluna + j) + "]");
                                linhas[j] = linha;
                                colunas[j] = coluna + j;
                            }
                            for (int k = 0; k < 4; k++) {
                                if (linhas[k] > 9 || colunas[k] > 9) {
                                    permitir = false;
                                }
                            }
                            if (permitir) {
                                for (int l = 0; l < 4; l++) {
                                    matriz[linhas[l]][colunas[l]] = formato[l];
                                }
                                quantidadePosicionado++;
                            }
                        }
                    }
                }
            }
        }
        System.out.println(Arrays.toString(linhas) + " " + Arrays.toString(colunas));
        return matriz;
    }

    public static String[][] posicionarEncouracado(String[][] matriz) {
        Embarcacoes embarcacoes = new Embarcacoes();
        String[] formato = embarcacoes.getFormatoEncouracado();
        int quantidade = embarcacoes.getQuantidadeEncouracados();
        int quantidadePosicionado = 0;
        int[] linhas = new int[formato.length];
        int[] colunas = new int[formato.length];
        boolean permitir = true;
        while (quantidadePosicionado < quantidade) {
            int linha = ThreadLocalRandom.current().nextInt(0, 10);
            int coluna = ThreadLocalRandom.current().nextInt(0, 10);
            if (matriz[linha][coluna].equals(".")) {
                permitir = true;
                if (definirLocalizacao().equals("VERTICAL")) {
                    for (int j = 0; j < formato.length; j++) {
                        System.out.print("[" + (linha + j) + ", " + (coluna) + "]");
                        linhas[j] = linha + j;
                        colunas[j] = coluna;
                    }
                    for (int k = 0; k < formato.length; k++) {
                        if (linhas[k] > 9 || colunas[k] > 9) {
                            permitir = false;
                        }
                    }
                    if (permitir) {
                        for (int l = 0; l < formato.length; l++) {
                            matriz[linhas[l]][colunas[l]] = formato[l];
                        }
                        quantidadePosicionado++;
                    }
                } else {
                    if (matriz[linha][coluna].equals(".")) {
                        if (definirLocalizacao().equals("VERTICAL")) {
                            for (int j = 0; j < formato.length; j++) {
                                System.out.print("[" + (linha) + ", " + (coluna + j) + "]");
                                linhas[j] = linha;
                                colunas[j] = coluna + j;
                            }
                            for (int k = 0; k < formato.length; k++) {
                                if (linhas[k] > 9 || colunas[k] > 9) {
                                    permitir = false;
                                }
                            }
                            if (permitir) {
                                for (int l = 0; l < formato.length; l++) {
                                    matriz[linhas[l]][colunas[l]] = formato[l];
                                }
                                quantidadePosicionado++;
                            }
                        }
                    }
                }
            }
        }
        System.out.println(Arrays.toString(linhas) + " " + Arrays.toString(colunas));
        return matriz;
    }

    public static String[][] posicionarCruzador(String[][] matriz) {
        Embarcacoes embarcacoes = new Embarcacoes();
        String[] formato = embarcacoes.getFormatoCruzador();
        int quantidade = embarcacoes.getQuantidadeCruzadores();
        int quantidadePosicionado = 0;
        int[] linhas = new int[formato.length];
        int[] colunas = new int[formato.length];
        boolean permitir = true;
        while (quantidadePosicionado < quantidade) {
            int linha = ThreadLocalRandom.current().nextInt(0, 10);
            int coluna = ThreadLocalRandom.current().nextInt(0, 10);
            if (matriz[linha][coluna].equals(".")) {
                permitir = true;
                if (definirLocalizacao().equals("VERTICAL")) {
                    for (int j = 0; j < formato.length; j++) {
                        System.out.print("[" + (linha + j) + ", " + (coluna) + "]");
                        linhas[j] = linha + j;
                        colunas[j] = coluna;
                    }
                    for (int k = 0; k < formato.length; k++) {
                        if (linhas[k] > 9 || colunas[k] > 9) {
                            permitir = false;
                        }
                    }
                    if (permitir) {
                        for (int l = 0; l < formato.length; l++) {
                            matriz[linhas[l]][colunas[l]] = formato[l];
                        }
                        quantidadePosicionado++;
                    }
                } else {
                    if (matriz[linha][coluna].equals(".")) {
                        if (definirLocalizacao().equals("VERTICAL")) {
                            for (int j = 0; j < formato.length; j++) {
                                System.out.print("[" + (linha) + ", " + (coluna + j) + "]");
                                linhas[j] = linha;
                                colunas[j] = coluna + j;
                            }
                            for (int k = 0; k < formato.length; k++) {
                                if (linhas[k] > 9 || colunas[k] > 9) {
                                    permitir = false;
                                }
                            }
                            if (permitir) {
                                for (int l = 0; l < formato.length; l++) {
                                    matriz[linhas[l]][colunas[l]] = formato[l];
                                }
                                quantidadePosicionado++;
                            }
                        }
                    }
                }
            }
        }
        System.out.println(Arrays.toString(linhas) + " " + Arrays.toString(colunas));
        return matriz;
    }

    public static String[][] posicionarSubmarino(String[][] matriz) {
        Embarcacoes embarcacoes = new Embarcacoes();
        String[] formato = embarcacoes.getFormatoSubmarino();
        int quantidade = embarcacoes.getQuantidadeSubmarinos();
        int quantidadePosicionado = 0;
        int[] linhas = new int[formato.length];
        int[] colunas = new int[formato.length];
        boolean permitir = true;
        while (quantidadePosicionado < quantidade) {
            int linha = ThreadLocalRandom.current().nextInt(0, 10);
            int coluna = ThreadLocalRandom.current().nextInt(0, 10);
            if (matriz[linha][coluna].equals(".")) {
                permitir = true;
                if (definirLocalizacao().equals("VERTICAL")) {
                    for (int j = 0; j < formato.length; j++) {
                        System.out.print("[" + (linha + j) + ", " + (coluna) + "]");
                        linhas[j] = linha + j;
                        colunas[j] = coluna;
                    }
                    for (int k = 0; k < formato.length; k++) {
                        if (linhas[k] > 9 || colunas[k] > 9) {
                            permitir = false;
                        }
                    }
                    if (permitir) {
                        for (int l = 0; l < formato.length; l++) {
                            matriz[linhas[l]][colunas[l]] = formato[l];
                        }
                        quantidadePosicionado++;
                    }
                } else {
                    if (matriz[linha][coluna].equals(".")) {
                        if (definirLocalizacao().equals("VERTICAL")) {
                            for (int j = 0; j < formato.length; j++) {
                                System.out.print("[" + (linha) + ", " + (coluna + j) + "]");
                                linhas[j] = linha;
                                colunas[j] = coluna + j;
                            }
                            for (int k = 0; k < formato.length; k++) {
                                if (linhas[k] > 9 || colunas[k] > 9) {
                                    permitir = false;
                                }
                            }
                            if (permitir) {
                                for (int l = 0; l < formato.length; l++) {
                                    matriz[linhas[l]][colunas[l]] = formato[l];
                                }
                                quantidadePosicionado++;
                            }
                        }
                    }
                }
            }
        }
        System.out.println(Arrays.toString(linhas) + " " + Arrays.toString(colunas));
        return matriz;
    }

    public static String[][] posicionarHidroaviao(String[][] matriz) {
        Embarcacoes embarcacoes = new Embarcacoes();
        String[] formato = embarcacoes.getFormatoHidroaviao();
        int quantidade = embarcacoes.getQuantidadeHidroavioes();
        int quantidadePosicionado = 0;
        int[] linhas = new int[formato.length];
        int[] colunas = new int[formato.length];
        boolean permitir = true;
        while (quantidadePosicionado < quantidade) {
            int linha = ThreadLocalRandom.current().nextInt(0, 10);
            int coluna = ThreadLocalRandom.current().nextInt(0, 10);
            if (matriz[linha][coluna].equals(".")) {
                permitir = true;
                if (definirLocalizacao().equals("VERTICAL")) {
                    for (int j = 0; j < formato.length; j++) {
                        System.out.print("[" + (linha + j) + ", " + (coluna) + "]");
                        linhas[j] = linha + j;
                        colunas[j] = coluna;
                    }
                    for (int k = 0; k < formato.length; k++) {
                        if (linhas[k] > 9 || colunas[k] > 9) {
                            permitir = false;
                        }
                    }
                    if (permitir) {
                        for (int l = 0; l < formato.length; l++) {
                            matriz[linhas[l]][colunas[l]] = formato[l];
                        }
                        quantidadePosicionado++;
                    }
                } else {
                    if (matriz[linha][coluna].equals(".")) {
                        if (definirLocalizacao().equals("VERTICAL")) {
                            for (int j = 0; j < formato.length; j++) {
                                System.out.print("[" + (linha) + ", " + (coluna + j) + "]");
                                linhas[j] = linha;
                                colunas[j] = coluna + j;
                            }
                            for (int k = 0; k < formato.length; k++) {
                                if (linhas[k] > 9 || colunas[k] > 9) {
                                    permitir = false;
                                }
                            }
                            if (permitir) {
                                for (int l = 0; l < formato.length; l++) {
                                    matriz[linhas[l]][colunas[l]] = formato[l];
                                }
                                quantidadePosicionado++;
                            }
                        }
                    }
                }
            }
        }
        System.out.println(Arrays.toString(linhas) + " " + Arrays.toString(colunas));
        return matriz;
    }

    public static String[][] posicionarEmbarcacoes(String[][] matriz) {
        Embarcacoes embarcacoes = new Embarcacoes();
        posicionarPortaAviao(matriz);
        posicionarEncouracado(matriz);
        posicionarCruzador(matriz);
        posicionarSubmarino(matriz);
        posicionarHidroaviao(matriz);


//        posicionarEmbarcacao(matriz, embarcacoes.getQuantidadeSubmarinos(), embarcacoes.getFormatoSubmarino());
//        posicionarEmbarcacao(matriz, embarcacoes.getQuantidadeHidroavioes(), embarcacoes.getFormatoHidroaviao());
//        posicionarEmbarcacao(matriz, embarcacoes.getQuantidadeCruzadores(), embarcacoes.getFormatoCruzador());
//        posicionarEmbarcacao(matriz, embarcacoes.getQuantidadeEncouracados(), embarcacoes.getFormatoEncouracado());
        return matriz;
    }
}
