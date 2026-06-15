package model;

public class Funcionario extends Pessoa {
    private static final long serialVersionUID = 1L;

    private int id;
    private String cargo;
    private double salario;

    public Funcionario(int id, String nome, String telefone, String endereco, String cargo, double salario) {
        super(nome, telefone, endereco);
        this.id = id;
        this.cargo = cargo;
        this.salario = salario;
    }

    public int getId() {
        return id;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "Funcionário #" + id
                + " | Nome: " + getNome()
                + " | Telefone: " + getTelefone()
                + " | Endereço: " + getEndereco()
                + " | Cargo: " + cargo
                + " | Salário: R$ " + salario;
    }
}