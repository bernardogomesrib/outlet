package TELAS;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.DimensionUIResource;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JViewport;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import DAO.ItempedidoDAO;
import DAO.PedidoDAO;
import DAO.ProdutoDao;
import DATABASE.Conexao;
import ENTIDADES.Itempedido;
import ENTIDADES.Pedido;
import ENTIDADES.Produto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class telateste2 extends JFrame {

	private JPanel contentPane;
	private JTextField tf_idp;
	private JFormattedTextField tf_cpf;
	private JFormattedTextField tf_data;
	private JTextField tf_cod;
	private JFormattedTextField tf_quantidade;
	private JTable table;
	private Produto produto = new Produto();
	private Pedido pedido =  new Pedido();
	private Itempedido item = new Itempedido();
	private ArrayList<Itempedido> itens = new ArrayList<Itempedido>();
	private Map<String,Produto> produtos = new HashMap<String, Produto>();
	private String qnt;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					telateste2 frame = new telateste2();
					frame.setVisible(true);
					Conexao conexao = new Conexao();
					PedidoDAO.start(conexao.getConexao());
					ItempedidoDAO.start(conexao.getConexao());
					ProdutoDao.start(conexao.getConexao());
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public telateste2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1013, 647);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(119, 118, 123));
		panel.setBounds(33, 33, 398, 446);
		contentPane.add(panel);
		panel.setLayout(null);
		
		tf_idp = new JTextField();
		tf_idp.setBounds(183, 12, 180, 19);
		panel.add(tf_idp);
		tf_idp.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				pedido.setId(tf_idp.getText());
				System.out.println(pedido.getId());
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
		
		JLabel lblProdutosParaO = new JLabel("Produtos para o pedido");
		lblProdutosParaO.setBounds(37, 137, 326, 33);
		panel.add(lblProdutosParaO);
		lblProdutosParaO.setFont(new Font("Dialog", Font.BOLD, 16));
		lblProdutosParaO.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblIdDoProduto = new JLabel("id do produto");
		lblIdDoProduto.setBounds(27, 184, 134, 15);
		panel.add(lblIdDoProduto);
		lblIdDoProduto.setHorizontalAlignment(SwingConstants.RIGHT);
		
		tf_cod = new JTextField();
		tf_cod.setBounds(182, 182, 180, 19);
		panel.add(tf_cod);
		tf_cod.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				produto.setCod(tf_cod.getText());
			}
		});
		tf_cod.setColumns(10);
		
		JLabel lblQuantidade = new JLabel("Quantidade");
		lblQuantidade.setBounds(38, 211, 124, 15);
		panel.add(lblQuantidade);
		lblQuantidade.setHorizontalAlignment(SwingConstants.RIGHT);
		
		tf_quantidade = new JFormattedTextField(Mascara("##########"));
		tf_quantidade.setBounds(183, 211, 180, 19);
		panel.add(tf_quantidade);
		tf_quantidade.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				try {
					qnt = tf_quantidade.getText();					
					item.setQuantidade(Integer.parseInt(qnt.strip()));
					System.out.println(qnt);
					tf_quantidade.setText(qnt);
				} catch (Exception z) {
					System.out.println(z.getMessage());
				}
			}
		});
		tf_quantidade.setColumns(10);
		
		JButton btnInserir = new JButton("Inserir");
		btnInserir.setBounds(12, 257, 95, 25);
		panel.add(btnInserir);
		
		JButton btnExcluir_1 = new JButton("Excluir");
		btnExcluir_1.setBounds(119, 257, 114, 25);
		panel.add(btnExcluir_1);
		
		JButton btnEditar_1 = new JButton("Editar");
		btnEditar_1.setBounds(245, 257, 117, 25);
		panel.add(btnEditar_1);
		
		JButton btnConcluirCompra = new JButton("Concluir compra");
		btnConcluirCompra.setBounds(12, 362, 164, 25);
		panel.add(btnConcluirCompra);
		
		JButton btnCancelarPedido = new JButton("Cancelar Pedido");
		btnCancelarPedido.setBounds(199, 362, 164, 25);
		panel.add(btnCancelarPedido);
		
		/*
		
		scrollPane = new JScrollPane(table);
		scrollPane.setBounds(511, 100, 450, 385);
		scrollPane.setLocation(511, 100);
		scrollPane.setSize(450, 385);
		
		
		contentPane.add(scrollPane);
		*/
		table = new JTable();
		table.setBounds(500, 33, 450, 555);
		defineTabela();
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(500, 33, 450, 555);
		scrollPane.setPreferredSize(new DimensionUIResource(450, 555)); // define a largura e altura do ScrollPane
		JViewport viewport = scrollPane.getViewport(); // define a cor de fundo do ScrollPane
		viewport.setBackground(new Color(255,255,255)); 
		
		contentPane.add(scrollPane);
		btnCancelarPedido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnConcluirCompra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnEditar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnExcluir_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				itens.remove(itens.indexOf(item));
				preencheouEsvazia(true);
			}
		});
		btnInserir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				produto = ProdutoDao.busca(produto.getCod());
				if(!produto.getDescricao().equals("")){					
					item.setPedido_id(pedido.getId());
					item.setProduto_cod(produto.getCod());
					if(!(item.getQuantidade()==0)){
						produtos.put(produto.getCod(),produto);
						itens.add(item);
						preencheouEsvazia(true);
					}else{
						JOptionPane.showMessageDialog(null, "Qual a quantidade?");
					}

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
			}
		});
		btnCriar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(PedidoDAO.insere(pedido)==1){
					JOptionPane.showMessageDialog(null, "Pedido criado");
				}
			}
		});
	
		
		
	}
	public void defineTabela(){
		DefaultTableModel model = (DefaultTableModel) table.getModel(); //
		model.addColumn("Descrição"); // adiciona a coluna 0
		model.addColumn("Quantidade"); // adiciona a coluna 1
		model.addColumn("Preço"); // adiciona a coluna 2
		table.getColumnModel().getColumn(0).setPreferredWidth(330); // define a largura da coluna 0
		table.getColumnModel().getColumn(1).setPreferredWidth(60); // define a largura da coluna 1
		table.getColumnModel().getColumn(2).setPreferredWidth(60);
	}
	public MaskFormatter Mascara(String Mascara){
        
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
	
		// Clear the table
		model.setRowCount(0);
	
		if (preenche) {
			// Populate the table with the items
			Produto prod = new Produto();
			for (Itempedido itempedido : itens) {
				prod = produtos.get(itempedido.getProduto_cod());
				itempedido.setSubtotal(itempedido.getQuantidade() * prod.getPreco());
				Object[] linha = new Object[]{prod.getDescricao(), itempedido.getQuantidade(), itempedido.getSubtotal()};
				model.addRow(linha);
			}
		}
		tf_quantidade.setText(qnt);
	}
}