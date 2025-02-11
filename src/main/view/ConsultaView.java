package view;

import controller.FerramentaController;
import model.Ferramenta;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ConsultaView extends JFrame {
    private FerramentaController ferramentaController;

    public ConsultaView() {
        ferramentaController = new FerramentaController();

        setTitle("Consulta de Ferramentas");
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

        // Botão para visualizar detalhes
        JButton detalhesButton = new JButton("Ver Detalhes");
        detalhesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = ferramentasList.getSelectedIndex();
                if (selectedIndex != -1) {
                    Ferramenta ferramentaSelecionada = ferramentas.get(selectedIndex);
                    new DetalhesFerramentaView(ferramentaSelecionada).setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(ConsultaView.this, "Selecione uma ferramenta para ver os detalhes.");
                }
            }
        });

        // Layout
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(detalhesButton, BorderLayout.SOUTH);

        add(panel);
    }
}