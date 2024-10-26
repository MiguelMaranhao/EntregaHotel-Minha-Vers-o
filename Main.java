package HotelMV;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Hotel hotel = new Hotel();
        boolean executando = true;

        while (executando) {
            System.out.println("-----------------------------------------------");
            System.out.println("\nOlá, seja Bem Vindo(a) ao sistema de gerenciamento do nosso Hotel\n");
            System.out.println("Segue as nossas opções:\n");
            System.out.println("1  = Cadastrar Quarto");
            System.out.println("2  = Cadastrar Hóspede");
            System.out.println("3  = Realizar Check-in");
            System.out.println("4  = Realizar Check-out");
            System.out.println("5  = Listar Quartos Disponíveis");
            System.out.println("6  = Listar Quartos Ocupados");
            System.out.println("7  = Listar Hóspedes Cadastrados");
            System.out.println("8  = Cadastrar Funcionários");
            System.out.println("9  = Listar Funcionários");
            System.out.println("10 = Editar informações dos hóspedes");
            System.out.println("11 = Editar Informações dos Funcionários");
            System.out.println("12 = Visualizar Histórico de estadias");
            System.out.println("13 = Calcular Salário dos Funcionários");
            System.out.println("14 = Criar Reserva");
            System.out.println("15 = Cancelar Reserva");
            System.out.println("16 = Sair\n");
            System.out.print("\nDigite dentre as nossas opções, a sua escolha: \n ");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a nova linha

            try {
                switch (opcao) {
                case 1: // Cadastrar Quarto
                    System.out.print("\nDigite o número do quarto: ");
                    String inputNumero = scanner.nextLine();
                    if (inputNumero.isEmpty()) {
                        System.out.println("\nCadastro de quarto cancelado! Número do quarto não informado.");
                        break;
                    }
                    int numero = Integer.parseInt(inputNumero);

                    System.out.print("\nDigite o tipo de quarto (Solteiro/ Casal / Suíte): ");
                    String tipo = scanner.nextLine().toLowerCase();
                    if (!(tipo.equals("solteiro") || tipo.equals("casal") || tipo.equals("grande") || tipo.equals("suíte") || tipo.equals("suite") || tipo.equals(""))) {
                        System.out.println("\nImpossível cadastrar! Tipo do quarto não informado ou não coincide com o Tipo de quarto que trabalhamos (Solteiro, Casal ou Suíte).");
                        break;
                    }

                    System.out.print("\nDigite a capacidade do quarto ( 1, 2, 3, 4 ): ");
                    String inputCapacidade = scanner.nextLine();
                    if (!(inputCapacidade.equals("1") || inputCapacidade.equals("2") || inputCapacidade.equals("3") || inputCapacidade.equals("4"))) {
                        System.out.println("\nImpossível cadastrar! Capacidade do quarto não informada ou não corresponde ao limite de capacidade que nossos quartos possuem ( 1, 2 , 3, 4 )");
                        break;
                    }

                    int capacidade = Integer.parseInt(inputCapacidade);

                    System.out.print("\nDigite o preço da diária (Em R$ ): ");
                    double preco = scanner.nextDouble();

                    Quarto quarto = new Quarto (numero, tipo, capacidade, preco);
                    hotel.cadastrarQuarto(quarto);
                    break;
                    

                case 2: // Cadastrar Hóspede
                    System.out.print("\nDigite o nome do hóspede: ");
                    String nomeHospede = scanner.nextLine();
                    if (nomeHospede.equals("")) {
                        System.out.println("\nImpossível cadastrar! Nome do Hóspede não informado!");
                        break;
                    }

                    System.out.print("\nDigite o CPF do hóspede ( 11 dígitos ): ");
                    String cpfHospede = scanner.nextLine();
                    if (cpfHospede.equals("")) {
                        System.out.println("\nImpossível cadastrar! CPF do Hóspede não informado!");
                        break;
                    }

                    System.out.print("\nDigite a data de nascimento do hóspede (dd/mm/aaaa): ");
                    String dataNascimento = scanner.nextLine();
                    if (dataNascimento.equals("")) {
                        System.out.println("\nImpossível cadastrar! Data de Nascimento do Hóspede não informada!");
                        break;
                    }

                    System.out.print("\nDigite o endereço do hóspede: ");
                    String endereco = scanner.nextLine();
                    if (endereco.equals("")) {
                        System.out.println("\nImpossível cadastrar! Endereço do Hóspede não informado!");
                        break;
                    }

                    System.out.print("\nDigite o número de contato do hóspede: ");
                    String numeroContato = scanner.nextLine();
                    if (numeroContato.equals("")) {
                        System.out.println("\nImpossível cadastrar! Contato do Hóspede não informado.");
                        break;
                    }

                    Hospede hospede = new Hospede(nomeHospede, cpfHospede, dataNascimento, endereco, numeroContato);
                    hotel.cadastrarHospede(hospede);
                   System.out.println("\nHóspede cadastrado com Sucesso!");
                    break;

                case 3: // Realizar Check-in
                    System.out.print("\nDigite o número do quarto para check-in: ");
                    String InputnumeroQuartoCheckIn = scanner.nextLine();
                    if (InputnumeroQuartoCheckIn.equals("")) {
                        System.out.println("\nImpossível realizar Check-in! Número do quarto não informado.");
                        break;
                    }

                    int numeroQuartoCheckIn = Integer.parseInt(InputnumeroQuartoCheckIn);

                    System.out.print("\nDigite o CPF do hóspede: ");
                    String cpfHospedeCheckIn = scanner.nextLine();
                    if (cpfHospedeCheckIn.equals("")) {
                        System.out.println("\nImpossível realizar Check-in! CPF do Hóspede não informado.");
                        break;
                    }

                    hotel.realizarCheckIn(numeroQuartoCheckIn, cpfHospedeCheckIn, null, null);
                    break;

                case 4: // Realizar Check-out
                    System.out.print("\nDigite o número do quarto para check-out: ");
                    String InputnumeroQuartoCheckOut = scanner.nextLine();
                    if (InputnumeroQuartoCheckOut.equals("")) {
                        System.out.println("\nImpossível realizar Check-out! Número do quarto não informado.");
                        break;
                    }

                    int numeroQuartoCheckOut = Integer.parseInt(InputnumeroQuartoCheckOut);

                    hotel.realizarCheckOut(numeroQuartoCheckOut);
                    break;

                case 5: // Listar Quartos Disponíveis
                    System.out.println("\nListando quartos disponíveis:");
                    hotel.listarQuartosDisponiveis();
                    break;

                case 6: // Listar Quartos Ocupados
                    System.out.println("\nListando quartos ocupados:");
                    hotel.listarQuartosOcupados();
                    break;

                case 7: // Listar Hóspedes Cadastrados
                    System.out.println("\nListando hóspedes cadastrados:");
                    hotel.listarHospedes();
                    break;
                    
                case 8: // Cadastrar Funcionários
                    System.out.print("\nDigite o nome do funcionário: ");
                    String nomeFuncionario = scanner.nextLine();
                    if (nomeFuncionario.equals("")) {
                        System.out.println("\nImpossível cadastrar! Nome do Funcionário não informado!");
                        break;
                    }

                    System.out.print("\nDigite o CPF do funcionário (11 dígitos): ");
                    String cpfFuncionario = scanner.nextLine();
                    if (cpfFuncionario.equals("")) {
                        System.out.println("\nImpossível cadastrar! CPF do Funcionário não informado!");
                        break;
                    }

                    System.out.print("\nDigite o cargo do funcionário: ");
                    String cargoFuncionario = scanner.nextLine();
                    if (cargoFuncionario.equals("")) {
                        System.out.println("\nImpossível cadastrar! Cargo do Funcionário não informado!");
                        break;
                    }

                    System.out.print("\nDigite o salário do funcionário: ");
                    double salarioFuncionario;
                    try {
                        salarioFuncionario = scanner.nextDouble();
                        scanner.nextLine(); // Consumir a nova linha
                    } catch (Exception e) {
                        System.out.println("\nImpossível cadastrar! Salário inválido.");
                        scanner.nextLine(); 
                        break;
                    }

                    Funcionario funcionario = new Funcionario(nomeFuncionario, cpfFuncionario, cargoFuncionario, salarioFuncionario);
                    hotel.cadastrarFuncionario(funcionario);
                    break;
                    
                case 9: // Listar Funcionários
                    hotel.listarFuncionarios();
                    break;
                
                case 10: 
                	System.out.print("\nDigite o CPF do hóspede que deseja editar: ");
                    String cpfParaEditar = scanner.nextLine();
                    Hospede hospedeParaEditar = hotel.buscarHospedePorCpf(cpfParaEditar);

                    if (hospedeParaEditar != null) {
                        System.out.println("\nInformações atuais do hóspede:");
                        System.out.println(hospedeParaEditar); 

                        
                        System.out.print("\nDigite o novo nome (ou pressione Enter para manter o mesmo): ");
                        String novoNome = scanner.nextLine();
                        if (!novoNome.isEmpty()) {
                            hospedeParaEditar.setNome(novoNome);
                        }

                        System.out.print("\nDigite o novo endereço (ou pressione Enter para manter o mesmo): ");
                        String novoEndereco = scanner.nextLine();
                        if (!novoEndereco.isEmpty()) {
                            hospedeParaEditar.setEndereco(novoEndereco);
                        }

                        System.out.print("\nDigite o novo número de contato (ou pressione Enter para manter o mesmo): ");
                        String novoContato = scanner.nextLine();
                        if (!novoContato.isEmpty()) {
                            hospedeParaEditar.setNumeroContato(novoContato);
                        }

                        System.out.println("\nInformações do hóspede atualizadas com sucesso!");
                    } else {
                        System.out.println("\nHóspede não encontrado.");
                    }
                    break;
                    
                case 11: // Editar Informações dos Funcionários
                    System.out.print("\nDigite o CPF do funcionário a ser editado: ");
                    String cpfFuncionarioEditado = scanner.nextLine();
                    Funcionario funcionarioEditado = hotel.buscarFuncionarioPorCpf(cpfFuncionarioEditado);
                    if (funcionarioEditado == null) {
                        System.out.println("\nFuncionário não encontrado.");
                        break;
                    }

                    System.out.print("\nDigite o novo nome do funcionário (ou pressione Enter para manter): ");
                    String novoNomeFuncionario = scanner.nextLine();
                    if (!novoNomeFuncionario.isEmpty()) {
                        funcionarioEditado.setNome(novoNomeFuncionario);
                    }
                    System.out.print("\nDigite o novo cargo do funcionário (ou pressione Enter para manter): ");
                    String novoCargoFuncionario = scanner.nextLine();
                    if (!novoCargoFuncionario.isEmpty()) {
                        funcionarioEditado.setNome(novoCargoFuncionario);
                    }

                    System.out.print("\nDigite o novo salário do funcionário (ou pressione Enter para manter): ");
                    String novoSalarioInput = scanner.nextLine();
                    if (!novoSalarioInput.isEmpty()) {
                        double novoSalarioFuncionario = Double.parseDouble(novoSalarioInput);
                        funcionarioEditado.setSalario(novoSalarioFuncionario);
                    }

                    

                    System.out.println("\nInformações do funcionário atualizadas com sucesso!");
                    break;

                case 12: // Visualizar Histórico de estadias
                    System.out.print("\nDigite o CPF do hóspede para visualizar o histórico: ");
                    String cpfHospedeHistorico = scanner.nextLine();
                    Hospede hospedeHistorico = hotel.buscarHospedePorCpf(cpfHospedeHistorico);
                    if (hospedeHistorico == null) {
                        System.out.println("\nHóspede não encontrado.");
                        break;
                    }

                    hotel.visualizarHistoricoEstadias(hospedeHistorico);
                    break;

                case 13: // Calcular Salário dos Funcionários
                	System.out.print("\nDigite o nome do funcionário para calcular o salário: ");
                    String nomeFuncionario1 = scanner.nextLine();
                    Funcionario funcionarioParaCalcular = hotel.buscarFuncionarioPorNome(nomeFuncionario1);

                    if (funcionarioParaCalcular != null) {
                        System.out.print("\nDigite a taxa de aumento (em porcentagem): ");
                        double taxaAumento = scanner.nextDouble() / 100; 
                        scanner.nextLine(); 

                        calcularSalario(funcionarioParaCalcular, taxaAumento);
                        System.out.println("\nSalário atualizado do funcionário: R$ " + String.format("%.2f", funcionarioParaCalcular.getSalario()));
                    } else {
                        System.out.println("\nFuncionário não encontrado.");
                    }
                    break;

                case 14: // Criar Reserva
                    System.out.print("\nDigite o CPF do hóspede para a reserva: ");
                    String cpfHospedeReserva = scanner.nextLine();

                    System.out.print("\nDigite o número do quarto para a reserva: ");
                    int numeroQuartoReserva = scanner.nextInt();
                    scanner.nextLine(); // Consumir a nova linha

                    System.out.print("\nDigite a data de entrada (dd/mm/yyyy): ");
                    String dataEntrada = scanner.nextLine();

                    System.out.print("\nDigite a data de saída (dd/mm/yyyy): ");
                    String dataSaida = scanner.nextLine();

                    Hospede hospedeReserva = hotel.buscarHospedePorCpf(cpfHospedeReserva);
                    Quarto quartoReserva = hotel.buscarQuartoPorNumero(numeroQuartoReserva);

                    if (hospedeReserva != null && quartoReserva != null) {
                        hotel.criarReserva(hospedeReserva, quartoReserva, dataEntrada, dataSaida);
                    } else {
                        System.out.println("\nHóspede ou quarto não encontrado.");
                    }
                    break;

                case 15: // Cancelar Reserva
                    System.out.print("\nDigite o número do quarto para cancelar a reserva: ");
                    int numeroQuartoCancelar = scanner.nextInt();

                    hotel.cancelarReserva(numeroQuartoCancelar);
                    break;

                case 16: // Sair
                    executando = false;
                    System.out.println("\nSaindo do sistema...");
                    break;

                default:
                    System.out.println("\nOpção inválida! Tente novamente.");
                    break;
            }
        } catch (Exception e) {
            System.out.println("\nErro: " + e.getMessage());
        }
    }

    scanner.close();
}

	private static void calcularSalario(Funcionario funcionarioParaCalcular, double taxaAumento) {
		// TODO Auto-generated method stub
		
	}
}
