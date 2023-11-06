package TELAS;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

import javax.swing.JPanel;

import javax.swing.JTextField;

import ENTIDADES.Fornecedor;

import java.awt.event.ActionListener;

import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Font;


public class PanelTeste2 extends JPanel {
	private JLayeredPane layeredPane;
	Fornecedor fornecedor = new Fornecedor();
	private JTextField tf_cnpj;
	private JTextField tf_cod;
	
	
	/**
	 * Create the panel.
	 */
	public void praFrente(){
		layeredPane.add(this);
		layeredPane.moveToFront(this);
	}
    public PanelTeste2(JLayeredPane layeredPane) {
		this.layeredPane = layeredPane;
		setBounds(0, 0, 910, 686);		
		setBackground(new Color(119, 118, 123));
		setLayout(null);
		
		tf_cnpj = new JTextField();
		tf_cnpj.setBounds(515, 202, 114, 19);
		add(tf_cnpj);
		tf_cnpj.setColumns(10);
		
		tf_cod = new JTextField();
		tf_cod.setBounds(515, 233, 114, 19);
		add(tf_cod);
		tf_cod.setColumns(10);
		
		JLabel lblCnpj = new JLabel("CNPJ");
		lblCnpj.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCnpj.setBounds(367, 204, 130, 15);
		add(lblCnpj);
		
		JLabel lblCodProduto = new JLabel("COD produto");
		lblCodProduto.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCodProduto.setBounds(377, 235, 120, 15);
		add(lblCodProduto);
		
		JButton btnInserir = new JButton("Inserir");
		btnInserir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnInserir.setBounds(344, 362, 117, 25);
		add(btnInserir);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnExcluir.setBounds(512, 362, 117, 25);
		add(btnExcluir);
		
		JLabel lblFornecedorDeProdutos = new JLabel("Fornecedor de produtos");
		lblFornecedorDeProdutos.setFont(new Font("Dialog", Font.BOLD, 18));
		lblFornecedorDeProdutos.setHorizontalAlignment(SwingConstants.CENTER);
		lblFornecedorDeProdutos.setBounds(165, 61, 568, 45);
		add(lblFornecedorDeProdutos);
		
    }	
}


