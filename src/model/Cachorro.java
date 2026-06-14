package model;

public class Cachorro extends Animal {
    private static final long serialVersionUID = 1L;

    private String porte;

    // Usa o 'super' para mandar os dados comuns para a mãe salvar
    public Cachorro(String nome, int idade, String raca, String tutor, String porte) {
        super(nome, idade, raca, tutor);
        this.porte = porte;
    }

    public String getPorte() { return porte; }
    public void setPorte(String porte) { this.porte = porte; }

    // Sobrescrita do método abstrato da mãe
    @Override
    public String emitirSom() {
        return "Au Au!";
    }

    @Override
    public String toString() {
        return "Cachorro: " + getNome() + " | Raça: " + getRaca() + " | Porte: " + porte + " | Dono: " + getTutor();
    }
}