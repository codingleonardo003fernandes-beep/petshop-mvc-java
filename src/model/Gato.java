package model;

public class Gato extends Animal {
    private static final long serialVersionUID = 1L;

    private boolean ehCastrado;

    public Gato(String nome, int idade, String raca, String tutor, boolean ehCastrado) {
        super(nome, idade, raca, tutor);
        this.ehCastrado = ehCastrado;
    }

    public boolean isEhCastrado() { return ehCastrado; }
    public void setEhCastrado(boolean ehCastrado) { this.ehCastrado = ehCastrado; }

    // Sobrescrita do som do gato
    @Override
    public String emitirSom() {
        return "Miau!";
    }

    @Override
    public String toString() {
        String textoCastrado = ehCastrado ? "Sim" : "Não";
        return "Gato: " + getNome() + " | Raça: " + getRaca() + " | Castrado: " + textoCastrado + " | Dono: " + getTutor();
    }
}