package DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import ENTIDADES.Produtofornecedor;

public class ProdutofornecedorDAO {
    private static Connection con;
    private static ResultSet rs;
    private static PreparedStatement ps;
    public static void start(Connection conn){
        con = conn;
    }
    public static int insere(Produtofornecedor produtofornecedor){
            /*
                /*
    * CREATE TABLE IF NOT EXISTS `outlet`.`produtofornecedor` (
  `produto_cod` INT NOT NULL,
  `fornecedor_cnpj` CHAR(18) NOT NULL,
  PRIMARY KEY (`produto_cod`, `fornecedor_cnpj`),
  INDEX `fk_produtofornecedor_fornecedor1_idx` (`fornecedor_cnpj` ASC),
  CONSTRAINT `fk_produtofornecedor_produto1`
    FOREIGN KEY (`produto_cod`)
    REFERENCES `outlet`.`produto` (`cod`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_produtofornecedor_fornecedor1`
    FOREIGN KEY (`fornecedor_cnpj`)
    REFERENCES `outlet`.`fornecedor` (`cnpj`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

    */
        int vl = 0;
        try {
            String sql = "INSERT INTO produtofornecedor(produto_cod,fornecedor_cnpj) values (?,?)";
            ps = con.prepareStatement(sql);
            ps.setString(1, produtofornecedor.getProduto_cod());
            ps.setString(2, produtofornecedor.getFornecedor_cnpj());
            vl += ps.executeUpdate();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir produto!\n"+ e.getMessage());
        }
        return vl;
    }
    public static int deleta(Produtofornecedor produtofornecedor){
        int vl = 0;
        try {
            String sql = "DELETE FROM produtofornecedor WHERE produto_cod = ? and fornecedor_cnpj = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1,produtofornecedor.getProduto_cod());
            ps.setString(2, produtofornecedor.getFornecedor_cnpj());            
            vl += ps.executeUpdate();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao deletar item do fornecedor!\n"+ e.getMessage());
        }
        return vl;
    }
    public static int atualiza(Produtofornecedor produtofornecedor){
        int vl = 0;
        try {
            String sql = "UPDATE produtofornecedor SET produto_cod=?,fornecedor_cnpj=?) WHERE produto_cod=? and fornecedor_cnpj=?";
            ps = con.prepareStatement(sql);
            ps.setString(1, produtofornecedor.getProduto_cod());
            ps.setString(2, produtofornecedor.getFornecedor_cnpj());
            ps.setString(3, produtofornecedor.getProduto_cod());
            ps.setString(4, produtofornecedor.getFornecedor_cnpj());
            vl += ps.executeUpdate();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir produto!\n"+ e.getMessage());
        }
        return vl;
    }
    public static List<Produtofornecedor> buscaProdutosDoFornecedor(String cnpj){
        Produtofornecedor prod = new Produtofornecedor();
        ArrayList<Produtofornecedor> ls = new ArrayList<Produtofornecedor>();
        try {
            String sql = "SELECT produto_cod,fornecedor_cnpj FROM produtofornecedor where fornecedor_cnpj =?";
            ps = con.prepareStatement(sql);
            ps.setString(1, cnpj);
            rs = ps.executeQuery();
            while(rs.next()){
                prod.setFornecedor_cnpj(rs.getString("fornecedor_cnpj"));
                prod.setProduto_cod(rs.getString("produto_cod"));
                ls.add(prod);
            }
            prod.setFornecedor_cnpj(null);
            prod.setProduto_cod(null);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar produtos do fornecedor!\n"+ e.getMessage());
        }
        return ls.subList(0, ls.size());
    }
    public static List<Produtofornecedor> buscaVendedoresDoProduto(String cod){
        Produtofornecedor prod = new Produtofornecedor();
        ArrayList<Produtofornecedor> ls = new ArrayList<Produtofornecedor>();
        try {
            String sql = "SELECT produto_cod,fornecedor_cnpj FROM produtofornecedor where produto_cod =?";
            ps = con.prepareStatement(sql);
            ps.setString(1, cod);
            rs = ps.executeQuery();
            while(rs.next()){
                prod.setFornecedor_cnpj(rs.getString("fornecedor_cnpj"));
                prod.setProduto_cod(rs.getString("produto_cod"));
                ls.add(prod);
            }
            prod.setFornecedor_cnpj(null);
            prod.setProduto_cod(null);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar produtos do fornecedor!\n"+ e.getMessage());
        }
        return ls.subList(0, ls.size());
    }
}
