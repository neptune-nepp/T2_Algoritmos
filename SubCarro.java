import java.time.LocalTime;

class SubCarro extends Carro{
    private LocalTime horarioEntrada;
    private int numeroDeManobras;

    public SubCarro(String placa, LocalTime horarioEntrada){
        super(placa);
        this.horarioEntrada = horarioEntrada;
        this.numeroDeManobras = 0;
    }

    public LocalTime getHorarioEntrada() {
        return horarioEntrada;
    }

    public int getNumeroDeManobras() {
        return numeroDeManobras;
    }

    public void incrementarManobras() {
        this.numeroDeManobras++;
    }
}
