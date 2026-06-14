package model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Historico implements Serializable {
    private static final long serialVersionUID = 1L;

    private int id;
    private String nomePet;
    private String descricaoEvento;
    private LocalDateTime dataRegistro;

    public Historico(int id, String nomePet, String descricaoEvento, LocalDateTime dataRegistro) {
        this.id = id;
        this.nomePet = nomePet;
        this.descricaoEvento = descricaoEvento;
        this.dataRegistro = dataRegistro;
    }

    public int getId() { return id; }
    public String getNomePet() { return nomePet; }
    public String getDescricaoEvento() { return descricaoEvento; }
    public LocalDateTime getDataRegistro() { return dataRegistro; }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        return "[" + dataRegistro.format(formatter) + "] Pet: " + nomePet + " -> " + descricaoEvento;
    }
}