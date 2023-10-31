package TELAS;

import java.awt.EventQueue;

import javax.swing.JFrame;

import javax.swing.JPanel;

import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;

import javax.swing.JLayeredPane;

import javax.swing.JMenuBar;

import javax.swing.JMenu;

import javax.swing.JMenuItem;

import java.awt.Color;


import java.awt.Font;

public class Inicia extends JFrame {

private JPanel contentPane;

/**

* Launch the application.

*/

public static void main(String[] args) {

EventQueue.invokeLater(new Runnable() {

public void run() {

try {

Inicia frame = new Inicia();

frame.setVisible(true);

} catch (Exception e) {

e.printStackTrace();

}

}

});

}

/**

* Create the frame.

*/

public Inicia() {

setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

setBounds(100, 100, 800, 630);

contentPane = new JPanel();

contentPane.setBackground(new Color(0, 51, 153));

contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

setContentPane(contentPane);

contentPane.setLayout(null);


JLayeredPane layeredPane = new JLayeredPane();

layeredPane.setBounds(805, -4, -832, 625);

contentPane.add(layeredPane);


JMenuBar menuBar = new JMenuBar();

menuBar.setBackground(Color.WHITE);

menuBar.setBounds(10, 11, 393, 22);

contentPane.add(menuBar);


JMenu MenuCliente = new JMenu("Cliente ");

MenuCliente.setForeground(new Color(0, 0, 0));

MenuCliente.setBackground(new Color(149, 0, 0));

menuBar.add(MenuCliente);


JMenuItem mntmNewMenuItem = new JMenuItem("Controle de Clientes\r\n");

MenuCliente.add(mntmNewMenuItem);


JMenuItem mntmNewMenuItem_4 = new JMenuItem("Cadastramento de endereços\r\n");

MenuCliente.add(mntmNewMenuItem_4);


JMenu MenuProduto = new JMenu("Produtos ");

MenuProduto.setForeground(new Color(0, 0, 0));

menuBar.add(MenuProduto);


JMenuItem mntmNewMenuItem_1 = new JMenuItem("Controle de Produtos");

MenuProduto.add(mntmNewMenuItem_1);


JMenu MenuPedido = new JMenu("Pedidos ");

MenuPedido.setForeground(new Color(0, 0, 0));

menuBar.add(MenuPedido);


JMenuItem mntmNewMenuItem_2 = new JMenuItem("Controle de pedidos");

MenuPedido.add(mntmNewMenuItem_2);


JMenu MenuFornecedor = new JMenu("Fornecedores");

MenuFornecedor.setForeground(new Color(0, 0, 0));

menuBar.add(MenuFornecedor);


JMenuItem mntmNewMenuItem_3 = new JMenuItem("Controle de Fornecedores");

MenuFornecedor.add(mntmNewMenuItem_3);


JLabel lblNewLabel = new JLabel("BEM VINDO!! \r\n");

lblNewLabel.setForeground(Color.WHITE);

lblNewLabel.setFont(new Font("Agency FB", Font.BOLD, 45));

lblNewLabel.setBounds(263, 205, 341, 102);

contentPane.add(lblNewLabel);


JLabel lblNewLabel_1 = new JLabel(" A CENTRAL DE CONTROLE DO SISTEMA");

lblNewLabel_1.setForeground(Color.WHITE);

lblNewLabel_1.setFont(new Font("Agency FB", Font.BOLD, 45));

lblNewLabel_1.setBounds(85, 279, 653, 95);

contentPane.add(lblNewLabel_1);

}

}

