package view;

import model.Ferramenta;
import model.PDCA;
import model.CincoW2H;

import javax.swing.*;
import java.awt.GridLayout;

public class DetalhesFerramentaView extends JFrame {
    public DetalhesFerramentaView(Ferramenta ferramenta) {
        setTitle("Detalhes da Ferramenta");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(0, 1));

        if (ferramenta instanceof PDCA) {
            PDCA pdca = (PDCA) ferramenta;
            panel.add(new JLabel("Tipo: PDCA"));
            panel.add(new JLabel("Objetivo: " + pdca.getObjetivo()));
            panel.add(new JLabel("Plano: " + pdca.getPlano()));
            panel.add(new JLabel("Execução: " + pdca.getExecucao()));
            panel.add(new JLabel("Verificação: " + pdca.getVerificacao()));
            panel.add(new JLabel("Ação: " + pdca.getAcao()));
        } else if (ferramenta instanceof CincoW2H) {
            CincoW2H cincoW2H = (CincoW2H) ferramenta;
            panel.add(new JLabel("Tipo: 5W2H"));
            panel.add(new JLabel("What: " + cincoW2H.getWhat()));
            panel.add(new JLabel("Why: " + cincoW2H.getWhy()));
            panel.add(new JLabel("Where: " + cincoW2H.getWhere()));
            panel.add(new JLabel("When: " + cincoW2H.getWhen()));
            panel.add(new JLabel("Who: " + cincoW2H.getWho()));
            panel.add(new JLabel("How: " + cincoW2H.getHow()));
            panel.add(new JLabel("How Much: " + cincoW2H.getHowMuch()));
        }

        add(panel);
    }
}