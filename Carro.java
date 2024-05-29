public class Carro {
    private String placa;

    public Carro(String placa){
        this.placa = placa;
    }

    public String getPlaca() {
        return placa;
    }

    @Override
    public String toString() {
        return placa;
    }
}
