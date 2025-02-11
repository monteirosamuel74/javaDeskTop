package view;

import javax.swing.*;
import java.awt.GridLayout;

public class CadastroView extends JFrame {
    public CadastroView() {
        setTitle("Cadastro");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(5, 2));
        JLabel nomeLabel = new JLabel("Nome:");
        JTextField nomeField = new JTextField();
        JLabel emailLabel = new JLabel("Email:");
        JTextField emailField = new JTextField();
        JLabel idadeLabel = new JLabel("Idade:");
        JTextField idadeField = new JTextField();
        JButton salvarButton = new JButton("Salvar");

        panel.add(nomeLabel);
        panel.add(nomeField);
        panel.add(emailLabel);
        panel.add(emailField);
        panel.add(idadeLabel);
        panel.add(idadeField);
        panel.add(new JLabel()); // Espaço vazio
        panel.add(salvarButton);

        add(panel);
    }
}