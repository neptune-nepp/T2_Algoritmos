class SubCarro extends Carro{
    private long horarioEntrada;
    private int numeroDeManobras;

    public SubCarro(String placa, long horarioEntrada){
        super(placa);
        this.horarioEntrada = horarioEntrada;
        this.numeroDeManobras = 0;
    }

    public long getHorarioEntrada() {
        return horarioEntrada;
    }

    public int getNumeroDeManobras() {
        return numeroDeManobras;
    }

    public void incrementarManobras() {
        this.numeroDeManobras++;
    }
}
