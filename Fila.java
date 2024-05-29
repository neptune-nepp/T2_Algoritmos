public class Fila<E> {
    private E[] dados;
    private int primeiro;
    private int ultimo;
    private int tamanho;

    public static final int CAPACIDADE_MINIMA = 10;

    public Fila (int capacidade){
        if (capacidade > CAPACIDADE_MINIMA){
            dados = (E[]) new Object[capacidade];
        } else {
            dados = (E[]) new Object[CAPACIDADE_MINIMA];
        }
        primeiro = 0;
        ultimo = dados.length - 1;
        tamanho = 0;
    }

    public Fila(){
        this(CAPACIDADE_MINIMA);
    }
    public int getTamanho(){
        return tamanho;
    }
    public boolean estaVazia () {
        return tamanho == 0;
    }
    public boolean estaCheia () {
        return tamanho == dados.length;
    }
    int proxima (int posicao) {
        return (posicao + 1) % dados.length;
    }
    public void enfileira (E info) {
        if (!estaCheia()) {
            ultimo = proxima(ultimo);
            dados[ultimo] = info;
            tamanho++;
        }
    }
    public E desenfileira () {
        E info = null;
        if (!estaVazia()) {
            info = dados[primeiro];
            primeiro = proxima(primeiro);
            tamanho--;
        }
        return info;
    }

    public E espiar(int posicao){
        if (posicao < 0 || posicao >= tamanho){
            throw new IndexOutOfBoundsException("Posição inválida na fila.");
        } return dados[(primeiro + posicao) % dados.length];
    }
    public String toStringVetor () {
        if (estaVazia()) return "_ _ _ _ _ _ _ _ _ _";
        int i;
        String s = "";
        if (primeiro <= ultimo) {
            for (i=0; i<primeiro; i++)
                s += "_ ";
            for (i=primeiro; i<=ultimo; i++)
                s += dados[i] + " ";
            for (i=ultimo+1; i<dados.length; i++)
                s += "_ ";
        }
        else {
            for (i=0; i<=ultimo; i++)
                s += dados[i] + " ";
            for (i=ultimo+1; i<primeiro; i++)
                s += "_ ";
            for (i=primeiro; i<dados.length; i++)
                s += dados[i] + " ";
        }
        return s;
    }
}
