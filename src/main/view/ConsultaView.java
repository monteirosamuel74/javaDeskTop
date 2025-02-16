package view;

import controller.FerramentaController;
import model.PDCA;
import model.CincoW2H;

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
        DefaultListModel<String> listModel = new DefaultListModel<>();

        // Carrega PDCA
        List<PDCA> pdcas = ferramentaController.getPdcas();
        for (PDCA pdca : pdcas) {
            listModel.addElement("PDCA: " + pdca.getNome());
        }

        // Carrega 5W2H
        List<CincoW2H> cincoW2Hs = ferramentaController.getCincoW2Hs();
        for (CincoW2H cincoW2H : cincoW2Hs) {
            listModel.addElement("5W2H: " + cincoW2H.getNome());
        }

        JList<String> ferramentasList = new JList<>(listModel);
        JScrollPane scrollPane = new JScrollPane(ferramentasList);

        // Botão para visualizar detalhes
        JButton detalhesButton = new JButton("Ver Detalhes");
        detalhesButton.setEnabled(false); // Desabilita o botão inicialmente

        ferramentasList.addListSelectionListener(e -> {
            detalhesButton.setEnabled(ferramentasList.getSelectedIndex() != -1);
        });

        detalhesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = ferramentasList.getSelectedIndex();
                if (selectedIndex != -1) {
                    String selectedValue = ferramentasList.getSelectedValue();
                    if (selectedValue.startsWith("PDCA:")) {
                        PDCA pdcaSelecionada = pdcas.get(selectedIndex);
                        new DetalhesFerramentaView(pdcaSelecionada).setVisible(true);
                    } else if (selectedValue.startsWith("5W2H:")) {
                        CincoW2H cincoW2HSelecionada = cincoW2Hs.get(selectedIndex - pdcas.size());
                        new DetalhesFerramentaView(cincoW2HSelecionada).setVisible(true);
                    }
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