package DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import ENTIDADES.Venda;

public class VendaDAO {
    private static Connection con;
    private static ResultSet rs;
    private static PreparedStatement ps;
    public static void start(Connection conn){
        con = conn;
    }
   /*
     public static int insere(Pedido pedido){
        String sql = "SELECT numero FROM venda ORDER BY numero DESC LIMIT 1";
        int num =1;
        int vl = 0;
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                num+= rs.getInt(1);
            }
            sql = "INSERT INTO venda(numero,data,formapagamento,total,pedido_id) values(?,CURRENT_TIMESTAMP,?,?,?)";
            ps = con.prepareStatement(sql);
            ps.setString(1, ""+num);
            ps.setString(2, venda.getFormapagamento());
            ps.setDouble(3, venda.getTotal());
            ps.setString(4, venda.getPedido_id());

            vl = ps.executeUpdate();
        } catch (SQLException e) {
           JOptionPane.showMessageDialog(null, "Erro ao inserir venda!\n"+ e.getMessage());
        }
        return vl;
    }
    */
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
            String sql = "INSERT INTO venda(numero,data,formapagamento,total,pedido_id) values(?,CURRENT_TIMESTAMP,?,?,?)";
            ps = con.prepareStatement(sql);
            ps.setString(1, venda.getNumero());            
            ps.setString(2, venda.getFormapagamento());
            ps.setDouble(3, venda.getTotal());
            ps.setString(4, venda.getPedido_id());
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
    public static int proxIdDisponivel(){
        int id = 1;
        String query="SELECT numero FROM venda ORDER BY numero DESC LIMIT 1";
        try {
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                id+=rs.getInt(1);
            }
        } catch (SQLException e) {
          JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return id;
    }
    public static ArrayList<Venda> relatorioVenda(String ids,String cpfs,String formaspgmnt,String datamin,String datamax,double totalmin,double totalmax){
        ArrayList<Venda> vn = new ArrayList<Venda>();
        String sql = "SELECT venda.numero, pedido.cliente_cpf, venda.formapagamento, venda.data, venda.total FROM venda JOIN pedido ON venda.pedido_id = pedido.id WHERE";
        if(!ids.equals("")){
            ids = " numero IN ("+ids+") AND ";
        }
        if(!cpfs.equals("")){
            cpfs = " pedido.cliente_cpf IN("+converteCPF(cpfs)+") AND ";
        }
        if(!formaspgmnt.equals("")){
            formaspgmnt = likeXorY(formaspgmnt, "venda.formapagamento");
        }
        if(!datamin.equals("")){
            datamin = " venda.data >="+datamin+" AND ";
        }
        
        if(!datamax.equals("")){
            datamin+= " venda.data <="+datamax+" AND ";
        }
        String total = " venda.total >= "+totalmin;
        if(totalmax>0){
            total+= " AND venda.total <= "+totalmax;
        }
        sql += ids+cpfs+formaspgmnt+datamin+total;
        System.out.println(sql);
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                vn.add(new Venda(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDouble(5)));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
        return vn;
    }
    private static String converteCPF(String cpfs){
        String[] aux = cpfs.split(",");
        cpfs = "";
        for (int i = 0; i<aux.length;i++) {
            if(i==aux.length-1){
                cpfs+="'"+aux[i]+"'";
            }else{
                cpfs+="'"+aux[i]+"', ";
            }
        }
        return cpfs;
    }
    public static String likeXorY(String names,String tablenamedotcolumn){
        String[]aux = names.split(",");
        int tamanho = aux.length;
        names = "";
        for(int i = 0;i<tamanho;i++){
            if(i==tamanho-1){
                names+=tablenamedotcolumn+" LIKE '"+ aux[i]+"' ";
            }else{
                names+=tablenamedotcolumn+" LIKE '"+ aux[i]+"' OR ";
            }
        }
        return names;
    }
}
