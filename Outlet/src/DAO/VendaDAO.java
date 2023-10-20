package DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import ENTIDADES.Venda;

public class VendaDAO {
    private static Connection con;
    private static ResultSet rs;
    private static PreparedStatement ps;
    public static void start(Connection conn){
        con = conn;
    }
    public static int insere(Venda venda){
         /*private String 
     *  -----------------------------------------------------
-- Table `outlet`.`venda`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `outlet`.`venda` (
  `numero` INT NOT NULL,
  `data` DATETIME NOT NULL,
  `formapagamento` VARCHAR(45) NOT NULL,
  `total` DECIMAL(12,2) NOT NULL,
  `pedido_id` INT NOT NULL,
  PRIMARY KEY (`numero`),
  INDEX `fk_venda_pedido1_idx` (`pedido_id` ASC),
  CONSTRAINT `fk_venda_pedido1`
    FOREIGN KEY (`pedido_id`)
    REFERENCES `outlet`.`pedido` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;
     */
        int vl = 0;
        try {
            String sql = "INSERT INTO venda(numero,data,formapagamento,total,pedido_id) values(?,?,?,?,?)";
            ps = con.prepareStatement(sql);
            ps.setString(1, venda.getNumero());
            ps.setString(2, venda.getData(true));
            ps.setString(3, venda.getFormapagamento());
            ps.setDouble(4, venda.getTotal());
            ps.setString(5, venda.getPedido_id());
            vl += ps.executeUpdate();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir venda!\n"+ e.getMessage());
        }     
        return vl;
    }
    public static int deleta(Venda venda){
        int vl = 0;
        try {
            String sql = "DELETE FROM venda WHERE numero = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1,venda.getNumero());            
            vl += ps.executeUpdate();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao deletar venda!\n"+ e.getMessage());
        }
        return vl;
    }
    public static int atualiza(Venda venda){
        int vl = 0;
        try {
            String sql = "UPDATE venda SET data=?,formapagamento=?,total=?,pedido_id=?) WHERE numero = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, venda.getData(true));
            ps.setString(2, venda.getFormapagamento());
            ps.setDouble(3, venda.getTotal());
            ps.setString(4, venda.getPedido_id());
            ps.setString(5, venda.getNumero());
            vl += ps.executeUpdate();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar venda!\n"+ e.getMessage());
        }
        return vl;
    }
    public static Venda busca(String numero){
        Venda venda = new Venda();
        
        try {
            String sql = "SELECT numero,data,formapagamento,total,pedido_id FROM venda where numero = ?";            
            ps = con.prepareStatement(sql);
            ps.setString(1,numero);
            rs = ps.executeQuery();
            while(rs.next()){
                venda.setData(rs.getString("data"), true);
                venda.setFormapagamento(rs.getString("formapagamento"));
                venda.setNumero(rs.getString("numero"));
                venda.setPedido_id(rs.getString("pedido_id"));
                venda.setTotal(rs.getInt("total"));
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar venda!\n"+ e.getMessage());
        }
        return venda;
    }
}
