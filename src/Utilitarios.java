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

    public static int[] receberLinhaColunaDoUsuario(){
        Scanner scan = new Scanner(System.in);
        System.out.print("Informe a linha e a coluna: ");
        String input = scan.nextLine();
        String[] split = input.split(" ");
        int [] valores= new int[2];
        for (int i = 0; i < valores.length; i++) {
            valores[i] = Integer.parseInt(split[i]);
        }
        return valores;
    }

    public static String[][] posicionarEmbarcacao(String[][] matriz){ // TESTE
        int linha  = ThreadLocalRandom.current().nextInt(0, 10);
        int coluna  = ThreadLocalRandom.current().nextInt(0, 10);
        matriz[linha][coluna] = "P";
        return matriz;
    }
}
