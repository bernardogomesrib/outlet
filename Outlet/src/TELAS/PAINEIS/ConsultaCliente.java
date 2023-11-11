package TELAS.PAINEIS;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JViewport;
import javax.swing.table.DefaultTableModel;

import com.itextpdf.html2pdf.*;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;

import DAO.ClienteComEnderecoDAO;

import com.itextpdf.commons.exceptions.*;

import ENTIDADES.ClienteComEndereco;
import javax.swing.SwingConstants;



public class ConsultaCliente extends JPanel {

	private static final long serialVersionUID = 1L;	
	private JTextField tf_CidadeClienteConsulta;
	private JTable table;
	private JLayeredPane layeredPane;
	private JScrollPane scrollPaneCliente;
	private JViewport viewport;
	
	private ArrayList<ClienteComEndereco> clienteComEnderecos = new ArrayList<ClienteComEndereco>();
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
		lbl_CidadeClienteConsulta.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_CidadeClienteConsulta.setBounds(40, 39, 87, 16);
		add(lbl_CidadeClienteConsulta);
		
		tf_CidadeClienteConsulta = new JTextField();
		tf_CidadeClienteConsulta.setBounds(139, 34, 164, 26);
		add(tf_CidadeClienteConsulta);
		tf_CidadeClienteConsulta.setColumns(10);
		
		JLabel lbl_EstadoClienteConsulta = new JLabel("Estado");
		lbl_EstadoClienteConsulta.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_EstadoClienteConsulta.setBounds(305, 39, 79, 16);
		add(lbl_EstadoClienteConsulta);
		
		JComboBox<String> cb_EstadoClienteConsulta = new JComboBox<String>();
		String[] estados = new String[] {"Selecione", "Acre", "Alagoas", "Amapá", "Amazonas", "Bahia", "Ceará", "Distrito Federal", "Espírito Santo", "Goiás", "Maranhão", "Mato Grosso", "Mato Grosso do Sul", "Minas Gerais", "Pará", "Paraíba", "Paraná", "Pernambuco", "Piauí", "Rio de Janeiro", "Rio Grande do Norte", "Rio Grande do Sul", "Rondônia", "Roraima", "Santa Catarina", "São Paulo", "Sergipe", "Tocantins"};
		cb_EstadoClienteConsulta.setModel(new DefaultComboBoxModel<String>(estados));
		cb_EstadoClienteConsulta.setBounds(396, 35, 238, 27);
		add(cb_EstadoClienteConsulta);
		table = new JTable();
		table.setBackground(new Color(255,255,255));								// define a cor de fundo do JTable
		table.setBounds(0, 0, 910, 560);
		defineTabela();
		scrollPaneCliente = new JScrollPane(table);
		scrollPaneCliente.setLocation(0, 67);
		scrollPaneCliente.setSize(910, 560);
		scrollPaneCliente.setPreferredSize(new Dimension(910, 560));							// define a largura e altura do ScrollPane
		viewport = scrollPaneCliente.getViewport();												// define a cor de fundo do ScrollPane
		viewport.setBackground(new Color(255,255,255));												// define a cor de fundo do ScrollPane
		add(scrollPaneCliente);
		JButton bt_BuscarClienteConsulta = new JButton("Buscar");
		bt_BuscarClienteConsulta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cidade = tf_CidadeClienteConsulta.getText();
				String estado =(String) cb_EstadoClienteConsulta.getSelectedItem();
				clienteComEnderecos = ClienteComEnderecoDAO.buscar(cidade,estado);
				if(clienteComEnderecos.size()>=1){
					preencheouEsvazia(true);
				}else{
					preencheouEsvazia(true);
				}
				
			}
		});
		bt_BuscarClienteConsulta.setBounds(667, 34, 117, 29);
		add(bt_BuscarClienteConsulta);
		
		JButton btnSalvarRelatorio = new JButton("Salvar Relatorio");
		btnSalvarRelatorio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				geraDocumento();
			}
		});
		btnSalvarRelatorio.setBounds(720, 636, 164, 25);
		add(btnSalvarRelatorio);
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
		table.getColumnModel().getColumn(0).setPreferredWidth(80);			// define a largura da coluna 0
		table.getColumnModel().getColumn(1).setPreferredWidth(150);			// define a largura da coluna 1
		table.getColumnModel().getColumn(2).setPreferredWidth(50);			// define a largura da coluna 2
		table.getColumnModel().getColumn(3).setPreferredWidth(150);			// define a largura da coluna 3
		table.getColumnModel().getColumn(4).setPreferredWidth(70);			// define a largura da coluna 4
		table.getColumnModel().getColumn(5).setPreferredWidth(80);			// define a largura da coluna 5
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
			for(int i = 0; i<clienteComEnderecos.size();i++){
				model.addRow(new Object[]{clienteComEnderecos.get(i).getCliente().getCpf(), clienteComEnderecos.get(i).getCliente().getNome(), clienteComEnderecos.get(i).getCliente().getDatanascimento(false), clienteComEnderecos.get(i).getCliente().getEmail(), clienteComEnderecos.get(i).getCliente().getTelefone(), clienteComEnderecos.get(i).getEndereco().getCidade(), clienteComEnderecos.get(i).getEndereco().getEstado()});
			}
		}
	}
	public void geraDocumento(){
		String html = "<!DOCTYPE html><html lang='pt-br'><head><meta charset='UTF-8'><meta name='viewport' content='width=device-width, initial-scale=1.0'><title>Document</title></head><body><style>table{width: 99%;}th{background-color: gray;}.cn{background-color: aqua;}table, th, td {border: 1px solid black;border-collapse: collapse;}h1{text-align: center;}</style><h1>Relatório de Clientes</h1><table><thead><tr><th>CPF</th><th>Nome</th><th>Nascimento</th><th>E-mail</th><th>Telefone</th><th>Cidade</th><th>Estado</th></tr></thead><tbody>";

		try {
			boolean corsin= true;
			for (ClienteComEndereco oop : clienteComEnderecos) {
				if (corsin) {
					html+= "<tr>";
					html+=" <td>"+oop.getCliente().getCpf()+"</td><td>"+oop.getCliente().getNome()+"</td><td>"+oop.getCliente().getDatanascimento(false)+"</td><td>"+oop.getCliente().getEmail()+"</td><td>"+oop.getCliente().getTelefone()+"</td><td>"+oop.getEndereco().getCidade()+"</td><td>"+oop.getEndereco().getEstado()+"</td></tr>";
				
					corsin=!corsin;
				}else{
					html+= "<tr class = 'cn'>";
					html+=" <td>"+oop.getCliente().getCpf()+"</td><td>"+oop.getCliente().getNome()+"</td><td>"+oop.getCliente().getDatanascimento(false)+"</td><td>"+oop.getCliente().getEmail()+"</td><td>"+oop.getCliente().getTelefone()+"</td><td>"+oop.getEndereco().getCidade()+"</td><td>"+oop.getEndereco().getEstado()+"</td></tr>";
					corsin=!corsin;
				}
			}
			html+="</tbody></table></body></html>";
			// cria arquivo temporario
			File arquivo = File.createTempFile("arquivoTemp", ".html");
			// Cria um FileWriter para o arquivo
			FileWriter writer = new FileWriter(arquivo);

			// Escreve a String no arquivo
			writer.write(html);
			
			// Fecha o FileWriter
			writer.close();

			// Cria um novo documento PDF com tamanho de página paisagem
			PdfWriter pdfWriter = new PdfWriter("arquivo.pdf");
			PdfDocument pdfDoc = new PdfDocument(pdfWriter);
			pdfDoc.setDefaultPageSize(PageSize.A4.rotate());

			// Converte a string HTML para PDF
			ConverterProperties props = new ConverterProperties();
			HtmlConverter.convertToPdf(new FileInputStream(arquivo), pdfDoc, props);
			
		} catch (IOException|ITextException erro_consulta_cliente) {
				JOptionPane.showMessageDialog(null, erro_consulta_cliente.getMessage());
		}
	}
}


