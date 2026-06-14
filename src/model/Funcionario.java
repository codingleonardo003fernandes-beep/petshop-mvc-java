package model.model;

import java.io.Serializable;

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

    public int getId() { return id; }
    public String getCargo() { return cargo; }
    public void setCargo(String cargo) { this.cargo = cargo; }
    public double getSalario() { return salario; }
    public void setSalario(double salario) { this.salario = salario; }

    public static class Relatorio implements Serializable {
        private static final long serialVersionUID = 1L;

        private int id;
        private String titulo;
        private String filtro;
        private String resultado;

        public Relatorio(int id, String titulo, String filtro, String resultado) {
            this.id = id;
            this.titulo = titulo;
            this.filtro = filtro;
            this.resultado = resultado;
        }

        public int getId() { return id; }
        public String getTitulo() { return titulo; }
        public String getFiltro() { return filtro; }
        public String getResultado() { return resultado; }
        public void setResultado(String resultado) { this.resultado = resultado; }
    }
}
