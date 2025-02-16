package controller;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import model.PDCA;
import model.CincoW2H;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class FerramentaController {
    private static final String PDCA_FILE_PATH = "resources/pdcas.json";
    private static final String CINCO_W2H_FILE_PATH = "resources/5w2hs.json";
    private static final Gson gson = new Gson();

    private List<PDCA> pdcas;
    private List<CincoW2H> cincoW2Hs;

    public FerramentaController() {
        pdcas = loadPdcas();
        cincoW2Hs = loadCincoW2Hs();
    }

    // Métodos para PDCA
    public List<PDCA> getPdcas() {
        return loadPdcas();
    }

    public void addPdca(PDCA pdca) {
        pdcas.add(pdca);
        savePdcas();
    }

    private List<PDCA> loadPdcas() {
        try (FileReader reader = new FileReader(PDCA_FILE_PATH)) {
            Type type = new TypeToken<List<PDCA>>() {
            }.getType();
            return gson.fromJson(reader, type);
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    private void savePdcas() {
        try (FileWriter writer = new FileWriter(PDCA_FILE_PATH)) {
            gson.toJson(pdcas, writer);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void savePdcas(List<PDCA> pdcas) {
        try (FileWriter writer = new FileWriter(PDCA_FILE_PATH)) {
            gson.toJson(pdcas, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Métodos para 5W2H
    public List<CincoW2H> getCincoW2Hs() {
        return loadCincoW2Hs();
    }

    public void addCincoW2H(CincoW2H cincoW2H) {
        cincoW2Hs.add(cincoW2H);
        saveCincoW2Hs();
    }

    private List<CincoW2H> loadCincoW2Hs() {
        try (FileReader reader = new FileReader(CINCO_W2H_FILE_PATH)) {
            Type type = new TypeToken<List<CincoW2H>>() {
            }.getType();
            return gson.fromJson(reader, type);
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    private void saveCincoW2Hs() {
        try (FileWriter writer = new FileWriter(CINCO_W2H_FILE_PATH)) {
            gson.toJson(cincoW2Hs, writer);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void saveCincoW2Hs(List<CincoW2H> cincoW2Hs) {
        try (FileWriter writer = new FileWriter(CINCO_W2H_FILE_PATH)) {
            gson.toJson(cincoW2Hs, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}