package controller;

import model.Ferramenta;
import util.JsonUtil;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class FerramentaController {
    private static final String FILE_PATH = "resources/ferramentas.json";
    private List<Ferramenta> ferramentas;
    private static final Gson gson = new Gson();

    public FerramentaController() {
        ferramentas = loadFerramentas();
    }

    public void addFerramenta(Ferramenta ferramenta) {
        ferramentas.add(ferramenta);
        saveFerramentas(ferramentas);
    }

    public List<Ferramenta> getFerramentas() {
        return loadFerramentas();
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
    
    public void updateFerramenta(Ferramenta ferramentaAtualizada) {
        boolean encontrou = false;
        for (int i = 0; i < ferramentas.size(); i++) {
            Ferramenta ferramenta = ferramentas.get(i);
            if (ferramenta.getNome().equals(ferramentaAtualizada.getNome())) { // Comparação pelo nome
                ferramentas.set(i, ferramentaAtualizada); // Substitui a ferramenta antiga pela atualizada
                encontrou = true;
                break;
            }
        }
        if (!encontrou) {
            System.err.println("Ferramenta não encontrada para atualização.");
        } else {
            saveFerramentas(ferramentas); // Salva as alterações no arquivo JSON
        }
    }
}