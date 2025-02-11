package view;

import controller.FerramentaController;
import model.Ferramenta;
import model.PDCA;
import model.CincoW2H;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.List;

public class EdicaoView extends JFrame {
    private FerramentaController ferramentaController;

    public EdicaoView() {
        ferramentaController = new FerramentaController();

        setTitle("Edição de Ferramentas");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // Lista de ferramentas
        List<Ferramenta> ferramentas = ferramentaController.getFerramentas();
        DefaultListModel<String> listModel = new DefaultListModel<>();
        for (Ferramenta ferramenta : ferramentas) {
            listModel.addElement(ferramenta.getNome() + " - " + ferramenta.getClass().getSimpleName());
        }

        JList<String> ferramentasList = new JList<>(listModel);
        JScrollPane scrollPane = new JScrollPane(ferramentasList);

        // Botão para editar
        JButton editarButton = new JButton("Editar");
        editarButton.addActionListener(e -> {
            int selectedIndex = ferramentasList.getSelectedIndex();
            if (selectedIndex != -1) {
                Ferramenta ferramentaSelecionada = ferramentas.get(selectedIndex);
                if (ferramentaSelecionada instanceof PDCA) {
                    new EditarPDCAView((PDCA) ferramentaSelecionada).setVisible(true);
                } else if (ferramentaSelecionada instanceof CincoW2H) {
                    new Editar5W2HView((CincoW2H) ferramentaSelecionada).setVisible(true);
                }
            } else {
                JOptionPane.showMessageDialog(EdicaoView.this, "Selecione uma ferramenta para editar.");
            }
        });

        // Layout
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(editarButton, BorderLayout.SOUTH);

        add(panel);
    }
}