package TELAS;

import ENTIDADES.Fornecedor;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import DAO.FornecedorDAO;
import DATABASE.Conexao;

public class Gerenciamento_Fornecedor extends JFrame {

    private JPanel painelControleFornecedor;
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

    Fornecedor fornecedor = new Fornecedor();
   

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Gerenciamento_Fornecedor
                 frame = new Gerenciamento_Fornecedor
                ();
                    frame.setVisible(true);
                    FornecedorDAO.start( new Conexao().getConexao());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Gerenciamento_Fornecedor() {
        setBounds(100, 100, 800, 630);
        painelControleFornecedor = new JPanel();
        painelControleFornecedor.setBackground(new Color(0, 51, 102));
        painelControleFornecedor.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(painelControleFornecedor);
        painelControleFornecedor.setLayout(null);

        JLabel lbrazaosocial = new JLabel("Razão social");
        lbrazaosocial.setFont(new Font("Tahoma", Font.BOLD, 14));
        lbrazaosocial.setForeground(Color.WHITE);
        lbrazaosocial.setBounds(405, 59, 89, 26);
        painelControleFornecedor.add(lbrazaosocial);

        tf_razaosocial = new JTextField();
        tf_razaosocial.setBounds(504, 64, 170, 20);
        painelControleFornecedor.add(tf_razaosocial);
        tf_razaosocial.setColumns(10);

        JLabel lblcnpj = new JLabel("CNPJ");
        lblcnpj.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblcnpj.setForeground(Color.WHITE);
        lblcnpj.setBounds(10, 63, 43, 19);
        painelControleFornecedor.add(lblcnpj);

        tf_cnpj = new JFormattedTextField(GerenciamentoPedido.Mascara("##.###.###/####-##"));
        tf_cnpj.setBounds(60, 64, 164, 20);
        painelControleFornecedor.add(tf_cnpj);
        tf_cnpj.setColumns(10);

        JLabel lblemail = new JLabel("Digite seu email");
        lblemail.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblemail.setForeground(Color.WHITE);
        lblemail.setBounds(10, 93, 112, 26);
        painelControleFornecedor.add(lblemail);

        tf_email = new JTextField();
        tf_email.setColumns(10);
        tf_email.setBounds(132, 98, 232, 20);
        painelControleFornecedor.add(tf_email);

        JLabel lblTelefone = new JLabel("Digite seu telefone");
        lblTelefone.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblTelefone.setForeground(Color.WHITE);
        lblTelefone.setBounds(405, 93, 127, 26);
        painelControleFornecedor.add(lblTelefone);

        tf_telefone = new JFormattedTextField(GerenciamentoPedido.Mascara("(##) #####-####"));
        tf_telefone.setColumns(10);
        tf_telefone.setBounds(542, 98, 232, 20);
        painelControleFornecedor.add(tf_telefone);

        JLabel lblEscolhaODestino = new JLabel("ESCOLHA O DESTINO DAS INFORMAÇOES");
        lblEscolhaODestino.setFont(new Font("Tw Cen MT", Font.BOLD, 19));
        lblEscolhaODestino.setForeground(Color.WHITE);
        lblEscolhaODestino.setBounds(10, 415, 343, 26);
        painelControleFornecedor.add(lblEscolhaODestino);

        JLabel lbllongradouro = new JLabel("Longradouro\r\n");
        lbllongradouro.setFont(new Font("Tahoma", Font.BOLD, 14));
        lbllongradouro.setForeground(Color.WHITE);
        lbllongradouro.setBounds(10, 150, 98, 26);
        painelControleFornecedor.add(lbllongradouro);

        tf_longradouro = new JTextField();
        tf_longradouro.setColumns(10);
        tf_longradouro.setBounds(118, 155, 157, 20);
        painelControleFornecedor.add(tf_longradouro);

        JLabel lblNumero = new JLabel("Numero\r\n");
        lblNumero.setForeground(Color.WHITE);
        lblNumero.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNumero.setBounds(302, 150, 62, 26);
        painelControleFornecedor.add(lblNumero);
        
        tf_numero = new JTextField();
        tf_numero.setColumns(10);
        tf_numero.setBounds(374, 155, 50, 20);
        painelControleFornecedor.add(tf_numero);
        
        JLabel lblComplemento = new JLabel("Complemento\r\n");
        lblComplemento.setForeground(Color.WHITE);
        lblComplemento.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblComplemento.setBounds(10, 224, 98, 26);
        painelControleFornecedor.add(lblComplemento);

        tf_complemento = new JTextField();
        tf_complemento.setColumns(10);
        tf_complemento.setBounds(112, 229, 215, 20);
        painelControleFornecedor.add(tf_complemento);
        
        JLabel lblBairro = new JLabel("Bairro");
        lblBairro.setForeground(Color.WHITE);
        lblBairro.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblBairro.setBounds(10, 187, 50, 26);
        painelControleFornecedor.add(lblBairro);

        tf_bairro = new JTextField();
        tf_bairro.setColumns(10);
        tf_bairro.setBounds(60, 192, 119, 20);
        painelControleFornecedor.add(tf_bairro);
        
        JLabel lblCidade = new JLabel("Cidade");
        lblCidade.setForeground(Color.WHITE);
        lblCidade.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblCidade.setBounds(10, 261, 56, 26);
        painelControleFornecedor.add(lblCidade);

        tf_cidade = new JTextField();
        tf_cidade.setColumns(10);
        tf_cidade.setBounds(76, 266, 157, 20);
        painelControleFornecedor.add(tf_cidade);
        
        JLabel lblEstado = new JLabel("Estado");
        lblEstado.setForeground(Color.WHITE);
        lblEstado.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblEstado.setBounds(10, 298, 50, 26);
        painelControleFornecedor.add(lblEstado);

        tf_estado = new JTextField();
        tf_estado.setColumns(10);
        tf_estado.setBounds(67, 303, 62, 20);
        painelControleFornecedor.add(tf_estado);
        
        JLabel lblCep = new JLabel("Cep");
        lblCep.setForeground(Color.WHITE);
        lblCep.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblCep.setBounds(10, 335, 31, 26);
        painelControleFornecedor.add(lblCep);
        
        tf_cep = new JFormattedTextField(GerenciamentoPedido.Mascara("#####-###"));
        tf_cep.setColumns(10);
        tf_cep.setBounds(51, 340, 157, 20);
        painelControleFornecedor.add(tf_cep);
               
        JLabel lblDadosDoFornecedor = new JLabel("DADOS DO FORNECEDOR");
        lblDadosDoFornecedor.setForeground(Color.WHITE);
        lblDadosDoFornecedor.setFont(new Font("Tw Cen MT", Font.BOLD, 19));
        lblDadosDoFornecedor.setBounds(10, 11, 215, 26);
        painelControleFornecedor.add(lblDadosDoFornecedor);

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
        painelControleFornecedor.add(btn_cadastrar);

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
        painelControleFornecedor.add(btn_Excluir);

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

        btn_atualizar.setBounds(361, 471, 89, 23);
        painelControleFornecedor.add(btn_atualizar);

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
        painelControleFornecedor.add(btn_buscar);
        
    }
 }