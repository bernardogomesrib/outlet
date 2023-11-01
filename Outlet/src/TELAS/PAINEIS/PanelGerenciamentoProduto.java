package TELAS.PAINEIS;


import DAO.ProdutoDao;
import ENTIDADES.Produto;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.SwingConstants;



public class PanelGerenciamentoProduto extends JPanel {
	
	private JTextField tf_cod;
	private JTextField tf_preco;
	private JTextField tf_descricao;
	private JTextField tf_marca;
	private JTextField tf_quantidadeestoque;
	private Produto prod= new Produto();
	private JLayeredPane layeredPane;
	/**
	 * Create the panel.
	 */
		public void praFrente(){
			layeredPane.add(this);
			layeredPane.moveToFront(this);
		}
    	public PanelGerenciamentoProduto(JLayeredPane layeredPane) {
		this.layeredPane = layeredPane;			

		setBounds(0, 0, 910, 686);		
		setBackground(new Color(255, 255, 255));	
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Gerenciamento de Produtos");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel.setBounds(12, 22, 876, 27);
		add(lblNewLabel);
		
		JLabel lblNewLabel_idproduto = new JLabel("ID Produto");
		lblNewLabel_idproduto.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_idproduto.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_idproduto.setBounds(137, 136, 111, 14);
		add(lblNewLabel_idproduto);
		
		JLabel lblNewLabel_valorcompra = new JLabel("Preço");
		lblNewLabel_valorcompra.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_valorcompra.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_valorcompra.setBounds(162, 214, 86, 14);
		add(lblNewLabel_valorcompra);
		
		JLabel lblNewLabel_3_descricao = new JLabel("Descrição");
		lblNewLabel_3_descricao.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3_descricao.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3_descricao.setBounds(162, 162, 86, 14);
		add(lblNewLabel_3_descricao);
		
		JLabel lblNewLabel_5_marca = new JLabel("Marca");
		lblNewLabel_5_marca.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_5_marca.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_5_marca.setBounds(162, 188, 86, 14);
		add(lblNewLabel_5_marca);
		
		tf_cod = new JTextField();
		tf_cod.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				prod.setCod(tf_cod.getText());
			}
		});
		tf_cod.setBounds(261, 135, 397, 20);
		add(tf_cod);
		tf_cod.setColumns(10);
		
		tf_preco = new JTextField();
		tf_preco.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				try {
					prod.setPreco(Double.parseDouble(tf_preco.getText()));	
				} catch (Exception x) {
					System.out.println(x.getMessage());
				}
				System.out.println(prod.getPreco());
			}
		});
		tf_preco.setBounds(261, 213, 397, 20);
		add(tf_preco);
		tf_preco.setColumns(10);
		
		tf_descricao = new JTextField();
		tf_descricao.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				prod.setDescricao(tf_descricao.getText());
			}
		});
		tf_descricao.setBounds(261, 161, 397, 20);
		add(tf_descricao);
		tf_descricao.setColumns(10);
		
		tf_marca = new JTextField();
		tf_marca.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				prod.setMarca(tf_marca.getText());
			}
		});
		tf_marca.setBounds(261, 187, 397, 20);
		add(tf_marca);
		tf_marca.setColumns(10);
		
		JButton btn_cadastrar = new JButton("Cadastrar");
		btn_cadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(ProdutoDao.insereProduto(prod)==1){
					JOptionPane.showMessageDialog(null, "produto cadastrado com sucesso.");
					preencheOuApaga(false);
				}
			}
		});
		btn_cadastrar.setBounds(153, 445, 108, 23);
		add(btn_cadastrar);
		
		JButton btn_buscar = new JButton("Buscar");
		btn_buscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				prod = ProdutoDao.busca(prod.getCod());
				preencheOuApaga(true);
			}
		});
		btn_buscar.setBounds(288, 445, 111, 23);
		add(btn_buscar);
		
		JButton btn_excluir = new JButton("Excluir");
		btn_excluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(ProdutoDao.deleta(prod)==1){
					JOptionPane.showMessageDialog(null, "produto apagado com sucesso.");
					preencheOuApaga(false);					
				}
			}
		});
		btn_excluir.setBounds(570, 445, 111, 23);
		add(btn_excluir);
		
		tf_quantidadeestoque = new JTextField();
		tf_quantidadeestoque.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				try {
					prod.setQuantidadeestoque(Integer.parseInt(tf_quantidadeestoque.getText()));
				} catch (Exception t) {
					System.out.println(t.getMessage());
				}
				System.out.println(prod.getQuantidadeestoque());
			}
		});
		tf_quantidadeestoque.setColumns(10);
		tf_quantidadeestoque.setBounds(366, 239, 293, 20);
		add(tf_quantidadeestoque);
		
		JLabel lblNewLabel_2_valorvenda_1 = new JLabel("Quantidade no estoque");
		lblNewLabel_2_valorvenda_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2_valorvenda_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_valorvenda_1.setBounds(153, 240, 207, 14);
		add(lblNewLabel_2_valorvenda_1);
		
		JButton btn_atualizar = new JButton("Atualizar");
		btn_atualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(ProdutoDao.atualiza(prod)==1){
					JOptionPane.showMessageDialog(null, "produto atualizado com sucesso.");
				}
			}
		});
		btn_atualizar.setBounds(423, 445, 111, 23);
		add(btn_atualizar);
		
	}
	public void preencheOuApaga(boolean preenche) {		
			if(preenche){
				tf_cod.setText(prod.getCod());
				tf_descricao.setText(prod.getDescricao());
				tf_marca.setText(prod.getMarca());				
				tf_quantidadeestoque.setText(""+prod.getQuantidadeestoque());
				tf_preco.setText(""+prod.getPreco());
			}else{
				tf_cod.setText("");
				tf_descricao.setText("");
				tf_marca.setText("");
				tf_quantidadeestoque.setText(""+"");
				tf_preco.setText(""+"");
				prod = new Produto();
			}
	}
}