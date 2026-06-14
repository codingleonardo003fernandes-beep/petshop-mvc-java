package util;

import model.LogRegistro;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class LogUtil {
    private static final String CAMINHO_PASTA = "logs";
    private static final String CAMINHO_ARQUIVO = "logs/log.txt";

    public static void registrar(LogRegistro registro) throws IOException {
        Files.createDirectories(Path.of(CAMINHO_PASTA));

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(CAMINHO_ARQUIVO, true))) {
            writer.write(formatarRegistro(registro));
            writer.newLine();
        }
    }

    public static List<String> listarLogs() throws IOException {
        Path caminho = Path.of(CAMINHO_ARQUIVO);

        if (!Files.exists(caminho)) {
            return new ArrayList<>();
        }
        return Files.readAllLines(caminho);
    }

    private static String formatarRegistro(LogRegistro registro) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

        return "[" + registro.getDataHora().format(formatter) + "] "
                + registro.getTipo()
                + " - "
                + registro.getMensagem();
    }
}
