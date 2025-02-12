package view;

import model.PDCA;
import model.Usuario;
import util.ValidationUtil;
import controller.FerramentaController;

import javax.swing.*;
import java.awt.GridLayout;
import java.util.List;

public class CriarPDCAView extends JFrame {
    private FerramentaController ferramentaController;

    public CriarPDCAView() {
        ferramentaController = new FerramentaController();

        setTitle("Criar PDCA");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(6, 2));
        JLabel objetivoLabel = new JLabel("Objetivo:");
        JTextField objetivoField = new JTextField();
        JLabel planoLabel = new JLabel("Plano:");
        JTextField planoField = new JTextField();
        JButton salvarButton = new JButton("Salvar");

        salvarButton.addActionListener(e -> {
            String objetivo = objetivoField.getText();
            String plano = planoField.getText();

            if (ValidationUtil.isNullOrEmpty(objetivo) || ValidationUtil.isNullOrEmpty(plano)) {
                JOptionPane.showMessageDialog(this, "Preencha todos os campos!");
                return;
            }

            PDCA pdca = new PDCA("Novo PDCA");
            pdca.setObjetivo(objetivo);
            pdca.setPlano(plano);

            ferramentaController.addFerramenta(pdca);
            JOptionPane.showMessageDialog(this, "PDCA criado com sucesso!");
            dispose();
        });

        panel.add(objetivoLabel);
        panel.add(objetivoField);
        panel.add(planoLabel);
        panel.add(planoField);
        panel.add(new JLabel()); // Espaço vazio
        panel.add(salvarButton);

        add(panel);
    }
}