package controller;

import model.Usuario;
import util.JsonUtil;

import java.util.ArrayList;
import java.util.List;

public class UsuarioController {
    private static final String FILE_PATH = "resources/usuarios.json";
    private List<Usuario> usuarios;

    public UsuarioController() {
        usuarios = loadUsuarios();
    }

    public void addUsuario(Usuario usuario) {
        usuarios.add(usuario);
        saveUsuarios();
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    private List<Usuario> loadUsuarios() {
        return JsonUtil.loadFromJson(FILE_PATH, new com.google.gson.reflect.TypeToken<List<Usuario>>() {}.getType());
    }

    private void saveUsuarios() {
        JsonUtil.saveToJson(usuarios, FILE_PATH);
    }
}