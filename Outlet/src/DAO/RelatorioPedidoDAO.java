package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import ENTIDADES.ConsultaPedido;

public class RelatorioPedidoDAO {
    private static Connection con;
    private static PreparedStatement stmt;
    private static ResultSet rs;
    public static void start(Connection conn){
        con = conn;
    }
    public static ArrayList<ConsultaPedido>procura(int pquantmin,int pquantmax,String cpf, String datamin,String datamax,boolean concluidos,int quantidademin,int quantidademax,double subtotalmin,double subtotalmax,String cods,boolean pelomenosum){
        ArrayList<ConsultaPedido>pr = new ArrayList<ConsultaPedido>();
        String query = "SELECT pedido.*, (SELECT SUM(subtotal) FROM itempedido WHERE pedido_id = pedido.id) AS total_compra,(SELECT SUM(quantidade) FROM itempedido WHERE pedido_id = pedido.id) AS quantidade_total,(SELECT COUNT(DISTINCT produto_cod) FROM itempedido WHERE pedido_id = pedido.id) AS produtos_distintos,CASE WHEN EXISTS (SELECT 1 FROM venda WHERE pedido_id = pedido.id) THEN 'Sim' ELSE 'Não' END AS concluido FROM pedido WHERE ";
        
        if(!cods.equals("")){
            if(pelomenosum){
                cods = "EXISTS (SELECT 1 FROM itempedido WHERE pedido_id = pedido.id AND produto_cod IN ("+cods+"))";
            }else{
                cods = "id IN ( SELECT pedido_id FROM itempedido WHERE produto_cod IN ("+cods+") GROUP BY pedido_id HAVING COUNT(DISTINCT produto_cod) = "+cods.split(",").length+")";
            }
        }else{
            cods = "1=1";
        }
        if(!cpf.equals("")){
            cpf = " pedido.cliente_cpf in ("+converteCPF(cpf)+") AND ";
        }
        String data= "";
        if(!datamin.equals("")){
            System.out.println("não era pa ta chegano aqui");
            data= " pedido.data >= '"+ converte(datamin)+"' AND ";
        }else{
            data+="";
        }
        if(!datamax.equals("")){
            data += "pedido.data <= '"+ converte(datamax)+"' AND ";
        }{
            data += "";
        }
        String conc = "";
        if(concluidos){
            conc +="AND concluido = 'Sim' ";
        }
        String quantInd = "";
        
        quantInd=" HAVING produtos_distintos >= '"+pquantmin+"'";
        
        
        if (pquantmax!=0){
            quantInd += "AND produtos_distintos <= '"+pquantmax+"'";
        }

        String subttl=" AND total_compra >='"+subtotalmin+"' ";
       
        if(subtotalmax!=0){
            subttl+= " AND total_compra <= '"+subtotalmax+"' ";
        }
        String totprod = "AND quantidade_total >= '"+quantidademin+"' ";
        if(quantidademax!=0){
            totprod += "AND quantidade_total <='"+quantidademax+"'";
        }
        query += cpf+data+cods+quantInd+conc+totprod+subttl;
        try {
            stmt = con.prepareStatement(query);
            System.out.println(query);
            rs = stmt.executeQuery();
            while(rs.next()){
                pr.add(new ConsultaPedido(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getInt(5), rs.getInt(6),rs.getString(7)));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao procurar produtos! \n "+e.getMessage());
        }
        return pr;
    }
    public static ArrayList<ConsultaPedido>procuraPedidosAbertos(int pquantmin,int pquantmax,String cpf, String datamin,String datamax,int quantidademin,int quantidademax,double subtotalmin,double subtotalmax,String cods,boolean pelomenosum){
        ArrayList<ConsultaPedido>pr = new ArrayList<ConsultaPedido>();
        String query = "SELECT pedido.*, (SELECT SUM(subtotal) FROM itempedido WHERE pedido_id = pedido.id) AS total_compra,(SELECT SUM(quantidade) FROM itempedido WHERE pedido_id = pedido.id) AS quantidade_total,(SELECT COUNT(DISTINCT produto_cod) FROM itempedido WHERE pedido_id = pedido.id) AS produtos_distintos,CASE WHEN EXISTS (SELECT 1 FROM venda WHERE pedido_id = pedido.id) THEN 'Sim' ELSE 'Não' END AS concluido FROM pedido WHERE ";
        
        if(!cods.equals("")){
            if(pelomenosum){
                cods = "EXISTS (SELECT 1 FROM itempedido WHERE pedido_id = pedido.id AND produto_cod IN ("+cods+"))";
            }else{
                cods = "id IN ( SELECT pedido_id FROM itempedido WHERE produto_cod IN ("+cods+") GROUP BY pedido_id HAVING COUNT(DISTINCT produto_cod) = "+cods.split(",").length+")";
            }
        }else{
            cods = "1=1";
        }
        if(!cpf.equals("")){
            cpf = " pedido.cliente_cpf in ("+converteCPF(cpf)+") AND ";
        }
        String data= "";
        if(!datamin.equals("")){
            System.out.println("não era pa ta chegano aqui");
            data= " pedido.data >= '"+ converte(datamin)+"' AND ";
        }else{
            data+="";
        }
        if(!datamax.equals("")){
            data += "pedido.data <= '"+ converte(datamax)+"' AND ";
        }{
            data += "";
        }

        String conc = "AND concluido = 'Não' ";
               
        String quantInd = "";
        
        quantInd=" HAVING produtos_distintos >= '"+pquantmin+"'";
        
        if (pquantmax!=0){
            quantInd += "AND produtos_distintos <= '"+pquantmax+"'";
        }

        String subttl=" AND total_compra >='"+subtotalmin+"' ";
       
        if(subtotalmax!=0){
            subttl+= " AND total_compra <= '"+subtotalmax+"' ";
        }
        String totprod = "AND quantidade_total >= '"+quantidademin+"' ";
        if(quantidademax!=0){
            totprod += "AND quantidade_total <='"+quantidademax+"'";
        }
        query += cpf+data+cods+quantInd+conc+totprod+subttl;
        try {
            stmt = con.prepareStatement(query);
            System.out.println(query);
            rs = stmt.executeQuery();
            while(rs.next()){
                pr.add(new ConsultaPedido(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getInt(5), rs.getInt(6),rs.getString(7)));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao procurar produtos! \n "+e.getMessage());
        }
        return pr;
    }
    public static String converte(String data){
        System.out.println(data);
        String[] aux = data.split("/");
        for (String string : aux) {
            System.out.println(string);
        }
        data = aux[2]+"-"+aux[1]+"-"+aux[0];
        return data;
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
}
