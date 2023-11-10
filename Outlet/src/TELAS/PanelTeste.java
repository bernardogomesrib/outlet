package TELAS;


import ENTIDADES.Fornecedor;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

import javax.swing.JPanel;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;

import java.awt.event.ActionEvent;
import java.util.ArrayList;


import javax.swing.table.DefaultTableModel;


import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;


public class PanelTeste extends JPanel {
		
	private JLayeredPane layeredPane;
	private JTextField tf_Cnpj;
	private JTextField tf_Razaosocial;
	private JTextField tf_Telefone;
	private JTextField tf_Logradouro;
	private JTextField tf_Numero;
	private JTextField tf_Complemento;
	private JTextField tf_Cidade;
	private JTextField tf_Estado;
	private JTextField tf_Bairro;
	private JTextField tf_Cep;
	private JTable table;
	private ArrayList<Fornecedor> Fornecedores = new ArrayList<Fornecedor>();
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
		
		JPanel panel_indetificar = new JPanel();
		panel_indetificar.setBackground(new Color(238, 238, 238));
		panel_indetificar.setBounds(10, 11, 266, 124);
		add(panel_indetificar);
		panel_indetificar.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Razão social:");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setBounds(10, 44, 94, 14);
		panel_indetificar.add(lblNewLabel_2);
		
		tf_Razaosocial = new JTextField();
		tf_Razaosocial.setBounds(108, 41, 148, 20);
		panel_indetificar.add(tf_Razaosocial);
		tf_Razaosocial.setColumns(10);
		
		tf_Cnpj = new JTextField();
		tf_Cnpj.setBounds(108, 12, 148, 20);
		panel_indetificar.add(tf_Cnpj);
		tf_Cnpj.setColumns(10);
		
		JLabel lblCnpj = new JLabel("CNPJ:");
		lblCnpj.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCnpj.setBounds(10, 14, 94, 14);
		panel_indetificar.add(lblCnpj);
		
		JLabel lblTelefone = new JLabel("Telefones:");
		lblTelefone.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTelefone.setBounds(10, 75, 94, 14);
		panel_indetificar.add(lblTelefone);
		
		tf_Telefone = new JTextField();
		tf_Telefone.setColumns(10);
		tf_Telefone.setBounds(108, 72, 148, 20);
		panel_indetificar.add(tf_Telefone);
		
		JPanel panel_endereço = new JPanel();
		panel_endereço.setBackground(new Color(238, 238, 238));
		panel_endereço.setBounds(301, 11, 597, 124);
		add(panel_endereço);
		panel_endereço.setLayout(null);
		
		JLabel lblLogradouro = new JLabel("Logradouro:");
		lblLogradouro.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLogradouro.setBounds(10, 20, 95, 14);
		panel_endereço.add(lblLogradouro);
		
		JLabel lblNumero = new JLabel("Numero:");
		lblNumero.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNumero.setBounds(425, 20, 81, 14);
		panel_endereço.add(lblNumero);
		
		JLabel lblComplemento = new JLabel("Complemento:");
		lblComplemento.setHorizontalAlignment(SwingConstants.RIGHT);
		lblComplemento.setBounds(10, 53, 113, 14);
		panel_endereço.add(lblComplemento);
		
		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCidade.setBounds(20, 84, 67, 14);
		panel_endereço.add(lblCidade);
		
		JLabel lblNewLabel_4 = new JLabel("Cep:");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_4.setBounds(426, 84, 32, 14);
		panel_endereço.add(lblNewLabel_4);
		
		JLabel lblBairro = new JLabel("Bairro:");
		lblBairro.setHorizontalAlignment(SwingConstants.RIGHT);
		lblBairro.setBounds(325, 53, 62, 14);
		panel_endereço.add(lblBairro);
		
		JLabel lblEstado = new JLabel("Estado:");
		lblEstado.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEstado.setBounds(217, 84, 67, 14);
		panel_endereço.add(lblEstado);
		
		tf_Logradouro = new JTextField();
		tf_Logradouro.setBounds(115, 18, 315, 20);
		panel_endereço.add(tf_Logradouro);
		tf_Logradouro.setColumns(10);
		
		tf_Numero = new JTextField();
		tf_Numero.setColumns(10);
		tf_Numero.setBounds(511, 18, 67, 20);
		panel_endereço.add(tf_Numero);
		
		tf_Complemento = new JTextField();
		tf_Complemento.setColumns(10);
		tf_Complemento.setBounds(125, 51, 188, 20);
		panel_endereço.add(tf_Complemento);
		
		tf_Cidade = new JTextField();
		tf_Cidade.setColumns(10);
		tf_Cidade.setBounds(100, 81, 113, 20);
		panel_endereço.add(tf_Cidade);
		
		tf_Estado = new JTextField();
		tf_Estado.setColumns(10);
		tf_Estado.setBounds(291, 81, 113, 20);
		panel_endereço.add(tf_Estado);
		
		tf_Bairro = new JTextField();
		tf_Bairro.setColumns(10);
		tf_Bairro.setBounds(392, 51, 186, 20);
		panel_endereço.add(tf_Bairro);
		
		tf_Cep = new JTextField();
		tf_Cep.setColumns(10);
		tf_Cep.setBounds(465, 81, 113, 20);
		panel_endereço.add(tf_Cep);
		
		JButton btnSalvarRelatrio = new JButton("Salvar relatório");
		btnSalvarRelatrio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				geraDocumento();
			}
		});
		btnSalvarRelatrio.setBounds(745, 652, 144, 23);
		add(btnSalvarRelatrio);
		table = new JTable();
		table.setBackground(new Color(255,255,255));
		table.setBounds(0, 0, 874, 492);
		defineTabela();
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 146, 888, 492);
		add(scrollPane);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnPesquisar.setBounds(590, 652, 131, 23);
		add(btnPesquisar);
		
		/** tf_Cnpj
		 * tf_Razaosocial
		 * tf_Telefone
		 * tf_Logradouro
		 * tf_Numero
		 * tf_Complemento
		 * tf_Bairro
		 * tf_Cidade
		 * tf_Estado
		 * tf_Cep
		 */

	}
	public void defineTabela(){
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.addColumn("Cnpj");
		model.addColumn("Razaosocial");
		model.addColumn("Telefone");
		model.addColumn("Logradouro");
		model.addColumn("Numero");
		model.addColumn("Complemento");
		model.addColumn("Bairro");
		model.addColumn("Cidade");	
		model.addColumn("Estado");
		model.addColumn("Cep");
		table.getColumnModel().getColumn(0).setPreferredWidth(87);
		table.getColumnModel().getColumn(1).setPreferredWidth(87);
		table.getColumnModel().getColumn(2).setPreferredWidth(87);
		table.getColumnModel().getColumn(3).setPreferredWidth(87);
		table.getColumnModel().getColumn(4).setPreferredWidth(87);
		table.getColumnModel().getColumn(5).setPreferredWidth(87);
		table.getColumnModel().getColumn(6).setPreferredWidth(87);
		table.getColumnModel().getColumn(7).setPreferredWidth(87);
		table.getColumnModel().getColumn(8).setPreferredWidth(87);
		table.getColumnModel().getColumn(9).setPreferredWidth(88);
		
	}
	public void preencheouEsvazia(boolean preenche) {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		for(int i = 0;i<model.getRowCount();i++){
			model.removeRow(0);
		}
		model.setRowCount(0);
		
		if (preenche) {
			// Populate the table with the items
			for (Fornecedor forn : Fornecedores) {
				model.addRow(new Object[]{forn.getCnpj(),forn.getRazaosocial(),forn.getTelefone(),forn.getLogradouro(),forn.getNumero(),forn.getComplemento(),forn.getBairro(),forn.getCidade(),forn.getEstado(),forn.getCep()});
			}
		}
	}
	public void geraDocumento(){
		
	}
}