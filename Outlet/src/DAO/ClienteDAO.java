package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import ENTIDADES.Cliente;

public class ClienteDAO {
    private static Connection con;
    private static ResultSet rs;
    private static PreparedStatement ps;
    public static void start(Connection conn){
        con = conn;
    }
    public static int insereCliente(Cliente cliente){
         /*  `cpf` CHAR(14) NOT NULL PRIMARY KEY,
        `nome` VARCHAR(100) NOT NULL,
        `datanascimento` DATE NOT NULL,
        `email` VARCHAR(45) NOT NULL UNIQUE,
        `telefone` CHAR(15) NOT NULL */
        int val = 0;
        try {
            String sql = "INSERT INTO cliente(cpf,nome,datanascimento,email,telefone) values(?,?,?,?,?)";
            ps = con.prepareStatement(sql);
            ps.setString(1,cliente.getCpf());
            ps.setString(2,cliente.getNome());
            ps.setString(3,cliente.getDatanascimento(true));
            ps.setString(4,cliente.getEmail());
            ps.setString(5,cliente.getTelefone());
            val += ps.executeUpdate();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir cliente!\n"+ e.getMessage());
        }        
        return val;
    }
    public static int deletaCliente(Cliente cliente) {
        int val = 0;
        try {
            String sql = "DELETE FROM cliente WHERE cpf = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1,cliente.getCpf());            
            val += ps.executeUpdate();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao deletar cliente!\n"+ e.getMessage());
        }        
        return val;
        
    }
    public static int atualizaCliente(Cliente cliente){
        int val = 0;
        try {
            String sql = "UPDATE cliente set nome = ?,datanascimento = ?,email = ?,telefone = ? where cpf = ?";
            ps = con.prepareStatement(sql);            
            ps.setString(1,cliente.getNome());
            ps.setString(2,cliente.getDatanascimento(true));
            ps.setString(3,cliente.getEmail());
            ps.setString(4,cliente.getTelefone());
            ps.setString(5,cliente.getCpf());
            val += ps.executeUpdate();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar cliente!\n"+ e.getMessage());
        }        
        return val;
    }
    public static Cliente buscaCliente(String cpf){
        Cliente cliente = new Cliente();
        
        try {
            String sql = "select cpf,nome,datanascimento,email,telefone from cliente where cpf = ?";
            
            ps = con.prepareStatement(sql);
            ps.setString(1,cpf);
            
            rs = ps.executeQuery();
            while(rs.next()){
                cliente.setCpf(rs.getString("cpf"));
                cliente.setNome(rs.getString("nome"));
                cliente.setDatanascimento(rs.getString("datanascimento"), true);
                cliente.setEmail(rs.getString("email"));
                cliente.setTelefone(rs.getString("telefone"));
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar cliente!\n"+ e.getMessage());
        }
        return cliente;
    }
}
