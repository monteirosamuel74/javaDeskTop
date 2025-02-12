package view;

import model.CincoW2H;
import controller.FerramentaController;
import util.ValidationUtil;

import javax.swing.*;
import java.awt.GridLayout;

public class Criar5W2HView extends JFrame {
    private FerramentaController ferramentaController;

    public Criar5W2HView() {
        ferramentaController = new FerramentaController();

        setTitle("Criar 5W2H");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(8, 2));
        JLabel whatLabel = new JLabel("What:");
        JTextField whatField = new JTextField();
        JLabel whyLabel = new JLabel("Why:");
        JTextField whyField = new JTextField();
        JLabel whereLabel = new JLabel("Where:");
        JTextField whereField = new JTextField();
        JLabel whenLabel = new JLabel("When:");
        JTextField whenField = new JTextField();
        JLabel whoLabel = new JLabel("Who:");
        JTextField whoField = new JTextField();
        JLabel howLabel = new JLabel("How:");
        JTextField howField = new JTextField();
        JLabel howMuchLabel = new JLabel("How Much:");
        JTextField howMuchField = new JTextField();
        JButton salvarButton = new JButton("Salvar");

        salvarButton.addActionListener(e -> {
            String what = whatField.getText();
            String why = whyField.getText();
            String where = whereField.getText();
            String when = whenField.getText();
            String who = whoField.getText();
            String how = howField.getText();
            String howMuch = howMuchField.getText();

            // Validação dos campos
            if (ValidationUtil.isNullOrEmpty(what) || ValidationUtil.isNullOrEmpty(why) ||
                ValidationUtil.isNullOrEmpty(where) || ValidationUtil.isNullOrEmpty(when) ||
                ValidationUtil.isNullOrEmpty(who) || ValidationUtil.isNullOrEmpty(how) ||
                ValidationUtil.isNullOrEmpty(howMuch)) {
                JOptionPane.showMessageDialog(this, "Todos os campos são obrigatórios!");
                return;
            }

            // Cria e salva a ferramenta 5W2H
            CincoW2H cincoW2H = new CincoW2H("Novo 5W2H");
            cincoW2H.setWhat(what);
            cincoW2H.setWhy(why);
            cincoW2H.setWhere(where);
            cincoW2H.setWhen(when);
            cincoW2H.setWho(who);
            cincoW2H.setHow(how);
            cincoW2H.setHowMuch(howMuch);

            ferramentaController.addFerramenta(cincoW2H);
            JOptionPane.showMessageDialog(this, "5W2H criado com sucesso!");
            dispose(); // Fecha a tela após salvar
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