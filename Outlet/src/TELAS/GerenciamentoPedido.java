package TELAS;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class GerenciamentoPedido extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GerenciamentoPedido frame = new GerenciamentoPedido();
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
	public GerenciamentoPedido() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1013, 647);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl_Cpf_cliente = new JLabel("Cpf do Cliente");
		lbl_Cpf_cliente.setBounds(44, 204, 86, 14);
		contentPane.add(lbl_Cpf_cliente);
		
		textField = new JTextField();
		textField.setBounds(134, 201, 215, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lbl_Gerenciamento_pedido = new JLabel("Gerenciamento de Pedido");
		lbl_Gerenciamento_pedido.setFont(new Font("Tahoma", Font.BOLD, 22));
		lbl_Gerenciamento_pedido.setBounds(350, 44, 303, 27);
		contentPane.add(lbl_Gerenciamento_pedido);
		
		JLabel lbl_Produto = new JLabel("Produto");
		lbl_Produto.setBounds(44, 275, 46, 14);
		contentPane.add(lbl_Produto);
		
		textField_1 = new JTextField();
		textField_1.setBounds(103, 272, 203, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Quantidade do Produto");
		lblNewLabel.setBounds(44, 350, 131, 14);
		contentPane.add(lblNewLabel);
		
		textField_2 = new JTextField();
		textField_2.setBounds(185, 347, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
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
	}
}
