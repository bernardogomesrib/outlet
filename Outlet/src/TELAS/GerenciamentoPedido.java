package TELAS;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.DimensionUIResource;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.text.MaskFormatter;

import DAO.PedidoDAO;
import DAO.ProdutoDao;
import DATABASE.Conexao;
import ENTIDADES.Itempedido;
import ENTIDADES.Pedido;
import ENTIDADES.Produto;

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

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class GerenciamentoPedido extends JFrame {

	private JPanel contentPane;
	private JTextField tf_cpf;
	private JTextField tf_data;
	private JTextField tf_quantidade;
	private JTextField tf_idpedido;
	private JTextField tf_cod;
	private JTable table;
	private Produto produto = new Produto();
	private Pedido pedido =  new Pedido();
	private Itempedido item = new Itempedido();
	private ArrayList<Itempedido> itens = new ArrayList<Itempedido>();
	private Map<String,Produto> produtos = new HashMap<String, Produto>();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GerenciamentoPedido frame = new GerenciamentoPedido();
					frame.setVisible(true);
					Conexao conexao = new Conexao();
					ProdutoDao.start(conexao.getConexao());
					PedidoDAO.start(conexao.getConexao());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GerenciamentoPedido() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1013, 647);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lbl_Cpf_cliente_1 = new JLabel("id do pedido");
		lbl_Cpf_cliente_1.setBounds(44, 109, 86, 14);
		contentPane.add(lbl_Cpf_cliente_1);

		tf_idpedido = new JTextField();
		tf_idpedido.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				pedido.setId(tf_idpedido.getText());
				System.out.println(pedido.getId());
			}
		});

		tf_idpedido.setBounds(134, 106, 215, 20);
		contentPane.add(tf_idpedido);			
		
		JLabel lbl_Cpf_cliente = new JLabel("Cpf do Cliente");
		lbl_Cpf_cliente.setBounds(44, 140, 86, 14);
		contentPane.add(lbl_Cpf_cliente);
		
		tf_cpf = new JFormattedTextField(Mascara("###.###.###-##"));
		tf_cpf.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				pedido.setCliente_cpf(tf_cpf.getText());
			}
		});
		tf_cpf.setBounds(134, 137, 215, 20);
		contentPane.add(tf_cpf);
		tf_cpf.setColumns(10);
		
		JLabel lbl_Gerenciamento_pedido = new JLabel("Gerenciamento de Pedido");
		lbl_Gerenciamento_pedido.setFont(new Font("Tahoma", Font.BOLD, 22));
		lbl_Gerenciamento_pedido.setBounds(350, 44, 303, 27);
		contentPane.add(lbl_Gerenciamento_pedido);
		
		JLabel lbl_Produto = new JLabel("Data");
		lbl_Produto.setBounds(54, 168, 79, 14);
		contentPane.add(lbl_Produto);
		
		tf_data = new JFormattedTextField(Mascara("##/##/####"));
		tf_data.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				pedido.setData(tf_data.getText(), false);
			}
		});
		tf_data.setBounds(146, 165, 203, 20);
		contentPane.add(tf_data);
		tf_data.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Quantidade do Produto");
		lblNewLabel.setBounds(44, 291, 131, 14);
		contentPane.add(lblNewLabel);
		
		tf_quantidade = new JFormattedTextField(Mascara("##########"));
		tf_quantidade.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				try {
					System.out.println(tf_quantidade.getText().strip());
					item.setQuantidade(Integer.parseInt(tf_quantidade.getText().strip()));
				} catch (Exception z) {
					System.out.println(z.getMessage());
				}
				
			}
		});
		tf_quantidade.setBounds(185, 288, 86, 20);
		contentPane.add(tf_quantidade);
		tf_quantidade.setColumns(10);
		
		JButton btn_Concluir = new JButton("Concluir");
		btn_Concluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_Concluir.setBounds(393, 535, 89, 23);
		contentPane.add(btn_Concluir);
		
		JButton btn_Cancelar = new JButton("Cancelar");
		btn_Cancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_Cancelar.setBounds(535, 535, 89, 23);
		contentPane.add(btn_Cancelar);
		
		
		
		tf_cod = new JTextField();
		tf_cod.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				produto.setCod(tf_cod.getText());
			}
		});
		tf_cod.setColumns(10);
		tf_cod.setBounds(185, 260, 86, 20);
		contentPane.add(tf_cod);
		
		JLabel lblIdDoProduto = new JLabel("id do produto");
		lblIdDoProduto.setBounds(44, 263, 131, 14);
		contentPane.add(lblIdDoProduto);
		
		JButton bt_criarpedido = new JButton("Criar pedido");
		bt_criarpedido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(PedidoDAO.insere(pedido)==1){
					JOptionPane.showMessageDialog(null, "Pedido criado");
				}
			}
		});
		bt_criarpedido.setBounds(10, 202, 103, 23);
		contentPane.add(bt_criarpedido);
		
		JButton bt_apagarPedido = new JButton("Apagar pedido");
		bt_apagarPedido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(PedidoDAO.deleta(pedido)==1){
					JOptionPane.showMessageDialog(null, "Pedido apagado");
				}
			}
		});
		bt_apagarPedido.setBounds(123, 202, 103, 23);
		contentPane.add(bt_apagarPedido);
		
		JButton bt_atualizar = new JButton("Atualizar pedido");
		bt_atualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(PedidoDAO.atualiza(pedido)==1){
					JOptionPane.showMessageDialog(null, "Pedido atualizado");
				}
			}
		});
		bt_atualizar.setBounds(236, 202, 113, 23);
		contentPane.add(bt_atualizar);
		
		JButton btn_Concluir_4 = new JButton("Adicionar produto");
		btn_Concluir_4.addActionListener(new ActionListener() {
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
		btn_Concluir_4.setBounds(10, 341, 120, 23);
		contentPane.add(btn_Concluir_4);
		
		JButton btn_Concluir_5 = new JButton("Apagar produto");
		btn_Concluir_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_Concluir_5.setBounds(137, 341, 113, 23);
		contentPane.add(btn_Concluir_5);
		
	
		
		JButton bt_excluirPedido = new JButton("Excluir pedido");
		bt_excluirPedido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		bt_excluirPedido.setBounds(260, 341, 89, 23);
		contentPane.add(bt_excluirPedido);
		
		JButton bt_excluirItemDoPedido = new JButton("Excluir item");
		bt_excluirItemDoPedido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		bt_excluirItemDoPedido.setBounds(369, 341, 89, 23);
		contentPane.add(bt_excluirItemDoPedido);
		table = new JTable();
		table.setBounds(511, 106, 450, 385);
		defineTabela();
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(511, 106, 450, 385);
		scrollPane.setLocation(511, 106);
		scrollPane.setSize(450, 385);
		scrollPane.setPreferredSize(new DimensionUIResource(450, 385)); // define a largura e altura do ScrollPane
		JViewport viewport = scrollPane.getViewport(); // define a cor de fundo do ScrollPane
		viewport.setBackground(new Color(255,255,255)); 
		
		contentPane.add(scrollPane);
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
	public void defineTabela(){
		DefaultTableModel model = (DefaultTableModel) table.getModel(); //
		model.addColumn("Descrição"); // adiciona a coluna 0
		model.addColumn("Quantidade"); // adiciona a coluna 1
		model.addColumn("Preço"); // adiciona a coluna 2
		table.getColumnModel().getColumn(0).setPreferredWidth(330); // define a largura da coluna 0
		table.getColumnModel().getColumn(1).setPreferredWidth(60); // define a largura da coluna 1
		table.getColumnModel().getColumn(2).setPreferredWidth(60);
	}
	public void preencheouEsvazia(boolean preenche){
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		if(preenche){
			preencheouEsvazia(false);
			Produto prod = new Produto();
			for (Itempedido itempedido : itens) {
				prod=produtos.get(itempedido.getProduto_cod());
				itempedido.setSubtotal(itempedido.getQuantidade()*prod.getPreco());
				model.addRow(new Object[]{prod.getDescricao(),itempedido.getQuantidade(),itempedido.getSubtotal()});
			}
		}else{
			model = new DefaultTableModel();
			table.setModel(model);
			defineTabela();
		}
		
	}
}
