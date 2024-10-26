package HotelMV;
import java.time.LocalDate;

public class Estadia {
    private Hospede hospede;
    private Quarto quarto;
    private LocalDate dataEntrada;
    private LocalDate dataSaida;

    public Estadia(Hospede hospede, Quarto quarto, LocalDate dataEntrada, LocalDate dataSaida) {
        this.hospede = hospede;
        this.quarto = quarto;
        this.dataEntrada = dataEntrada;
        this.dataSaida = dataSaida;
    }

    @Override
    public String toString() {
        return "Estadia{" +
                "hóspede=" + hospede.getNome() + 
                ", quarto=" + quarto.getNumero() + 
                ", data de entrada=" + dataEntrada + 
                ", data de saída=" + dataSaida + 
                '}';
    }

    // Getters (opcional)
    public Hospede getHospede() {
        return hospede;
    }

    public Quarto getQuarto() {
        return quarto;
    }

    public LocalDate getDataEntrada() {
        return dataEntrada;
    }

    public LocalDate getDataSaida() {
        return dataSaida;
    }
}