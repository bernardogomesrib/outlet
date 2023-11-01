package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import ENTIDADES.Cliente;
import ENTIDADES.Endereco;

public class EnderecoDAO {
    private static Connection con;
    private static ResultSet rs;
    private static PreparedStatement ps;
    public static void start(Connection conn){
        con = conn;
    }
    public static int insereEndereco(Endereco endereco){
        int val= 0;
        /*`id` INT NOT NULL AUTO_INCREMENT,
        `logradouro` VARCHAR(100) NOT NULL,
        `numero` VARCHAR(10) NOT NULL,
        `complemento` VARCHAR(45) NULL,
        `bairro` VARCHAR(45) NOT NULL,
        `cidade` VARCHAR(45) NOT NULL,
        `estado` VARCHAR(45) NOT NULL,
        `cep` CHAR(10) NOT NULL,
        `cliente_cpf` CHAR(14) NOT NULL, */
        try {
            String sql = "INSERT INTO endereco(logradouro,numero,complemento,bairro,cidade,estado,cep,cliente_cpf) values(?,?,?,?,?,?,?,?)";
            ps = con.prepareStatement(sql);
            ps.setString(1,endereco.getLogradouro());
            ps.setString(2,endereco.getNumero());
            ps.setString(3,endereco.getComplemento());
            ps.setString(4,endereco.getBairro());
            ps.setString(5,endereco.getCidade());
            ps.setString(6,endereco.getEstado());
            ps.setString(7,endereco.getCep());
            ps.setString(8,endereco.getCliente_cpf());
            val += ps.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir endereço!\n"+ e.getMessage());
        }
        return val;
    }
    public static int deletaEndereco(Endereco endereco){
        int val= 0;
        try {
            String sql = "DELETE FROM endereco WHERE id = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1,endereco.getId());
            val += ps.executeUpdate();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao deletar endereço!\n"+ e.getMessage());
        }    
        return val;
    }
     public static int deletaEndereco(Cliente cliente){
        int val= 0;
        try {
            String sql = "DELETE FROM endereco WHERE cliente_cpf = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1,cliente.getCpf());
            val += ps.executeUpdate();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao deletar endereço!\n"+ e.getMessage());
        }    
        return val;
    }
    public static int atualizaEndereco(Endereco endereco){
        int val= 0;
        try {
            String sql = "UPDATE endereco SET logradouro =?,numero=?,complemento=?,bairro=?,cidade=?,estado=?,cep=?,cliente_cpf=? WHERE id =?";
            ps = con.prepareStatement(sql);
            ps.setString(1,endereco.getLogradouro());
            ps.setString(2,endereco.getNumero());
            ps.setString(3,endereco.getComplemento());
            ps.setString(4,endereco.getBairro());
            ps.setString(5,endereco.getCidade());
            ps.setString(6,endereco.getEstado());
            ps.setString(7,endereco.getCep());
            ps.setString(8,endereco.getCliente_cpf());
            ps.setString(9,endereco.getId());
            val += ps.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir endereço!\n"+ e.getMessage());
        }
        return val;
    }
    public static List<Endereco> buscaEnderecosDoCLiente(String cpf){
        ArrayList<Endereco> lst = new ArrayList<Endereco>();
        try {
            String sql = "select * from endereco where cliente_cpf =?";
            
            ps = con.prepareStatement(sql);
            ps.setString(1,cpf);
            
            rs = ps.executeQuery();
            while(rs.next()){
                lst.add(new Endereco(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9)));
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar endereços!\n"+ e.getMessage());
        }
        return lst.subList(0, lst.size());
    }
    
    
    
    
}
