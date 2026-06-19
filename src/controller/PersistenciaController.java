package controller;

import model.EstadoSistema;
import util.ArquivoUtil;
import util.LogUtil;

import java.nio.file.Files;
import java.nio.file.Path;

public class PersistenciaController {

    private static final String PASTA_DADOS = "dados";
    private static final String ARQUIVO_ESTADO = "dados/sistema_petshop.dat";

    public EstadoSistema carregarEstado() {
        try {
            EstadoSistema estado = (EstadoSistema) ArquivoUtil.carregarObjeto(ARQUIVO_ESTADO);

            System.out.println("Dados carregados com sucesso!");
            LogUtil.registrar("INFO", "Dados carregados com sucesso.");

            return estado;

        } catch (Exception e) {
            System.out.println("Nenhum dado salvo encontrado. Iniciando sistema novo.");
            LogUtil.registrar("INFO", "Nenhum dado salvo encontrado. Sistema novo iniciado.");

            return new EstadoSistema();
        }
    }

    public void salvarEstado(EstadoSistema estado) {
        try {
            Files.createDirectories(Path.of(PASTA_DADOS));
            ArquivoUtil.salvarObjeto(estado, ARQUIVO_ESTADO);

            System.out.println("Dados salvos com sucesso!");
            LogUtil.registrar("INFO", "Dados salvos com sucesso.");

        } catch (Exception e) {
            System.out.println("[ERRO] Não foi possível salvar os dados: " + e.getMessage());
            LogUtil.registrar("ERRO", "Falha ao salvar dados: " + e.getMessage());
        }
    }
}