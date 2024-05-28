public class Main {
    public static void main(String[] args) {
        Estacionamento estacionamento = new Estacionamento(15);

        estacionamento.entradaCarro("ABC-1234");
        estacionamento.entradaCarro("XYZ-5678");
        estacionamento.entradaCarro("DEF-9012");

        estacionamento.consultarCarro("XYZ-5678");

        //teste para tempo
        // try {
        //     Thread.sleep(10000);
        //   } catch (InterruptedException e) {
        //     Thread.currentThread().interrupt();
        //   }

        estacionamento.saidaCarro();

        estacionamento.estadoAtual();

        estacionamento.entradaCarro("ABC-1234");

        estacionamento.consultarCarro("ABC-1234");
        estacionamento.estadoAtual();
    }
}
