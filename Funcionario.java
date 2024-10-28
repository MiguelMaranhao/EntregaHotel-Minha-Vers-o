package HotelMV;
import java.util.Scanner;

public class Funcionario implements Cadastravel {
	 
	    private String nome;
	    private String cpf;
	    private String cargo;
	    private double salario;
	    private int horasTrabalhadas;

	    public Funcionario(String nome, String cpf, String cargo, double salario) {
	        this.nome = nome;
	        this.cpf = cpf;
	        this.cargo = cargo;
	        this.salario = salario;
	        this.horasTrabalhadas = 0;
	    }

	    public void registrarHoras(int horas) {
	        horasTrabalhadas += horas;
	        System.out.println("\nHoras registradas: " + horas);
	    }

	    public double calcularSalario() {
	        return horasTrabalhadas * salario;
	    }

	    @Override
	    public void cadastrar() {
	        System.out.println("\nFuncionário " + nome + " cadastrado com sucesso!");
	    }

	    @Override
	    public void listar() {
	        System.out.println("Nome: " + nome + ", CPF: " + cpf + ", Cargo: " + cargo + ", Salário: " + salario);
	    }

	    public void editarFuncionario(String cargo, double salario) {
	        this.cargo = cargo;
	        this.salario = salario;
	        System.out.println("\nDados do funcionário atualizados.");
	    }
	    public void atualizarInformacoes() {
	        Scanner scanner = new Scanner(System.in);

	        System.out.print("\nDigite o novo nome (atual: " + nome + "): ");
	        String novoNome = scanner.nextLine();
	        if (!novoNome.isEmpty()) this.nome = novoNome;

	        System.out.print("\nDigite o novo cargo (atual: " + cargo + "): ");
	        String novoCargo = scanner.nextLine();
	        if (!novoCargo.isEmpty()) this.cargo = novoCargo;

	        System.out.print("\nDigite o novo salário (atual: " + salario + "): ");
	        double novoSalario = scanner.nextDouble();
	        if (novoSalario > 0) this.salario = novoSalario;

	        System.out.println("\nInformações do funcionário atualizadas com sucesso.");
	    }
	

	    public String getNome() {
	        return nome;
	    }

	    public String getCpf() {
	        return cpf;
	    }

	    public double getSalario() {
	        return salario;
	    }

	    
	    public void setNome(String nome) {
	        this.nome = nome;
	    }

	    public void setCpf(String cpf) {
	        this.cpf = cpf;
	    }

	    public void setSalario(double salario) {
	        this.salario = salario;
	    }

		public String getCargo() {
			return cargo;
		}

		public void setCargo(String cargo) {
			this.cargo = cargo;
			
		}
	}
