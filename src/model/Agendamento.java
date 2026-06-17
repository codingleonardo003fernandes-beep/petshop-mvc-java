package model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class Agendamento implements Serializable {
    private static final long serialVersionUID = 1L;
    

    private int id;
    private Animal pet;       
    private Servico servico;   
    private LocalDateTime dataHora;
    private String status;     


    public Agendamento(int id, Animal pet, Servico servico, LocalDateTime dataHora) {
        this.id = id;
        this.pet = pet;
        this.servico = servico;
        this.dataHora = dataHora;
        this.status = "Pendente"; 
    }


    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public Animal getPet() { return pet; }
    public void setPet(Animal pet) { this.pet = pet; }

    public Servico getServico() { return servico; }
    public void setServico(Servico servico) { this.servico = servico; }

    public LocalDateTime getDataHora() { return dataHora; }
    public void setDataHora(LocalDateTime dataHora) { this.dataHora = dataHora; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }


    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        
        String nomePet = (pet != null) ? pet.getNome() : "Não Informado";
        String nomeServico = (servico != null) ? servico.getNome() : "Não Informado";
        String dataFormatada = dataHora.format(formatter);
        
        return "Agendamento #" + id + " | Pet: " + nomePet + " | Serviço: " + nomeServico + " | Data: " + dataFormatada + " | Status: " + status;
    }
}
