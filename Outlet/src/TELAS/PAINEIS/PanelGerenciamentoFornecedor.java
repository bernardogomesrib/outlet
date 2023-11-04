package TELAS.PAINEIS;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import javax.swing.JTextField;

import DAO.FornecedorDAO;

import ENTIDADES.Fornecedor;
import TELAS.GerenciamentoPedido;

import javax.swing.SwingConstants;


public class PanelGerenciamentoFornecedor extends JPanel {

    private JTextField tf_razaosocial;
    private JTextField tf_cnpj;
    private JTextField tf_email;
    private JTextField tf_telefone;
    private JTextField tf_longradouro;
    private JTextField tf_numero;
    private JTextField tf_complemento;
    private JTextField tf_bairro;
    private JTextField tf_cidade;
    private JTextField tf_estado;
    private JTextField tf_cep;
	private JLayeredPane layeredPane;
	Fornecedor fornecedor = new Fornecedor();
   
	/**
	 * Create the panel.
	 */
	public void praFrente(){
		layeredPane.add(this);
		layeredPane.moveToFront(this);
	}
    public PanelGerenciamentoFornecedor(JLayeredPane layeredPane) {
		this.layeredPane = layeredPane;
		setBounds(0, 0, 910, 686);		
		setBackground(new Color(0, 51, 102));
		setLayout(null);

        JLabel lbrazaosocial = new JLabel("Razão social");
        lbrazaosocial.setHorizontalAlignment(SwingConstants.RIGHT);
        lbrazaosocial.setFont(new Font("Tahoma", Font.BOLD, 14));
        lbrazaosocial.setForeground(Color.WHITE);
        lbrazaosocial.setBounds(248, 59, 137, 26);
        add(lbrazaosocial);

        tf_razaosocial = new JTextField();
        tf_razaosocial.setBounds(414, 63, 170, 20);
        add(tf_razaosocial);
        tf_razaosocial.setColumns(10);

        JLabel lblcnpj = new JLabel("CNPJ");
        lblcnpj.setHorizontalAlignment(SwingConstants.RIGHT);
        lblcnpj.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblcnpj.setForeground(Color.WHITE);
        lblcnpj.setBounds(10, 63, 56, 19);
        add(lblcnpj);

        tf_cnpj = new JFormattedTextField(GerenciamentoPedido.Mascara("##.###.###/####-##"));
        tf_cnpj.setBounds(77, 63, 164, 20);
        add(tf_cnpj);
        tf_cnpj.setColumns(10);

        JLabel lblemail = new JLabel("Digite seu email");
        lblemail.setHorizontalAlignment(SwingConstants.RIGHT);
        lblemail.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblemail.setForeground(Color.WHITE);
        lblemail.setBounds(10, 94, 140, 26);
        add(lblemail);

        tf_email = new JTextField();
        tf_email.setColumns(10);
        tf_email.setBounds(153, 98, 232, 20);
        add(tf_email);

        JLabel lblTelefone = new JLabel("Digite seu telefone");
        lblTelefone.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblTelefone.setForeground(Color.WHITE);
        lblTelefone.setBounds(403, 94, 150, 26);
        add(lblTelefone);

        tf_telefone = new JFormattedTextField(GerenciamentoPedido.Mascara("(##) #####.####"));
        tf_telefone.setColumns(10);
        tf_telefone.setBounds(571, 98, 232, 20);
        add(tf_telefone);

        JLabel lblEscolhaODestino = new JLabel("ESCOLHA O DESTINO DAS INFORMAÇOES");
        lblEscolhaODestino.setFont(new Font("Tw Cen MT", Font.BOLD, 19));
        lblEscolhaODestino.setForeground(Color.WHITE);
        lblEscolhaODestino.setBounds(10, 415, 521, 26);
        add(lblEscolhaODestino);

        JLabel lbllongradouro = new JLabel("Logradouro\r\n");
        lbllongradouro.setHorizontalAlignment(SwingConstants.RIGHT);
        lbllongradouro.setFont(new Font("Tahoma", Font.BOLD, 14));
        lbllongradouro.setForeground(Color.WHITE);
        lbllongradouro.setBounds(10, 132, 104, 26);
        add(lbllongradouro);

        tf_longradouro = new JTextField();
        tf_longradouro.setColumns(10);
        tf_longradouro.setBounds(117, 136, 157, 20);
        add(tf_longradouro);

        JLabel lblNumero = new JLabel("Numero\r\n");
        lblNumero.setForeground(Color.WHITE);
        lblNumero.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNumero.setBounds(286, 132, 62, 26);
        add(lblNumero);
        
        tf_numero = new JTextField();
        tf_numero.setColumns(10);
        tf_numero.setBounds(358, 137, 92, 20);
        add(tf_numero);
        
        JLabel lblComplemento = new JLabel("Complemento\r\n");
        lblComplemento.setHorizontalAlignment(SwingConstants.RIGHT);
        lblComplemento.setForeground(Color.WHITE);
        lblComplemento.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblComplemento.setBounds(12, 208, 117, 26);
        add(lblComplemento);

        tf_complemento = new JTextField();
        tf_complemento.setColumns(10);
        tf_complemento.setBounds(133, 212, 215, 20);
        add(tf_complemento);
        
        JLabel lblBairro = new JLabel("Bairro");
        lblBairro.setForeground(Color.WHITE);
        lblBairro.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblBairro.setBounds(20, 170, 50, 26);
        add(lblBairro);

        tf_bairro = new JTextField();
        tf_bairro.setColumns(10);
        tf_bairro.setBounds(70, 175, 119, 20);
        add(tf_bairro);
        
        JLabel lblCidade = new JLabel("Cidade");
        lblCidade.setForeground(Color.WHITE);
        lblCidade.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblCidade.setBounds(10, 246, 56, 26);
        add(lblCidade);

        tf_cidade = new JTextField();
        tf_cidade.setColumns(10);
        tf_cidade.setBounds(76, 251, 157, 20);
        add(tf_cidade);
        
        JLabel lblEstado = new JLabel("Estado");
        lblEstado.setHorizontalAlignment(SwingConstants.RIGHT);
        lblEstado.setForeground(Color.WHITE);
        lblEstado.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblEstado.setBounds(20, 284, 62, 26);
        add(lblEstado);

        tf_estado = new JTextField();
        tf_estado.setHorizontalAlignment(SwingConstants.RIGHT);
        tf_estado.setColumns(10);
        tf_estado.setBounds(86, 288, 107, 20);
        add(tf_estado);
        
        JLabel lblCep = new JLabel("Cep");
        lblCep.setForeground(Color.WHITE);
        lblCep.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblCep.setBounds(10, 322, 31, 26);
        add(lblCep);
        
        tf_cep = new JFormattedTextField(GerenciamentoPedido.Mascara("##.###-###"));
        tf_cep.setColumns(10);
        tf_cep.setBounds(51, 327, 157, 20);
        add(tf_cep);
               
        JLabel lblDadosDoFornecedor = new JLabel("DADOS DO FORNECEDOR");
        lblDadosDoFornecedor.setForeground(Color.WHITE);
        lblDadosDoFornecedor.setFont(new Font("Tw Cen MT", Font.BOLD, 19));
        lblDadosDoFornecedor.setBounds(10, 11, 403, 26);
        add(lblDadosDoFornecedor);

        JButton btn_cadastrar = new JButton("Cadastrar");
        btn_cadastrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                fornecedor.setCnpj(tf_cnpj.getText());
                fornecedor.setRazaosocial(tf_razaosocial.getText());
                fornecedor.setEmail(tf_email.getText());
                fornecedor.setTelefone(tf_telefone.getText());
                fornecedor.setLogradouro(tf_longradouro.getText());
                fornecedor.setNumero(tf_numero.getText());
                fornecedor.setComplemento(tf_complemento.getText());
                fornecedor.setBairro(tf_bairro.getText());
                fornecedor.setCidade(tf_cidade.getText());
                fornecedor.setEstado(tf_estado.getText());
                fornecedor.setCep(tf_cep.getText());

                if (fornecedor.getCnpj().equals("")
                        || fornecedor.getRazaosocial().equals("")
                        || fornecedor.getEmail().equals("")
                        || fornecedor.getTelefone().equals("")
                        || fornecedor.getLogradouro().equals("")
                        || fornecedor.getNumero().equals("")
                        || fornecedor.getComplemento().equals("")
                        || fornecedor.getBairro().equals("")
                        || fornecedor.getCidade().equals("")
                        || fornecedor.getEstado().equals("")
                        || fornecedor.getCep().equals("")) {
                    JOptionPane.showMessageDialog(null, "Todos os campos são obrigatórios!");
                } else {
                    FornecedorDAO.insere(fornecedor);

                    // Limpar campos após o cadastro
                    tf_cnpj.setText("");
                    tf_razaosocial.setText("");
                    tf_email.setText("");
                    tf_telefone.setText("");
                    tf_longradouro.setText("");
                    tf_numero.setText("");
                    tf_complemento.setText("");
                    tf_bairro.setText("");
                    tf_cidade.setText("");
                    tf_estado.setText("");
                    tf_cep.setText("");
                    JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!");
                }
            }
        });
        btn_cadastrar.setBounds(10, 471, 119, 23);
        add(btn_cadastrar);

        JButton btn_Excluir = new JButton("Excluir");
        btn_Excluir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
    
                    
                fornecedor.setCnpj(tf_cnpj.getText());

            if (tf_cnpj.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Informe o CPF do fornecedor a ser excluído.");
            } else {
                int resposta = JOptionPane.showConfirmDialog(null, "Tem certeza de que deseja excluir este fornecedor?", "Confirmação", JOptionPane.YES_NO_OPTION);
                if (resposta == JOptionPane.YES_OPTION) {
                    FornecedorDAO.deleta(fornecedor);
                    JOptionPane.showMessageDialog(null, "fornecedor excluído!");

                    // Limpar os campos após a exclusão
                    tf_cnpj.setText("");
                    tf_razaosocial.setText("");
                    tf_email.setText("");
                    tf_telefone.setText("");
                    tf_longradouro.setText("");
                    tf_numero.setText("");
                    tf_complemento.setText("");
                    tf_bairro.setText("");
                    tf_cidade.setText("");
                    tf_estado.setText("");
                    tf_cep.setText(""); // Limpe o campo de telefone
                }
            }
        }
    	});

        btn_Excluir.setBounds(522, 471, 89, 23);
        add(btn_Excluir);

        JButton btn_atualizar = new JButton("Atualizar");
        btn_atualizar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
    
                String novoCpf = tf_cnpj.getText();
                String novoRazaosocial = tf_razaosocial.getText();
                String novoEmail = tf_email.getText();
                String novoTelefone = tf_telefone.getText();
                String novolongradouro = tf_longradouro.getText();
                String novoNumero = tf_numero.getText();
                String novoComplemento = tf_complemento.getText();
                String novoBairro = tf_bairro.getText();
                String novoCidade = tf_cidade.getText();
                String novoEstado = tf_estado.getText();
                String novoCep = tf_cep.getText();

                fornecedor.setCnpj(tf_cnpj.getText());
    
        
                if (novoCpf.isEmpty()
                    || novoRazaosocial.isEmpty()
                    || novoEmail.isEmpty()
                    || novoTelefone.isEmpty()
                    || novolongradouro.isEmpty()
                    || novoNumero.isEmpty()
                    || novoComplemento.isEmpty()
                    || novoBairro.isEmpty()
                    || novoCidade.isEmpty()
                    || novoEstado.isEmpty()
                    || novoCep.isEmpty()){
                    JOptionPane.showMessageDialog(null, "Todos os campos são obrigatórios!");
                } else {
                    // Atualize os valores no objeto "fornecedor"
    
                    fornecedor.setCnpj(novoCpf);
                    fornecedor.setRazaosocial(novoRazaosocial);
                    fornecedor.setEmail(novoEmail);
                    fornecedor.setTelefone(novoTelefone);
                    fornecedor.setLogradouro(novolongradouro);
                    fornecedor.setNumero(novoNumero);
                    fornecedor.setComplemento(novoComplemento);
                    fornecedor.setBairro(novoBairro);
                    fornecedor.setCidade(novoCidade);
                    fornecedor.setEstado(novoEstado);
                    fornecedor.setCep(novoCep);
        
                    FornecedorDAO.atualiza(fornecedor);
    
                    tf_cnpj.setText("");
                    tf_razaosocial.setText("");
                    tf_email.setText("");
                    tf_telefone.setText("");
                    tf_longradouro.setText("");
                    tf_numero.setText("");
                    tf_complemento.setText("");
                    tf_bairro.setText("");
                    tf_cidade.setText("");
                    tf_estado.setText("");
                    tf_cep.setText("");
        
                    JOptionPane.showMessageDialog(null, "Atualização realizada com sucesso!");
                }
            }
        });

        btn_atualizar.setBounds(346, 471, 104, 23);
        add(btn_atualizar);

        JButton btn_buscar = new JButton("Buscar");
        btn_buscar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
    
                fornecedor.setCnpj(tf_cnpj.getText());

                fornecedor = FornecedorDAO.buscaFornecedor(fornecedor.getCnpj());
                
                tf_razaosocial.setText(fornecedor.getRazaosocial());
                tf_email.setText(fornecedor.getEmail());
                tf_telefone.setText(fornecedor.getTelefone());
                tf_longradouro.setText(fornecedor.getLogradouro());
                tf_numero.setText(fornecedor.getTelefone());
                tf_complemento.setText(fornecedor.getComplemento());
                tf_bairro.setText(fornecedor.getBairro());
                tf_cidade.setText(fornecedor.getCidade());
                tf_estado.setText(fornecedor.getEstado());
                tf_cep.setText(fornecedor.getCep());
            }
        });
        btn_buscar.setBounds(186, 471, 89, 23);
        add(btn_buscar);
        
    }	
}


