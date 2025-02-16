package view;

import model.PDCA;
import controller.FerramentaController;

import javax.swing.*;
import java.awt.GridLayout;
import java.util.List;

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
        JLabel execucaoLabel = new JLabel("Execução:");
        JTextField execucaoField = new JTextField(pdca.getExecucao());
        JLabel verificacaoLabel = new JLabel("Verificação:");
        JTextField verificacaoField = new JTextField(pdca.getVerificacao());
        JLabel acaoLabel = new JLabel("Ação:");
        JTextField acaoField = new JTextField(pdca.getAcao());
        JButton salvarButton = new JButton("Salvar");

        salvarButton.addActionListener(e -> {
            // Atualiza os dados do PDCA
            pdca.setObjetivo(objetivoField.getText());
            pdca.setPlano(planoField.getText());
            pdca.setExecucao(execucaoField.getText());
            pdca.setVerificacao(verificacaoField.getText());
            pdca.setAcao(acaoField.getText());

            // Carrega a lista de PDCA
            List<PDCA> pdcas = ferramentaController.getPdcas();

            // Encontra a ferramenta na lista e atualiza seus dados
            for (int i = 0; i < pdcas.size(); i++) {
                if (pdcas.get(i).getNome().equals(pdca.getNome())) {
                    pdcas.set(i, pdca); // Atualiza a ferramenta na lista
                    break;
                }
            }

            // Salva a lista atualizada no arquivo JSON
            ferramentaController.savePdcas(pdcas);

            JOptionPane.showMessageDialog(this, "PDCA atualizado com sucesso!");
            dispose(); // Fecha a tela após salvar
        });

        panel.add(objetivoLabel);
        panel.add(objetivoField);
        panel.add(planoLabel);
        panel.add(planoField);
        panel.add(execucaoLabel);
        panel.add(execucaoField);
        panel.add(verificacaoLabel);
        panel.add(verificacaoField);
        panel.add(acaoLabel);
        panel.add(acaoField);
        panel.add(new JLabel()); // Espaço vazio
        panel.add(salvarButton);

        add(panel);
    }
}