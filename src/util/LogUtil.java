package util;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LogUtil {

    private static final String PASTA_LOGS = "logs";
    private static final String ARQUIVO_LOG = "logs/log.txt";

    public static void registrar(String tipo, String mensagem) {
        try {
            Files.createDirectories(Path.of(PASTA_LOGS));

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(ARQUIVO_LOG, true))) {
                writer.write(formatarLog(tipo, mensagem));
                writer.newLine();
            }

        } catch (IOException e) {
            System.out.println("[ERRO] Não foi possível registrar log: " + e.getMessage());
        }
    }

    private static String formatarLog(String tipo, String mensagem) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String dataHora = LocalDateTime.now().format(formatter);

        return "[" + dataHora + "] " + tipo + " - " + mensagem;
    }
}