package view;

import model.PDCA;
import controller.FerramentaController;

import javax.swing.*;
import java.awt.GridLayout;

public class EditarPDCAView extends JFrame {
    private FerramentaController ferramentaController;
    private PDCA pdca;

    public EditarPDCAView(PDCA pdca) {
        this.pdca = pdca;
        ferramentaController = new FerramentaController();

        setTitle("Editar PDCA");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(6, 2));
        JLabel objetivoLabel = new JLabel("Objetivo:");
        JTextField objetivoField = new JTextField(pdca.getObjetivo());
        JLabel planoLabel = new JLabel("Plano:");
        JTextField planoField = new JTextField(pdca.getPlano());
        JButton salvarButton = new JButton("Salvar");

        salvarButton.addActionListener(e -> {
            pdca.setObjetivo(objetivoField.getText());
            pdca.setPlano(planoField.getText());
            ferramentaController.updateFerramenta(pdca); // Salva as alterações
            JOptionPane.showMessageDialog(this, "PDCA atualizado com sucesso!");
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