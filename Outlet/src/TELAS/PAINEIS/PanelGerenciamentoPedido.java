package TELAS.PAINEIS;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JViewport;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;
import java.awt.event.KeyAdapter;

import DAO.ItempedidoDAO;
import DAO.PedidoDAO;
import DAO.ProdutoDao;

import ENTIDADES.Itempedido;
import ENTIDADES.Pedido;
import ENTIDADES.Produto;

import javax.swing.SwingConstants;
import javax.swing.plaf.DimensionUIResource;

public class PanelGerenciamentoPedido extends JPanel {

	private static final long serialVersionUID = 1L;	
	private JTextField tf_idp;
	private JFormattedTextField tf_cpf;
	private JFormattedTextField tf_data;
	private JTextField tf_cod;
	private JTextField tf_quantidade;
	private JTable table;
	private Produto produto = new Produto();
	private Pedido pedido =  new Pedido();
	private Itempedido item = new Itempedido();
	private ArrayList<Itempedido> itens = new ArrayList<Itempedido>();
	private ArrayList<Produto> produtos = new ArrayList<Produto>();
	private String qnt;
	private boolean ja_tinha_itens_no_pedido= false;
	private JLayeredPane layeredPane;
	/**
	 * Create the panel.
	 */
	public void praFrente(){
		layeredPane.add(this);
		layeredPane.moveToFront(this);
	}
    public PanelGerenciamentoPedido(JLayeredPane layeredPane) {
		this.layeredPane = layeredPane;
		setBounds(0, 0, 910, 686);		
		setBackground(new Color(255, 255, 255));
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(119, 118, 123));
		panel.setBounds(32, 112, 398, 446);
		add(panel);
		panel.setLayout(null);
		
		tf_idp = new JTextField();
		tf_idp.setBounds(183, 12, 180, 19);
		panel.add(tf_idp);
		tf_idp.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				pedido.setId(tf_idp.getText());
			}
		});
		tf_idp.setColumns(10);
		
		JLabel lblIdDoPedido = new JLabel("Id do pedido");
		lblIdDoPedido.setBounds(58, 12, 104, 15);
		panel.add(lblIdDoPedido);
		lblIdDoPedido.setHorizontalAlignment(SwingConstants.RIGHT);
		
		tf_cpf = new JFormattedTextField(Mascara("###.###.###-##"));
		tf_cpf.setBounds(183, 40, 180, 19);
		panel.add(tf_cpf);
		tf_cpf.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				pedido.setCliente_cpf(tf_cpf.getText());
			}
		});
		tf_cpf.setColumns(10);
		
		JLabel lblCpfDoCliente = new JLabel("CPf do cliente");
		lblCpfDoCliente.setBounds(58, 42, 107, 15);
		panel.add(lblCpfDoCliente);
		lblCpfDoCliente.setHorizontalAlignment(SwingConstants.RIGHT);
		
		tf_data = new JFormattedTextField(Mascara("##/##/####"));
		tf_data.setBounds(183, 71, 180, 19);
		panel.add(tf_data);
		tf_data.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				pedido.setData(tf_data.getText(), false);
			}
		});
		tf_data.setColumns(10);
		
		JLabel lblData = new JLabel("Data");
		lblData.setBounds(92, 73, 70, 15);
		panel.add(lblData);
		lblData.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JButton btnCriar = new JButton("Criar");
		btnCriar.setBounds(12, 100, 68, 25);
		panel.add(btnCriar);
		
		JButton btnProcurar = new JButton("Procurar");
		btnProcurar.setBounds(91, 100, 95, 25);
		panel.add(btnProcurar);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.setBounds(199, 100, 76, 25);
		panel.add(btnEditar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setBounds(284, 100, 79, 25);
		panel.add(btnExcluir);
		
		JPanel panelProdutos = new JPanel();
		panelProdutos.setBackground(new Color(119, 118, 123));
		panelProdutos.setBounds(12, 137, 374, 108);
		panel.add(panelProdutos);
		panelProdutos.setLayout(null);
		
		tf_cod = new JTextField();
		tf_cod.setBounds(167, 45, 180, 19);
		panelProdutos.add(tf_cod);
		tf_cod.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				produto.setCod(tf_cod.getText());
			}
		});
		tf_cod.setColumns(10);
		
		JLabel lblIdDoProduto = new JLabel("id do produto");
		lblIdDoProduto.setBounds(12, 47, 134, 15);
		panelProdutos.add(lblIdDoProduto);
		lblIdDoProduto.setHorizontalAlignment(SwingConstants.RIGHT);
		
		tf_quantidade = new JTextField();
		tf_quantidade.setBounds(169, 77, 180, 19);
		panelProdutos.add(tf_quantidade);
		tf_quantidade.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {				
				qnt = tf_quantidade.getText();					
				String trueNum ="";
				for(int i = 0;i<qnt.length();i++){
					char a = qnt.charAt(i);
					try {
						int b = Integer.parseInt(""+a);
						trueNum+=""+b;
						item.setQuantidade(Integer.parseInt(trueNum));
					} catch (Exception yyys) {
						JOptionPane.showMessageDialog(null, yyys.getMessage());		
					}
				}
				tf_quantidade.setText(trueNum);
			}
		});
		tf_quantidade.setColumns(10);
		
		JLabel lblQuantidade = new JLabel("Quantidade");
		lblQuantidade.setBounds(24, 77, 124, 15);
		panelProdutos.add(lblQuantidade);
		lblQuantidade.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel lblProdutosParaO = new JLabel("Produtos para o pedido");
		lblProdutosParaO.setBounds(23, 0, 326, 33);
		panelProdutos.add(lblProdutosParaO);
		lblProdutosParaO.setFont(new Font("Dialog", Font.BOLD, 16));
		lblProdutosParaO.setHorizontalAlignment(SwingConstants.CENTER);
		
		JButton btnInserir = new JButton("Inserir");
		btnInserir.setBounds(12, 257, 95, 25);
		panel.add(btnInserir);
		
		JButton btnExcluir_1 = new JButton("Excluir");
		btnExcluir_1.setBounds(119, 257, 114, 25);
		panel.add(btnExcluir_1);
		
		JButton btnEditar_1 = new JButton("Editar");
		btnEditar_1.setBounds(245, 257, 117, 25);
		panel.add(btnEditar_1);
		
		JButton btnConcluirCompra = new JButton("Concluir pedido");
		btnConcluirCompra.setBounds(12, 323, 164, 25);
		panel.add(btnConcluirCompra);
		
		JButton btnCancelarPedido = new JButton("Cancelar Pedido");
		btnCancelarPedido.setBounds(199, 323, 164, 25);
		panel.add(btnCancelarPedido);
		
		

		table = new JTable();
		table.setBounds(0, 0, 450, 555);
		defineTabela();
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(456, 50, 450, 555);
		scrollPane.setPreferredSize(new DimensionUIResource(450, 555)); // define a largura e altura do ScrollPane
		JViewport viewport = scrollPane.getViewport(); // define a cor de fundo do ScrollPane
		viewport.setBackground(new Color(255,255,255)); 
		
		add(scrollPane);
		
		JLabel lblGerenciamentoDePedidos = new JLabel("Gerenciamento de pedidos");
		lblGerenciamentoDePedidos.setFont(new Font("Dialog", Font.BOLD, 18));
		lblGerenciamentoDePedidos.setHorizontalAlignment(SwingConstants.CENTER);
		lblGerenciamentoDePedidos.setBounds(32, 51, 390, 32);
		add(lblGerenciamentoDePedidos);
		btnCancelarPedido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(ja_tinha_itens_no_pedido){
					if(ItempedidoDAO.deletaItensdoPedido(tf_idp.getText())>=1){
						itens.clear();
						produtos.clear(); 
						JOptionPane.showMessageDialog(null,"Itens deletados do pedido.");
						preencheouEsvazia(false);
					}else{
						itens.clear();
						produtos.clear(); 
						preencheouEsvazia(false);
					}
				}else{
					itens.clear();
					produtos.clear();
					JOptionPane.showMessageDialog(null,"Itens deletados do pedido.");
					preencheouEsvazia(false);
				}
			}
		});
		btnConcluirCompra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				double somas =0;
				for (Itempedido itempedido : itens) {
					somas+=itempedido.getSubtotal();
				}
				DecimalFormat df = new DecimalFormat("0.00");
				model.addRow(new Object[]{"","Total:","","R$ "+df.format(somas)});
				if(ja_tinha_itens_no_pedido){
					for (Itempedido ite : itens) {
						ItempedidoDAO.deleta(ite);
					}
					if(ItempedidoDAO.colocarvarios(itens,produtos)>=1){
						JOptionPane.showMessageDialog(null,"Itens inseridos com sucesso");
						ja_tinha_itens_no_pedido = true;
					}
				}else{
					if(ItempedidoDAO.colocarvarios(itens,produtos)>=1){
						JOptionPane.showMessageDialog(null,"Itens inseridos com sucesso");
						ja_tinha_itens_no_pedido = true;
					}
				}
			}
		});
		btnEditar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int local = procurapeloid(tf_cod.getText());
				if(local == -9999){
					JOptionPane.showMessageDialog(null, "não foi encontrado o produto");
				}else{
					itens.get(local).setQuantidadenova(Integer.parseInt(tf_quantidade.getText()));
					preencheouEsvazia(true);
				}
			}
		});
		btnExcluir_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int idRemovido = procurapeloid(tf_cod.getText());
				itens.remove(idRemovido);
				produtos.remove(idRemovido);
				preencheouEsvazia(true);
			}
		});
		btnInserir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				produto = ProdutoDao.busca(produto.getCod());
				try {
					if(!produto.getDescricao().equals("")){					
						item.setPedido_id(pedido.getId());
						item.setProduto_cod(produto.getCod());
						item.setValor(Double.parseDouble(""+produto.getPreco()));					
						int qnt = item.getQuantidade();
						double vl = item.getValor();
						
						int local = procurapeloid(item.getProduto_cod());
						if(!(item.getQuantidade()==0)){							
							if(-9999 == local){
								produtos.add(produto);
								item.setSubtotal(vl*qnt);
								itens.add(new Itempedido(item.getPedido_id(),item.getProduto_cod(),item.getQuantidade(),item.getValor(),item.getSubtotal()));
							}else{							
								itens.get(local).addMaisQuantidade(qnt);
							}						
							preencheouEsvazia(true);
					}else{
						JOptionPane.showMessageDialog(null, "Qual a quantidade?");
					}
				}
				} catch (NullPointerException zxc) {
					JOptionPane.showMessageDialog(null, "Produto não encontrado");
				}
				
				
			}
		});
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(PedidoDAO.deleta(pedido)==1){
					JOptionPane.showMessageDialog(null, "Pedido apagado");
				}
			}
		});
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(PedidoDAO.atualiza(pedido)==1){
					JOptionPane.showMessageDialog(null, "Pedido atualizado");
				}
			}
		});
		btnProcurar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pedido = PedidoDAO.buscaClienteDoPedido(pedido.getId(),true);
				pedidoNaTela();
				itens = ItempedidoDAO.buscaItensDoPedido(pedido.getId());
				if(itens.size()!=0){
					ja_tinha_itens_no_pedido = true;
					produtos = ProdutoDao.procuraProdutos(itens);
					preencheouEsvazia(true);	
					
				}else{
					preencheouEsvazia(true);
				}
			}
		});
		btnCriar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(PedidoDAO.insere(pedido)==1){
					JOptionPane.showMessageDialog(null, "Pedido criado");
					produtos = new ArrayList<Produto>();
					itens = new ArrayList<Itempedido>();
					preencheouEsvazia(true);
				}
			}
		});		
	}
	public void defineTabela(){
		DefaultTableModel model = (DefaultTableModel) table.getModel(); //
		model.addColumn("id");
		model.addColumn("Descrição"); // adiciona a coluna 0
		model.addColumn("Qnt"); // adiciona a coluna 1
		model.addColumn("Preço"); // adiciona a coluna 2
		table.getColumnModel().getColumn(0).setPreferredWidth(30);
		table.getColumnModel().getColumn(1).setPreferredWidth(300); // define a largura da coluna 0
		table.getColumnModel().getColumn(2).setPreferredWidth(30); // define a largura da coluna 1
		table.getColumnModel().getColumn(3).setPreferredWidth(90);
	}
	public static MaskFormatter Mascara(String Mascara){
        
		MaskFormatter F_Mascara = new MaskFormatter();
		try{
			F_Mascara.setMask(Mascara); //Atribui a mascara
			F_Mascara.setPlaceholderCharacter(' '); //Caracter para preencimento
		}
		catch (Exception excecao) {
		excecao.printStackTrace();
		}
		return F_Mascara;
 	}
	public void preencheouEsvazia(boolean preenche) {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		for(int i = 0;i<model.getRowCount();i++){
			model.removeRow(0);
		}			
		model.setRowCount(0);	
		if (preenche) {
			// Populate the table with the items
			for (int i = 0;i<itens.size();i++) {
				model.addRow(new Object[]{itens.get(i).getProduto_cod(),produtos.get(i).getDescricao(),itens.get(i).getQuantidade(),itens.get(i).getSubtotalf()});
			}
		}
	}
	public int procurapeloid(String id){
		for(int i = itens.size()-1;i>=0;i--){
			if(itens.get(i).getProduto_cod().equals(id)){
				return i;
			}
		}
		return -9999;
	}
	public void pedidoNaTela(){
		tf_idp.setText(pedido.getId());
		tf_cpf.setText(pedido.getCliente_cpf());
		String data = pedido.getData(false);
		tf_data.setText(data);
	}
}
