import DAO.*;

import DATABASE.Conexao;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        Conexao conexao = new Conexao();
        ClienteDAO.start(conexao.getConexao());
        EnderecoDAO.start(conexao.getConexao());
        FornecedorDAO.start(conexao.getConexao());
        ItempedidoDAO.start(conexao.getConexao());
        PedidoDAO.start(conexao.getConexao());
        ProdutoDao.start(conexao.getConexao());
        ProdutofornecedorDAO.start(conexao.getConexao());
        VendaDAO.start(conexao.getConexao());

    }
}
