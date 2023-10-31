package TELAS;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAO.ClienteDAO;
import DATABASE.Conexao;
import ENTIDADES.Cliente;
//import main.GerenciamentoPedido;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

public class Gerenciamento_cliente extends JFrame {

    private JPanel contentPane;
    private JTextField tf_nome;
    private JTextField tf_cpf;
    private JTextField tf_email;
    private JTextField tf_telefone;
    private JTextField tf_data_nascimento;

    Cliente cliente = new Cliente();
    ClienteDAO clientedao = new ClienteDAO();

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Gerenciamento_cliente frame = new Gerenciamento_cliente();
                    frame.setVisible(true);
                    ClienteDAO.start( new Conexao().getConexao());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Gerenciamento_cliente() {
        setBounds(100, 100, 800, 630);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(0, 51, 102));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("Digite seu nome");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel.setForeground(Color.WHITE);
        lblNewLabel.setBounds(10, 43, 119, 26);
        contentPane.add(lblNewLabel);

        tf_nome = new JTextField();
        tf_nome.setBounds(135, 48, 140, 20);
        contentPane.add(tf_nome);
        tf_nome.setColumns(10);

        tf_cpf = new JFormattedTextField(GerenciamentoPedido.Mascara("###.###.###-##"));
        tf_cpf.setBounds(49, 12, 146, 20);
        contentPane.add(tf_cpf);
        tf_cpf.setColumns(10);

        JLabel lblNewLabel_1 = new JLabel("CPF");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_1.setForeground(Color.WHITE);
        lblNewLabel_1.setBounds(10, 11, 33, 19);
        contentPane.add(lblNewLabel_1);

        JLabel lblDigiteSuaProfissao = new JLabel("Data de nascimento");
        lblDigiteSuaProfissao.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblDigiteSuaProfissao.setForeground(Color.WHITE);
        lblDigiteSuaProfissao.setBounds(10, 80, 149, 26);
        contentPane.add(lblDigiteSuaProfissao);

        tf_email = new JTextField();
        tf_email.setColumns(10);
        tf_email.setBounds(135, 122, 232, 20);
        contentPane.add(tf_email);

        JLabel lblDigiteSeuTelefone = new JLabel("Digite seu telefone");
        lblDigiteSeuTelefone.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblDigiteSeuTelefone.setForeground(Color.WHITE);
        lblDigiteSeuTelefone.setBounds(10, 154, 127, 26);
        contentPane.add(lblDigiteSeuTelefone);

        tf_telefone = new JFormattedTextField(GerenciamentoPedido.Mascara("(##) #####-####"));
        tf_telefone.setColumns(10);
        tf_telefone.setBounds(145, 159, 232, 20);
        contentPane.add(tf_telefone);

        JLabel lblEscolhaODestino = new JLabel("ESCOLHA O DESTINO DOS DADOS");
        lblEscolhaODestino.setFont(new Font("Tw Cen MT", Font.BOLD, 19));
        lblEscolhaODestino.setForeground(Color.WHITE);
        lblEscolhaODestino.setBounds(109, 336, 290, 26);
        contentPane.add(lblEscolhaODestino);

        JLabel lblDigiteSuaProfissao_1 = new JLabel("Digite seu email");
        lblDigiteSuaProfissao_1.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblDigiteSuaProfissao_1.setForeground(Color.WHITE);
        lblDigiteSuaProfissao_1.setBounds(10, 117, 119, 26);
        contentPane.add(lblDigiteSuaProfissao_1);

        tf_data_nascimento = new JFormattedTextField(GerenciamentoPedido.Mascara("##/##/####"));
        tf_data_nascimento.setColumns(10);
        tf_data_nascimento.setBounds(168, 85, 157, 20);
        contentPane.add(tf_data_nascimento);

        JButton btn_cadastrar = new JButton("Cadastrar");
        btn_cadastrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                cliente.setCpf(tf_cpf.getText());
                cliente.setNome(tf_nome.getText());
                cliente.setDatanascimento(tf_data_nascimento.getText(), false);
                cliente.setEmail(tf_email.getText());
                cliente.setTelefone(tf_telefone.getText());

                if (cliente.getCpf().equals("")
                        || cliente.getNome().equals("")
                        || cliente.getDatanascimento(false).equals("")
                        || cliente.getEmail().equals("")
                        || cliente.getTelefone().equals("")) {
                    JOptionPane.showMessageDialog(null, "Todos os campos são obrigatórios!");
                } else {
                    ClienteDAO.insereCliente(cliente);

                    // Limpar campos após o cadastro
                    tf_cpf.setText("");
                    tf_nome.setText("");
                    tf_data_nascimento.setText("");
                    tf_email.setText("");
                    tf_telefone.setText("");
                    JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!");
                }
            }
        });
        btn_cadastrar.setBounds(10, 434, 119, 23);
        contentPane.add(btn_cadastrar);

        JButton btn_Excluir = new JButton("Excluir");
        btn_Excluir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
    
                    
                cliente.setCpf(tf_cpf.getText());

            if (tf_cpf.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Informe o CPF do cliente a ser excluído.");
            } else {
                int resposta = JOptionPane.showConfirmDialog(null, "Tem certeza de que deseja excluir este cliente?", "Confirmação", JOptionPane.YES_NO_OPTION);
                if (resposta == JOptionPane.YES_OPTION) {
                    ClienteDAO.deletaCliente(cliente);
                    JOptionPane.showMessageDialog(null, "Cliente excluído!");

                    // Limpar os campos após a exclusão
                    tf_cpf.setText("");
                    tf_nome.setText("");
                    tf_data_nascimento.setText("");
                    tf_email.setText("");
                    tf_telefone.setText(""); // Limpe o campo de telefone
                }
            }
        }
    });

        btn_Excluir.setBounds(383, 434, 89, 23);
        contentPane.add(btn_Excluir);

        JButton btn_atualizar = new JButton("Atualizar");
        btn_atualizar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
    
                String novoCpf = tf_cpf.getText();
                String novoNome = tf_nome.getText();
                String novoData_nascimento = tf_data_nascimento.getText();
                String novoEmail = tf_email.getText();
                String novoTelefone = tf_telefone.getText();
                cliente.setCpf(tf_cpf.getText());
    
        
                if (novoCpf.isEmpty()
                    || novoNome.isEmpty()
                    || cliente.getDatanascimento(false).equals("")
                    || novoEmail.isEmpty()
                    || novoTelefone.isEmpty()){
                    JOptionPane.showMessageDialog(null, "Todos os campos são obrigatórios!");
                } else {

                    // Atualize os valores no objeto "cliente"
    
                    cliente.setCpf(novoCpf);
                    cliente.setNome(novoNome);
                    cliente.setDatanascimento(novoData_nascimento, false);
                    cliente.setEmail(novoEmail);
                    cliente.setTelefone(novoTelefone);
        
                    ClienteDAO.atualizaCliente(cliente);
    
                    tf_cpf.setText("");
                    tf_nome.setText("");
                    tf_data_nascimento.setText("");
                    tf_email.setText("");
                    tf_telefone.setText("");
        
                    JOptionPane.showMessageDialog(null, "Atualização realizada com sucesso!");
                }
            }
        });

        btn_atualizar.setBounds(262, 434, 89, 23);
        contentPane.add(btn_atualizar);

        JButton btn_buscar = new JButton("Buscar");
        btn_buscar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
    
                cliente.setCpf(tf_cpf.getText());

                cliente = ClienteDAO.buscaCliente(cliente.getCpf());
                
                tf_nome.setText(cliente.getNome());
                tf_data_nascimento.setText(cliente.getDatanascimento(false));
                tf_email.setText(cliente.getEmail());
                tf_telefone.setText(cliente.getTelefone());
            }
        });
        btn_buscar.setBounds(151, 434, 89, 23);
        contentPane.add(btn_buscar);
    }
}