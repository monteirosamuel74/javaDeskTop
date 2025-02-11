package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainView extends JFrame {
    public MainView() {
        setTitle("Sistema de Gestão PDCA e 5W2H");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Opções");
        JMenuItem novaFerramentaItem = new JMenuItem("Criar Nova Ferramenta");
        JMenuItem cadastroUsuarioItem = new JMenuItem("Cadastrar Usuário");
        JMenuItem consultaItem = new JMenuItem("Consultar Ferramentas");
        JMenuItem edicaoItem = new JMenuItem("Editar Ferramentas");

        novaFerramentaItem.addActionListener(e -> new CriarFerramentaView().setVisible(true));
        cadastroUsuarioItem.addActionListener(e -> new CadastroUsuarioView().setVisible(true));
        consultaItem.addActionListener(e -> new ConsultaView().setVisible(true));
        edicaoItem.addActionListener(e -> new EdicaoView().setVisible(true));

        menu.add(novaFerramentaItem);
        menu.add(cadastroUsuarioItem);
        menu.add(consultaItem);
        menu.add(edicaoItem);
        menuBar.add(menu);
        setJMenuBar(menuBar);
    }
}