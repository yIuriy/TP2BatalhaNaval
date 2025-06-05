public class BatalhaNaval {
    public static void main(String[] args) {
        String[][] matrizA = Utilitarios.criarMatrizVazia();
        String[][] matrizB = Utilitarios.criarMatrizVazia(); // matriz que o usuário irá ver

        for (int i = 0; i < 20; i++) {
            Utilitarios.posicionarEmbarcacao(matrizA);
        }

        Utilitarios.mostrarCampoDeBatalha(matrizA);
        System.out.println();
        Utilitarios.mostrarCampoDeBatalha(matrizB);
        System.out.println();

        int[] ints = Utilitarios.receberLinhaColunaDoUsuario();
        for (int i : ints){
            System.out.println(i);
        }


    }
}
