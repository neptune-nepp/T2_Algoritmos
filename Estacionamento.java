import java.util.Scanner;


public class Estacionamento {
    private Fila<SubCarro> filaCarros;
    private int capacidadeMaxima;
    Scanner sc = new Scanner(System.in);

    public void Estaciona(int capacidadeMaxima){
        this.capacidadeMaxima = capacidadeMaxima;
        this.filaCarros = new Fila<>(capacidadeMaxima);
    }

    //pronto
    public boolean entradaCarro(SubCarro carro){
        if(filaCarros.estaCheia()){
            System.out.println("Estacionamento lotado. Nao é possível adicionar mais carros.");
            return false;
        }
        filaCarros.enfileira(carro);
        System.out.println("Carro com placa " + carro.getPlaca() + " entrou no estacionamento.");
        return true;
    }

    public SubCarro saidaCarro(String placa){
        SubCarro carro = null;
        if (filaCarros.estaVazia()){
            System.out.println("Nenhum carro no estacionamento para sair.");
            return null;
        }

        Fila<SubCarro> aux = new Fila<SubCarro>();
        boolean encontrouCarro = false;

        while (!encontrouCarro && !filaCarros.estaVazia()){
            carro = filaCarros.desenfileira();
            if(carro.getPlaca().equals(placa)) {
                carro.incrementarManobras();
                encontrouCarro = true;
            } else{
                carro.incrementarManobras();
                aux.enfileira(carro);
            }
        }
        while(!aux.estaVazia()){
            filaCarros.enfileira(aux.desenfileira());
        } 
        return carro;
    }

    public boolean consultarCarro(String placa){
        boolean encontrouCarro = false;
        
        for (int i = 0; i < filaCarros.getTamanho(); i++){
            SubCarro carro = filaCarros.espiar(i);
            
            if (carro.getPlaca().equals(placa)){
                System.out.println(carro.getPlaca());
                encontrouCarro = true;
                return encontrouCarro;
            }
        } return encontrouCarro;
    }

    public String estadoAtual(){
        return filaCarros.toStringVetor();
    }

}