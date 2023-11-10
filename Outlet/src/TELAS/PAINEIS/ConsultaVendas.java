package TELAS.PAINEIS;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import DAO.VendaDAO;
import ENTIDADES.Venda;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;


public class ConsultaVendas extends JPanel {
	private JLayeredPane layeredPane;	
	private JTextField textField;
	private JTextField tf_numeros;
	private JTextField tf_datamin;
	private JTextField tf_datamax;
	private JTextField tf_cpfs;
	private JTextField tf_formaspgmt;
	private JTextField tf_totalmin;
	private JTextField tf_totalmax;
	private ArrayList<Venda> vendas = new ArrayList<Venda>();
	private JTable table;
	
	/**
	 * Create the panel.
	 */
	public void praFrente(){
		layeredPane.add(this);
		layeredPane.moveToFront(this);
	}
    public ConsultaVendas(JLayeredPane layeredPane) {
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
		
		tf_numeros = new JTextField();
		tf_numeros.setBounds(162, 10, 128, 19);
		panel.add(tf_numeros);
		tf_numeros.setColumns(10);
		
		JLabel lblCpfs = new JLabel("CPFs:");
		lblCpfs.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCpfs.setBounds(12, 39, 124, 15);
		panel.add(lblCpfs);
		
		tf_cpfs = new JTextField();
		tf_cpfs.setColumns(10);
		tf_cpfs.setBounds(162, 39, 128, 19);
		panel.add(tf_cpfs);
		
		JLabel lblFormasPg = new JLabel("Formas PGMT");
		lblFormasPg.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFormasPg.setBounds(12, 66, 124, 15);
		panel.add(lblFormasPg);
		
		tf_formaspgmt = new JTextField();
		tf_formaspgmt.setColumns(10);
		tf_formaspgmt.setBounds(162, 66, 128, 19);
		panel.add(tf_formaspgmt);
		table = new JTable();
		table.setBounds(0,0,886,513);
		defineTabela();
		JScrollPane scrollPane = new JScrollPane(table);
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
		
		tf_datamin = new JTextField();
		tf_datamin.setBounds(83, 37, 114, 19);
		panel_1.add(tf_datamin);
		tf_datamin.setColumns(10);
		
		JLabel lblMin = new JLabel("Min:");
		lblMin.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMin.setBounds(12, 39, 55, 15);
		panel_1.add(lblMin);
		
		tf_datamax = new JTextField();
		tf_datamax.setColumns(10);
		tf_datamax.setBounds(83, 68, 114, 19);
		panel_1.add(tf_datamax);
		
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
		
		tf_totalmin = new JTextField();
		tf_totalmin.setColumns(10);
		tf_totalmin.setBounds(83, 37, 114, 19);
		panel_1_1.add(tf_totalmin);
		
		JLabel lblMin_1 = new JLabel("Min:");
		lblMin_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMin_1.setBounds(12, 39, 55, 15);
		panel_1_1.add(lblMin_1);
		
		tf_totalmax = new JTextField();
		tf_totalmax.setColumns(10);
		tf_totalmax.setBounds(83, 68, 114, 19);
		panel_1_1.add(tf_totalmax);
		
		JLabel lblMax_1 = new JLabel("Max:");
		lblMax_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMax_1.setBounds(12, 70, 55, 15);
		panel_1_1.add(lblMax_1);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					double totalmin = 0;
					double totalmax = 0;
					if(!tf_totalmax.getText().equals("")){
						totalmax = Double.parseDouble(tf_totalmax.getText());
					}
					if(!tf_totalmin.getText().equals("")){
						totalmin = Double.parseDouble(tf_totalmin.getText());
					}
					vendas = VendaDAO.relatorioVenda(tf_numeros.getText(), tf_cpfs.getText(), tf_formaspgmt.getText(), tf_datamin.getText(), tf_datamax.getText(), totalmin, totalmax);	
					preencheouEsvazia();
				} catch (Exception zzz) {
					JOptionPane.showMessageDialog(null, zzz.getMessage());
				}
				
			}
		});
		btnPesquisar.setBounds(765, 12, 133, 99);
		add(btnPesquisar);
		
		JButton btnSalvarRelatorio = new JButton("Salvar relatório");
		btnSalvarRelatorio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSalvarRelatorio.setBounds(742, 648, 156, 25);
		add(btnSalvarRelatorio);
    }
	public void defineTabela(){
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.addColumn("ID Venda");
		model.addColumn("CPF cliente");
		model.addColumn("Form. PGT.");
		model.addColumn("data");
		model.addColumn("Total");
		table.getColumnModel().getColumn(0).setPreferredWidth(177);
		table.getColumnModel().getColumn(1).setPreferredWidth(177);
		table.getColumnModel().getColumn(2).setPreferredWidth(177);
		table.getColumnModel().getColumn(3).setPreferredWidth(178);
		table.getColumnModel().getColumn(4).setPreferredWidth(177);
	}
	public void preencheouEsvazia(){
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		for(int i = 0;i<model.getRowCount();i++){
			model.removeRow(0);
		}
		model.setRowCount(0);
			// Populate the table with the items			
			for (Venda prd : vendas) {
				model.addRow(new Object[]{prd.getNumero(),prd.getCliente_cpf(),prd.getFormapagamento(),prd.getData(false),prd.getTotalf()});
			}	
	}
}


