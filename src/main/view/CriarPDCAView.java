package view;

import controller.FerramentaController;
import controller.UsuarioController;
import model.PDCA;
import model.Usuario;
import util.ValidationUtil;

import javax.swing.*;
import java.awt.GridLayout;
import java.util.List;

public class CriarPDCAView extends JFrame {
    private FerramentaController ferramentaController;
    private UsuarioController usuarioController;

    public CriarPDCAView() {
        ferramentaController = new FerramentaController();
        usuarioController = new UsuarioController();

        setTitle("Criar PDCA");
        setSize(400, 500); 
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(9, 2)); 
        JLabel nomeLabel = new JLabel("Nome:");
        JTextField nomeField = new JTextField();
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

        // Lista de usuários disponíveis
        List<Usuario> usuariosDisponiveis = usuarioController.getUsuarios();
        DefaultListModel<Usuario> usuariosListModel = new DefaultListModel<>();
        for (Usuario usuario : usuariosDisponiveis) {
            usuariosListModel.addElement(usuario);
        }
        JList<Usuario> usuariosList = new JList<>(usuariosListModel);
        JScrollPane usuariosScrollPane = new JScrollPane(usuariosList);

        JButton adicionarParticipanteButton = new JButton("Adicionar Participante");
        JButton salvarButton = new JButton("Salvar");

        // Lógica para adicionar participantes
        adicionarParticipanteButton.addActionListener(e -> {
            Usuario usuarioSelecionado = usuariosList.getSelectedValue();
            if (usuarioSelecionado != null) {
                // Aqui você pode adicionar o usuário à ferramenta
                JOptionPane.showMessageDialog(this, "Participante adicionado com sucesso!");
            } else {
                JOptionPane.showMessageDialog(this, "Selecione um usuário para adicionar.");
            }
        });

        // Lógica para salvar a ferramenta
        salvarButton.addActionListener(e -> {
            String nome = nomeField.getText();
            String objetivo = objetivoField.getText();
            String plano = planoField.getText();
            String execucao = execucaoField.getText();
            String verificacao = verificacaoField.getText();
            String acao = acaoField.getText();

            // Validação dos campos
            if (ValidationUtil.isNullOrEmpty(nome) || ValidationUtil.isNullOrEmpty(objetivo) ||
                ValidationUtil.isNullOrEmpty(plano) || ValidationUtil.isNullOrEmpty(execucao) ||
                ValidationUtil.isNullOrEmpty(verificacao) || ValidationUtil.isNullOrEmpty(acao)) {
                JOptionPane.showMessageDialog(this, "Preencha todos os campos!");
                return;
            }

            // Cria a ferramenta PDCA
            PDCA pdca = new PDCA(nome);
            pdca.setObjetivo(objetivo);
            pdca.setPlano(plano);
            pdca.setExecucao(execucao);
            pdca.setVerificacao(verificacao);
            pdca.setAcao(acao);

            // Adiciona os participantes selecionados
            List<Usuario> participantesSelecionados = usuariosList.getSelectedValuesList();
            for (Usuario usuario : participantesSelecionados) {
                pdca.adicionarParticipante(usuario);
            }

            // Salva a ferramenta
            ferramentaController.addPdca(pdca);
            JOptionPane.showMessageDialog(this, "PDCA criado com sucesso!");
            dispose(); // Fecha a tela após salvar
        });

        // Adiciona os componentes ao painel
        panel.add(nomeLabel);
        panel.add(nomeField);
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
        panel.add(new JLabel("Participantes:"));
        panel.add(usuariosScrollPane);
        panel.add(adicionarParticipanteButton);
        panel.add(new JLabel()); // Espaço vazio
        panel.add(salvarButton);

        add(panel);
    }
}