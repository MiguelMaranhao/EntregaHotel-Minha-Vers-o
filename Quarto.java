package HotelMV;

public class Quarto {
    private int numero;
    private String tipo; // Pode ser "solteiro", "casal" ou "suíte"
    private int capacidade;
    private double preco;
    private boolean disponivel; // True se o quarto está disponível, false se ocupado
    private boolean ocupado;
    // Construtor
    public Quarto(int numero, String tipo, int capacidade, double preco) {
        this.numero = numero;
        this.tipo = tipo;
        this.capacidade = capacidade;
        this.preco = preco;
        this.disponivel = true; // Por padrão, o quarto é criado como disponível
        this.ocupado = false;
    }

    // Métodos de acesso (getters e setters)
    public int getNumero() {
        return numero;
    }

    public String getTipo() {
        return tipo;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public double getPreco() {
        return preco;
    }

    public boolean isDisponivel() {
        return disponivel;
    }
    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel; // Atualiza o status de disponibilidade do quarto
    }


    public void atualizarStatus(boolean disponivel) {
        this.disponivel = disponivel;
    }
    public boolean isOcupado() {
        return ocupado;
    }

    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }
    public void atualizarStatus(String status) {
        if (status.equalsIgnoreCase("disponível")) {
            this.disponivel = true;
        } else if (status.equalsIgnoreCase("ocupado")) {
            this.disponivel = false;
        } else {
            throw new IllegalArgumentException("\nStatus inválido");
        }
    }

    @Override
    public String toString() {
        return "\nQuarto: " + numero + "\nTipo: " + tipo + " \nCapacidade: " + capacidade + " \nPreço: R$ " + preco + " \nStatus: " + disponivel + "";
    }

	
}