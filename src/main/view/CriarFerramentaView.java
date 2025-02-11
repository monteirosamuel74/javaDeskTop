package view;

import javax.swing.*;
import java.awt.GridLayout;

public class CriarFerramentaView extends JFrame {
    public CriarFerramentaView() {
        setTitle("Criar Nova Ferramenta");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(3, 1));
        JButton pdcaButton = new JButton("Criar PDCA");
        JButton cincoW2hButton = new JButton("Criar 5W2H");

        pdcaButton.addActionListener(e -> {
            new CriarPDCAView().setVisible(true);
            dispose();
        });

        cincoW2hButton.addActionListener(e -> {
            new Criar5W2HView().setVisible(true);
            dispose();
        });

        panel.add(new JLabel("Escolha o tipo de ferramenta:"));
        panel.add(pdcaButton);
        panel.add(cincoW2hButton);

        add(panel);
    }
}