public class BatalhaNaval {
    public static void main(String[] args) {
        String[][] matrizA = Utilitarios.criarMatrizVazia();
        String[][] matrizB = Utilitarios.criarMatrizVazia(); // matriz que o usuário irá ver

        Utilitarios.posicionarEmbarcacoes(matrizA);

        Utilitarios.mostrarCampoDeBatalha(matrizA);
        System.out.println();
//        Utilitarios.mostrarCampoDeBatalha(matrizB);
//        System.out.println();
    }
}
