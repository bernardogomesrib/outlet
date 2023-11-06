package TELAS;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

import javax.swing.JPanel;

import javax.swing.JTextField;

import ENTIDADES.Fornecedor;


import javax.swing.SwingConstants;

import javax.swing.JComboBox;


public class PanelTeste extends JPanel {
	private JLayeredPane layeredPane;
	Fornecedor fornecedor = new Fornecedor();
	private JTextField tf_desconto;
	private JTextField tf_numero;
	private JTextField tf_idpedido;
	
	
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
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(22, 43, 377, 190);
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
		tf_desconto.setBounds(195, 43, 172, 19);
		panel.add(tf_desconto);
		tf_desconto.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("desconto");
		lblNewLabel.setBounds(107, 45, 70, 15);
		panel.add(lblNewLabel);
		
		tf_idpedido = new JTextField();
		tf_idpedido.setBounds(195, 74, 172, 19);
		panel.add(tf_idpedido);
		tf_idpedido.setColumns(10);
		
		JLabel lblIdDoPedido = new JLabel("id do pedido");
		lblIdDoPedido.setBounds(63, 76, 114, 15);
		panel.add(lblIdDoPedido);
		lblIdDoPedido.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel lblFormaDePagamento = new JLabel("Forma de pagamento");
		lblFormaDePagamento.setBounds(12, 107, 165, 15);
		panel.add(lblFormaDePagamento);
		lblFormaDePagamento.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JComboBox<String> cb_formapagamento = new JComboBox<String>();
		cb_formapagamento.setBounds(195, 105, 172, 19);
		panel.add(cb_formapagamento);
		
		JButton btnCompletarVenda = new JButton("Completar venda");
		btnCompletarVenda.setBounds(12, 153, 165, 25);
		panel.add(btnCompletarVenda);
		
		JButton btnEditarVenda = new JButton("Editar venda");
		btnEditarVenda.setBounds(195, 153, 172, 25);
		panel.add(btnEditarVenda);
		
		JLabel lblValorDoPedido = new JLabel("Valor do pedido");
		lblValorDoPedido.setBounds(417, 88, 120, 15);
		add(lblValorDoPedido);
		
    }	
}


