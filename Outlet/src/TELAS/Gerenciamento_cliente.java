package TELAS;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;

public class Gerenciamento_cliente extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gerenciamento_cliente frame = new Gerenciamento_cliente();
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
	public Gerenciamento_cliente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1013, 647);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 128, 128));
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl_Gerenciamento_cliente = new JLabel("Gerenciamento de Cliente");
		lbl_Gerenciamento_cliente.setFont(new Font("Tahoma", Font.BOLD, 22));
		lbl_Gerenciamento_cliente.setBounds(348, 34, 303, 27);
		contentPane.add(lbl_Gerenciamento_cliente);
		
		JLabel lbl_Nome = new JLabel("Nome");
		lbl_Nome.setBounds(57, 100, 41, 14);
		contentPane.add(lbl_Nome);
		
		textField = new JTextField();
		textField.setBounds(94, 97, 203, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lbl_Sobrenome = new JLabel("Sobrenome");
		lbl_Sobrenome.setBounds(57, 140, 68, 14);
		contentPane.add(lbl_Sobrenome);
		
		textField_1 = new JTextField();
		textField_1.setBounds(132, 137, 193, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lbl_Cpf = new JLabel("CPF");
		lbl_Cpf.setBounds(57, 177, 30, 14);
		contentPane.add(lbl_Cpf);
		
		textField_2 = new JTextField();
		textField_2.setBounds(94, 174, 184, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lbl_Data_nascimento = new JLabel("Data de Nascimento");
		lbl_Data_nascimento.setBounds(57, 217, 106, 14);
		contentPane.add(lbl_Data_nascimento);
		
		textField_3 = new JTextField();
		textField_3.setBounds(173, 214, 158, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lbl_email = new JLabel("E-mail");
		lbl_email.setBounds(57, 256, 41, 14);
		contentPane.add(lbl_email);
		
		textField_4 = new JTextField();
		textField_4.setBounds(108, 253, 254, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Telefone");
		lblNewLabel.setBounds(57, 299, 57, 14);
		contentPane.add(lblNewLabel);
		
		textField_5 = new JTextField();
		textField_5.setBounds(141, 296, 184, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		JButton btnNewButton = new JButton("Atualizar");
		btnNewButton.setBounds(263, 509, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cadastrar");
		btnNewButton_1.setBounds(402, 509, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Buscar");
		btnNewButton_2.setBounds(541, 509, 89, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Excluir");
		btnNewButton_3.setBounds(682, 509, 89, 23);
		contentPane.add(btnNewButton_3);
		
		JLabel lblNewLabel_1 = new JLabel("Cep");
		lblNewLabel_1.setBounds(57, 340, 35, 14);
		contentPane.add(lblNewLabel_1);
		
		textField_7 = new JTextField();
		textField_7.setBounds(98, 337, 106, 20);
		contentPane.add(textField_7);
		textField_7.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Número");
		lblNewLabel_2.setBounds(57, 380, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		textField_8 = new JTextField();
		textField_8.setBounds(118, 377, 86, 20);
		contentPane.add(textField_8);
		textField_8.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Complemento");
		lblNewLabel_3.setBounds(57, 421, 79, 14);
		contentPane.add(lblNewLabel_3);
		
		textField_9 = new JTextField();
		textField_9.setBounds(140, 418, 185, 20);
		contentPane.add(textField_9);
		textField_9.setColumns(10);
	}
}
