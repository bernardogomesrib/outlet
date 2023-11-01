package DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import ENTIDADES.Itempedido;
import ENTIDADES.Produto;

public class ProdutoDao {
    private static Connection con;
    private static ResultSet rs;
    private static PreparedStatement ps;
    public static void start(Connection conn){
        con = conn;
    }
    public static int insereProduto(Produto produto){
         /*-- -----------------------------------------------------
        -- Table `outlet`.`produto`
        -- -----------------------------------------------------
        CREATE TABLE IF NOT EXISTS `outlet`.`produto` (
        `cod` INT NOT NULL,
        `descricao` VARCHAR(100) NOT NULL,
        `marca` VARCHAR(45) NULL,
        `preco` DECIMAL(8,2) NOT NULL,
        `quantidadeestoque` INT NOT NULL,
        PRIMARY KEY (`cod`))
        ENGINE = InnoDB; */
        int vl = 0;
        try {
            String sql = "INSERT INTO produto(cod,descricao,marca,preco,quantidadeestoque) values (?,?,?,?,?)";
            ps = con.prepareStatement(sql);
            ps.setString(1,produto.getCod());
            ps.setString(2,produto.getDescricao());
            ps.setString(3,produto.getMarca());
            ps.setDouble(4,produto.getPreco());
            ps.setInt(5, produto.getQuantidadeestoque());
            
            vl += ps.executeUpdate();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir produto!\n"+ e.getMessage());
        }
        return vl;
    }
    public static int deleta(Produto produto){
        int vl = 0;
        try {
            String sql = "DELETE FROM produto WHERE cod = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1,produto.getCod());            
            vl += ps.executeUpdate();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao deletar produto!\n"+ e.getMessage());
        }
        return vl;
    }
    public static int atualiza(Produto produto){
        int vl = 0;
        try {
            String sql = "UPDATE produto SET descricao=?,marca=?,preco=?,quantidadeestoque=? WHERE cod = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1,produto.getDescricao());
            ps.setString(2,produto.getMarca());            
            ps.setDouble(3,produto.getPreco());
            ps.setInt(4, produto.getQuantidadeestoque());
            ps.setString(5,produto.getCod());
            
            vl += ps.executeUpdate();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir produto!\n"+ e.getMessage());
        }
        return vl;
    }
    public static Produto busca(String cod){
        Produto produto = new Produto();
        
        try {
            String sql =  "SELECT cod,descricao,marca,preco,quantidadeestoque FROM produto WHERE cod = ?";
            
            ps = con.prepareStatement(sql);
            ps.setString(1,cod);
            rs = ps.executeQuery();
            while(rs.next()){
                produto.setCod(rs.getString("cod"));
                produto.setDescricao(rs.getString("descricao"));
                produto.setMarca(rs.getString("marca"));
                produto.setPreco(rs.getDouble("preco"));
                produto.setQuantidadeestoque(rs.getInt("quantidadeestoque"));
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar Produto!\n"+ e.getMessage());
        }
        return produto;
    }
    public static ArrayList<Produto>procuraProdutos(String cod,String descricao,boolean descricaoExata,String marca,boolean marcaExata,double precomin,double precomax,int quantmin,int quantmax){
        ArrayList<Produto>pr = new ArrayList<Produto>();
        String query = "SELECT * FROM produto WHERE";
        if (!cod.equals("")) {
            cod =" cod = "+cod+" AND ";
        }
        if(!descricao.equals("")){
            if(descricaoExata){
                descricao = " descricao = '"+descricao+"' AND ";
            }else{
                descricao = " descricao LIKE '%"+descricao+"%' AND ";
            }
            
        }
        if(!marca.equals("")){
            if(marcaExata){
                marca = " marca = '"+marca+"' AND ";
            }else{
                marca = " marca LIKE '%"+marca+"%' AND";
            }
            
        }
        String condicaoPreco = " preco >= '"+precomin+"' AND ";
        if (precomax>0) {
            condicaoPreco += " preco <= '"+precomax+"' AND ";
        }
        String condicaoQuantidade = " quantidadeestoque>= '"+quantmin+"' ";
        if(quantmax>0){
            condicaoQuantidade += " AND quantidadeestoque <= '"+quantmax+"' ";
        }

        query += cod+descricao+marca+condicaoPreco+condicaoQuantidade;
         try {
                ps = con.prepareStatement(query);
                rs = ps.executeQuery();
                while(rs.next()){
                    pr.add(new Produto(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getInt(5)));
                }
            } catch (SQLException e) {
               JOptionPane.showMessageDialog(null, "Erro ao procurar produtos! \n "+e.getMessage());
            }
        return pr;
    }
    public static ArrayList<Produto>procuraProdutos(ArrayList<Itempedido>itens){
        ArrayList<Produto>pr = new ArrayList<Produto>();
        String sql = "SELECT * FROM produto WHERE ";
        int tam = itens.size();
        for (int i = 0;i<tam;i++) {
            if(i == tam-1){
                sql+= " cod = '"+itens.get(i).getProduto_cod()+"'";
            }else{
                sql+= " cod = '"+itens.get(i).getProduto_cod()+"' or";
            }
            try {
                ps = con.prepareStatement(sql);
                rs = ps.executeQuery();
                while(rs.next()){
                    pr.add(new Produto(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getInt(5)));
                }


            } catch (SQLException e) {
               //JOptionPane.showMessageDialog(null, "Erro ao procurar produtos! \n "+e.getMessage());
            }
        }
        return pr;
    }

}