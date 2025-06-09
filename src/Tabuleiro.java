import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Tabuleiro {
    public static final String BG_BLACK = "\u001B[40m";
    public static final String RESET = "\u001B[0m";

    public static char[][] criarTabuleiroVazio_B() { // Considere vazia como preenchida somente por "."
        char[][] matriz = new char[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                matriz[i][j] = '.';
            }
        }
        return matriz;
    }

    public static Navio[][] criarTabuleiroVazio_A() { // Considere vazia como preenchida somente por "."
        Navio[][] matriz = new Navio[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                matriz[i][j] = null;
            }
        }
        return matriz;
    }


    public static void mostrarCampoDeBatalha(char[][] matrizDoCampoDeBatalha) {
        System.out.println(BG_BLACK);
        System.out.println("    1  2  3  4  5  6  7  8  9  10");
        for (int linha = 0; linha < 10; linha++) {
            System.out.print((linha + 1) + ((linha + 1 != 10) ? "  " : " "));
            for (int coluna = 0; coluna < 10; coluna++) {
                System.out.print(" " + matrizDoCampoDeBatalha[linha][coluna] + " ");
            }
            System.out.println();
        }
        System.out.println(RESET);
    }

    public static Navio[][] addNavioTab_A(Navio navio, Navio[][] tab_A){
        for(int i = 0; i < navio.getTamanho(); i++){
            if(navio.getDirecao() == 'D'){
                tab_A[navio.getLinha()][navio.getColuna() + i] = navio;
            } else if (navio.getDirecao() == 'B'){
                tab_A[navio.getLinha() + i][navio.getColuna()] = navio;
            }
        }
        return tab_A;
    }

}
