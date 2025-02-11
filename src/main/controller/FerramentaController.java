package controller;

import model.Ferramenta;
import util.JsonUtil;

import java.util.ArrayList;
import java.util.List;

public class FerramentaController {
    private static final String FILE_PATH = "src/resources/ferramentas.json";
    private List<Ferramenta> ferramentas;

    public FerramentaController() {
        ferramentas = loadFerramentas();
    }

    public void addFerramenta(Ferramenta ferramenta) {
        ferramentas.add(ferramenta);
        saveFerramentas();
    }

    public List<Ferramenta> getFerramentas() {
        return ferramentas;
    }

    private List<Ferramenta> loadFerramentas() {
        return JsonUtil.loadFromJson(FILE_PATH, new com.google.gson.reflect.TypeToken<List<Ferramenta>>() {}.getType());
    }

    private void saveFerramentas() {
        JsonUtil.saveToJson(ferramentas, FILE_PATH);
    }
}