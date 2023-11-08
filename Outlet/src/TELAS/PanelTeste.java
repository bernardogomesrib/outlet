package TELAS;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ENTIDADES.ConsultaPedido;
import ENTIDADES.Fornecedor;


import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import DAO.RelatorioPedidoDAO;

import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class PanelTeste extends JPanel {
	private JLayeredPane layeredPane;
	Fornecedor fornecedor = new Fornecedor();
	private ArrayList<ConsultaPedido> pedidosConsultados = new ArrayList<ConsultaPedido>();
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField textField;
	
	
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
		panel.setBounds(12, 12, 313, 99);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblIdVenda = new JLabel("id Venda:");
		lblIdVenda.setBounds(12, 12, 70, 15);
		panel.add(lblIdVenda);
		
		textField = new JTextField();
		textField.setBounds(162, 10, -67, 15);
		panel.add(textField);
		textField.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 123, 886, 513);
		add(scrollPane);
		String[] pagamentos = {"Selecione", "Dinheiro", "Pix", "Cartão", "Boleto"};
		DefaultComboBoxModel<String> model = new DefaultComboBoxModel<String>(pagamentos);
		defineTabela();
		
    }	
	public void defineTabela(){
		model.addColumn("ID");																// adiciona a coluna 0
		model.addColumn("CPF");																// adiciona a coluna 1
		model.addColumn("Data");														// adiciona a coluna 2
		model.addColumn("Subtotal");															// adiciona a coluna 3
		model.addColumn("Qnt.its");
		model.addColumn("Qnt.pds.");
	}
	public void preencheouEsvazia(boolean preenche) {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		for(int i = 0;i<model.getRowCount();i++){
			model.removeRow(0);
		}			
		model.setRowCount(0);
		if(preenche){
			for (ConsultaPedido cs : pedidosConsultados) {
				model.addRow(new Object[]{cs.getId(),cs.getCpf(),cs.getData(),cs.getSubTotalf(),cs.getQuanidadeDeItens(),cs.getQuanidadeDeItensdist()});
			}
		}
	}
}


