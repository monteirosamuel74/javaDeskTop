package view;

import controller.UsuarioController;
import model.Usuario;
import util.ValidationUtil;

import javax.swing.*;
import java.awt.GridLayout;

public class CadastroUsuarioView extends JFrame {
    private UsuarioController usuarioController;

    public CadastroUsuarioView() {
        usuarioController = new UsuarioController();

        setTitle("Cadastro de Usuário");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(4, 2));
        JLabel nomeLabel = new JLabel("Nome:");
        JTextField nomeField = new JTextField();
        JLabel funcaoLabel = new JLabel("Função:");
        JTextField funcaoField = new JTextField();
        JLabel contatoLabel = new JLabel("Contato:");
        JTextField contatoField = new JTextField();
        JButton salvarButton = new JButton("Salvar");

        salvarButton.addActionListener(e -> {
            String nome = nomeField.getText();
            String funcao = funcaoField.getText();
            String contato = contatoField.getText();

            // Validação dos campos
            if (ValidationUtil.isNullOrEmpty(nome) || ValidationUtil.isNullOrEmpty(funcao) || ValidationUtil.isNullOrEmpty(contato)) {
                JOptionPane.showMessageDialog(this, "Todos os campos são obrigatórios!");
                return;
            }

            // Cria e salva o usuário
            Usuario usuario = new Usuario(nome, funcao, contato);
            usuarioController.addUsuario(usuario);
            JOptionPane.showMessageDialog(this, "Usuário cadastrado com sucesso!");
            dispose(); // Fecha a tela após salvar
        });

        panel.add(nomeLabel);
        panel.add(nomeField);
        panel.add(funcaoLabel);
        panel.add(funcaoField);
        panel.add(contatoLabel);
        panel.add(contatoField);
        panel.add(new JLabel()); // Espaço vazio
        panel.add(salvarButton);

        add(panel);
    }
}