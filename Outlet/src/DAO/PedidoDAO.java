package DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import ENTIDADES.Pedido;

public class PedidoDAO {
    private static Connection con;
    private static ResultSet rs;
    private static PreparedStatement ps;
    public static void start(Connection conn){
        con = conn;
    }
    public static int insere(Pedido pedido){
         /*-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `outlet`.`pedido` (
  `id` INT NOT NULL,
  `data` DATETIME NOT NULL,
  `cliente_cpf` CHAR(14) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_pedido_cliente_idx` (`cliente_cpf` ASC),
  CONSTRAINT `fk_pedido_cliente`
    FOREIGN KEY (`cliente_cpf`)
    REFERENCES `outlet`.`cliente` (`cpf`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB; */
        int vl = 0;
        try {
            String sql = "INSERT INTO pedido(id,data,cliente_cpf) values (?,?,?)";
            ps = con.prepareStatement(sql);
            ps.setString(1,pedido.getId());
            ps.setString(2,pedido.getData(true));
            ps.setString(3,pedido.getCliente_cpf());
            vl += ps.executeUpdate();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir pedido!\n"+ e.getMessage());
        }
        return vl;
    }
    public static int deleta(Pedido pedido){
        int vl = 0;
        try {
            String sql = "DELETE FROM pedido WHERE id = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1,pedido.getId());
            vl += ps.executeUpdate();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao deletar pedido!\n"+ e.getMessage());
        }
        return vl;
    }
    public static int atualiza(Pedido pedido){
        int vl = 0;
        try {
            String sql = "UPDATE pedido SET data=?,cliente_cpf=? WHERE id =?";
            ps = con.prepareStatement(sql);
            
            ps.setString(1,pedido.getData(true));
            ps.setString(2,pedido.getCliente_cpf());
            ps.setString(3, pedido.getId());
            vl += ps.executeUpdate();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar pedido!\n"+ e.getMessage());
        }
        return vl;
    }
    public static Pedido buscaClienteDoPedido(String id){
        Pedido pedido = new Pedido();
        try {
            String sql = "select id,data,cliente_cpf from pedido where id = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, id);
            rs = ps.executeQuery();
            while(rs.next()){
                pedido.setCliente_cpf(rs.getString("cliente_cpf"));
                pedido.setData(rs.getString("data"), true);
                pedido.setId(rs.getString("id"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar pedido!\n"+ e.getMessage());
        }
        return pedido;
        
    }
    public static Pedido buscaPedidosDoCliente(String cpf){
        Pedido pedido = new Pedido();
        try {
            String sql = "SELECT id,data,cliente_cpf FROM pedido WHERE cliente_cpf = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, cpf);
            rs = ps.executeQuery();
            while(rs.next()){
                pedido.setCliente_cpf(rs.getString("cliente_cpf"));
                pedido.setData(rs.getString("data"), true);
                pedido.setId(rs.getString("id"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar pedido!\n"+ e.getMessage());
        }
        return pedido;
        
    }
    
}