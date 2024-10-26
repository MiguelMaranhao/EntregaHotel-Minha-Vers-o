package HotelMV;
import java.util.ArrayList;
import java.util.List; 
import java.util.Scanner;
class Hospede implements Cadastravel {
    private String nome;
    private String cpf;
    private String dataNascimento;
    private String endereco;
    private String numeroContato;
    private List<Reserva> historicoReservas;

    public Hospede(String nome, String cpf, String dataNascimento, String endereco, String numeroContato) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;
        this.numeroContato = numeroContato;
        this.historicoReservas = new ArrayList<>();
    }

    

    @Override
    public void cadastrar() {
        System.out.println("Hóspede " + nome + " cadastrado com sucesso!");
    }

    @Override
    public void listar() {
        System.out.println("Nome: " + nome + ", CPF: " + cpf);
        for (Reserva r : historicoReservas) {
            System.out.println(r);
        }
    }

    public void adicionarReserva(Reserva reserva) {
        historicoReservas.add(reserva);
    }
    public void atualizarInformacoes() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("\nDigite o novo nome (atual: " + nome + "): ");
        String novoNome = scanner.nextLine();
        if (!novoNome.isEmpty()) this.nome = novoNome;

        System.out.print("\nDigite o novo endereço (atual: " + endereco + "): ");
        String novoEndereco = scanner.nextLine();
        if (!novoEndereco.isEmpty()) this.endereco = novoEndereco;

        System.out.print("\nDigite o novo número de contato (atual: " + numeroContato + "): ");
        String novoContato = scanner.nextLine();
        if (!novoContato.isEmpty()) this.numeroContato = novoContato;

        System.out.println("\nInformações do hóspede atualizadas com sucesso.");
    }


    public void editarHospede(String endereco, String numeroContato) {
        this.endereco = endereco;
        this.numeroContato = numeroContato;
        System.out.println("Dados do hóspede atualizados.");
    }
    @Override
    public String toString() {
        return String.format("Nome: %s%nCPF: %s%nData de Nascimento: %s%nEndereço: %s%nContato: %s", 
                             nome, cpf, dataNascimento, endereco, numeroContato);
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getNumeroContato() {
        return numeroContato;
    }

    // Setters
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setNumeroContato(String numeroContato) {
        this.numeroContato = numeroContato;
    }
}