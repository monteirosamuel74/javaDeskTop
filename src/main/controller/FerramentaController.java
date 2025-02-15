package controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import model.Ferramenta;
import model.PDCA;
import model.CincoW2H;
import util.RuntimeTypeAdapterFactory;
import util.JsonUtil;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class FerramentaController {
    private static final String FILE_PATH = "resources/ferramentas.json";
    private List<Ferramenta> ferramentas;
    private static final Gson gson;

    static {
        // Configura o Gson para suportar subclasses de Ferramenta
        RuntimeTypeAdapterFactory<Ferramenta> typeAdapterFactory = RuntimeTypeAdapterFactory
            .of(Ferramenta.class, "tipo") // "tipo" é o campo discriminador
            .registerSubtype(PDCA.class, "PDCA")
            .registerSubtype(CincoW2H.class, "5W2H");

        gson = new GsonBuilder()
            .registerTypeAdapterFactory(typeAdapterFactory)
            .create();
    }

    public FerramentaController() {
        ferramentas = loadFerramentas();
    }

    public List<Ferramenta> getFerramentas() {
        return ferramentas;
    }

    public void addFerramenta(Ferramenta ferramenta) {
        ferramentas.add(ferramenta);
        saveFerramentas(ferramentas);
    }

    public void updateFerramenta(Ferramenta ferramentaAtualizada) {
        // Encontra a ferramenta na lista e atualiza seus dados
        for (int i = 0; i < ferramentas.size(); i++) {
            Ferramenta ferramenta = ferramentas.get(i);
            if (ferramenta.getNome().equals(ferramentaAtualizada.getNome())) {
                ferramentas.set(i, ferramentaAtualizada); // Atualiza a ferramenta na lista
                break;
            }
        }
        saveFerramentas(ferramentas); // Salva as alterações no arquivo JSON
    }

    private List<Ferramenta> loadFerramentas() {
        File file = new File(FILE_PATH);

        // Se o arquivo não existir ou estiver vazio, cria um arquivo com um array vazio
        if (!file.exists() || file.length() == 0) {
            try {
                file.createNewFile();
                saveFerramentas(new ArrayList<>()); // Salva uma lista vazia
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try (FileReader reader = new FileReader(FILE_PATH)) {
            Type type = new TypeToken<List<Ferramenta>>() {}.getType();
            return gson.fromJson(reader, type);
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public void saveFerramentas(List<Ferramenta> ferramentas) {
        JsonUtil.saveToJson(ferramentas, FILE_PATH);
    }
}