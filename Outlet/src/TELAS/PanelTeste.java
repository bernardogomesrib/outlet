package TELAS;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.itextpdf.commons.exceptions.ITextException;
import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.html2pdf.HtmlConverter;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;

import DAO.RelatorioPedidoDAO;
import ENTIDADES.ConsultaPedido;
import ENTIDADES.Fornecedor;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;


public class PanelTeste extends JPanel {
	private JLayeredPane layeredPane;
	Fornecedor fornecedor = new Fornecedor();
	private JTextField tf_datamin;
	private JTextField tf_datamax;
	private JTextField tf_cpfs;
	private JTextField tf_quantMin;
	private JTextField tf_quantMax;
	private JTextField tf_cods;
	private JTextField tf_subtotalMax;
	private JTextField tf_subtotalmin;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTable table;
	private ArrayList<ConsultaPedido> pedidosConsultados = new ArrayList<ConsultaPedido>();
	private JTextField tf_proddismax;
	private JTextField tf_proddismin;
	private JRadioButton rdbtnPeloMenosUm;
	private JCheckBox chckbxVendaCompletada;
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
		table = new JTable();
		table.setBackground(new Color(255,255,255));
		table.setBounds(0, 0, 886, 510);
		defineTabela();
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(12, 119, 886, 510);
		add(scrollPane);
		
		JButton btnSalvarRelatrio = new JButton("Salvar Relatório");
		btnSalvarRelatrio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				geraDocumento();
			}
		});
		btnSalvarRelatrio.setBounds(711, 649, 187, 25);
		add(btnSalvarRelatrio);
		
		JLabel lblQuantidadeDeItens = new JLabel("Quantidade de itens| produtos distintos");
		lblQuantidadeDeItens.setBounds(187, 4, 287, 15);
		add(lblQuantidadeDeItens);
		
		JLabel lblContemNoPedido = new JLabel("Contem no pedido certo produto:");
		lblContemNoPedido.setBounds(665, 4, 236, 15);
		add(lblContemNoPedido);
		
		JLabel lblSubtotal = new JLabel("Subtotal:");
		lblSubtotal.setHorizontalAlignment(SwingConstants.CENTER);
		lblSubtotal.setBounds(486, 4, 167, 15);
		add(lblSubtotal);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int quantmin = 1;
				int quantmax = 0;
				double subtotalmin = 0;
				double subtotalmax = 0;
				int pquantmin = 1;
				int pquantmax = 0;
				try {
					if(!tf_quantMin.getText().equals("")){
					quantmin = Integer.parseInt(tf_quantMin.getText());
					}
					if(!tf_quantMax.getText().equals("")){
						quantmax = Integer.parseInt(tf_quantMax.getText());
					}
					if(!tf_subtotalmin.getText().equals("")){
						subtotalmin = Double.parseDouble(tf_subtotalmin.getText());
					}
					if(!tf_subtotalMax.getText().equals("")){
						subtotalmax = Double.parseDouble(tf_subtotalMax.getText());
					}
					if(!tf_proddismin.getText().equals("")){
						pquantmin = Integer.parseInt(tf_proddismin.getText());
					}
					if(!tf_proddismax.getText().equals("")){
						pquantmax = Integer.parseInt(tf_proddismax.getText());
					}					
					pedidosConsultados = RelatorioPedidoDAO.procura(pquantmin,pquantmax,tf_cpfs.getText(),tf_datamin.getText(),tf_datamax.getText(),chckbxVendaCompletada.isSelected(),quantmin,quantmax,subtotalmin,subtotalmax,tf_cods.getText(),rdbtnPeloMenosUm.isSelected());
					
					preencheouEsvazia(true);
					
				} catch (Exception rrr) {
					JOptionPane.showMessageDialog(null, "Preencha corretamente os campos!"+rrr.getMessage());
				}
				
				
			}
		});
		btnPesquisar.setBounds(582, 649, 117, 25);
		add(btnPesquisar);
		
		JPanel panel = new JPanel();
		panel.setBounds(12, 24, 171, 85);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblMin = new JLabel("Min:");
		lblMin.setBounds(12, 14, 51, 15);
		panel.add(lblMin);
		
		tf_datamin = new JTextField();
		tf_datamin.setBounds(64, 12, 94, 19);
		panel.add(tf_datamin);
		tf_datamin.setColumns(10);
		
		JLabel lblDataMaxima = new JLabel("Max:");
		lblDataMaxima.setBounds(12, 35, 51, 15);
		panel.add(lblDataMaxima);
		
		tf_datamax = new JTextField();
		tf_datamax.setBounds(64, 33, 94, 19);
		panel.add(tf_datamax);
		tf_datamax.setColumns(10);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setBounds(12, 62, 51, 15);
		panel.add(lblCpf);
		
		tf_cpfs = new JTextField();
		tf_cpfs.setBounds(64, 62, 94, 19);
		panel.add(tf_cpfs);
		tf_cpfs.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(187, 24, 277, 85);
		add(panel_1);
		panel_1.setLayout(null);
		
		chckbxVendaCompletada = new JCheckBox("Venda completada");
		chckbxVendaCompletada.setBounds(8, 54, 166, 23);
		panel_1.add(chckbxVendaCompletada);
		
		JLabel lblMin_1 = new JLabel("Min:");
		lblMin_1.setBounds(12, 14, 51, 15);
		panel_1.add(lblMin_1);
		
		tf_quantMin = new JTextField();
		tf_quantMin.setBounds(56, 12, 76, 19);
		panel_1.add(tf_quantMin);
		tf_quantMin.setColumns(10);
		
		JLabel lblDataMaxima_1 = new JLabel("Max:");
		lblDataMaxima_1.setBounds(12, 34, 51, 15);
		panel_1.add(lblDataMaxima_1);
		
		tf_quantMax = new JTextField();
		tf_quantMax.setBounds(56, 32, 76, 19);
		panel_1.add(tf_quantMax);
		tf_quantMax.setColumns(10);
		
		JLabel lblMin_1_2 = new JLabel("Min:");
		lblMin_1_2.setBounds(144, 16, 51, 15);
		panel_1.add(lblMin_1_2);
		
		tf_proddismin = new JTextField();
		tf_proddismin.setBounds(196, 14, 76, 19);
		panel_1.add(tf_proddismin);
		tf_proddismin.setColumns(10);
		
		tf_proddismax = new JTextField();
		tf_proddismax.setBounds(196, 34, 76, 19);
		panel_1.add(tf_proddismax);
		tf_proddismax.setColumns(10);
		
		JLabel lblDataMaxima_1_2 = new JLabel("Max:");
		lblDataMaxima_1_2.setBounds(144, 36, 51, 15);
		panel_1.add(lblDataMaxima_1_2);
		
		JLabel lblDataDoPedido = new JLabel("Data dos pedidos");
		lblDataDoPedido.setBounds(12, 4, 171, 15);
		add(lblDataDoPedido);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(470, 24, 196, 85);
		add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblMin_1_1 = new JLabel("Min:");
		lblMin_1_1.setBounds(12, 14, 51, 15);
		panel_2.add(lblMin_1_1);
		
		tf_subtotalmin = new JTextField();
		tf_subtotalmin.setBounds(64, 12, 114, 19);
		panel_2.add(tf_subtotalmin);
		tf_subtotalmin.setColumns(10);
		
		tf_subtotalMax = new JTextField();
		tf_subtotalMax.setBounds(64, 32, 114, 19);
		panel_2.add(tf_subtotalMax);
		tf_subtotalMax.setColumns(10);
		
		JLabel lblDataMaxima_1_1 = new JLabel("Max:");
		lblDataMaxima_1_1.setBounds(12, 34, 51, 15);
		panel_2.add(lblDataMaxima_1_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(675, 24, 223, 85);
		add(panel_3);
		panel_3.setLayout(null);
		
		tf_cods = new JTextField();
		tf_cods.setBounds(59, 12, 114, 19);
		panel_3.add(tf_cods);
		tf_cods.setColumns(10);
		
		JLabel lblCod = new JLabel("COD:");
		lblCod.setBounds(12, 14, 51, 15);
		panel_3.add(lblCod);
		
		rdbtnPeloMenosUm = new JRadioButton("pelo menos um");
		rdbtnPeloMenosUm.setBounds(12, 32, 164, 19);
		panel_3.add(rdbtnPeloMenosUm);
		buttonGroup.add(rdbtnPeloMenosUm);
		
		JRadioButton rdbtnContemTodos = new JRadioButton("contem todos");
		rdbtnContemTodos.setBounds(12, 52, 164, 19);
		panel_3.add(rdbtnContemTodos);
		rdbtnContemTodos.setSelected(true);
		buttonGroup.add(rdbtnContemTodos);
    }
	public void defineTabela(){
		DefaultTableModel model = (DefaultTableModel) table.getModel();					//
		model.addColumn("ID");																// adiciona a coluna 0
		model.addColumn("CPF");																// adiciona a coluna 1
		model.addColumn("Data");														// adiciona a coluna 2
		model.addColumn("SubTotal");															// adiciona a coluna 3
		model.addColumn("Qnt. de Itns.");
		model.addColumn("Qnt. de Prods.");
		model.addColumn("Concluído");
		table.getColumnModel().getColumn(0).setPreferredWidth(62);
		table.getColumnModel().getColumn(1).setPreferredWidth(65);
		table.getColumnModel().getColumn(2).setPreferredWidth(105);
		table.getColumnModel().getColumn(3).setPreferredWidth(72);
		table.getColumnModel().getColumn(4).setPreferredWidth(72);
		table.getColumnModel().getColumn(5).setPreferredWidth(72);
		table.getColumnModel().getColumn(6).setPreferredWidth(62);
	}
	public void preencheouEsvazia(boolean preenche) {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		for(int i = 0;i<model.getRowCount();i++){
			model.removeRow(0);
		}			
		model.setRowCount(0);
		if(preenche){
			for (ConsultaPedido cs : pedidosConsultados) {
				model.addRow(new Object[]{cs.getId(),cs.getCpf(),cs.getData(),cs.getSubTotalf(),cs.getQuanidadeDeItens(),cs.getQuanidadeDeItensdist(),cs.getConcluido()});
			}
		}
	}
	public void geraDocumento(){
		String html = "<!DOCTYPE html><html lang='pt-br'><head><meta charset='UTF-8'><meta name='viewport' content='width=device-width, initial-scale=1.0'><title>Document</title></head><body><style>*,*:before,*:after{box-sizing: border-box;margin: 0;}body{display: flex;flex-wrap: wrap;}#main{width: 84%;}table {min-width:100%;}th {background-color: gray;}.cn {background-color: aqua;}table,th,td {border: 1px solid black;border-collapse: collapse;}h1 {text-align: center;}p{margin-top:5px;margin-bottom:5px;}#sidebar{width: 16%;background-color: lightblue;height: 50%;box-sizing: border-box;border-right:1px solid black;}</style><div id=\"sidebar\"><h4>Filtros utilizados</h4><strong>data:</strong>"+"<p>min:"+tf_datamin.getText()+"</p><p>max:"+tf_datamax.getText()+"</p><strong>Quantidade de itens</strong><p>min:"+tf_quantMin.getText()+"</p><p>max:"+tf_quantMax.getText()+"</p><strong>Itens distintos</strong><p>min:"+tf_proddismin.getText()+"</p><p>max:"+tf_proddismax.getText()+"</p><strong>Subtotal</strong><p>min:"+tf_subtotalmin.getText()+"</p><p>max:"+tf_subtotalmin.getText()+"</p><strong>CPF:</strong>";
		for (String string : tf_cpfs.getText().split(",")) {
			html+="<p>"+string+"</p>";
		}
		html+="<strong>Produtos</strong><p>";
		for (String string : tf_cods.getText().split(",")) {
			html+="<p>"+string+"</p>";
		}
		if(rdbtnPeloMenosUm.isSelected()){
			html+= "<label for='rd'><input name='rd' id='rd' checked type='radio' group='gp'>pelo menos um</label><br><label for='rd1'><input name='rd' id='rd1' type='radio' group='gp'>contem todos</label><br>";
		}else{
			html+="<label for='rd'><input name='rd' id='rd'  type='radio' group='gp'>pelo menos um</label><br><label for='rd1'><input name='rd' id='rd1' checked type='radio' group='gp'>contem todos</label><br>";
		}
		if(chckbxVendaCompletada.isSelected()){
			html+="<label for='rd2'><input type='checkbox' checked name='rd2' id='rd2'>Venda completada</label>";
		}else{
			html+="<label for='rd2'><input type='checkbox' name='rd2' id='rd2'>Venda completada</label>";
		}
		html+="</p></div><div id = 'main'><h1>Relatório de Pedidos</h1><table><thead><tr><th>ID</th><th>CPF</th><th>Dada</th><th>SubTotal</th><th>Qnt. de Itns.</th><th>Qnt. de Prods.</th><th>Concluído</th></tr></thead><tbody>";
		try {
			boolean corsin= true;
			for (ConsultaPedido oop :pedidosConsultados) {
				if (corsin) {
					html+= "<tr>";
					html+=" <td>"+oop.getId()+"</td><td>"+oop.getCpf()+"</td><td>"+oop.getData()+"</td><td>"+oop.getSubTotal()+"</td><td>"+oop.getQuanidadeDeItens()+"</td><td>"+oop.getQuanidadeDeItensdist()+"</td><td>"+oop.getConcluido()+"</td></tr>";
				
					corsin=!corsin;
				}else{
					html+= "<tr class = 'cn'>";
					html+=" <td>"+oop.getId()+"</td><td>"+oop.getCpf()+"</td><td>"+oop.getData()+"</td><td>"+oop.getSubTotal()+"</td><td>"+oop.getQuanidadeDeItens()+"</td><td>"+oop.getQuanidadeDeItensdist()+"</td><td>"+oop.getConcluido()+"</td></tr>";
					corsin=!corsin;
				}
			}
			html+="</tbody></table></div></body></html>";
			// cria arquivo temporario
			File arquivo = File.createTempFile("arquivoTemp", ".html");
			// Cria um FileWriter para o arquivo
			FileWriter writer = new FileWriter(arquivo);
			// Escreve a String no arquivo
			writer.write(html);			
			// Fecha o FileWriter
			writer.close();
			Gerahtml(html);
			// Cria um novo documento PDF com tamanho de página paisagem
			PdfWriter pdfWriter = new PdfWriter("Relatorio de Pedidos.pdf");
			PdfDocument pdfDoc = new PdfDocument(pdfWriter);
			pdfDoc.setDefaultPageSize(PageSize.A4.rotate());
			// Converte a string HTML para PDF
			ConverterProperties props = new ConverterProperties();
			HtmlConverter.convertToPdf(new FileInputStream(arquivo), pdfDoc, props);			
		} catch (IOException|ITextException erro_consulta_cliente) {
				JOptionPane.showMessageDialog(null, erro_consulta_cliente.getMessage());
		}
	}
	public void Gerahtml(String html){
		try {
            File myFile = new File("nomeDoArquivo.html");
            if (myFile.createNewFile()) {
                System.out.println("Arquivo criado: " + myFile.getName());
            } else {
                System.out.println("O arquivo já existe.");
            }

            FileWriter writer = new FileWriter(myFile);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);

            bufferedWriter.write(html);
           
            bufferedWriter.close();
            System.out.println("Escrito no arquivo com sucesso.");
        } catch (IOException e) {
            System.out.println("Ocorreu um erro.");
            e.printStackTrace();
        }
	}
}


