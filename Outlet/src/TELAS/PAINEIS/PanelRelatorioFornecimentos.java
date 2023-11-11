package TELAS.PAINEIS;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import com.itextpdf.commons.exceptions.ITextException;
import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.html2pdf.HtmlConverter;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;

import DAO.ProdutofornecedorDAO;
import ENTIDADES.Produtofornecedor;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;


public class PanelRelatorioFornecimentos extends JPanel {
	private JLayeredPane layeredPane;	
	private JTextField textField;
	private JTextField tf_cnpjs;
	private JTextField tf_nomeFornecedor;
	private JTextField tf_telefonefornecedor;
	private JTextField textField_1;
	private JTextField tf_cods;
	private JTextField tf_nomes;
	private JTextField tf_marcas;
	private JTextField tf_estoquemin;
	private JTextField tf_estoquemax;
	private JTextField tf_estados;
	private JTextField tf_cidades;
	private JTable table;
	private ArrayList<Produtofornecedor> produtosComFornecedores = new ArrayList<Produtofornecedor>();
	
	/**
	 * Create the panel.
	 */
	public void praFrente(){
		layeredPane.add(this);
		layeredPane.moveToFront(this);
	}
    public PanelRelatorioFornecimentos(JLayeredPane layeredPane) {
		this.layeredPane = layeredPane;
		setBounds(0, 0, 910, 686);		
		setBackground(new Color(255, 255, 255));
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(12, 12, 243, 99);
		add(panel);
		panel.setLayout(null);
		
		JLabel CNPJs = new JLabel("CNPJs");
		CNPJs.setHorizontalAlignment(SwingConstants.RIGHT);
		CNPJs.setBounds(12, 26, 75, 15);
		panel.add(CNPJs);
		
		textField = new JTextField();
		textField.setBounds(162, 10, -67, 15);
		panel.add(textField);
		textField.setColumns(10);
		
		tf_cnpjs = new JTextField();
		tf_cnpjs.setBounds(105, 24, 128, 19);
		panel.add(tf_cnpjs);
		tf_cnpjs.setColumns(10);
		
		JLabel lblFormasPg = new JLabel("Nome");
		lblFormasPg.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFormasPg.setBounds(12, 46, 75, 15);
		panel.add(lblFormasPg);
		
		tf_nomeFornecedor = new JTextField();
		tf_nomeFornecedor.setColumns(10);
		tf_nomeFornecedor.setBounds(105, 46, 128, 19);
		panel.add(tf_nomeFornecedor);
		
		JLabel lblNumeroTel = new JLabel("Telefones");
		lblNumeroTel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNumeroTel.setBounds(12, 68, 75, 15);
		panel.add(lblNumeroTel);
		
		tf_telefonefornecedor = new JTextField();
		tf_telefonefornecedor.setColumns(10);
		tf_telefonefornecedor.setBounds(105, 68, 128, 19);
		panel.add(tf_telefonefornecedor);
		
		JLabel lblFornecedor = new JLabel("Fornecedor");
		lblFornecedor.setHorizontalAlignment(SwingConstants.CENTER);
		lblFornecedor.setBounds(12, 2, 221, 15);
		panel.add(lblFornecedor);
		table = new JTable();
		table.setBounds(0,0,886,513);
		defineTabela();
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(12, 123, 886, 513);
		add(scrollPane);
		
		JButton btnSalvarRelatorio = new JButton("Salvar relatório");
		btnSalvarRelatorio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				geraDocumento();
			}
		});
		btnSalvarRelatorio.setBounds(742, 648, 156, 25);
		add(btnSalvarRelatorio);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(467, 12, 237, 99);
		add(panel_1);
		
		JLabel lblCods = new JLabel("CODs");
		lblCods.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCods.setBounds(12, 24, 70, 15);
		panel_1.add(lblCods);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(162, 10, -67, 15);
		panel_1.add(textField_1);
		
		tf_cods = new JTextField();
		tf_cods.setColumns(10);
		tf_cods.setBounds(100, 24, 128, 19);
		panel_1.add(tf_cods);
		
		JLabel lblNomeProd = new JLabel("Nomes");
		lblNomeProd.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNomeProd.setBounds(12, 46, 70, 15);
		panel_1.add(lblNomeProd);
		
		tf_nomes = new JTextField();
		tf_nomes.setColumns(10);
		tf_nomes.setBounds(100, 46, 128, 19);
		panel_1.add(tf_nomes);
		
		JLabel lblMarcaProd = new JLabel("Marcas");
		lblMarcaProd.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMarcaProd.setBounds(12, 68, 70, 15);
		panel_1.add(lblMarcaProd);
		
		tf_marcas = new JTextField();
		tf_marcas.setColumns(10);
		tf_marcas.setBounds(100, 68, 128, 19);
		panel_1.add(tf_marcas);
		
		JLabel lblProduto = new JLabel("Produto");
		lblProduto.setHorizontalAlignment(SwingConstants.CENTER);
		lblProduto.setBounds(12, 2, 251, 15);
		panel_1.add(lblProduto);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(716, 12, 182, 99);
		add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblEstoque = new JLabel("Qnt. Estoque");
		lblEstoque.setHorizontalAlignment(SwingConstants.CENTER);
		lblEstoque.setBounds(12, 2, 158, 15);
		panel_2.add(lblEstoque);
		
		tf_estoquemin = new JTextField();
		tf_estoquemin.setBounds(54, 29, 116, 19);
		panel_2.add(tf_estoquemin);
		tf_estoquemin.setColumns(10);
		
		JLabel lblMin = new JLabel("Min:");
		lblMin.setBounds(12, 29, 39, 15);
		panel_2.add(lblMin);
		
		JLabel lblMax = new JLabel("Max:");
		lblMax.setBounds(11, 60, 39, 15);
		panel_2.add(lblMax);
		
		tf_estoquemax = new JTextField();
		tf_estoquemax.setColumns(10);
		tf_estoquemax.setBounds(53, 60, 117, 19);
		panel_2.add(tf_estoquemax);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int quantmin =0;
				int quantmax =0;
				try {
					if(!tf_estoquemin.getText().equals("")){
						quantmin = Integer.parseInt(tf_estoquemin.getText());
					}
					if(!tf_estoquemax.getText().equals("")){
						quantmax = Integer.parseInt(tf_estoquemax.getText());
					}
					produtosComFornecedores = ProdutofornecedorDAO.pesquisaRelatorio(tf_cnpjs.getText(), tf_nomeFornecedor.getText(), tf_telefonefornecedor.getText(), tf_estados.getText(), tf_cidades.getText(), tf_cods.getText(),tf_nomes.getText(),tf_marcas.getText(),quantmin,quantmax);
					preencheouEsvazia();
				} catch (Exception fkk) {
					JOptionPane.showMessageDialog(null, "Preencha corretamente os campos.");
				}
				
				
				
			}
		});
		btnPesquisar.setBounds(613, 648, 117, 25);
		add(btnPesquisar);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(267, 12, 188, 99);
		add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblLocal = new JLabel("Local");
		lblLocal.setHorizontalAlignment(SwingConstants.CENTER);
		lblLocal.setBounds(12, 2, 164, 15);
		panel_3.add(lblLocal);
		
		tf_estados = new JTextField();
		tf_estados.setBounds(80, 29, 96, 19);
		panel_3.add(tf_estados);
		tf_estados.setColumns(10);
		
		JLabel lblEstados = new JLabel("Estados");
		lblEstados.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEstados.setBounds(12, 29, 62, 15);
		panel_3.add(lblEstados);
		
		tf_cidades = new JTextField();
		tf_cidades.setColumns(10);
		tf_cidades.setBounds(80, 60, 96, 19);
		panel_3.add(tf_cidades);
		
		JLabel lblCidades = new JLabel("Cidades");
		lblCidades.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCidades.setBounds(12, 60, 62, 15);
		panel_3.add(lblCidades);
    }
	public void defineTabela(){
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.addColumn("CNPJ");
		model.addColumn("Nome");
		model.addColumn("Cidade");
		model.addColumn("Estado");
		model.addColumn("id");
		model.addColumn("Nome Prod.");
		model.addColumn("Qnt. Est.");
		table.getColumnModel().getColumn(0).setPreferredWidth(133);
		table.getColumnModel().getColumn(1).setPreferredWidth(163);
		table.getColumnModel().getColumn(2).setPreferredWidth(106);
		table.getColumnModel().getColumn(3).setPreferredWidth(106);
		table.getColumnModel().getColumn(4).setPreferredWidth(106);
		table.getColumnModel().getColumn(5).setPreferredWidth(166);
		table.getColumnModel().getColumn(6).setPreferredWidth(106);
	}
	public void preencheouEsvazia() {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		for(int i = 0;i<model.getRowCount();i++){
			model.removeRow(0);
		}
		model.setRowCount(0);
			// Populate the table with the items			
			for (Produtofornecedor prd : produtosComFornecedores) {
				model.addRow(new Object[]{prd.getFornecedor_cnpj(),prd.getFornecedorNome(),prd.getFornecedorCidade(),prd.getFornecedorEstado(),prd.getProduto_cod(),prd.getProdutoNome(),prd.getProdutoEstoque()});
			}		
	}
	public void geraDocumento(){
		String html = "<!DOCTYPE html><html lang='pt-br'><head><meta charset='UTF-8'><meta name='viewport' content='width=device-width, initial-scale=1.0'><title>Document</title></head><body><style>table{width: 99%;}th{background-color: gray;}.cn{background-color: aqua;}table, th, td {border: 1px solid black;border-collapse: collapse;}h1{text-align: center;}</style><h1>Relatório de Fornecimentos</h1><table><thead><tr><th>CNPJ</th><th>Nome</th><th>Cidade</th><th>Estado</th><th>id</th><th>Nome Prod</th><th>Qnt. Est</th></tr></thead><tbody>";

		try {
			boolean corsin= true;
			for (Produtofornecedor prd : produtosComFornecedores) {
				if (corsin) {
					html+= "<tr>";
					html+="<td>"+prd.getFornecedor_cnpj()+"</td><td>"+prd.getFornecedorNome()+"</td><td>"+prd.getFornecedorCidade()+"</td><td>"+prd.getFornecedorEstado()+"</td><td>"+prd.getProduto_cod()+"</td><td>"+prd.getProdutoNome()+"</td><td>"+prd.getProdutoEstoque()+"</td></tr>";
				
					corsin=!corsin;
				}else{
					html+= "<tr class = 'cn'>";
					html+="<td>"+prd.getFornecedor_cnpj()+"</td><td>"+prd.getFornecedorNome()+"</td><td>"+prd.getFornecedorCidade()+"</td><td>"+prd.getFornecedorEstado()+"</td><td>"+prd.getProduto_cod()+"</td><td>"+prd.getProdutoNome()+"</td><td>"+prd.getProdutoEstoque()+"</td></tr>";
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
			PdfWriter pdfWriter = new PdfWriter("RelatorioFornecimento.pdf");
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


