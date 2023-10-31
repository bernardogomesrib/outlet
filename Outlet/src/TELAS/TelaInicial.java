package main;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JViewport;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;

import com.toedter.calendar.JDateChooser;

import DAO.ClienteDAO;
import DATABASE.Conexao;
import ENTIDADES.Cliente;
import ENTIDADES.Endereco;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JLayeredPane;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class TelaInicial extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel PainelInicial;
    private JLayeredPane layeredPane;
    private JPanel PainelGerenciamentoCliente;
	private JPanel PainelConsultaCliente;
    private JTextField tf_NomeCliente;
    private JTextField tf_EmailCliente;
    private JTextField tf_LogradouroCliente;
    private JTextField tf_NumeroCliente;
    private JTextField tf_ComplementoCliente;
    private JTextField tf_BairroCliente;
    private JTextField tf_CidadeCliente;
	private JTextField tf_CidadeClienteConsulta;
	private Cliente cliente = new Cliente();
	private Endereco endereco = new Endereco();
	private ClienteDAO clientedao = new ClienteDAO();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaInicial frame = new TelaInicial();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaInicial() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1080, 720);
		PainelInicial = new JPanel();
		PainelInicial.setBackground(new Color(255, 255, 255));
		PainelInicial.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(PainelInicial);
		PainelInicial.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(170, 170, 170));
		menuBar.setBounds(0, 0, 152, 686);
		PainelInicial.add(menuBar);
		// Defina o layout do JMenuBar como BoxLayout na orientação Y (vertical)
        menuBar.setLayout(new BoxLayout(menuBar, BoxLayout.Y_AXIS));
        
		JMenu mn_Cliente = new JMenu("Cliente");
		menuBar.add(mn_Cliente);
		
		JMenuItem mntm_ClienteGerenciamento = new JMenuItem("Gerenciamento");
		mntm_ClienteGerenciamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                limparpainel();
                GerenciamentoCliente();
			}
		});
		mn_Cliente.add(mntm_ClienteGerenciamento);
		
		JMenuItem mntm_ClienteConsulta = new JMenuItem("Consulta");
		mntm_ClienteConsulta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limparpainel();
				ConsultaCliente();
			}
		});
		mn_Cliente.add(mntm_ClienteConsulta);
		
		JMenu mn_Produto = new JMenu("Produto");
		menuBar.add(mn_Produto);
		
		JMenuItem mntm_ProdutoGerenciamento = new JMenuItem("Gerenciamento");
		mntm_ProdutoGerenciamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		mn_Produto.add(mntm_ProdutoGerenciamento);
		
		JMenuItem mntm_ProdutoConsulta = new JMenuItem("Consulta");
		mntm_ProdutoConsulta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		mn_Produto.add(mntm_ProdutoConsulta);
		
		JMenu mn_Estoque = new JMenu("Estoque");
		menuBar.add(mn_Estoque);
		
		JMenu mn_Pedido = new JMenu("Pedido");
		menuBar.add(mn_Pedido);
		
		JMenuItem mntm_PedidoGerenciamento = new JMenuItem("Gerenciamento");
		mntm_PedidoGerenciamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		mn_Pedido.add(mntm_PedidoGerenciamento);
		
		JMenuItem mntm_PedidoConsulta = new JMenuItem("Consulta");
		mntm_PedidoConsulta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		mn_Pedido.add(mntm_PedidoConsulta);
		
		JMenu mn_Venda = new JMenu("Venda");
		menuBar.add(mn_Venda);
		
		JMenuItem mntm_VendaGerenciamento = new JMenuItem("Gerenciamento");
		mntm_VendaGerenciamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		mn_Venda.add(mntm_VendaGerenciamento);
		
		JMenuItem mntm_VendaConsulta = new JMenuItem("Consulta");
		mntm_VendaConsulta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		mn_Venda.add(mntm_VendaConsulta);
		
		JMenu mn_Financeiro = new JMenu("Financeiro");
		menuBar.add(mn_Financeiro);
		
		JMenuItem mntm_ContasPagar = new JMenuItem("Contas a Pagar");
		mntm_ContasPagar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		mn_Financeiro.add(mntm_ContasPagar);
		
		JMenuItem mntm_ContasReceber = new JMenuItem("Contas a Receber");
		mntm_ContasReceber.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		mn_Financeiro.add(mntm_ContasReceber);
		
		JMenu mn_EntradaMercadorias = new JMenu("Entrada de \nMercadoria");
		mn_EntradaMercadorias.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		menuBar.add(mn_EntradaMercadorias);
		
		JMenu mn_Relatorios = new JMenu("Relatórios");
		menuBar.add(mn_Relatorios);
		
		JMenu mn_Nada1 = new JMenu(" ");
		menuBar.add(mn_Nada1);
		JMenu mn_Nada2 = new JMenu(" ");
		menuBar.add(mn_Nada2);
		JMenu mn_Nada3 = new JMenu(" ");
		menuBar.add(mn_Nada3);
		JMenu mn_Nada4 = new JMenu(" ");
		menuBar.add(mn_Nada4);
		JMenu mn_Nada5 = new JMenu(" ");
		menuBar.add(mn_Nada5);
		JMenu mn_Nada6 = new JMenu(" ");
		menuBar.add(mn_Nada6);
		JMenu mn_Nada7 = new JMenu(" ");
		menuBar.add(mn_Nada7);
		JMenu mn_Nada8 = new JMenu(" ");
		menuBar.add(mn_Nada8);
		JMenu mn_Nada9 = new JMenu(" ");
		menuBar.add(mn_Nada9);
		JMenu mn_Nada10 = new JMenu(" ");
		menuBar.add(mn_Nada10);
		
		JMenu mn_Sair = new JMenu("Sair");
		mn_Sair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		menuBar.add(mn_Sair);
		
		layeredPane = new JLayeredPane();
		layeredPane.setBackground(new Color(32, 215, 0));
		layeredPane.setBounds(164, 0, 910, 686);
		PainelInicial.add(layeredPane);
	}

    /**
     * 
     */
    public void GerenciamentoCliente() {

        PainelGerenciamentoCliente = new JPanel();
        layeredPane.setLayer(PainelGerenciamentoCliente, 0);
        PainelGerenciamentoCliente.setBounds(0, 0, 910, 686);
        layeredPane.add(PainelGerenciamentoCliente);
		PainelGerenciamentoCliente.setBackground(new Color(255, 255, 255));
		PainelGerenciamentoCliente.setLayout(null);
		
		JLabel lbl_Titulo = new JLabel("Gerenciamento de Cliente");
		lbl_Titulo.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		lbl_Titulo.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Titulo.setBounds(6, 35, 904, 16);
		PainelGerenciamentoCliente.add(lbl_Titulo);
		
		JLabel lbl_CPFCliente = new JLabel("CPF");
		lbl_CPFCliente.setBounds(32, 103, 36, 16);
		PainelGerenciamentoCliente.add(lbl_CPFCliente);
		
		JFormattedTextField ftf_CPFCliente = new JFormattedTextField(Funcoes.Mascara("###.###.###-##"));
		ftf_CPFCliente.setBounds(71, 98, 238, 26);
		PainelGerenciamentoCliente.add(ftf_CPFCliente);
		
		JLabel lbl_NomeCliente = new JLabel("Nome");
		lbl_NomeCliente.setBounds(348, 103, 48, 16);
		PainelGerenciamentoCliente.add(lbl_NomeCliente);
		
		tf_NomeCliente = new JTextField();
		tf_NomeCliente.setBounds(396, 98, 491, 26);
		PainelGerenciamentoCliente.add(tf_NomeCliente);
		tf_NomeCliente.setColumns(10);
		
		JLabel lbl_DataNascimentoCliente = new JLabel("Data de Nascimento");
		lbl_DataNascimentoCliente.setBounds(32, 149, 138, 16);
		PainelGerenciamentoCliente.add(lbl_DataNascimentoCliente);
		
		JDateChooser dt_DataNascimentoCliente = new JDateChooser();
		dt_DataNascimentoCliente.setBounds(171, 144, 213, 26);
		PainelGerenciamentoCliente.add(dt_DataNascimentoCliente);
		
		JLabel lbl_EmailCliente = new JLabel("E-mail");
		lbl_EmailCliente.setBounds(396, 149, 48, 16);
		PainelGerenciamentoCliente.add(lbl_EmailCliente);
		
		tf_EmailCliente = new JTextField();
		tf_EmailCliente.setBounds(456, 144, 431, 26);
		PainelGerenciamentoCliente.add(tf_EmailCliente);
		tf_EmailCliente.setColumns(10);
		
		JLabel lbl_TelefoneCliente = new JLabel("Telefone");
		lbl_TelefoneCliente.setBounds(32, 199, 61, 16);
		PainelGerenciamentoCliente.add(lbl_TelefoneCliente);
		
		JFormattedTextField ftf_TelefoneCliente = new JFormattedTextField(Funcoes.Mascara("(##) #####.####"));
		ftf_TelefoneCliente.setBounds(96, 194, 213, 26);
		PainelGerenciamentoCliente.add(ftf_TelefoneCliente);
		
		JLabel lbl_EnderecoCliente = new JLabel("Endereço");
		lbl_EnderecoCliente.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_EnderecoCliente.setBounds(6, 260, 904, 16);
		PainelGerenciamentoCliente.add(lbl_EnderecoCliente);
		
		JLabel lbl_LogradouroCliente = new JLabel("Logradouro");
		lbl_LogradouroCliente.setBounds(32, 304, 82, 16);
		PainelGerenciamentoCliente.add(lbl_LogradouroCliente);
		
		tf_LogradouroCliente = new JTextField();
		tf_LogradouroCliente.setBounds(114, 299, 543, 26);
		PainelGerenciamentoCliente.add(tf_LogradouroCliente);
		tf_LogradouroCliente.setColumns(10);
		
		JLabel lbl_NumeroCliente = new JLabel("Número");
		lbl_NumeroCliente.setBounds(684, 304, 61, 16);
		PainelGerenciamentoCliente.add(lbl_NumeroCliente);
		
		tf_NumeroCliente = new JTextField();
		tf_NumeroCliente.setBounds(757, 299, 130, 26);
		PainelGerenciamentoCliente.add(tf_NumeroCliente);
		tf_NumeroCliente.setColumns(10);
		
		JLabel lbl_ComplementoCliente = new JLabel("Complemento");
		lbl_ComplementoCliente.setBounds(32, 349, 94, 16);
		PainelGerenciamentoCliente.add(lbl_ComplementoCliente);
		
		tf_ComplementoCliente = new JTextField();
		tf_ComplementoCliente.setBounds(134, 344, 340, 26);
		PainelGerenciamentoCliente.add(tf_ComplementoCliente);
		tf_ComplementoCliente.setColumns(10);
		
		JLabel lbl_BairroCliente = new JLabel("Bairro");
		lbl_BairroCliente.setBounds(486, 349, 48, 16);
		PainelGerenciamentoCliente.add(lbl_BairroCliente);
		
		tf_BairroCliente = new JTextField();
		tf_BairroCliente.setBounds(538, 344, 349, 26);
		PainelGerenciamentoCliente.add(tf_BairroCliente);
		tf_BairroCliente.setColumns(10);
		
		JLabel lbl_CidadeCliente = new JLabel("Cidade");
		lbl_CidadeCliente.setBounds(32, 396, 48, 16);
		PainelGerenciamentoCliente.add(lbl_CidadeCliente);
		
		tf_CidadeCliente = new JTextField();
		tf_CidadeCliente.setBounds(84, 391, 265, 26);
		PainelGerenciamentoCliente.add(tf_CidadeCliente);
		tf_CidadeCliente.setColumns(10);
		
		JLabel lbl_EstadoCliente = new JLabel("Estado");
		lbl_EstadoCliente.setBounds(371, 396, 48, 16);
		PainelGerenciamentoCliente.add(lbl_EstadoCliente);
		
		JComboBox cb_EstadoCliente = new JComboBox();
		cb_EstadoCliente.setModel(new DefaultComboBoxModel(new String[] {"Selecione", "Acre", "Alagoas", "Amapá", "Amazonas", "Bahia", "Ceará", "Distrito Federal", "Espírito Santo", "Goiás", "Maranhão", "Mato Grosso", "Mato Grosso do Sul", "Minas Gerais", "Pará", "Paraíba", "Paraná", "Pernambuco", "Piauí", "Rio de Janeiro", "Rio Grande do Norte", "Rio Grande do Sul", "Rondônia", "Roraima", "Santa Catarina", "São Paulo", "Sergipe", "Tocantins"}));
		cb_EstadoCliente.setBounds(419, 392, 238, 27);
		PainelGerenciamentoCliente.add(cb_EstadoCliente);
		
		JLabel lbl_CEPCliente = new JLabel("CEP");
		lbl_CEPCliente.setBounds(685, 396, 36, 16);
		PainelGerenciamentoCliente.add(lbl_CEPCliente);
		
		JFormattedTextField ftf_CEPCliente = new JFormattedTextField(GerenciamentoPedido.Mascara("##.###-###"));
		ftf_CEPCliente.setBounds(721, 391, 166, 26);
		PainelGerenciamentoCliente.add(ftf_CEPCliente);

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

				clientedao.cadastrarCliente(cliente, endereco);

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
		PainelGerenciamentoCliente.add(btn_CadastrarCliente);
		
		JButton btn_BuscarCliente = new JButton("Buscar");
		btn_BuscarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cliente.setCpf(ftf_CPFCliente.getText());
				if (cliente.getCpf().equals(null)) {
					JOptionPane.showMessageDialog(null,"Informe o CPF do cliente!");
				} else {
					clientedao.buscarCliente(cliente, endereco);
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
		PainelGerenciamentoCliente.add(btn_BuscarCliente);
		
		JButton btn_AtualizarCliente = new JButton("Atualizar");
		btn_AtualizarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_AtualizarCliente.setBounds(449, 518, 117, 29);
		PainelGerenciamentoCliente.add(btn_AtualizarCliente);
		
		JButton btn_ExcluirCliente = new JButton("Excluir");
		btn_ExcluirCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_ExcluirCliente.setBounds(604, 518, 117, 29);
		PainelGerenciamentoCliente.add(btn_ExcluirCliente);

    }

    public void ConsultaCliente() {
		PainelConsultaCliente = new JPanel();
		layeredPane.setLayer(PainelConsultaCliente, 0);
		PainelConsultaCliente.setBounds(0, 0, 910, 686);
		layeredPane.add(PainelConsultaCliente);
		PainelConsultaCliente.setBackground(new Color(255, 255, 255));
		PainelConsultaCliente.setLayout(null);
		
		JLabel lbl_CidadeClienteConsulta = new JLabel("Cidade");
		lbl_CidadeClienteConsulta.setBounds(79, 39, 48, 16);
		PainelConsultaCliente.add(lbl_CidadeClienteConsulta);
		
		tf_CidadeClienteConsulta = new JTextField();
		tf_CidadeClienteConsulta.setBounds(139, 34, 164, 26);
		PainelConsultaCliente.add(tf_CidadeClienteConsulta);
		tf_CidadeClienteConsulta.setColumns(10);
		
		JLabel lbl_EstadoClienteConsulta = new JLabel("Estado");
		lbl_EstadoClienteConsulta.setBounds(336, 39, 48, 16);
		PainelConsultaCliente.add(lbl_EstadoClienteConsulta);
		
		JComboBox cb_EstadoClienteConsulta = new JComboBox();
		cb_EstadoClienteConsulta.setModel(new DefaultComboBoxModel(new String[] {"Selecione", "Acre", "Alagoas", "Amapá", "Amazonas", "Bahia", "Ceará", "Distrito Federal", "Espírito Santo", "Goiás", "Maranhão", "Mato Grosso", "Mato Grosso do Sul", "Minas Gerais", "Pará", "Paraíba", "Paraná", "Pernambuco", "Piauí", "Rio de Janeiro", "Rio Grande do Norte", "Rio Grande do Sul", "Rondônia", "Roraima", "Santa Catarina", "São Paulo", "Sergipe", "Tocantins"}));
		cb_EstadoClienteConsulta.setBounds(396, 35, 238, 27);
		PainelConsultaCliente.add(cb_EstadoClienteConsulta);
		
		
		JButton bt_BuscarClienteConsulta = new JButton("Buscar");
		bt_BuscarClienteConsulta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Document document = new Document(PageSize.A4);     //gerar pdf

				JTable table_ConsultaCliente = new JTable();
				table_ConsultaCliente.setBackground(new Color(255,255,255));								// define a cor de fundo do JTable
				table_ConsultaCliente.setBounds(0, 88, 910, 590);
				DefaultTableModel model = (DefaultTableModel) table_ConsultaCliente.getModel();					//
				model.addColumn("CPF");																// adiciona a coluna 0
				model.addColumn("Nome");																// adiciona a coluna 1
				model.addColumn("Nascimento");														// adiciona a coluna 2
				model.addColumn("E-mail");															// adiciona a coluna 3
				model.addColumn("Telefone");															// adiciona a coluna 4
				model.addColumn("Cidade");															// adiciona a coluna 5
				model.addColumn("Estado");															// adiciona a coluna 6
				table_ConsultaCliente.getColumnModel().getColumn(0).setPreferredWidth(100);			// define a largura da coluna 0
				table_ConsultaCliente.getColumnModel().getColumn(1).setPreferredWidth(150);			// define a largura da coluna 1
				table_ConsultaCliente.getColumnModel().getColumn(2).setPreferredWidth(80);			// define a largura da coluna 2
				table_ConsultaCliente.getColumnModel().getColumn(3).setPreferredWidth(150);			// define a largura da coluna 3
				table_ConsultaCliente.getColumnModel().getColumn(4).setPreferredWidth(80);			// define a largura da coluna 4
				table_ConsultaCliente.getColumnModel().getColumn(5).setPreferredWidth(100);			// define a largura da coluna 5
				table_ConsultaCliente.getColumnModel().getColumn(6).setPreferredWidth(30);			// define a largura da coluna 6
				
				JScrollPane scrollPaneCliente = new JScrollPane(table_ConsultaCliente);
				scrollPaneCliente.setLocation(0, 88);
				scrollPaneCliente.setSize(910, 590);
				scrollPaneCliente.setPreferredSize(new Dimension(910, 590));							// define a largura e altura do ScrollPane
				JViewport viewport = scrollPaneCliente.getViewport();												// define a cor de fundo do ScrollPane
				viewport.setBackground(new Color(255,255,255));												// define a cor de fundo do ScrollPane
				PainelConsultaCliente.add(scrollPaneCliente);

				try {

					PdfWriter.getInstance(document, new FileOutputStream("output.pdf"));
            		document.open();
            		Paragraph TituloPDF = new Paragraph();
					TituloPDF.setAlignment(Element.ALIGN_CENTER);
					TituloPDF.add("Outlet SA\nRelatório de Clientes\n\n");
					document.add(TituloPDF);	// cabeçalho do pdf		
					
					String cidade = tf_CidadeClienteConsulta.getText();
					String estado = (String) cb_EstadoClienteConsulta.getSelectedItem();
					String query = "";
					

					Conexao novaConexao = new Conexao();
				    Connection conectar = novaConexao.getConexao();
				    Connection conn = conectar;
				    
				    // Procedimentos para obter os dados de uma tabela
		            java.sql.Statement stmt = conn.createStatement();

					if (cidade.equals("") && estado.equals("Selecione")) {
						query = "SELECT cliente.cpf, cliente.nome, cliente.datanascimento, cliente.telefone, cliente.email, endereco.cidade, endereco.estado FROM cliente INNER JOIN endereco ON cliente.cpf = endereco.cliente_cpf";
					} else if (!cidade.equals("") && estado.equals("Selecione")) {
						query = "SELECT cliente.cpf, cliente.nome, cliente.datanascimento, cliente.telefone, cliente.email, endereco.cidade, endereco.estado FROM cliente INNER JOIN endereco ON cliente.cpf = endereco.cliente_cpf WHERE endereco.cidade = '" + cidade + "'";
					} else if (!cidade.equals("") && !estado.equals("Selecione")) {
						query = "SELECT cliente.cpf, cliente.nome, cliente.datanascimento, cliente.telefone, cliente.email, endereco.cidade, endereco.estado FROM cliente INNER JOIN endereco ON cliente.cpf = endereco.cliente_cpf WHERE endereco.cidade = '" + cidade + "' AND endereco.estado = '" + estado + "'";
					}

					ResultSet rs = stmt.executeQuery(query);

				    while (rs.next()) {
				    	String cpf = rs.getString("cliente.cpf");
				        String nome = rs.getString("cliente.nome");
				        Date datanascimento = rs.getDate("cliente.datanascimento");
				        String email = rs.getString("cliente.email");
				        String telefone = rs.getString("cliente.telefone");
				        String cidadeconsulta = rs.getString("endereco.cidade");
				        String estadoconsulta = rs.getString("endereco.estado");
				        
				        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				        String strdatanascimento = sdf.format(datanascimento);
				        model.addRow(new Object[]{cpf, nome, strdatanascimento, email, telefone, cidadeconsulta, estadoconsulta});

						document.add(new Paragraph("CPF: " + cpf + "\n" +
                        "Nome: " + nome + "\n" +
                        "Data de Nascimento: " + strdatanascimento + "\n" +
                        "Email: " + email + "\n" +
                        "Telefone: " + telefone + "\n" +
                        "Cidade: " + cidadeconsulta + "\n" +
                        "Estado: " + estadoconsulta + "\n\n"));
						
				    }

					document.close();								// gerar pdf
					

				} catch (Error | SQLException | DocumentException | FileNotFoundException erro_consulta_cliente) {
						System.out.println(erro_consulta_cliente);
				}
			}
		});
		bt_BuscarClienteConsulta.setBounds(667, 34, 117, 29);
		PainelConsultaCliente.add(bt_BuscarClienteConsulta);
	}
	
	public void limparpainel() {
		
        layeredPane.removeAll();
        layeredPane.repaint();
        layeredPane.revalidate();
    }
}