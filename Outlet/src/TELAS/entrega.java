package TELAS;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.Font;

public class entrega extends JFrame {

	private JPanel contentPane;
	private JTextField txtId;
	private JTextField txtEndereço;
	private JTextField txtRastreio;
	private JTextField txtStatus;
	private JTextField txtEntrega;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					entrega frame = new entrega();
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
	public entrega() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1013, 647);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEntrega = new JLabel("ENTREGA");
		lblEntrega.setFont(new Font("Arial", Font.PLAIN, 40));
		lblEntrega.setHorizontalAlignment(SwingConstants.CENTER);
		lblEntrega.setBounds(0, 0, 997, 39);
		contentPane.add(lblEntrega);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(73, 73, 73));
		panel.setBounds(114, 50, 780, 403);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lb_idVenda = new JLabel("Informe o ID da venda");
		lb_idVenda.setForeground(new Color(255, 255, 255));
		lb_idVenda.setBackground(new Color(0, 0, 0));
		lb_idVenda.setHorizontalAlignment(SwingConstants.CENTER);
		lb_idVenda.setFont(new Font("Arial", Font.PLAIN, 40));
		lb_idVenda.setBounds(0, 11, 780, 31);
		panel.add(lb_idVenda);
		
		txtId = new JTextField();
		txtId.setBounds(199, 53, 385, 31);
		panel.add(txtId);
		txtId.setColumns(10);
		
		JLabel lblEndereço = new JLabel("Endereço do cliente: ");
		lblEndereço.setForeground(new Color(255, 255, 255));
		lblEndereço.setBackground(new Color(0, 0, 0));
		lblEndereço.setFont(new Font("Arial", Font.PLAIN, 20));
		lblEndereço.setBounds(22, 132, 197, 20);
		panel.add(lblEndereço);
		
		txtEndereço = new JTextField();
		txtEndereço.setBounds(267, 121, 317, 31);
		panel.add(txtEndereço);
		txtEndereço.setColumns(10);
		
		JLabel lblRastreio = new JLabel("Número de rastreio: ");
		lblRastreio.setForeground(new Color(255, 255, 255));
		lblRastreio.setBackground(new Color(0, 0, 0));
		lblRastreio.setFont(new Font("Arial", Font.PLAIN, 20));
		lblRastreio.setBounds(22, 202, 197, 20);
		panel.add(lblRastreio);
		
		txtRastreio = new JTextField();
		txtRastreio.setBounds(267, 191, 317, 31);
		panel.add(txtRastreio);
		txtRastreio.setColumns(10);
		
		JLabel lblStatus = new JLabel("Status da entrega: ");
		lblStatus.setForeground(new Color(255, 255, 255));
		lblStatus.setBackground(new Color(0, 0, 0));
		lblStatus.setFont(new Font("Arial", Font.PLAIN, 20));
		lblStatus.setBounds(22, 270, 197, 20);
		panel.add(lblStatus);
		
		txtStatus = new JTextField();
		txtStatus.setBounds(267, 268, 317, 31);
		panel.add(txtStatus);
		txtStatus.setColumns(10);
		
		JLabel lblTipoEntrega = new JLabel("Tipo de entrega: ");
		lblTipoEntrega.setForeground(new Color(255, 255, 255));
		lblTipoEntrega.setBackground(new Color(0, 0, 0));
		lblTipoEntrega.setFont(new Font("Arial", Font.PLAIN, 20));
		lblTipoEntrega.setBounds(22, 340, 197, 20);
		panel.add(lblTipoEntrega);
		
		txtEntrega = new JTextField();
		txtEntrega.setBounds(267, 338, 317, 31);
		panel.add(txtEntrega);
		txtEntrega.setColumns(10);
	}
}
