package HotelMV;

public class Reserva {
	private Hospede hospede;
    private Quarto quarto;
    private String dataEntrada;
    private String dataSaida;

    public Reserva(Hospede hospede, Quarto quarto, String dataEntrada, String dataSaida) {
        this.hospede = hospede;
        this.setQuarto(quarto);
        this.dataEntrada = dataEntrada;
        this.dataSaida = dataSaida;
    }

    public void cancelarReserva() {
        getQuarto().atualizarStatus("disponível");
        System.out.println("Reserva cancelada com sucesso.");
    }

    @Override
    public String toString() {
        return "Reserva: Hóspede " + hospede.getCpf() + ", Quarto " + getQuarto().getNumero() + ", Entrada: " + dataEntrada + ", Saída: " + dataSaida;
    }

	public Quarto getQuarto() {
		return quarto;
	}

	public void setQuarto(Quarto quarto) {
		this.quarto = quarto;
	}
}



