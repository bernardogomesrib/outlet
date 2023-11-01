package TELAS.PAINEIS;

import DAO.ProdutoDao;
import ENTIDADES.Produto;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import com.itextpdf.commons.exceptions.ITextException;
import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.html2pdf.HtmlConverter;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JCheckBox;

public class ConsultaProduto extends JPanel {	
	private JLayeredPane layeredPane;
	private JTextField tf_cod;
	private JTextField tf_descricao;
	private JTextField tf_marca;
	private JTextField tf_preco_min;
	private JTextField tf_preco_max;
	private JTextField tf_quantidade_min;
	private JTextField tf_quantidade_max;
	private JTable table;
	private ArrayList<Produto> produtos = new ArrayList<Produto>();
	/**
	 * Create the panel.
	 */
		public void praFrente(){
			layeredPane.add(this);
			layeredPane.moveToFront(this);
		}
    	public ConsultaProduto(JLayeredPane layeredPane) {
		this.layeredPane = layeredPane;			

		setBounds(0, 0, 910, 686);		
		setBackground(new Color(255, 255, 255));
		setLayout(null);
		
		tf_cod = new JTextField();
		tf_cod.setBounds(96, 12, 70, 19);
		add(tf_cod);
		tf_cod.setColumns(10);
		
		JLabel lblCdigo = new JLabel("Código:");
		lblCdigo.setBounds(22, 14, 70, 15);
		lblCdigo.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblCdigo);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(178, 14, 70, 15);
		lblNome.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblNome);
		
		tf_descricao = new JTextField();
		tf_descricao.setBounds(251, 12, 150, 19);
		add(tf_descricao);
		tf_descricao.setColumns(10);
		
		JLabel lblMarca = new JLabel("Marca:");
		lblMarca.setBounds(535, 16, 70, 15);
		lblMarca.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblMarca);
		
		tf_marca = new JTextField();
		tf_marca.setBounds(613, 14, 150, 19);
		add(tf_marca);
		tf_marca.setColumns(10);
		
		JLabel lblPreoMinimo = new JLabel("Preço minimo:");
		lblPreoMinimo.setBounds(32, 43, 106, 15);
		lblPreoMinimo.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblPreoMinimo);
		
		tf_preco_min = new JTextField();
		tf_preco_min.setBounds(156, 41, 92, 19);
		add(tf_preco_min);
		tf_preco_min.setColumns(10);
		
		JLabel lblMax = new JLabel("max:");
		lblMax.setBounds(261, 43, 48, 15);
		add(lblMax);
		
		JLabel lblQntMin = new JLabel("Qnt.  min:");
		lblQntMin.setBounds(416, 45, 92, 15);
		lblQntMin.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblQntMin);
		
		JLabel lblMax_1 = new JLabel("max:");
		lblMax_1.setBounds(612, 45, 48, 15);
		add(lblMax_1);
		
		JButton btnSalvarRelatrio = new JButton("Salvar relatório");
		btnSalvarRelatrio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				geraDocumento();
			}
		});
		btnSalvarRelatrio.setBounds(705, 649, 179, 25);
		add(btnSalvarRelatrio);
		table = new JTable();
		table.setBackground(new Color(255,255,255));
		table.setBounds(0, 0, 864, 570);
		defineTabela();
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(20, 70, 864, 570);
		add(scrollPane);
		
		JCheckBox chckbxExato = new JCheckBox("Nome exato");
		chckbxExato.setBounds(404, 10, 117, 23);
		add(chckbxExato);
		
		JCheckBox chckbxMarcaExata = new JCheckBox("Marca exata");
		chckbxMarcaExata.setBounds(768, 12, 116, 23);
		add(chckbxMarcaExata);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					double precomax = 0;
					double precomin = 0;
					int quantmax = 0;
					int quantmin = 0;
					if(!tf_preco_max.getText().equals("")){
						precomax = Double.parseDouble(tf_preco_max.getText());
					}
					if(!tf_preco_min.getText().equals("")){
						precomin = Double.parseDouble(tf_preco_min.getText());
					}
					if(!tf_quantidade_max.getText().equals("")){
						quantmax = Integer.parseInt(tf_quantidade_max.getText());
					}
					if(!tf_quantidade_min.getText().equals("")){
						quantmin = Integer.parseInt(tf_quantidade_min.getText());
					}
					produtos = ProdutoDao.procuraProdutos(tf_cod.getText(),tf_descricao.getText(),chckbxExato.isSelected(),tf_marca.getText(),chckbxMarcaExata.isSelected(),precomin,precomax,quantmin,quantmax);
					if(produtos.size()>=1){
						preencheouEsvazia(true);
					}else{
						JOptionPane.showMessageDialog(null, "Não foram encontrados produtos");
					}
				} catch (Exception zzz) {
					JOptionPane.showMessageDialog(null, "Preencha corretamente os campos para pesquisar, não insira letras ou virgula nos campos de quantidade ou preço");
				}
				
			}
		});
		btnPesquisar.setBounds(767, 38, 117, 25);
		add(btnPesquisar);
		
		tf_preco_max = new JTextField();
		tf_preco_max.setColumns(10);
		tf_preco_max.setBounds(314, 43, 92, 19);
		add(tf_preco_max);
		
		tf_quantidade_min = new JTextField();
		tf_quantidade_min.setColumns(10);
		tf_quantidade_min.setBounds(510, 43, 92, 19);
		add(tf_quantidade_min);
		
		tf_quantidade_max = new JTextField();
		tf_quantidade_max.setColumns(10);
		tf_quantidade_max.setBounds(661, 43, 92, 19);
		add(tf_quantidade_max);

		
	}
	public void defineTabela(){
		DefaultTableModel model = (DefaultTableModel) table.getModel();					//
		model.addColumn("COD");																// adiciona a coluna 0
		model.addColumn("Descrição");																// adiciona a coluna 1
		model.addColumn("Marca");														// adiciona a coluna 2
		model.addColumn("Preço");															// adiciona a coluna 3
		model.addColumn("Qnt");															// adiciona a coluna 4
		table.getColumnModel().getColumn(0).setPreferredWidth(80);			// define a largura da coluna 0
		table.getColumnModel().getColumn(1).setPreferredWidth(180);			// define a largura da coluna 1
		table.getColumnModel().getColumn(2).setPreferredWidth(150);			// define a largura da coluna 2
		table.getColumnModel().getColumn(3).setPreferredWidth(80);			// define a largura da coluna 3
		table.getColumnModel().getColumn(4).setPreferredWidth(80);			// define a largura da coluna 4
	}
	public void preencheouEsvazia(boolean preenche) {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		for(int i = 0;i<model.getRowCount();i++){
			model.removeRow(0);
		}
		model.setRowCount(0);
		
		if (preenche) {
			// Populate the table with the items
			for (Produto prod : produtos) {
				model.addRow(new Object[]{prod.getCod(),prod.getDescricao(),prod.getMarca(),prod.getPreco(),prod.getQuantidadeestoque()});
			}
		}
	}
	public void geraDocumento(){
		String html = "<!DOCTYPE html><html lang='pt-br'><head><meta charset='UTF-8'><meta ame='viewport' content='width=device-width, initial-scale=1.0'><title>ocument</title></head><body><style>table{width: 99%;}th{background-color: gray;}.cn{background-color: aqua;}table, th, td {border: 1px solid black;border-collapse: collapse;}h1{text-align: center;}</style><h1>Relatório de Produtos</h1><table><thead><tr><th>COD</th><th>Descrição</th><th>Marca</th><th>Quantidade</th><th>Preço</th></tr></thead><tbody>";

		try {
			boolean corsin= true;
			for (Produto oop : produtos) {
				if (corsin) {
					html+= "<tr>";
					html+=" <td>"+oop.getCod()+"</td><td>"+oop.getDescricao()+"</td><td>"+oop.getMarca()+"</td><td>"+oop.getQuantidadeestoque()+"</td><td>"+oop.getPrecof()+"</td></tr>";
				
					corsin=!corsin;
				}else{
					html+= "<tr class = 'cn'>";
					html+=" <td>"+oop.getCod()+"</td><td>"+oop.getDescricao()+"</td><td>"+oop.getMarca()+"</td><td>"+oop.getQuantidadeestoque()+"</td><td>"+oop.getPrecof()+"</td></tr>";
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
			PdfWriter pdfWriter = new PdfWriter("relatorioProduto.pdf");
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