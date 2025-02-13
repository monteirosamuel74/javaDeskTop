package view;

import model.CincoW2H;
import controller.FerramentaController;

import javax.swing.*;
import java.awt.GridLayout;

public class Editar5W2HView extends JFrame {
    private FerramentaController ferramentaController;
    private CincoW2H cincoW2H;

    public Editar5W2HView(CincoW2H cincoW2H) {
        this.cincoW2H = cincoW2H;
        ferramentaController = new FerramentaController();

        setTitle("Editar 5W2H");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(8, 2));
        JLabel whatLabel = new JLabel("What:");
        JTextField whatField = new JTextField(cincoW2H.getWhat());
        JLabel whyLabel = new JLabel("Why:");
        JTextField whyField = new JTextField(cincoW2H.getWhy());
        JLabel whereLabel = new JLabel("Where:");
        JTextField whereField = new JTextField(cincoW2H.getWhere());
        JLabel whenLabel = new JLabel("When:");
        JTextField whenField = new JTextField(cincoW2H.getWhen());
        JLabel whoLabel = new JLabel("Who:");
        JTextField whoField = new JTextField(cincoW2H.getWho());
        JLabel howLabel = new JLabel("How:");
        JTextField howField = new JTextField(cincoW2H.getHow());
        JLabel howMuchLabel = new JLabel("How Much:");
        JTextField howMuchField = new JTextField(cincoW2H.getHowMuch());
        JButton salvarButton = new JButton("Salvar");

        salvarButton.addActionListener(e -> {
            cincoW2H.setWhat(whatField.getText());
            cincoW2H.setWhy(whyField.getText());
            cincoW2H.setWhere(whereField.getText());
            cincoW2H.setWhen(whenField.getText());
            cincoW2H.setWho(whoField.getText());
            cincoW2H.setHow(howField.getText());
            cincoW2H.setHowMuch(howMuchField.getText());
            ferramentaController.updateFerramenta(cincoW2H); // Salva as alterações
            JOptionPane.showMessageDialog(this, "5W2H atualizado com sucesso!");
            dispose();
        });

        panel.add(whatLabel);
        panel.add(whatField);
        panel.add(whyLabel);
        panel.add(whyField);
        panel.add(whereLabel);
        panel.add(whereField);
        panel.add(whenLabel);
        panel.add(whenField);
        panel.add(whoLabel);
        panel.add(whoField);
        panel.add(howLabel);
        panel.add(howField);
        panel.add(howMuchLabel);
        panel.add(howMuchField);
        panel.add(new JLabel()); // Espaço vazio
        panel.add(salvarButton);

        add(panel);
    }
}