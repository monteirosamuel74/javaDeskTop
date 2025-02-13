package view;

import controller.FerramentaController;
import model.PDCA;
import util.ValidationUtil;

import javax.swing.*;
import java.awt.GridLayout;

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
        JLabel execucaoLabel = new JLabel("Execução:");
        JTextField execucaoField = new JTextField();
        JLabel verificacaoLabel = new JLabel("Verificação:");
        JTextField verificacaoField = new JTextField();
        JLabel acaoLabel = new JLabel("Ação:");
        JTextField acaoField = new JTextField();
        JButton salvarButton = new JButton("Salvar");

        salvarButton.addActionListener(e -> {
            String objetivo = objetivoField.getText();
            String plano = planoField.getText();
            String execucao = execucaoField.getText();
            String verificacao = verificacaoField.getText();
            String acao = acaoField.getText();

            // Validação dos campos
            if (ValidationUtil.isNullOrEmpty(objetivo) || ValidationUtil.isNullOrEmpty(plano) ||
                ValidationUtil.isNullOrEmpty(execucao) || ValidationUtil.isNullOrEmpty(verificacao) ||
                ValidationUtil.isNullOrEmpty(acao)) {
                JOptionPane.showMessageDialog(this, "Preencha todos os campos!");
                return;
            }

            // Cria e salva a ferramenta PDCA
            PDCA pdca = new PDCA("Novo PDCA");
            pdca.setObjetivo(objetivo);
            pdca.setPlano(plano);
            pdca.setExecucao(execucao);
            pdca.setVerificacao(verificacao);
            pdca.setAcao(acao);

            ferramentaController.addFerramenta(pdca); // Adiciona a ferramenta à lista
            ferramentaController.saveFerramentas(ferramentaController.getFerramentas()); // Salva a lista atualizada
            JOptionPane.showMessageDialog(this, "PDCA criado com sucesso!");
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