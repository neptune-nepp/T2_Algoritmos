import java.time.Duration;
import java.time.LocalTime;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Estacionamento estacionamento = new Estacionamento();
        Scanner sc = new Scanner(System.in);
        String placaRetirada = "";
        String placaProcurada = "";
        System.out.println("Insira a capacidade maxima do estacionamento, digite 0 para sair.");
        int capacidade = sc.nextInt();
        int i = 1;
        while(capacidade != 0){
            
            estacionamento.Estaciona(capacidade);
            while (i < capacidade+1) {
                if (estacionamento.entradaCarro(new SubCarro("ABC123" + i, LocalTime.now()))) {
                    System.out.println("O Carro de Placa ABC123" + i + " foi alocado\n");
                } else {
                    System.out.println("Estacionamento cheio.");
                }

                i++;
            }

            System.out.println("Digite 1 para retirar um carro.\nDigite 2 para consultar um carro estacionado.\nDigite 0 para sair.");
            int escolha = sc.nextInt();

            while(escolha != 0){
                if(escolha == 1){
                    System.out.println("Digite a placa do carro a ser retirado: ");
                    placaRetirada = sc.next();
                    SubCarro carroSaiu = estacionamento.saidaCarro(placaRetirada);
                    if(carroSaiu != null){
                        Duration duracao = Duration.between(LocalTime.now(), carroSaiu.getHorarioEntrada());
                        System.out.println("\nCarro de placa " + carroSaiu.getPlaca() + " acabou de sair.\nTempo de permanencia: "
                                + duracao + "\nA quantidade de manobras feitas com o carro foram: "
                                + carroSaiu.getNumeroDeManobras()+"\n");
                    } 
                    else {
                        System.out.println("Seu carro foi roubado parceiro.\n");
                    }
                } 
                else if (escolha == 2){
                    System.out.println("Digite a placa do carro procurado: ");
                    placaProcurada = sc.next();
                    if(estacionamento.consultarCarro(placaProcurada) == true){
                        System.out.println("\nCarro com placa " + placaProcurada + " foi encontrado.\n");
                    } 
                    else {
                        System.out.println("\nCarro com placa " + placaProcurada + " nao encontrado.\n");
                    }
                } 
                else {
                    System.out.println("Digite um número válido.\n");
                }
                System.out.println("Digite 1 para retirar um carro.\nDigite 2 para consultar um carro estacionado.\nDigite 0 para sair.");
                escolha = sc.nextInt();
            }
            
            System.out.println("Insira a capacidade maxima do estacionamento, digite 0 para sair.");
            capacidade = sc.nextInt();
        }
        sc.close();
    }
}
