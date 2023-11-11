package TELAS.PAINEIS;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ENTIDADES.ConsultaPedido;
import ENTIDADES.Fornecedor;
import ENTIDADES.Venda;

import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import DAO.PedidoDAO;
import DAO.RelatorioPedidoDAO;
import DAO.VendaDAO;

import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;


public class PanelGerenciamentoVendas extends JPanel {
	private JLayeredPane layeredPane;
	Fornecedor fornecedor = new Fornecedor();
	private JTextField tf_desconto;
	private JTextField tf_numero;
	private JTextField tf_idpedido;
	private JTextField tf_cpfs;
	private JTextField tf_cods;
	private JTextField tf_subtotalMax;
	private JTextField tf_subtotalmin;
	private JTextField tf_datamin;
	private JTextField tf_datamax;
	private JTable table;
	private ArrayList<ConsultaPedido> pedidosConsultados = new ArrayList<ConsultaPedido>();
	private JTextField tf_quantMin;
	private JTextField tf_quantMax;
	private JTextField tf_proddismin;
	private JTextField tf_proddismax;
	private JRadioButton rdbtnPeloMenosUm;
	private JComboBox<String> cb_formapagamento;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JLabel lblValorDoPedido;
	private JLabel lblValorDesconto;
	private DecimalFormat df = new DecimalFormat("0.00");
	private double desconto = 0;
	
	/**
	 * Create the panel.
	 */
	public void praFrente(){
		layeredPane.add(this);
		layeredPane.moveToFront(this);
	}
    public PanelGerenciamentoVendas(JLayeredPane layeredPane) {
		this.layeredPane = layeredPane;
		setBounds(0, 0, 910, 686);		
		setBackground(new Color(255, 255, 255));
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(22, 30, 377, 145);
		add(panel);
		panel.setLayout(null);
		
		tf_numero = new JTextField();
		tf_numero.setBounds(195, 12, 172, 19);
		panel.add(tf_numero);
		tf_numero.setColumns(10);
		
		JLabel lblIdDaVenda = new JLabel("id da venda");
		lblIdDaVenda.setBounds(63, 14, 114, 15);
		panel.add(lblIdDaVenda);
		lblIdDaVenda.setHorizontalAlignment(SwingConstants.RIGHT);
		
		tf_desconto = new JTextField();
		tf_desconto.setBounds(195, 32, 172, 19);
		panel.add(tf_desconto);
		tf_desconto.setColumns(10);
		tf_desconto.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				double subtotal = 0;				
				if(!tf_idpedido.getText().equals("")){
					int local = encontraNapesquisa(tf_idpedido.getText());
					try {
						desconto = Double.parseDouble(tf_desconto.getText());
						if(local!=-9999)		{
							subtotal = pedidosConsultados.get(local).getSubTotal();							
						}else{							
							subtotal = PedidoDAO.pegaSubtotalDePedido(tf_idpedido.getText());							
						}
					} catch (Exception zz) {
						JOptionPane.showMessageDialog(null, zz.getMessage());
					}
					
					lblValorDoPedido.setText("Valor do pedido : R$ "+df.format(subtotal));
					desconto = ((1-(desconto/100))*subtotal);
					lblValorDesconto.setText("Valor pós desconto: R$ "+df.format(desconto));
				}
			}
		});

		JLabel lblNewLabel = new JLabel("desconto");
		lblNewLabel.setBounds(107, 34, 70, 15);
		panel.add(lblNewLabel);
		
		tf_idpedido = new JTextField();
		tf_idpedido.setBounds(195, 52, 172, 19);
		
		tf_idpedido.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				double subtotal = 0;				
				if(!tf_desconto.getText().equals("")){
					int local = encontraNapesquisa(tf_idpedido.getText());
					try {
						desconto = Double.parseDouble(tf_desconto.getText());
						if(local!=-9999)		{
							subtotal = pedidosConsultados.get(local).getSubTotal();							
						}else{							
							subtotal = PedidoDAO.pegaSubtotalDePedido(tf_idpedido.getText());							
						}
					} catch (Exception zz) {
						JOptionPane.showMessageDialog(null, zz.getMessage());
					}
					lblValorDoPedido.setText("Valor do pedido : R$ "+df.format(subtotal));
					desconto = ((1-(desconto/100))*subtotal);
					lblValorDesconto.setText("Valor pós desconto: R$ "+df.format(desconto));
				}
			}
		});

		panel.add(tf_idpedido);
		tf_idpedido.setColumns(10);
		
		JLabel lblIdDoPedido = new JLabel("id do pedido");
		lblIdDoPedido.setBounds(63, 54, 114, 15);
		panel.add(lblIdDoPedido);
		lblIdDoPedido.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel lblFormaDePagamento = new JLabel("Forma de pagamento");
		lblFormaDePagamento.setBounds(12, 75, 165, 15);
		panel.add(lblFormaDePagamento);
		lblFormaDePagamento.setHorizontalAlignment(SwingConstants.RIGHT);
		
		cb_formapagamento = new JComboBox<String>();
		String[] pagamentos = {"Selecione", "Dinheiro", "Pix", "Cartão", "Boleto"};
		DefaultComboBoxModel<String> model = new DefaultComboBoxModel<String>(pagamentos);
		cb_formapagamento.setModel(model);
		cb_formapagamento.setBounds(195, 73, 172, 19);
		panel.add(cb_formapagamento);
		
		JButton btnCompletarVenda = new JButton("Completar venda");
		btnCompletarVenda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!cb_formapagamento.getSelectedItem().equals("Selecione")){
					if(VendaDAO.insere(new Venda(tf_numero.getText(),(String)cb_formapagamento.getSelectedItem(),desconto,tf_idpedido.getText()))==1){
						JOptionPane.showMessageDialog(null,"Venda Completada");
					}
				}
				setNextIdVenda();
			}
		});
		btnCompletarVenda.setBounds(12, 102, 355, 25);
		panel.add(btnCompletarVenda);
		
		/*
		JButton btnEditarVenda = new JButton("Editar venda");
		btnEditarVenda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

		btnEditarVenda.setBounds(195, 102, 172, 25);
		panel.add(btnEditarVenda);
		
		 */
		
		lblValorDoPedido = new JLabel("Valor do pedido : R$");
		lblValorDoPedido.setBounds(417, 85, 334, 15);
		add(lblValorDoPedido);
		
		lblValorDesconto = new JLabel("Valor pós desconto: R$ ");
		lblValorDesconto.setBounds(417, 112, 334, 15);
		add(lblValorDesconto);
		
		table = new JTable();
		table.setBackground(new Color(255,255,255));
		table.setBounds(0, 0, 487, 470);
		defineTabela();
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(383, 204, 515, 470);
		add(scrollPane);
		
		JLabel lblPedidosAbertos = new JLabel("Pedidos abertos");
		lblPedidosAbertos.setBounds(383, 177, 264, 15);
		add(lblPedidosAbertos);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(22, 224, 349, 409);
		add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCpf.setBounds(12, 12, 70, 15);
		panel_1.add(lblCpf);
		
		tf_cpfs = new JTextField();
		tf_cpfs.setBounds(88, 10, 250, 19);
		panel_1.add(tf_cpfs);
		tf_cpfs.setColumns(10);
		
		JLabel lblCod = new JLabel("CODs:");
		lblCod.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCod.setBounds(12, 41, 70, 15);
		panel_1.add(lblCod);
		
		tf_cods = new JTextField();
		tf_cods.setColumns(10);
		tf_cods.setBounds(88, 39, 250, 19);
		panel_1.add(tf_cods);
		
		tf_subtotalMax = new JTextField();
		tf_subtotalMax.setBounds(268, 102, 70, 19);
		panel_1.add(tf_subtotalMax);
		tf_subtotalMax.setColumns(10);
		
		JLabel lblMax = new JLabel("max:");
		lblMax.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMax.setBounds(216, 104, 46, 15);
		panel_1.add(lblMax);
		
		tf_subtotalmin = new JTextField();
		tf_subtotalmin.setBounds(134, 102, 70, 19);
		panel_1.add(tf_subtotalmin);
		tf_subtotalmin.setColumns(10);
		
		JLabel lblSubtotalMin = new JLabel("Subtotal min:");
		lblSubtotalMin.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSubtotalMin.setBounds(18, 104, 98, 15);
		panel_1.add(lblSubtotalMin);
		
		JLabel lblDataMin = new JLabel("Data min:");
		lblDataMin.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDataMin.setBounds(18, 133, 98, 15);
		panel_1.add(lblDataMin);
		
		tf_datamin = new JTextField();
		tf_datamin.setColumns(10);
		tf_datamin.setBounds(134, 131, 70, 19);
		panel_1.add(tf_datamin);
		
		JLabel lblMax_1 = new JLabel("max:");
		lblMax_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMax_1.setBounds(216, 133, 46, 15);
		panel_1.add(lblMax_1);
		
		tf_datamax = new JTextField();
		tf_datamax.setColumns(10);
		tf_datamax.setBounds(268, 131, 70, 19);
		panel_1.add(tf_datamax);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int quantmin = 1;
				int quantmax = 0;
				double subtotalmin = 0;
				double subtotalmax = 0;
				int pquantmin = 1;
				int pquantmax = 0;
				try {
					if(!tf_quantMin.getText().equals("")){
					quantmin = Integer.parseInt(tf_quantMin.getText());
					}
					if(!tf_quantMax.getText().equals("")){
						quantmax = Integer.parseInt(tf_quantMax.getText());
					}
					if(!tf_subtotalmin.getText().equals("")){
						subtotalmin = Double.parseDouble(tf_subtotalmin.getText());
					}
					if(!tf_subtotalMax.getText().equals("")){
						subtotalmax = Double.parseDouble(tf_subtotalMax.getText());
					}
					if(!tf_proddismin.getText().equals("")){
						pquantmin = Integer.parseInt(tf_proddismin.getText());
					}
					if(!tf_proddismax.getText().equals("")){
						pquantmax = Integer.parseInt(tf_proddismax.getText());
					}					
					pedidosConsultados = RelatorioPedidoDAO.procuraPedidosAbertos(pquantmin,pquantmax,tf_cpfs.getText(),tf_datamin.getText(),tf_datamax.getText(),quantmin,quantmax,subtotalmin,subtotalmax,tf_cods.getText(),rdbtnPeloMenosUm.isSelected());
					
					preencheouEsvazia(true);
					
				} catch (Exception rrr) {
					JOptionPane.showMessageDialog(null, "Preencha corretamente os campos!"+rrr.getMessage());
				}
			}
		});
		btnPesquisar.setBounds(12, 231, 326, 25);
		panel_1.add(btnPesquisar);
		
		JLabel lblQntDeItens = new JLabel("Qnt. itns min:");
		lblQntDeItens.setHorizontalAlignment(SwingConstants.RIGHT);
		lblQntDeItens.setBounds(18, 162, 98, 15);
		panel_1.add(lblQntDeItens);
		
		tf_quantMin = new JTextField();
		tf_quantMin.setColumns(10);
		tf_quantMin.setBounds(134, 160, 70, 19);
		panel_1.add(tf_quantMin);
		
		JLabel lblMax_1_1 = new JLabel("max:");
		lblMax_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMax_1_1.setBounds(216, 162, 46, 15);
		panel_1.add(lblMax_1_1);
		
		tf_quantMax = new JTextField();
		tf_quantMax.setColumns(10);
		tf_quantMax.setBounds(268, 160, 70, 19);
		panel_1.add(tf_quantMax);
		
		JLabel lblQntPrdMin = new JLabel("Qnt. prd min");
		lblQntPrdMin.setHorizontalAlignment(SwingConstants.RIGHT);
		lblQntPrdMin.setBounds(18, 189, 98, 15);
		panel_1.add(lblQntPrdMin);
		
		tf_proddismin = new JTextField();
		tf_proddismin.setColumns(10);
		tf_proddismin.setBounds(134, 187, 70, 19);
		panel_1.add(tf_proddismin);
		
		JLabel lblMax_1_2 = new JLabel("max:");
		lblMax_1_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMax_1_2.setBounds(216, 189, 46, 15);
		panel_1.add(lblMax_1_2);
		
		tf_proddismax = new JTextField();
		tf_proddismax.setColumns(10);
		tf_proddismax.setBounds(268, 187, 70, 19);
		panel_1.add(tf_proddismax);
		
		rdbtnPeloMenosUm = new JRadioButton("Pelo menos um");
		rdbtnPeloMenosUm.setSelected(true);
		buttonGroup.add(rdbtnPeloMenosUm);
		rdbtnPeloMenosUm.setBounds(12, 64, 149, 23);
		panel_1.add(rdbtnPeloMenosUm);
		
		JRadioButton rdbtnContemTodos = new JRadioButton("Contem todos");
		buttonGroup.add(rdbtnContemTodos);
		rdbtnContemTodos.setBounds(189, 66, 149, 23);
		panel_1.add(rdbtnContemTodos);
		
		JLabel lblBuscaDePedidos = new JLabel("Busca de pedidos para transformar em venda");
		lblBuscaDePedidos.setHorizontalAlignment(SwingConstants.CENTER);
		lblBuscaDePedidos.setBounds(22, 204, 343, 15);
		add(lblBuscaDePedidos);
		
    }	
	public void defineTabela(){
		DefaultTableModel model = (DefaultTableModel) table.getModel();					//
		model.addColumn("ID");																// adiciona a coluna 0
		model.addColumn("CPF");																// adiciona a coluna 1
		model.addColumn("Data");														// adiciona a coluna 2
		model.addColumn("Subtotal");															// adiciona a coluna 3
		model.addColumn("Qnt.its");
		model.addColumn("Qnt.pds.");
		table.getColumnModel().getColumn(0).setPreferredWidth(50);
		table.getColumnModel().getColumn(1).setPreferredWidth(100);
		table.getColumnModel().getColumn(2).setPreferredWidth(150);
		table.getColumnModel().getColumn(3).setPreferredWidth(80);
		table.getColumnModel().getColumn(4).setPreferredWidth(50);
		table.getColumnModel().getColumn(5).setPreferredWidth(50);
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
	public int encontraNapesquisa(String id){
		
		for(int i = 0;i<pedidosConsultados.size();i++){
			if(id.equals(pedidosConsultados.get(i).getId())){
				return i;
			}
		}
		return -9999;
	}
	public void setNextIdVenda(){
		tf_numero.setText(""+VendaDAO.proxIdDisponivel());
	}
}


