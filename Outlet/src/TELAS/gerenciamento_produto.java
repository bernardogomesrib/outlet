package TELAS;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAO.ProdutoDao;
import DATABASE.Conexao;
import ENTIDADES.Produto;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;



public class gerenciamento_produto extends JFrame {

	private JPanel contentPane_titlulo;
	private JTextField tf_cod;
	private JTextField tf_preco;
	private JTextField tf_descricao;
	private JTextField tf_marca;
	private JTextField tf_quantidadeestoque;
	private Produto prod= new Produto();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gerenciamento_produto frame = new gerenciamento_produto();
					frame.setVisible(true);
					ProdutoDao.start(new Conexao().getConexao());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public gerenciamento_produto() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 910, 686);
		contentPane_titlulo = new JPanel();
		contentPane_titlulo.setBackground(new Color(128, 128, 128));
		contentPane_titlulo.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane_titlulo);
		contentPane_titlulo.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Gerenciamento de Produtos");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel.setBounds(338, 22, 320, 27);
		contentPane_titlulo.add(lblNewLabel);
		
		JLabel lblNewLabel_idproduto = new JLabel("ID Produto");
		lblNewLabel_idproduto.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_idproduto.setBounds(162, 136, 86, 14);
		contentPane_titlulo.add(lblNewLabel_idproduto);
		
		JLabel lblNewLabel_valorcompra = new JLabel("Preço");
		lblNewLabel_valorcompra.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_valorcompra.setBounds(162, 214, 104, 14);
		contentPane_titlulo.add(lblNewLabel_valorcompra);
		
		JLabel lblNewLabel_3_descricao = new JLabel("Descrição");
		lblNewLabel_3_descricao.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3_descricao.setBounds(162, 162, 69, 14);
		contentPane_titlulo.add(lblNewLabel_3_descricao);
		
		JLabel lblNewLabel_5_marca = new JLabel("Marca");
		lblNewLabel_5_marca.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_5_marca.setBounds(162, 188, 46, 14);
		contentPane_titlulo.add(lblNewLabel_5_marca);
		
		tf_cod = new JTextField();
		tf_cod.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				prod.setCod(tf_cod.getText());
			}
		});
		tf_cod.setBounds(261, 135, 397, 20);
		contentPane_titlulo.add(tf_cod);
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
		tf_preco.setBounds(218, 213, 440, 20);
		contentPane_titlulo.add(tf_preco);
		tf_preco.setColumns(10);
		
		tf_descricao = new JTextField();
		tf_descricao.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				prod.setDescricao(tf_descricao.getText());
			}
		});
		tf_descricao.setBounds(241, 161, 417, 20);
		contentPane_titlulo.add(tf_descricao);
		tf_descricao.setColumns(10);
		
		tf_marca = new JTextField();
		tf_marca.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				prod.setMarca(tf_marca.getText());
			}
		});
		tf_marca.setBounds(218, 187, 440, 20);
		contentPane_titlulo.add(tf_marca);
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
		contentPane_titlulo.add(btn_cadastrar);
		
		JButton btn_buscar = new JButton("Buscar");
		btn_buscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				prod = ProdutoDao.busca(prod.getCod());
				preencheOuApaga(true);
			}
		});
		btn_buscar.setBounds(288, 445, 111, 23);
		contentPane_titlulo.add(btn_buscar);
		
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
		contentPane_titlulo.add(btn_excluir);
		
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
		tf_quantidadeestoque.setBounds(339, 239, 320, 20);
		contentPane_titlulo.add(tf_quantidadeestoque);
		
		JLabel lblNewLabel_2_valorvenda_1 = new JLabel("Quantidade no estoque");
		lblNewLabel_2_valorvenda_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_valorvenda_1.setBounds(162, 240, 167, 14);
		contentPane_titlulo.add(lblNewLabel_2_valorvenda_1);
		
		JButton btn_atualizar = new JButton("Atualizar");
		btn_atualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(ProdutoDao.atualiza(prod)==1){
					JOptionPane.showMessageDialog(null, "produto atualizado com sucesso.");
				}
			}
		});
		btn_atualizar.setBounds(423, 445, 111, 23);
		contentPane_titlulo.add(btn_atualizar);
		
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
