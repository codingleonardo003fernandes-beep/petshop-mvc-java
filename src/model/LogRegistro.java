package model;

import java.io.Serializable;
import java.time.LocalDateTime;

public class LogRegistro implements Serializable{
    private static final long serialVersionUID = 1L;

    private LocalDateTime dataHora;
    private String tipo;
    private String mensagem;

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public String getTipo() {
        return tipo;
    }

    public String getMensagem() {
        return mensagem;
    }
}
