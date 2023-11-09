package DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import ENTIDADES.Fornecedor;
import ENTIDADES.Produto;
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
    public ArrayList<Produtofornecedor>pesquisaRelatorio(String cnpjs,String nomesfornecedor,String telefones,String estados,String cidades,String cods,String nomesprod,String marcas,int quantmin,int quantmax){
        ArrayList<Produtofornecedor> pr = new ArrayList<Produtofornecedor>();
        String sql = "SELECT fornecedor.*, produto.* FROM produtofornecedor JOIN produto ON produto_cod = cod JOIN fornecedor ON fornecedor_cnpj = cnpj WHERE ";
        if(!cnpjs.equals("")){
            cnpjs = "fornecedor.cnpj IN("+converteCNPJ(cnpjs)+") AND ";
        }
        if(!nomesfornecedor.equals("")){
            nomesfornecedor = likeXorY(nomesfornecedor, "fornecedor.razaosocial")+" AND ";
        }
        if(!telefones.equals("")){
            telefones = "fornecedor.telefone IN("+telefones+") AND ";
        }
        if(!estados.equals("")){
            estados = likeXorY(estados, "fornecedor.estado")+" AND ";
        }
        if(!cidades.equals("")){
            cidades = likeXorY(cidades, "fornecedor.cidade")+" AND ";
        }
        if(!cods.equals("")){
            cods = "AND produto.cod IN("+converteCNPJ(cods)+")"+" AND ";
        }
        if(!nomesprod.equals("")){
            nomesprod = likeXorY(nomesprod,"produto.descricao")+" AND ";
        }
        if(!marcas.equals("")){
            marcas = likeXorY(marcas, "produto.marca")+" AND ";
        }
        String quantminstr = "produto.quantidadeestoque >= "+quantmin;       
        if(quantmax!=0){
            quantminstr+=" AND produto.quantidadeestoque <= "+quantmax; 
        }
        sql +=cnpjs+nomesfornecedor+telefones+estados+cidades+cods+nomesprod+marcas+quantminstr;
        try {
            System.out.println(sql);
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                pr.add(new Produtofornecedor(new Produto(rs.getString(12), rs.getString(13), rs.getString(14), rs.getDouble(15), rs.getInt(16)), new Fornecedor(rs.getString(1), rs.getString(2), rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11))));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return pr;
    }
    public String converteCNPJ(String cnpjs){
        String[] aux = cnpjs.split(",");
        cnpjs = "";
        for (int i = 0;i<aux.length;i++) {
            if(i==0){
                cnpjs+="'"+aux[i]+"'";
            }else{
                cnpjs+=",'"+aux[i]+"'";
            }
        }
        return cnpjs;
    }
    public String likeXorY(String names,String tablenamedotcolumn){
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
