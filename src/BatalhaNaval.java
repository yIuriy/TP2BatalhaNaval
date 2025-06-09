import java.util.Scanner;

public class BatalhaNaval {
    public static void main(String[] args) {
        Scanner ent = new Scanner(System.in);
        int navioAfundados = 0;
        int ataquesFeitos = 0;

        Navio[][] tab_A = Tabuleiro.criarTabuleiroVazio_A();
        char[][] tab_B = Tabuleiro.criarTabuleiroVazio_B(); // matriz que o usuário irá ver

        Navio p1 = Navio.criar_Navio(tab_A,'P',4);
        tab_A = Tabuleiro.addNavioTab_A(p1, tab_A);

        Navio e1 = Navio.criar_Navio(tab_A,'E',3);
        tab_A = Tabuleiro.addNavioTab_A(e1, tab_A);

        Navio e2 = Navio.criar_Navio(tab_A,'E',3);
        tab_A = Tabuleiro.addNavioTab_A(e2, tab_A);

        Navio c1 = Navio.criar_Navio(tab_A,'C',2);
        tab_A = Tabuleiro.addNavioTab_A(c1, tab_A);

        Navio c2 = Navio.criar_Navio(tab_A,'C',2);
        tab_A = Tabuleiro.addNavioTab_A(c2, tab_A);

        Navio c3 = Navio.criar_Navio(tab_A,'C',2);
        tab_A = Tabuleiro.addNavioTab_A(c3, tab_A);

        Navio s1 = Navio.criar_Navio(tab_A,'S',1);
        tab_A = Tabuleiro.addNavioTab_A(s1, tab_A);

        Navio s2 = Navio.criar_Navio(tab_A,'S',1);
        tab_A = Tabuleiro.addNavioTab_A(s2, tab_A);

        Navio s3 = Navio.criar_Navio(tab_A,'S',1);
        tab_A = Tabuleiro.addNavioTab_A(s3, tab_A);

        Navio s4 = Navio.criar_Navio(tab_A,'S',1);
        tab_A = Tabuleiro.addNavioTab_A(s4, tab_A);

        Navio h1 = Navio.criar_Navio(tab_A,'H',1);
        tab_A = Tabuleiro.addNavioTab_A(h1, tab_A);

        Navio h2 = Navio.criar_Navio(tab_A,'H',1);
        tab_A = Tabuleiro.addNavioTab_A(h2, tab_A);

        Navio h3 = Navio.criar_Navio(tab_A,'H',1);
        tab_A = Tabuleiro.addNavioTab_A(h3, tab_A);

        Navio h4 = Navio.criar_Navio(tab_A,'H',1);
        tab_A = Tabuleiro.addNavioTab_A(h4, tab_A);

        Navio h5 = Navio.criar_Navio(tab_A,'H',1);
        tab_A = Tabuleiro.addNavioTab_A(h5, tab_A);

        while(navioAfundados < 15) {

            Tabuleiro.mostrarCampoDeBatalha(tab_B);
            try {
                System.out.print("Informe a linha e a coluna: ");
                String input = ent.nextLine();
                String[] split = input.split(" ");
                int linhaAtaque = Integer.parseInt(split[0]) -1;
                int colunaAtaque = Integer.parseInt(split[1]) -1;

                if(tab_B[linhaAtaque][colunaAtaque] != '.'){
                    System.out.println("Você ja atingiu essa região do tabuleiro");

                }else if(tab_A[linhaAtaque][colunaAtaque] == null){
                    System.out.println("Você acertou: Água");
                    tab_B[linhaAtaque][colunaAtaque] = '*';
                    ataquesFeitos++;

                }else if(tab_A[linhaAtaque][colunaAtaque] != null){
                    Navio.causarDano(tab_A[linhaAtaque][colunaAtaque]);
                    tab_B[linhaAtaque][colunaAtaque] = tab_A[linhaAtaque][colunaAtaque].getTipo();
                    ataquesFeitos++;
                    System.out.println("Você acertou o navio: "+tab_A[linhaAtaque][colunaAtaque].getTipo());

                    if(!tab_A[linhaAtaque][colunaAtaque].isVivo()){
                        System.out.println("Navio "+tab_A[linhaAtaque][colunaAtaque].getTipo()+" Afundado");
                        navioAfundados++;
                        System.out.println("Navios restantes: "+(15-navioAfundados));
                    }
                }


            }catch(Exception EX){
                System.out.println("Valores inválidos utilize valores de 0-10 e use formato: x y");
            }
        }
        System.out.println("Fim do Jogo");
        System.out.println("Você destruiu os 15 navios em "+ataquesFeitos+" rodadas");
        System.out.println("Tabuleiro Final: ");
        Tabuleiro.mostrarCampoDeBatalha(tab_B);
    }
}
