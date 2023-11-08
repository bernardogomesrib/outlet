package TELAS;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import ENTIDADES.Fornecedor;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.JButton;


public class PanelTeste extends JPanel {
	private JLayeredPane layeredPane;
	Fornecedor fornecedor = new Fornecedor();
	
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	
	
	/**
	 * Create the panel.
	 */
	public void praFrente(){
		layeredPane.add(this);
		layeredPane.moveToFront(this);
	}
    public PanelTeste(JLayeredPane layeredPane) {
		this.layeredPane = layeredPane;
		setBounds(0, 0, 910, 686);		
		setBackground(new Color(255, 255, 255));
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(12, 12, 301, 99);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblIdVenda = new JLabel("ids Venda:");
		lblIdVenda.setHorizontalAlignment(SwingConstants.RIGHT);
		lblIdVenda.setBounds(12, 12, 124, 15);
		panel.add(lblIdVenda);
		
		textField = new JTextField();
		textField.setBounds(162, 10, -67, 15);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(162, 10, 128, 19);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblCpfs = new JLabel("CPFs:");
		lblCpfs.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCpfs.setBounds(12, 39, 124, 15);
		panel.add(lblCpfs);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(162, 39, 128, 19);
		panel.add(textField_4);
		
		JLabel lblFormasPg = new JLabel("Formas PGMT");
		lblFormasPg.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFormasPg.setBounds(12, 66, 124, 15);
		panel.add(lblFormasPg);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(162, 66, 128, 19);
		panel.add(textField_5);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 123, 886, 513);
		add(scrollPane);			
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(325, 12, 208, 99);
		add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblDataDaVenda = new JLabel("Data da venda");
		lblDataDaVenda.setHorizontalAlignment(SwingConstants.CENTER);
		lblDataDaVenda.setBounds(12, 12, 184, 15);
		panel_1.add(lblDataDaVenda);
		
		textField_2 = new JTextField();
		textField_2.setBounds(83, 37, 114, 19);
		panel_1.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblMin = new JLabel("Min:");
		lblMin.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMin.setBounds(12, 39, 55, 15);
		panel_1.add(lblMin);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(83, 68, 114, 19);
		panel_1.add(textField_3);
		
		JLabel lblMax = new JLabel("Max:");
		lblMax.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMax.setBounds(12, 70, 55, 15);
		panel_1.add(lblMax);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBounds(545, 12, 208, 99);
		add(panel_1_1);
		
		JLabel lblSubtotal = new JLabel("Total");
		lblSubtotal.setHorizontalAlignment(SwingConstants.CENTER);
		lblSubtotal.setBounds(12, 12, 184, 15);
		panel_1_1.add(lblSubtotal);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(83, 37, 114, 19);
		panel_1_1.add(textField_6);
		
		JLabel lblMin_1 = new JLabel("Min:");
		lblMin_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMin_1.setBounds(12, 39, 55, 15);
		panel_1_1.add(lblMin_1);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(83, 68, 114, 19);
		panel_1_1.add(textField_7);
		
		JLabel lblMax_1 = new JLabel("Max:");
		lblMax_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMax_1.setBounds(12, 70, 55, 15);
		panel_1_1.add(lblMax_1);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setBounds(765, 12, 133, 99);
		add(btnPesquisar);
    }	
}


