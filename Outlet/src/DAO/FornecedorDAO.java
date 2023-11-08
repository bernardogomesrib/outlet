package DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import ENTIDADES.Fornecedor;

public class FornecedorDAO {
    private static Connection con;
    private static ResultSet rs;
    private static PreparedStatement ps;
    public static void start(Connection conn){
        con = conn;
    }
    public static int insere(Fornecedor fornecedor){
        /*-- -----------------------------------------------------
-- Table `outlet`.`fornecedor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `outlet`.`fornecedor` (
  `cnpj` CHAR(18) NOT NULL,
  `razaosocial` VARCHAR(100) NOT NULL,
  `email` VARCHAR(80) NOT NULL,
  `telefone` CHAR(15) NOT NULL,
  `logradouro` VARCHAR(80) NOT NULL,
  `numero` VARCHAR(10) NOT NULL,
  `complemento` VARCHAR(45) NULL,
  `bairro` VARCHAR(45) NOT NULL,
  `cidade` VARCHAR(45) NOT NULL,
  `estado` VARCHAR(45) NOT NULL,
  `cep` CHAR(10) NOT NULL,
  PRIMARY KEY (`cnpj`))
ENGINE = InnoDB; */
        int vl = 0;
        
        try {
            String sql = "INSERT INTO fornecedor(cnpj,razaosocial,email,telefone,logradouro,numero,complemento,bairro,cidade,estado,cep) values (?,?,?,?,?,?,?,?,?,?,?)";
            ps = con.prepareStatement(sql);
            ps.setString(1, fornecedor.getCnpj());
            ps.setString(2, fornecedor.getRazaosocial());
            ps.setString(3, fornecedor.getEmail());
            ps.setString(4, fornecedor.getTelefone());
            ps.setString(5, fornecedor.getLogradouro());
            ps.setString(6, fornecedor.getNumero());
            ps.setString(7, fornecedor.getComplemento());
            ps.setString(8, fornecedor.getBairro());
            ps.setString(9, fornecedor.getCidade());
            ps.setString(10, fornecedor.getEstado());
            ps.setString(11, fornecedor.getCep());
            vl += ps.executeUpdate();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir fornecedor!\n"+ e.getMessage());
        }
        return vl;
    }
    public static int deleta(Fornecedor fornecedor){
        int vl = 0;
        try {
            String sql = "DELETE FROM fornecedor WHERE cnpj = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1,fornecedor.getCnpj());            
            vl += ps.executeUpdate();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao deletar fornecedor!\n"+ e.getMessage());
        }        
        return vl;
    }
    public static int atualiza(Fornecedor fornecedor){
        int vl = 0;
        try {
            String sql = "UPDATE fornecedor SET razaosocial=?,email=?,telefone=?,logradouro=?,numero=?,complemento=?,bairro=?,cidade=?,estado=?,cep=? WHERE cnpj = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, fornecedor.getRazaosocial());
            ps.setString(2, fornecedor.getEmail());
            ps.setString(3, fornecedor.getTelefone());
            ps.setString(4, fornecedor.getLogradouro());
            ps.setString(5, fornecedor.getNumero());
            ps.setString(6, fornecedor.getComplemento());
            ps.setString(7, fornecedor.getBairro());
            ps.setString(8, fornecedor.getCidade());
            ps.setString(9, fornecedor.getEstado());
            ps.setString(10, fornecedor.getCep());
            ps.setString(11, fornecedor.getCnpj());
            vl += ps.executeUpdate();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar fornecedor!\n"+ e.getMessage());
        }
        return vl;
    }
    public static Fornecedor buscaFornecedor(String id){
        Fornecedor end = new Fornecedor();
        
        try {
            String sql = "select cnpj,razaosocial,email,telefone,logradouro,numero,complemento,bairro,cidade,estado,cep from fornecedor where cnpj =?";
            
            ps = con.prepareStatement(sql);
            ps.setString(1,id);
            
            rs = ps.executeQuery();
            while(rs.next()){
                end.setCnpj(rs.getString("cnpj"));;
                end.setRazaosocial(rs.getString("razaosocial"));
                end.setEmail(rs.getString("email"));;
                end.setTelefone(rs.getString("telefone"));;
                end.setLogradouro(rs.getString("logradouro"));;
                end.setNumero(rs.getString("numero"));;
                end.setComplemento(rs.getString("complemento"));;
                end.setBairro(rs.getString("bairro"));;
                end.setCidade(rs.getString("cidade"));
                end.setEstado(rs.getString("estado"));
                end.setCep(rs.getString("cep"));
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar fornecedor!\n"+ e.getMessage());
        }
        return end;
        
    }
    public static ArrayList<Fornecedor>buscaFornecedor(String cnpj,String nome){
        String sql = "select cnpj,razaosocial,email,telefone,logradouro,numero,complemento,bairro,cidade,estado,cep from fornecedor ";        
        ArrayList<Fornecedor>fr = new ArrayList<Fornecedor>();
        if(nome.equals("")){
            if(cnpj.equals("")){

            }else{
                nome = "where cnpj = '"+cnpj+"'";
                cnpj = "";
            }
        }else{
            nome = "where razaosocial like '%"+nome+"%'";
        }
        if(!cnpj.equals("")){
            cnpj = " AND cnpj = '"+cnpj+"';";
        }
        sql+=nome+cnpj;
        System.out.println(sql);
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                fr.add(new Fornecedor(rs.getString("cnpj"),rs.getString("razaosocial"),rs.getString("estado")));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
        return fr;
    }
}
