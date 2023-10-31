package TELAS.PAINEIS;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JViewport;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.toedter.calendar.JDateChooser;

import DATABASE.Conexao;
import ENTIDADES.Cliente;
import ENTIDADES.Endereco;
import TELAS.GerenciamentoPedido;

public class ConsultaCliente extends JPanel {

	private static final long serialVersionUID = 1L;	
	private JTextField tf_CidadeClienteConsulta;
	private JTable table;
	private JLayeredPane layeredPane;
	private JScrollPane scrollPaneCliente;
	private JViewport viewport;
	private Document document = new Document(PageSize.A4);     //gerar pdf
	/**
	 * Create the panel.
	 */
	public void praFrente(){
		layeredPane.add(this);
		layeredPane.moveToFront(this);
	}
    public ConsultaCliente(JLayeredPane layeredPane) {
		this.layeredPane = layeredPane;
        setBounds(0, 0, 910, 686);
		
		setBackground(new Color(255, 255, 255));
		setLayout(null);
		
		JLabel lbl_CidadeClienteConsulta = new JLabel("Cidade");
		lbl_CidadeClienteConsulta.setBounds(79, 39, 48, 16);
		add(lbl_CidadeClienteConsulta);
		
		tf_CidadeClienteConsulta = new JTextField();
		tf_CidadeClienteConsulta.setBounds(139, 34, 164, 26);
		add(tf_CidadeClienteConsulta);
		tf_CidadeClienteConsulta.setColumns(10);
		
		JLabel lbl_EstadoClienteConsulta = new JLabel("Estado");
		lbl_EstadoClienteConsulta.setBounds(336, 39, 48, 16);
		add(lbl_EstadoClienteConsulta);
		
		JComboBox<String> cb_EstadoClienteConsulta = new JComboBox<>();
		String[] estados = new String[] {"Selecione", "Acre", "Alagoas", "Amapá", "Amazonas", "Bahia", "Ceará", "Distrito Federal", "Espírito Santo", "Goiás", "Maranhão", "Mato Grosso", "Mato Grosso do Sul", "Minas Gerais", "Pará", "Paraíba", "Paraná", "Pernambuco", "Piauí", "Rio de Janeiro", "Rio Grande do Norte", "Rio Grande do Sul", "Rondônia", "Roraima", "Santa Catarina", "São Paulo", "Sergipe", "Tocantins"};
		cb_EstadoClienteConsulta.setModel(new DefaultComboBoxModel<String>(estados));
		cb_EstadoClienteConsulta.setBounds(396, 35, 238, 27);
		add(cb_EstadoClienteConsulta);
		
		
		JButton bt_BuscarClienteConsulta = new JButton("Buscar");
		bt_BuscarClienteConsulta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				

				table = new JTable();
				table.setBackground(new Color(255,255,255));								// define a cor de fundo do JTable
				table.setBounds(0, 88, 910, 590);
				
				scrollPaneCliente = new JScrollPane(table);
				scrollPaneCliente.setLocation(0, 88);
				scrollPaneCliente.setSize(910, 590);
				scrollPaneCliente.setPreferredSize(new Dimension(910, 590));							// define a largura e altura do ScrollPane
				viewport = scrollPaneCliente.getViewport();												// define a cor de fundo do ScrollPane
				viewport.setBackground(new Color(255,255,255));												// define a cor de fundo do ScrollPane
				add(scrollPaneCliente);

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
						query = "SELECT cliente.*, endereco.* FROM cliente INNER JOIN endereco ON cliente.cpf = endereco.cliente_cpf";
					} else if (!cidade.equals("") && estado.equals("Selecione")) {
						query = "SELECT cliente.*, endereco.* FROM cliente INNER JOIN endereco ON cliente.cpf = endereco.cliente_cpf WHERE endereco.cidade = '" + cidade + "'";
					} else if (!cidade.equals("") && !estado.equals("Selecione")) {
						query = "SELECT cliente.*, endereco.* FROM cliente INNER JOIN endereco ON cliente.cpf = endereco.cliente_cpf WHERE endereco.cidade = '" + cidade + "' AND endereco.estado = '" + estado + "'";
					}

					ResultSet rs = stmt.executeQuery(query);

				    while (rs.next()) {
				    	String cpf = rs.getString("cliente.cpf");
				        String nome = rs.getString("cliente.nome");
				        String datanascimento = rs.getString("cliente.datanascimento");
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
		add(bt_BuscarClienteConsulta);
	}
	public void defineTabela(){
		DefaultTableModel model = (DefaultTableModel) table.getModel();					//
		model.addColumn("CPF");																// adiciona a coluna 0
		model.addColumn("Nome");																// adiciona a coluna 1
		model.addColumn("Nascimento");														// adiciona a coluna 2
		model.addColumn("E-mail");															// adiciona a coluna 3
		model.addColumn("Telefone");															// adiciona a coluna 4
		model.addColumn("Cidade");															// adiciona a coluna 5
		model.addColumn("Estado");															// adiciona a coluna 6
		table.getColumnModel().getColumn(0).setPreferredWidth(100);			// define a largura da coluna 0
		table.getColumnModel().getColumn(1).setPreferredWidth(150);			// define a largura da coluna 1
		table.getColumnModel().getColumn(2).setPreferredWidth(80);			// define a largura da coluna 2
		table.getColumnModel().getColumn(3).setPreferredWidth(150);			// define a largura da coluna 3
		table.getColumnModel().getColumn(4).setPreferredWidth(80);			// define a largura da coluna 4
		table.getColumnModel().getColumn(5).setPreferredWidth(100);			// define a largura da coluna 5
		table.getColumnModel().getColumn(6).setPreferredWidth(30);			// define a largura da coluna 6				
	}
	public void preencheouEsvazia(boolean preenche) {
		DefaultTableModel model = (DefaultTableModel) table.getModel();


		for(int i = 0;i<model.getRowCount();i++){
			model.removeRow(0);
		}			
		model.setRowCount(0);
					
		if (preenche) {
			// Populate the table with the items
			/*
			 * 
				for (int i = 0;i<itens.size();i++) {
					model.addRow(new Object[]{produtos.get(i).getCod(),produtos.get(i).getDescricao(),itens.get(i).getQuantidade(),itens.get(i).getSubtotal()});
				}
			 */
		}
	}

}


