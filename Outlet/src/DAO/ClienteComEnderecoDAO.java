package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import ENTIDADES.Cliente;
import ENTIDADES.ClienteComEndereco;
import ENTIDADES.Endereco;

public class ClienteComEnderecoDAO {
    private static Connection con;
    private static PreparedStatement stmt;
    private static ResultSet rs;
    public static void start(Connection conn){
        con = conn;
    }
    public static ArrayList<ClienteComEndereco> buscar(String cidade,String estado){
        String query = "";
        ArrayList<ClienteComEndereco> ls = new ArrayList<ClienteComEndereco>();
        if (cidade.equals("") && estado.equals("Selecione")) {
            query = "SELECT cliente.*, endereco.* FROM cliente INNER JOIN endereco ON cliente.cpf = endereco.cliente_cpf";
        } else if (!cidade.equals("") && estado.equals("Selecione")) {
            query = "SELECT cliente.*, endereco.* FROM cliente INNER JOIN endereco ON cliente.cpf = endereco.cliente_cpf WHERE endereco.cidade = '" + cidade + "'";
        } else if (!cidade.equals("") && !estado.equals("Selecione")) {
            query = "SELECT cliente.*, endereco.* FROM cliente INNER JOIN endereco ON cliente.cpf = endereco.cliente_cpf WHERE endereco.cidade = '" + cidade + "' AND endereco.estado = '" + estado + "'";
        }else{
            query = "SELECT cliente.*, endereco.* FROM cliente INNER JOIN endereco ON cliente.cpf = endereco.cliente_cpf";
        }
        try {
            stmt = con.prepareStatement(query);
            rs = stmt.executeQuery();
            while (rs.next()) {
               ls.add(new ClienteComEndereco(new Cliente(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)), new Endereco(rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12),rs.getString(13),rs.getString(14))));
            }
        } catch (SQLException e) {          
            JOptionPane.showMessageDialog(null,"algo de errado aconteceu"+e.getMessage());
        }
        return ls;
    }
}
