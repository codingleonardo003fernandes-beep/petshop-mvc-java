package util;

import java.io.*;

public class ArquivoUtil {

    public static void salvarObjeto(Object objeto, String caminhoArquivo)throws IOException {
        try (ObjectOutputStream saida = new ObjectOutputStream(new FileOutputStream(caminhoArquivo))){
            saida.writeObject(objeto);
        }
    }
    public static Object carregarObjeto(String caminhoArquivo) throws IOException, ClassNotFoundException{
        try (ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(caminhoArquivo))){
            return entrada.readObject();
        }
    }

    }
