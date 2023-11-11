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
    public static ArrayList<Fornecedor>consultaFornecedores(String cnpjs,String razao,String telefone, String logradouro, String numero,String complemento,String bairro,String cidade,String estado,String cep){
        ArrayList<Fornecedor>fr = new ArrayList<>();
        String sql = "SELECT * FROM fornecedor WHERE ";
        if(!cnpjs.equals("")){
            cnpjs = "  cnpj in ("+converteCPF(cnpjs)+") AND ";
        }
        if(!razao.equals("")){
            razao = likeXorY(razao," razaosocial")+" AND ";
        }
        if(!telefone.equals("")){
            telefone = " telefone in ("+converteCPF(telefone)+") AND ";
        }
        if(!logradouro.equals("")){
            logradouro = likeXorY(logradouro, " logradouro")+" AND ";
        }
        if(!numero.equals("")){
            numero = " numero in("+converteCPF(numero)+") AND";
        }
        if(!complemento.equals("")){
            complemento = likeXorY(complemento, " complemento")+" AND ";
        }
        if(!bairro.equals("")){
            bairro = likeXorY(bairro, " bairro")+" AND ";
        }
        if(!cidade.equals("")){
            cidade = likeXorY(cidade, " cidade")+" AND ";
        }
        if(!estado.equals("")){
            estado = likeXorY(estado, " estado")+" AND ";
        }
        if(!cep.equals("")){
            cep = " cep in ("+converteCPF(cep)+") AND ";
        }
        sql +=cnpjs+razao+telefone+logradouro+numero+complemento+bairro+cidade+estado+cep+" 1=1 " ;
       
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                fr.add(new Fornecedor(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11)));
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
        return fr;
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
