import java.util.Date;

public class Estacionamento {
    private Fila<SubCarro> filaCarros;
    private int capacidadeMaxima;

    public Estacionamento(int capacidadeMaxima){
        this.capacidadeMaxima = capacidadeMaxima;
        this.filaCarros = new Fila<>(capacidadeMaxima);
    }

    public boolean entradaCarro(String placa){
        if(filaCarros.estaCheia()){
            System.out.println("Estacionamento lotado. Nao é possível adicionar mais carros.");
            return false;
        }
        long horarioEntrada = System.currentTimeMillis();
        SubCarro novoCarro = new SubCarro(placa, horarioEntrada);
        filaCarros.enfileira(novoCarro);
        System.out.println("Carro com placa " +placa+ " entrou no estacionamento.");
        return true;
    }

    public boolean saidaCarro(){
        if (filaCarros.estaVazia()){
            System.out.println("Nenhum carro no estacionamento para sair.");
            return false;
        }
        SubCarro carroASair = filaCarros.desenfileira();
        long horarioSaida = System.currentTimeMillis();
        long tempoPermanencia = horarioSaida - carroASair.getHorarioEntrada();
        System.out.println("Carro com placa " +carroASair.getPlaca()+ " saiu do estacionamento.");
        System.out.println("Tempo de permanencia: " +tempoPermanencia/1000+ " segundos.");
        System.out.println("Numero de manobras: " +carroASair.getNumeroDeManobras());
        return true;
    }

    public void consultarCarro(String placa){
        boolean encontrouCarro = false;
        for (int i = 0; i < filaCarros.getTamanho(); i++){
            SubCarro carro = filaCarros.espiar(i);
            if (carro.getPlaca() == placa){
                System.out.println("Carro com placa " +placa+ " esta na posicao " +(i + 1)+ " da fila.");
                System.out.println("Horario de entrada: " + new Date(carro.getHorarioEntrada()));
                encontrouCarro = true;
                break;
            }
        }

        if (!encontrouCarro){
            System.out.println("Carro com placa " + placa + " nao encontrado no estacionamento. ");
        }
    }

    public void estadoAtual(){
        System.out.println("Estado atual do estacionamento:");
        for(int i = 0; i < filaCarros.getTamanho(); i++){
            SubCarro carro = filaCarros.espiar(i);
            System.out.println("Posicao " + (i+1) + " | Placa: " + carro.getPlaca() + " | Horario de entrada: " + new Date(carro.getHorarioEntrada()) + " | Numero de manobras: " +carro.getNumeroDeManobras());
        }
    }
}