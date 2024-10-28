package HotelMV;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Hotel {
    private List<Quarto> quartos;
    public List<Hospede> hospedes;
    public List<Funcionario> funcionarios;
    private List<Reserva> reservas;
    private List<Estadia> estadias;

    public Hotel() {
        quartos = new ArrayList<>();
        hospedes = new ArrayList<>();
        funcionarios = new ArrayList<>();
        reservas = new ArrayList<>();
        estadias = new ArrayList<>();
    }

    // 1. Gerenciamento de Quartos

    // Cadastrar novo quarto
    public void cadastrarQuarto(Quarto quarto) throws DadosInvalidosException {
        if (quarto == null || quarto.getNumero() <= 0) {
            throw new DadosInvalidosException("\nDados inválidos: número do quarto deve ser positivo.");
        }
        quartos.add(quarto);
        System.out.println("\nQuarto cadastrado com sucesso!");
    }

    // Listar quartos disponíveis
    public void listarQuartosDisponiveis() {
        boolean disponivel = false;
        for (Quarto quarto : quartos) {
            if (quarto.isDisponivel()) {
                System.out.println(quarto);
                disponivel = true;
            }
        }
        if (!disponivel) {
            System.out.println("\nNenhum quarto disponível no momento.");
        }
    }
    public void listarQuartosOcupados() {
        boolean temOcupados = false;

        System.out.println("\nQuartos ocupados:");
        for (Quarto quarto : quartos) {
            if (quarto.isOcupado()) {  
                System.out.println("Quarto " + quarto.getNumero() + " está Ocupado.");
                temOcupados = true;
            }
        }

        if (!temOcupados) {
            System.out.println("\nNenhum quarto está ocupado no momento.");
        }
    }
    public boolean temQuartosOcupados() {
        for (Quarto quarto : quartos) {
            if (!quarto.isDisponivel()) { 
                return true; 
            }
        }
        return false; 
    }
    public boolean temQuartosDisponiveis() {
        for (Quarto quarto : quartos) {
            if (quarto.isDisponivel()) { 
                return true; 
            }
        }
        return false; 
    }
    public boolean temHospedesCadastrados() {
        return !hospedes.isEmpty(); 
    }
    public void listarHospedesCadastrados() {
        System.out.println("\nListando hóspedes cadastrados:");
        for (Hospede hospede : hospedes) {
            System.out.println(hospede);
        }
    }
    public void listarFuncionarios() {
        if (funcionarios.isEmpty()) {
            System.out.println("\nNão existem funcionários cadastrados.");
            return;
        }

        System.out.println("\nListando Funcionários:");
        System.out.printf("%-20s %-15s %-20s %-10s%n", "Nome", "CPF", "Cargo", "Salário");
        

        for (Funcionario funcionario : funcionarios) {
            System.out.printf("%-20s %-15s %-20s %-10.2f%n", 
                funcionario.getNome(), 
                funcionario.getCpf(), 
                funcionario.getCargo(), 
                funcionario.getSalario());
        }
    }

    
    // Atualizar status de um quarto
    public void atualizarStatusQuarto(int numero, String status) throws DadosInvalidosException {
        Quarto quarto = buscarQuartoPorNumero(numero);
        if (quarto == null) {
            throw new DadosInvalidosException("\nQuarto não encontrado.");
        }
        quarto.atualizarStatus(status);
        System.out.println("\nStatus do quarto atualizado para: " + status);
    }

    Quarto buscarQuartoPorNumero(int numero) {
        for (Quarto quarto : quartos) {
            if (quarto.getNumero() == numero) {
                return quarto;
            }
        }
        return null;
    }

    // 2. Gerenciamento de Hóspedes

    // Cadastrar novo hóspede
    public void cadastrarHospede(Hospede hospede) {
        hospedes.add(hospede);
    }
    public void listarHospedes() {
        if (hospedes.isEmpty()) {
            System.out.println("\nNão existem hóspedes cadastrados.");
            return;
        }
        System.out.println("\nListando Hóspedes:");
        for (Hospede hospede : hospedes) {
            System.out.println("Nome: " + hospede.getNome());
            System.out.println("CPF: " + hospede.getCpf());
            System.out.println("Data de Nascimento: " + hospede.getDataNascimento());
            System.out.println("Endereço: " + hospede.getEndereco());
            System.out.println("Contato: " + hospede.getNumeroContato());
            System.out.println("------------------------------------");
        }
    }
    

    // Listar histórico de estadias de um hóspede
    public void listarHistoricoHospede(String cpf) throws DadosInvalidosException {
        Hospede hospede = buscarHospedePorCpf(cpf);
        if (hospede == null) {
            throw new DadosInvalidosException("\nHóspede não encontrado.");
        }
        hospede.listar();
    }

    // Editar informações de um hóspede
    public void editarHospede(String cpf, String novoEndereco, String novoNumeroContato) throws DadosInvalidosException {
        Hospede hospede = buscarHospedePorCpf(cpf);
        if (hospede == null) {
            throw new DadosInvalidosException("\nHóspede não encontrado.");
        }
        hospede.editarHospede(novoEndereco, novoNumeroContato);
    }

    Hospede buscarHospedePorCpf(String cpf) {
        for (Hospede hospede : hospedes) {
            if (hospede.getCpf().equals(cpf)) {
                return hospede;
            }
        }
        return null;
    }
    public void editarInformacoesHospede(String cpf) {
        Hospede hospede = buscarHospedePorCpf(cpf); // Método que retorna um hóspede pelo CPF
        if (hospede != null) {
            // Supondo que você tenha um método que permita atualizar informações
            hospede.atualizarInformacoes(); 
            System.out.println("\nInformações do hóspede atualizadas com sucesso!");
        } else {
            System.out.println("\nHóspede não encontrado.");
            
        }
    }

    // 3. Gerenciamento de Funcionários

    // Cadastrar novo funcionário
    public void cadastrarFuncionario(Funcionario funcionario) {
        if (buscarFuncionarioPorCpf(funcionario.getCpf()) == null) { // Supondo que temos o método `buscarFuncionarioPorCpf`
            funcionarios.add(funcionario);
            System.out.println("\nFuncionário cadastrado com sucesso!");
        } else {
            System.out.println("\nFuncionário com esse CPF já está cadastrado.");
        }
    }
    public void editarInformacoesFuncionario(String cpf) {
        Funcionario funcionario = buscarFuncionarioPorCpf(cpf); // Método para buscar funcionário pelo CPF
        if (funcionario != null) {
            funcionario.atualizarInformacoes(); 
            System.out.println("\nInformações do funcionário atualizadas com sucesso!");
        } else {
            System.out.println("\nFuncionário não encontrado.");
           
        }
    }
    public void listarHistoricoEstadias() {
        System.out.println("\nHistórico de Estadias:");
        if (estadias.isEmpty()) {
            System.out.println("\nNenhuma estadia registrada.");
        } else {
            for (Estadia estadia : estadias) {
                System.out.println(estadia);
            }
        }
    }
    public static void calcularSalario(Funcionario funcionario, double taxaAumento) {
        double salarioAtual = funcionario.getSalario();
        double novoSalario = salarioAtual + (salarioAtual * taxaAumento);
        funcionario.setSalario(novoSalario); 
    }
    public Funcionario buscarFuncionarioPorNome(String nome) {
        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getNome().equalsIgnoreCase(nome)) {
                return funcionario;
            }
        }
        return null; 
    }

    // Editar informações de um funcionário
    public void editarFuncionario(String cpf, String novoCargo, double novoSalario) throws DadosInvalidosException {
        Funcionario funcionario = buscarFuncionarioPorCpf(cpf);
        if (funcionario == null) {
            throw new DadosInvalidosException("\nFuncionário não encontrado.");
        }
        funcionario.editarFuncionario(novoCargo, novoSalario);
    }

    Funcionario buscarFuncionarioPorCpf(String cpf) {
        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getCpf().equals(cpf)) {
                return funcionario;
            }
        }
        return null;
    }

    // Registrar horas trabalhadas e calcular salário
    public void registrarHorasFuncionario(String cpf, int horas) throws DadosInvalidosException {
        if (horas < 0) {
            throw new DadosInvalidosException("\nNúmero de horas deve ser positivo.");
        }
        Funcionario funcionario = buscarFuncionarioPorCpf(cpf);
        if (funcionario == null) {
            throw new DadosInvalidosException("\nFuncionário não encontrado.");
        }
        funcionario.registrarHoras(horas);
        System.out.println("\nSalário atualizado: " + funcionario.calcularSalario());
    }

    // 4. Gerenciamento de Reservas

    // Criar reserva
    public void criarReserva(Hospede hospede, Quarto quarto, LocalDate dataEntradaReserva, LocalDate dataSaidaReserva) throws DadosInvalidosException {
        
        if (!quarto.isDisponivel()) { 
            throw new DadosInvalidosException("\nQuarto indisponível.");
        }
        
        // Cria uma nova reserva
        Reserva reserva = new Reserva(hospede, quarto, dataEntradaReserva, dataSaidaReserva);
        reservas.add(reserva); 
        
        
        quarto.setOcupado(true); 
        hospede.adicionarReserva(reserva);
        
        System.out.println("\nReserva criada com sucesso!");
    }

    // Cancelar reserva
    public void cancelarReserva(int numeroQuarto) throws DadosInvalidosException {
        Reserva reserva = buscarReservaPorNumeroQuarto(numeroQuarto);
        if (reserva == null) {
            throw new DadosInvalidosException("\nReserva não encontrada.");
        }
        reserva.cancelarReserva();
        reservas.remove(reserva);
    }

    private Reserva buscarReservaPorNumeroQuarto(int numeroQuarto) {
        for (Reserva reserva : reservas) {
            if (reserva.getQuarto().getNumero() == numeroQuarto) {
                return reserva;
            }
        }
        return null;
    }

    // 5. Check-in e Check-out

    // Check-in
    public void realizarCheckIn(int numeroQuarto, String cpfHospede, LocalDate dataEntrada, LocalDate dataSaida) {
        Quarto quarto = buscarQuartoPorNumero(numeroQuarto);
        Hospede hospede = buscarHospedePorCpf(cpfHospede);

        if (quarto != null && hospede != null && quarto.isDisponivel()) {
            
            Estadia novaEstadia = new Estadia(hospede, quarto, dataEntrada, dataSaida);
            estadias.add(novaEstadia);

            quarto.setDisponivel(false);
            quarto.setOcupado(true);
            
            System.out.println("\nCheck-in realizado com sucesso para " + hospede.getNome());
        } else {
            System.out.println("\nCheck-in não pode ser realizado. Quarto ou hóspede não encontrado ou quarto já ocupado.");
        }
    }

    public void realizarCheckOut(int numeroQuarto) {
        Quarto quarto = buscarQuartoPorNumero(numeroQuarto);
        
        if (quarto != null && !quarto.isDisponivel()) {
            quarto.setDisponivel(true);
            quarto.setOcupado(false);
            
            System.out.println("\nCheck-out realizado com sucesso!");
        } else {
            System.out.println("\nQuarto não está ocupado.");
        }
    }
    public void visualizarHistoricoEstadias(Hospede hospede) {
        System.out.println("\nHistórico de estadias de " + hospede.getNome() + ":");
        boolean temEstadias = false;

        for (Estadia estadia : estadias) {
            if (estadia.getHospede().equals(hospede)) {
                System.out.printf("Quarto: %s, Data de entrada: %s, Data de saída: %s\n",
                                  estadia.getQuarto().getNumero(),
                                  estadia.getDataEntrada(),
                                  estadia.getDataSaida());
                temEstadias = true;
            }
        }

        if (!temEstadias) {
            System.out.println("Nenhuma estadia encontrada.");
        }
    }

    public void registrarEstadia(Hospede hospede, Quarto quarto, LocalDate dataEntrada, LocalDate dataSaida) {
        Estadia novaEstadia = new Estadia(hospede, quarto, dataEntrada, dataSaida);
        estadias.add(novaEstadia);
    }
}