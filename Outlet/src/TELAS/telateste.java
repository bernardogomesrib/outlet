package TELAS;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JViewport;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Dimension;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class telateste extends JFrame {

	private JPanel contentPane;
	private JTextField tf_cpf;
	private JTextField tf_data;
	private JTextField tf_quantidade;
	private JTextField tf_idpedido;
	private JTextField tf_cod;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					telateste frame = new telateste();
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
	public telateste() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1013, 647);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl_Cpf_cliente = new JLabel("Cpf do Cliente");
		lbl_Cpf_cliente.setBounds(44, 140, 86, 14);
		contentPane.add(lbl_Cpf_cliente);
		
		tf_cpf = new JTextField();
		tf_cpf.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
			}
		});
		tf_cpf.setBounds(134, 137, 215, 20);
		contentPane.add(tf_cpf);
		tf_cpf.setColumns(10);
		
		JLabel lbl_Gerenciamento_pedido = new JLabel("Gerenciamento de Pedido");
		lbl_Gerenciamento_pedido.setFont(new Font("Tahoma", Font.BOLD, 22));
		lbl_Gerenciamento_pedido.setBounds(350, 44, 303, 27);
		contentPane.add(lbl_Gerenciamento_pedido);
		
		JLabel lbl_Produto = new JLabel("Data");
		lbl_Produto.setBounds(54, 168, 79, 14);
		contentPane.add(lbl_Produto);
		
		tf_data = new JTextField();
		tf_data.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
			}
		});
		tf_data.setBounds(146, 165, 203, 20);
		contentPane.add(tf_data);
		tf_data.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Quantidade do Produto");
		lblNewLabel.setBounds(44, 291, 131, 14);
		contentPane.add(lblNewLabel);
		
		tf_quantidade = new JTextField();
		tf_quantidade.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
			}
		});
		tf_quantidade.setBounds(185, 288, 86, 20);
		contentPane.add(tf_quantidade);
		tf_quantidade.setColumns(10);
		
		JButton btn_Concluir = new JButton("Concluir");
		btn_Concluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_Concluir.setBounds(393, 535, 89, 23);
		contentPane.add(btn_Concluir);
		
		JButton btn_Cancelar = new JButton("Cancelar");
		btn_Cancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_Cancelar.setBounds(535, 535, 89, 23);
		contentPane.add(btn_Cancelar);
		
		tf_idpedido = new JTextField();
		tf_idpedido.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
			}
		});
		tf_idpedido.setColumns(10);
		tf_idpedido.setBounds(134, 106, 215, 20);
		contentPane.add(tf_idpedido);
		
		JLabel lbl_Cpf_cliente_1 = new JLabel("id do pedido");
		lbl_Cpf_cliente_1.setBounds(44, 109, 86, 14);
		contentPane.add(lbl_Cpf_cliente_1);
		
		tf_cod = new JTextField();
		tf_cod.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
			}
		});
		tf_cod.setColumns(10);
		tf_cod.setBounds(185, 260, 86, 20);
		contentPane.add(tf_cod);
		
		JLabel lblIdDoProduto = new JLabel("id do produto");
		lblIdDoProduto.setBounds(44, 263, 131, 14);
		contentPane.add(lblIdDoProduto);
		
		JButton bt_criarpedido = new JButton("Criar pedido");
		bt_criarpedido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		bt_criarpedido.setBounds(10, 202, 103, 23);
		contentPane.add(bt_criarpedido);
		
		JButton bt_apagarPedido = new JButton("Apagar pedido");
		bt_apagarPedido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		bt_apagarPedido.setBounds(123, 202, 103, 23);
		contentPane.add(bt_apagarPedido);
		
		JButton bt_atualizar = new JButton("Atualizar pedido");
		bt_atualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		bt_atualizar.setBounds(236, 202, 113, 23);
		contentPane.add(bt_atualizar);
		
		JButton btn_Concluir_4 = new JButton("Adicionar produto");
		btn_Concluir_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_Concluir_4.setBounds(10, 341, 120, 23);
		contentPane.add(btn_Concluir_4);
		
		JButton btn_Concluir_5 = new JButton("Apagar produto");
		btn_Concluir_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_Concluir_5.setBounds(137, 341, 113, 23);
		contentPane.add(btn_Concluir_5);
		
		JButton btn_Concluir_6 = new JButton("Concluir");
		btn_Concluir_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_Concluir_6.setBounds(260, 341, 89, 23);
		contentPane.add(btn_Concluir_6);
		
		JButton bt_excluirPedido = new JButton("Excluir pedido");
		bt_excluirPedido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		bt_excluirPedido.setBounds(355, 202, 103, 23);
		contentPane.add(bt_excluirPedido);
		
		JButton bt_excluirItemDoPedido = new JButton("Excluir item");
		bt_excluirItemDoPedido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		bt_excluirItemDoPedido.setBounds(369, 341, 89, 23);
		contentPane.add(bt_excluirItemDoPedido);
		table = new JTable();
		table.setBounds(511, 106, 450, 385);
		DefaultTableModel model = (DefaultTableModel) table.getModel(); //
		model.addColumn("Descrição"); // adiciona a coluna 0
		model.addColumn("Quantidade"); // adiciona a coluna 1
		model.addColumn("Preço"); // adiciona a coluna 2
		table.setModel(model);
		//table.getColumnModel().getColumn(0).setPreferredWidth(80); // define a largura da coluna 0
		//table.getColumnModel().getColumn(1).setPreferredWidth(80); // define a largura da coluna 1
		//table.getColumnModel().getColumn(2).setPreferredWidth(80);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(511, 106, 450, 385);
		scrollPane.setLocation(511, 106);
		scrollPane.setSize(450, 385);
		scrollPane.setPreferredSize(new Dimension(450, 385)); // define a largura e altura do ScrollPane
		JViewport viewport = scrollPane.getViewport(); // define a cor de fundo do ScrollPane
		viewport.setBackground(new Color(255,255,255)); 
		contentPane.add(scrollPane);
		
	
		scrollPane.setViewportView(table);
	}
}
