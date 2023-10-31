package TELAS;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


import com.toedter.calendar.JDateChooser;

import ENTIDADES.Cliente;
import ENTIDADES.Endereco;

public class PanelTeste extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField tf_BairroCliente;
	private JTextField tf_NomeCliente;
	private JTextField tf_EmailCliente;
	private JTextField tf_LogradouroCliente;
	private JTextField tf_NumeroCliente;
	private JTextField tf_ComplementoCliente;
	private JTextField tf_CidadeCliente;
	private Cliente cliente = new Cliente();
	private Endereco endereco = new Endereco();

	/**
	 * Create the panel.
	 */
	public PanelTeste() {

		
		setBackground(new Color(255, 255, 255));
		setLayout(null);
		
		JLabel lbl_Titulo = new JLabel("Gerenciamento de Cliente");
		lbl_Titulo.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		lbl_Titulo.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Titulo.setBounds(6, 35, 904, 16);
		add(lbl_Titulo);
		
		JLabel lbl_CPFCliente = new JLabel("CPF");
		lbl_CPFCliente.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_CPFCliente.setBounds(6, 103, 62, 16);
		add(lbl_CPFCliente);
		
		JFormattedTextField ftf_CPFCliente = new JFormattedTextField(GerenciamentoPedido.Mascara("###.###.###-##"));
		ftf_CPFCliente.setBounds(71, 98, 238, 26);
		add(ftf_CPFCliente);
		
		JLabel lbl_NomeCliente = new JLabel("Nome");
		lbl_NomeCliente.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_NomeCliente.setBounds(327, 103, 69, 16);
		add(lbl_NomeCliente);
		
		tf_NomeCliente = new JTextField();
		tf_NomeCliente.setBounds(396, 98, 491, 26);
		add(tf_NomeCliente);
		tf_NomeCliente.setColumns(10);
		
		JLabel lbl_DataNascimentoCliente = new JLabel("Data de Nascimento");
		lbl_DataNascimentoCliente.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_DataNascimentoCliente.setBounds(12, 149, 158, 16);
		add(lbl_DataNascimentoCliente);
		
		JDateChooser dt_DataNascimentoCliente = new JDateChooser();
		dt_DataNascimentoCliente.setBounds(171, 144, 213, 26);
		add(dt_DataNascimentoCliente);
		
		JLabel lbl_EmailCliente = new JLabel("E-mail");
		lbl_EmailCliente.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_EmailCliente.setBounds(382, 149, 62, 16);
		add(lbl_EmailCliente);
		
		tf_EmailCliente = new JTextField();
		tf_EmailCliente.setBounds(456, 144, 431, 26);
		add(tf_EmailCliente);
		tf_EmailCliente.setColumns(10);
		
		JLabel lbl_TelefoneCliente = new JLabel("Telefone");
		lbl_TelefoneCliente.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_TelefoneCliente.setBounds(6, 199, 87, 16);
		add(lbl_TelefoneCliente);
		
		JFormattedTextField ftf_TelefoneCliente = new JFormattedTextField(GerenciamentoPedido.Mascara("(##) #####.####"));
		ftf_TelefoneCliente.setBounds(96, 194, 213, 26);
		add(ftf_TelefoneCliente);
		
		JLabel lbl_EnderecoCliente = new JLabel("Endereço");
		lbl_EnderecoCliente.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_EnderecoCliente.setBounds(6, 260, 904, 16);
		add(lbl_EnderecoCliente);
		
		JLabel lbl_LogradouroCliente = new JLabel("Logradouro");
		lbl_LogradouroCliente.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_LogradouroCliente.setBounds(6, 304, 108, 16);
		add(lbl_LogradouroCliente);
		
		tf_LogradouroCliente = new JTextField();
		tf_LogradouroCliente.setBounds(114, 299, 543, 26);
		add(tf_LogradouroCliente);
		tf_LogradouroCliente.setColumns(10);
		
		JLabel lbl_NumeroCliente = new JLabel("Número");
		lbl_NumeroCliente.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_NumeroCliente.setBounds(660, 304, 85, 16);
		add(lbl_NumeroCliente);
		
		tf_NumeroCliente = new JTextField();
		tf_NumeroCliente.setBounds(757, 299, 130, 26);
		add(tf_NumeroCliente);
		tf_NumeroCliente.setColumns(10);
		
		JLabel lbl_ComplementoCliente = new JLabel("Complemento");
		lbl_ComplementoCliente.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_ComplementoCliente.setBounds(0, 349, 126, 16);
		add(lbl_ComplementoCliente);
		
		tf_ComplementoCliente = new JTextField();
		tf_ComplementoCliente.setBounds(134, 344, 340, 26);
		add(tf_ComplementoCliente);
		tf_ComplementoCliente.setColumns(10);
		
		JLabel lbl_BairroCliente = new JLabel("Bairro");
		lbl_BairroCliente.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_BairroCliente.setBounds(486, 349, 48, 16);
		add(lbl_BairroCliente);
		
		tf_BairroCliente = new JTextField();
		tf_BairroCliente.setBounds(538, 344, 349, 26);
		add(tf_BairroCliente);
		tf_BairroCliente.setColumns(10);
		
		JLabel lbl_CidadeCliente = new JLabel("Cidade");
		lbl_CidadeCliente.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_CidadeCliente.setBounds(6, 396, 74, 16);
		add(lbl_CidadeCliente);
		
		tf_CidadeCliente = new JTextField();
		tf_CidadeCliente.setBounds(84, 391, 265, 26);
		add(tf_CidadeCliente);
		tf_CidadeCliente.setColumns(10);
		
		JLabel lbl_EstadoCliente = new JLabel("Estado");
		lbl_EstadoCliente.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_EstadoCliente.setBounds(348, 396, 71, 16);
		add(lbl_EstadoCliente);
		
		JComboBox<String> cb_EstadoCliente = new JComboBox<>();
		String[] estados = {"Selecione", "Acre", "Alagoas", "Amapá", "Amazonas", "Bahia", "Ceará", "Distrito Federal", "Espírito Santo", "Goiás", "Maranhão", "Mato Grosso", "Mato Grosso do Sul", "Minas Gerais", "Pará", "Paraíba", "Paraná", "Pernambuco", "Piauí", "Rio de Janeiro", "Rio Grande do Norte", "Rio Grande do Sul", "Rondônia", "Roraima", "Santa Catarina", "São Paulo", "Sergipe", "Tocantins"};
		DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>(estados);
		cb_EstadoCliente.setModel(model);
		cb_EstadoCliente.setBounds(419, 392, 238, 27);
		add(cb_EstadoCliente);
		JLabel lbl_CEPCliente = new JLabel("CEP");
		lbl_CEPCliente.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_CEPCliente.setBounds(660, 396, 61, 16);
		add(lbl_CEPCliente);
		
		JFormattedTextField ftf_CEPCliente = new JFormattedTextField(GerenciamentoPedido.Mascara("##.###-###"));
		ftf_CEPCliente.setBounds(721, 391, 166, 26);
		add(ftf_CEPCliente);

        JButton btn_CadastrarCliente = new JButton("Cadastrar");
		btn_CadastrarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cliente.setCpf(ftf_CPFCliente.getText());
				cliente.setNome(tf_NomeCliente.getText());
				SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
				cliente.setDatanascimento(sdf1.format(dt_DataNascimentoCliente.getDate()),false);
				cliente.setEmail(tf_EmailCliente.getText());
				cliente.setTelefone(ftf_TelefoneCliente.getText());
				endereco.setLogradouro(tf_LogradouroCliente.getText());
				endereco.setNumero(tf_NumeroCliente.getText());
				endereco.setComplemento(tf_ComplementoCliente.getText());
				endereco.setBairro(tf_BairroCliente.getText());
				endereco.setCidade(tf_CidadeCliente.getText());
				endereco.setEstado((String) cb_EstadoCliente.getSelectedItem());
				endereco.setCep(ftf_CEPCliente.getText());

				//clientedao.cadastrarCliente(cliente, endereco);

				ftf_CPFCliente.setText("");
				tf_NomeCliente.setText("");
				dt_DataNascimentoCliente.setCalendar(null);
				tf_EmailCliente.setText("");
				ftf_TelefoneCliente.setText("");
				tf_LogradouroCliente.setText("");
				tf_NumeroCliente.setText("");
				tf_ComplementoCliente.setText("");
				tf_BairroCliente.setText("");
				tf_CidadeCliente.setText("");
				cb_EstadoCliente.setSelectedItem("Selecione");
				ftf_CEPCliente.setText("");
			}
		});
		btn_CadastrarCliente.setBounds(151, 518, 117, 29);
		add(btn_CadastrarCliente);
		
		JButton btn_BuscarCliente = new JButton("Buscar");
		btn_BuscarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cliente.setCpf(ftf_CPFCliente.getText());
				if (cliente.getCpf().equals(null)) {
					JOptionPane.showMessageDialog(null,"Informe o CPF do cliente!");
				} else {
					//clientedao.buscarCliente(cliente, endereco);
					tf_NomeCliente.setText(cliente.getNome());
					//dt_DataNascimentoCliente.setDate(cliente.getDatanascimento());
					tf_EmailCliente.setText(cliente.getEmail());
					ftf_TelefoneCliente.setText(cliente.getTelefone());
					tf_LogradouroCliente.setText(endereco.getLogradouro());
					tf_NumeroCliente.setText(endereco.getNumero());
					tf_ComplementoCliente.setText(endereco.getComplemento());
					tf_BairroCliente.setText(endereco.getBairro());
					tf_CidadeCliente.setText(endereco.getCidade());
					cb_EstadoCliente.setSelectedItem(endereco.getEstado());
					ftf_CEPCliente.setText(endereco.getCep());
				}
			}
		});
		btn_BuscarCliente.setBounds(296, 518, 117, 29);
		add(btn_BuscarCliente);
		
		JButton btn_AtualizarCliente = new JButton("Atualizar");
		btn_AtualizarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_AtualizarCliente.setBounds(449, 518, 117, 29);
		add(btn_AtualizarCliente);
		
		JButton btn_ExcluirCliente = new JButton("Excluir");
		btn_ExcluirCliente.addActionListener(new ActionListener() {		
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_ExcluirCliente.setBounds(604, 518, 117, 29);
		add(btn_ExcluirCliente);

    }

	}


