import java.util.Random;

public class Navio {
    private char tipo;
    private int tamanho;
    private  int vida;
    private char direcao;
    private int linha;
    private int coluna;


    public static void causarDano(Navio navio){
        navio.setVida(navio.getVida()-1);
    }

    public static Navio criar_Navio (Navio[][] tab_A, char tipo, int tamanho){
        Random random = new Random();
        Navio navio = new Navio();

        navio.setTipo(tipo);
        navio.setTamanho(tamanho);
        navio.setVida(tamanho);

        boolean isInvalido = true;
        int linha = 0;
        int coluna = 0;

        int numDirecao = random.nextInt(2);

        if(numDirecao == 0){
            navio.setDirecao('D');
        }else {
            navio.setDirecao('B');
        }

        while(isInvalido){
            boolean isValido = true;

            if(numDirecao == 0){
                linha = random.nextInt(10);
                coluna = random.nextInt(11 - tamanho);
            }else if(numDirecao == 1){
                linha = random.nextInt(11 - tamanho);
                coluna = random.nextInt(10);
            }

            for(int i = 0; i < tamanho; i++){
                if(numDirecao == 0){
                    if(tab_A[linha][coluna + i] != null){
                        isValido = false;
                    }
                }else if(numDirecao == 1){
                    if(tab_A[linha + i][coluna] != null){
                        isValido = false;
                    }
                }
            }

            isInvalido = !isValido;
        }

        navio.setLinha(linha);
        navio.setColuna(coluna);

        return navio;
    }

    public boolean isVivo(){
        return vida > 0;
    }

    // Getters, Setters e Construtor

    public Navio() {
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
