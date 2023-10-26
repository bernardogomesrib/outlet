package DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import ENTIDADES.Itempedido;
import ENTIDADES.Produto;

public class ItempedidoDAO {
    private static Connection con;
    private static ResultSet rs;
    private static PreparedStatement ps;
    public static void start(Connection conn){
        con = conn;
    }
    public static int insere(Itempedido itempedido){
          /*
     * CREATE TABLE IF NOT EXISTS `outlet`.`itempedido` (
  `pedido_id` INT NOT NULL,
  `produto_cod` INT NOT NULL,
  `quantidade` INT NOT NULL,
  `valor` DECIMAL(8,2) NOT NULL,
  `subtotal` DECIMAL(10,2) NOT NULL,
  INDEX `fk_itempedido_pedido1_idx` (`pedido_id` ASC),
  INDEX `fk_itempedido_produto1_idx` (`produto_cod` ASC),
  PRIMARY KEY (`pedido_id`, `produto_cod`),
  CONSTRAINT `fk_itempedido_pedido1`
    FOREIGN KEY (`pedido_id`)
    REFERENCES `outlet`.`pedido` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_itempedido_produto1`
    FOREIGN KEY (`produto_cod`)
    REFERENCES `outlet`.`produto` (`cod`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;
     */
        int vl = 0;
        try {
            String sql = "INSERT INTO itempedido(pedido_id,produto_cod,quantidade,valor,subtotal) values(?,?,?,?,?)";
            ps = con.prepareStatement(sql);
            ps.setString(1,itempedido.getPedido_id());
            ps.setString(2,itempedido.getProduto_cod());
            ps.setInt(3,itempedido.getQuantidade());
            ps.setDouble(4,itempedido.getValor());
            ps.setDouble(5,itempedido.getSubtotal());
            vl += ps.executeUpdate();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir item do pedido!\n"+ e.getMessage());
        }        
        return vl;
    }
    public static int deleta(Itempedido itempedido){
        int vl = 0;
        try {
            String sql = "DELETE FROM itempedido WHERE pedido_id = ? and produto_cod = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1,itempedido.getPedido_id());
            ps.setString(2, itempedido.getProduto_cod());            
            vl += ps.executeUpdate();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao deletar item do pedido!\n"+ e.getMessage());
        }
        return vl;
    }
    public static int atualiza(Itempedido itempedido){
        int vl = 0;
        try {
            String sql = "UPDATE itempedido SET quantidade=?,valor=?,subtotal=? WHERE pedido_id = ? and produto_cod=?";
            ps = con.prepareStatement(sql);
            ps.setInt(1,itempedido.getQuantidade());
            ps.setDouble(2,itempedido.getValor());
            ps.setDouble(3,itempedido.getSubtotal());
            ps.setString(4,itempedido.getPedido_id());
            ps.setString(5,itempedido.getProduto_cod());
            vl += ps.executeUpdate();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir item do pedido!\n"+ e.getMessage());
        }
        return vl;
    }
    public static ArrayList<Itempedido> buscaItensDoPedido(String id){
        
        ArrayList<Itempedido> ls = new ArrayList<Itempedido>();
        try {
            String sql ="SELECT pedido_id,produto_cod,quantidade,valor,subtotal FROM itempedido where pedido_id = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1,id);            
            rs = ps.executeQuery();
            while(rs.next()){
                ls.add(new Itempedido(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getDouble(4), rs.getDouble(5)));
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar itens do pedido!\n"+ e.getMessage());
        }

        return ls;
    }
    public static List<Itempedido> buscaPedidosDoItem(String id){
        Itempedido it = new Itempedido();
        ArrayList<Itempedido> ls = new ArrayList<Itempedido>();
        try {
            String sql ="SELECT pedido_id,produto_cod,quantidade,valor,subtotal FROM itempedido where produto_cod = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1,id);            
            rs = ps.executeQuery();
            while(rs.next()){
                it.setPedido_id(rs.getString("pedido_id"));
                it.setProduto_cod(rs.getString("produto_cod"));
                it.setQuantidade(rs.getInt("quantidade"));
                it.setValor(rs.getDouble("valor"));
                it.setSubtotal(rs.getDouble("subtotal"));
                ls.add(it);
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar itens do pedido!\n"+ e.getMessage());
        }

        return ls.subList(0, ls.size());
    }
    public static int colocarvarios(ArrayList<Itempedido> itens,ArrayList<Produto> produtos){
        String sql = "INSERT INTO itempedido(pedido_id,produto_cod,quantidade,valor,subtotal) values";
        Itempedido item = null;
        int val = 0;
        int tamanho =itens.size();
        for(int i= 0;i<tamanho;i++){
            item = itens.get(i);
            if(i == tamanho-1){
                System.out.println(item.getValor());
                sql+="("+item.getPedido_id()+","+item.getProduto_cod()+","+item.getQuantidade()+",'"+produtos.get(i).getPreco()+"','"+item.getSubtotal()+"')";
            }else{
                sql+="("+item.getPedido_id()+","+item.getProduto_cod()+","+item.getQuantidade()+",'"+produtos.get(i).getPreco()+"','"+item.getSubtotal()+"'),";
            }
        }
        try {
            ps = con.prepareStatement(sql);
            val = ps.executeUpdate();
        } catch (SQLException e) {
           JOptionPane.showMessageDialog(null, "Erro ao inserir item do pedidos!\n"+ e.getMessage());
        }

        return val;
    }
}
