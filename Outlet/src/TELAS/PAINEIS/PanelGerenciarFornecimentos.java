package TELAS.PAINEIS;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import javax.swing.JTextField;

import ENTIDADES.Fornecedor;
import ENTIDADES.Produto;
import ENTIDADES.Produtofornecedor;
import TELAS.GerenciamentoPedido;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import DAO.FornecedorDAO;
import DAO.ProdutoDao;
import DAO.ProdutofornecedorDAO;

import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;


public class PanelGerenciarFornecimentos extends JPanel {
	private JLayeredPane layeredPane;
	Fornecedor fornecedor = new Fornecedor();
	private JTextField tf_cnpj;
	private JTextField tf_cod;
	private JTextField txtCnpj;
	private JTextField txtFornecedornome;
	private JTextField txtProdutocod;
	private JTextField txtProdutonome;
	private JTextField txtPrecomax;
	private JTextField txtPrecomin;
	private JTextField txtEstoquemin;
	private JTextField txtEstoquemax;
	private JTable table;
	private JTable table2;
	private ArrayList<Fornecedor> fornecedores = new ArrayList<Fornecedor>();
	private ArrayList<Produto> produtos = new ArrayList<Produto>();
	Produtofornecedor var = new Produtofornecedor();
	private JTextField txtMarca;
	
	/**
	 * Create the panel.
	 */
	public void praFrente(){
		layeredPane.add(this);
		layeredPane.moveToFront(this);
	}
    public PanelGerenciarFornecimentos(JLayeredPane layeredPane) {
		this.layeredPane = layeredPane;
		setBounds(0, 0, 910, 686);		
		setBackground(new Color(119, 118, 123));
		setLayout(null);
		
		JLabel lblFornecedorDeProdutos = new JLabel("Fornecedor de produtos");
		lblFornecedorDeProdutos.setFont(new Font("Dialog", Font.BOLD, 18));
		lblFornecedorDeProdutos.setHorizontalAlignment(SwingConstants.CENTER);
		lblFornecedorDeProdutos.setBounds(161, 12, 568, 45);
		add(lblFornecedorDeProdutos);
		
		JPanel panel = new JPanel();
		panel.setBounds(28, 103, 300, 165);
		add(panel);
		panel.setLayout(null);
		
		tf_cnpj = new JFormattedTextField(GerenciamentoPedido.Mascara("##.###.###/####-##"));
		tf_cnpj.setBounds(160, 48, 114, 19);
		panel.add(tf_cnpj);
		tf_cnpj.setColumns(10);
		
		JLabel lblCnpj = new JLabel("CNPJ");
		lblCnpj.setBounds(12, 50, 130, 15);
		panel.add(lblCnpj);
		lblCnpj.setHorizontalAlignment(SwingConstants.RIGHT);
		
		tf_cod = new JTextField();
		tf_cod.setBounds(160, 79, 114, 19);
		panel.add(tf_cod);
		tf_cod.setColumns(10);
		
		JLabel lblCodProduto = new JLabel("COD produto");
		lblCodProduto.setBounds(22, 81, 120, 15);
		panel.add(lblCodProduto);
		lblCodProduto.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JButton btnInserir = new JButton("Inserir");
		btnInserir.setBounds(12, 110, 117, 25);
		panel.add(btnInserir);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setBounds(157, 110, 117, 25);
		panel.add(btnExcluir);
		
		JLabel lblControleDeFornecimentos = new JLabel("Controle de fornecimentos");
		lblControleDeFornecimentos.setHorizontalAlignment(SwingConstants.CENTER);
		lblControleDeFornecimentos.setBounds(12, 12, 276, 15);
		panel.add(lblControleDeFornecimentos);
		
		table = new JTable();
		table.setBackground(new Color(255,255,255));
		table.setBounds(0, 0, 550, 270);
		
		defineTabela(1);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(340, 103, 550, 270);
		add(scrollPane);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(28, 280, 300, 394);
		add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblPesquisaDeFornecedor = new JLabel("Pesquisa de Fornecedor");
		lblPesquisaDeFornecedor.setHorizontalAlignment(SwingConstants.CENTER);
		lblPesquisaDeFornecedor.setBounds(12, 12, 276, 15);
		panel_2.add(lblPesquisaDeFornecedor);
		
		txtCnpj = new JTextField();
		txtCnpj.setBounds(84, 39, 204, 19);
		panel_2.add(txtCnpj);
		txtCnpj.setColumns(10);
		
		txtFornecedornome = new JTextField();
		txtFornecedornome.setBounds(84, 70, 204, 19);
		panel_2.add(txtFornecedornome);
		txtFornecedornome.setColumns(10);
		
		JButton btnPesquisarFornecedor = new JButton("Pesquisar Fornecedor");
		btnPesquisarFornecedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fornecedores = FornecedorDAO.buscaFornecedor(txtCnpj.getText(), txtFornecedornome.getText());
				preencheouEsvaziafornecedor(true);
			}
		});
		btnPesquisarFornecedor.setBounds(12, 101, 276, 25);
		panel_2.add(btnPesquisarFornecedor);
		
		JLabel lblCnpj_1 = new JLabel("CNPJ");
		lblCnpj_1.setBounds(12, 41, 70, 15);
		panel_2.add(lblCnpj_1);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(12, 72, 70, 15);
		panel_2.add(lblNome);
		
		JLabel lblPesquisaDeProdutos = new JLabel("Pesquisa de Produtos");
		lblPesquisaDeProdutos.setHorizontalAlignment(SwingConstants.CENTER);
		lblPesquisaDeProdutos.setBounds(12, 138, 276, 15);
		panel_2.add(lblPesquisaDeProdutos);
		
		txtProdutocod = new JTextField();
		txtProdutocod.setBounds(84, 165, 204, 19);
		panel_2.add(txtProdutocod);
		txtProdutocod.setColumns(10);
		
		txtProdutonome = new JTextField();
		txtProdutonome.setBounds(84, 196, 204, 19);
		panel_2.add(txtProdutonome);
		txtProdutonome.setColumns(10);
		
		JLabel lblCod = new JLabel("Cod");
		lblCod.setBounds(12, 167, 58, 15);
		panel_2.add(lblCod);
		
		JLabel lblNome_1 = new JLabel("Nome");
		lblNome_1.setBounds(12, 198, 54, 15);
		panel_2.add(lblNome_1);
		
		JButton btnPesquisaProduto = new JButton("Pesquisa Produto");
		btnPesquisaProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					double precomax = 0;
					double precomin = 0;
					int quantmax = 0;
					int quantmin = 0;
					try {
						if(!txtPrecomax.getText().equals("")){
						precomax = Double.parseDouble(txtPrecomax.getText());
						}
						if(!txtPrecomin.getText().equals("")){
							precomin = Double.parseDouble(txtPrecomin.getText());
						}
						if(!txtEstoquemax.getText().equals("")){
							quantmax = Integer.parseInt(txtEstoquemax.getText());
						}
						if(!txtEstoquemin.getText().equals("")){
							quantmin = Integer.parseInt(txtEstoquemin.getText());
						}
						produtos = ProdutoDao.procuraProdutos(txtProdutocod.getText(), txtProdutonome.getText(), false, txtMarca.getText(), false, precomin,precomax,quantmin,quantmax);	
					} catch (Exception h) {
						JOptionPane.showMessageDialog(null,h.getMessage());
					}
					preencheouEsvaziaProduto(true);
					
			}
		});
		btnPesquisaProduto.setBounds(12, 334, 276, 25);
		panel_2.add(btnPesquisaProduto);
		
		txtPrecomax = new JTextField();
		txtPrecomax.setBounds(228, 258, 60, 19);
		panel_2.add(txtPrecomax);
		txtPrecomax.setColumns(10);
		
		JLabel lblPreoMin = new JLabel("Preço min:");
		lblPreoMin.setBounds(12, 260, 81, 15);
		panel_2.add(lblPreoMin);
		
		txtPrecomin = new JTextField();
		txtPrecomin.setBounds(94, 258, 60, 19);
		panel_2.add(txtPrecomin);
		txtPrecomin.setColumns(10);
		
		JLabel lblMax = new JLabel("Max:");
		lblMax.setBounds(170, 260, 50, 15);
		panel_2.add(lblMax);
		
		JLabel lblEstoqueMin = new JLabel("Estoque min:");
		lblEstoqueMin.setBounds(12, 291, 92, 15);
		panel_2.add(lblEstoqueMin);
		
		txtEstoquemin = new JTextField();
		txtEstoquemin.setColumns(10);
		txtEstoquemin.setBounds(114, 289, 60, 19);
		panel_2.add(txtEstoquemin);
		
		JLabel lblMax_1 = new JLabel("Max:");
		lblMax_1.setBounds(180, 291, 40, 15);
		panel_2.add(lblMax_1);
		
		txtEstoquemax = new JTextField();
		txtEstoquemax.setColumns(10);
		txtEstoquemax.setBounds(228, 289, 60, 19);
		panel_2.add(txtEstoquemax);
		
		JLabel lblNome_1_1 = new JLabel("Marca");
		lblNome_1_1.setBounds(12, 229, 54, 15);
		panel_2.add(lblNome_1_1);
		
		txtMarca = new JTextField();
		txtMarca.setColumns(10);
		txtMarca.setBounds(84, 227, 204, 19);
		panel_2.add(txtMarca);
		
		JLabel lblFornecedores = new JLabel("Fornecedores");
		lblFornecedores.setBounds(341, 80, 157, 15);
		add(lblFornecedores);
		
		JLabel lblProdutos = new JLabel("Produtos");
		lblProdutos.setBounds(340, 380, 124, 15);
		add(lblProdutos);
		
		table2 = new JTable();
		table.setBackground(new Color(255,255,255));
		table.setBounds(0, 0, 550, 270);
		
		JScrollPane scrollPane_1 = new JScrollPane(table2);
		scrollPane_1.setBounds(340, 404, 550, 270);
		
		defineTabela(2);
		
		add(scrollPane_1);
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jogaNaVar();				
				if(ProdutofornecedorDAO.deleta(var)==1){
					JOptionPane.showMessageDialog(null, "O fornecedor agora não fornece o produto informado");
				}
			}
		});
		btnInserir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jogaNaVar();
				if(ProdutofornecedorDAO.insere(var)==1){
					JOptionPane.showMessageDialog(null,"O fornecedor agora fornece um produto a mais para você");
				}
			}
		});
		
    }
	public void defineTabela(int num){
		if(num == 1){
			DefaultTableModel model = (DefaultTableModel) table.getModel();					//
			model.addColumn("CNPJ");																// adiciona a coluna 0
			model.addColumn("Nome");																// adiciona a coluna 1
			model.addColumn("Estado");
			table.getColumnModel().getColumn(0).setPreferredWidth(180);			// define a largura da coluna 0
			table.getColumnModel().getColumn(1).setPreferredWidth(190);			// define a largura da coluna 1
			table.getColumnModel().getColumn(2).setPreferredWidth(180);			// define a largura da coluna 2
		}else{
			DefaultTableModel model = (DefaultTableModel) table2.getModel();					//
			model.addColumn("COD");																// adiciona a coluna 0
			model.addColumn("Descrição");																// adiciona a coluna 1
			model.addColumn("Preço");														// adiciona a coluna 2
			model.addColumn("Qnt");															// adiciona a coluna 4
			table2.getColumnModel().getColumn(0).setPreferredWidth(77);			// define a largura da coluna 0
			table2.getColumnModel().getColumn(1).setPreferredWidth(259);			// define a largura da coluna 1
			table2.getColumnModel().getColumn(2).setPreferredWidth(107);			// define a largura da coluna 2
			table2.getColumnModel().getColumn(3).setPreferredWidth(107);			// define a largura da coluna 3
		}
	}
	public void preencheouEsvaziafornecedor(boolean preenche){
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		for(int i = 0;i<model.getRowCount();i++){
			model.removeRow(0);
		}
		model.setRowCount(0);
		
		if (preenche) {
			// Populate the table with the items
			for (Fornecedor forn : fornecedores) {
				model.addRow(new Object[]{forn.getCnpj(),forn.getRazaosocial(),forn.getEstado()});
			}
		}
	}
	public void preencheouEsvaziaProduto(boolean preenche) {
		DefaultTableModel model = (DefaultTableModel) table2.getModel();
		for(int i = 0;i<model.getRowCount();i++){
			model.removeRow(0);
		}
		model.setRowCount(0);
		
		if (preenche) {
			// Populate the table with the items
			for (Produto prod : produtos) {
				model.addRow(new Object[]{prod.getCod(),prod.getDescricao(),prod.getPrecof(),prod.getQuantidadeestoque()});
			}
		}
	}
	public void jogaNaVar(){
		var.setFornecedor_cnpj(tf_cnpj.getText());
		var.setProduto_cod(tf_cod.getText());
	}
}


