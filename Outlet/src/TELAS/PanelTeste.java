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
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class PanelTeste extends JPanel {
	private JLayeredPane layeredPane;
	Fornecedor fornecedor = new Fornecedor();
	private JTextField tf_desconto;
	private JTextField tf_numero;
	private JTextField tf_idpedido;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	
	
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
		btnCompletarVenda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCompletarVenda.setBounds(12, 153, 165, 25);
		panel.add(btnCompletarVenda);
		
		JButton btnEditarVenda = new JButton("Editar venda");
		btnEditarVenda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnEditarVenda.setBounds(195, 153, 172, 25);
		panel.add(btnEditarVenda);
		
		JLabel lblValorDoPedido = new JLabel("Valor do pedido : R$");
		lblValorDoPedido.setBounds(417, 88, 334, 15);
		add(lblValorDoPedido);
		
		JLabel lblValorDesconto = new JLabel("Valor pós desconto: R$ ");
		lblValorDesconto.setBounds(417, 115, 334, 15);
		add(lblValorDesconto);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(411, 204, 487, 470);
		add(scrollPane);
		
		JLabel lblPedidosAbertos = new JLabel("Pedidos abertos");
		lblPedidosAbertos.setBounds(417, 177, 264, 15);
		add(lblPedidosAbertos);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(22, 265, 377, 409);
		add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCpf.setBounds(12, 12, 70, 15);
		panel_1.add(lblCpf);
		
		textField = new JTextField();
		textField.setBounds(88, 10, 277, 19);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JLabel lblCod = new JLabel("CODs:");
		lblCod.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCod.setBounds(12, 41, 70, 15);
		panel_1.add(lblCod);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(88, 39, 277, 19);
		panel_1.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setBounds(275, 70, 90, 19);
		panel_1.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblMax = new JLabel("max:");
		lblMax.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMax.setBounds(223, 72, 46, 15);
		panel_1.add(lblMax);
		
		textField_3 = new JTextField();
		textField_3.setBounds(128, 70, 90, 19);
		panel_1.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblSubtotalMin = new JLabel("Subtotal min:");
		lblSubtotalMin.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSubtotalMin.setBounds(12, 72, 98, 15);
		panel_1.add(lblSubtotalMin);
		
		JLabel lblDataMin = new JLabel("Data min:");
		lblDataMin.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDataMin.setBounds(12, 103, 98, 15);
		panel_1.add(lblDataMin);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(128, 101, 90, 19);
		panel_1.add(textField_4);
		
		JLabel lblMax_1 = new JLabel("max:");
		lblMax_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMax_1.setBounds(223, 103, 46, 15);
		panel_1.add(lblMax_1);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(275, 101, 90, 19);
		panel_1.add(textField_5);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnPesquisar.setBounds(12, 146, 353, 25);
		panel_1.add(btnPesquisar);
		
		JLabel lblBuscaDePedidos = new JLabel("Busca de pedidos para transformar em venda");
		lblBuscaDePedidos.setBounds(32, 245, 367, 15);
		add(lblBuscaDePedidos);
		
    }	
}


