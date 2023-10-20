package DATABASE;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Conexao {   
    private static final String url = "jdbc:mysql://localhost:3306/outlet";
    private static final String user = "root";
    private static final String pass = "";

    private static Connection conectar;

    //contrutor da classe, verifica se o objeto conexao é nulo, se sim, estabelece a conexao através do DriverManager, se não, retorna a conexão existente
    public Conexao() {
        try {
            if (conectar == null) {
                PreparedStatement prep;
                conectar = DriverManager.getConnection(url, user, pass);
                System.out.println("Conexão com o banco de dados realizada com sucesso!");
                String sql ="CREATE TABLE IF NOT EXISTS outlet.cliente (cpf CHAR(14) NOT NULL PRIMARY KEY, nome VARCHAR(100) NOT NULL, datanascimento DATE NOT NULL, email VARCHAR(45) NOT NULL UNIQUE, telefone CHAR(15) NOT NULL);";
                prep= conectar.prepareStatement(sql);
                prep.execute();
                sql = "CREATE TABLE IF NOT EXISTS outlet.pedido (id INT NOT NULL, data DATETIME NOT NULL, cliente_cpf CHAR(14) NOT NULL, PRIMARY KEY (id), INDEX fk_pedido_cliente_idx (cliente_cpf ASC), CONSTRAINT fk_pedido_cliente FOREIGN KEY (cliente_cpf) REFERENCES outlet.cliente (cpf) ON DELETE NO ACTION ON UPDATE NO ACTION) ENGINE = InnoDB;";
                prep = conectar.prepareStatement(sql);
                prep.execute();
                sql = "CREATE TABLE IF NOT EXISTS outlet.produto (cod INT NOT NULL, descricao VARCHAR(100) NOT NULL, marca VARCHAR(45) NULL, preco DECIMAL(8,2) NOT NULL, quantidadeestoque INT NOT NULL, PRIMARY KEY (cod)) ENGINE = InnoDB;";
                prep = conectar.prepareStatement(sql);
                prep.execute();
                sql = "CREATE TABLE IF NOT EXISTS outlet.itempedido (pedido_id INT NOT NULL, produto_cod INT NOT NULL, quantidade INT NOT NULL, valor DECIMAL(8,2) NOT NULL, subtotal DECIMAL(10,2) NOT NULL, INDEX fk_itempedido_pedido1_idx (pedido_id ASC), INDEX fk_itempedido_produto1_idx (produto_cod ASC), PRIMARY KEY (pedido_id, produto_cod), CONSTRAINT fk_itempedido_pedido1 FOREIGN KEY (pedido_id) REFERENCES outlet.pedido (id) ON DELETE NO ACTION ON UPDATE NO ACTION, CONSTRAINT fk_itempedido_produto1 FOREIGN KEY (produto_cod) REFERENCES outlet.produto (cod) ON DELETE NO ACTION ON UPDATE NO ACTION) ENGINE = InnoDB;";
                prep = conectar.prepareStatement(sql);
                prep.execute();
                sql = "CREATE TABLE IF NOT EXISTS outlet.endereco (id INT NOT NULL AUTO_INCREMENT, logradouro VARCHAR(100) NOT NULL, numero VARCHAR(10) NOT NULL, complemento VARCHAR(45) NULL, bairro VARCHAR(45) NOT NULL, cidade VARCHAR(45) NOT NULL, estado VARCHAR(45) NOT NULL, cep CHAR(10) NOT NULL, cliente_cpf CHAR(14) NOT NULL, PRIMARY KEY (id), INDEX fk_endereco_cliente1_idx (cliente_cpf ASC), CONSTRAINT fk_endereco_cliente1 FOREIGN KEY (cliente_cpf) REFERENCES outlet.cliente (cpf) ON DELETE NO ACTION ON UPDATE NO ACTION) ENGINE = InnoDB;";
                prep = conectar.prepareStatement(sql);
                prep.execute();
                sql = "CREATE TABLE IF NOT EXISTS outlet.venda (numero INT NOT NULL, data DATETIME NOT NULL, formapagamento VARCHAR(45) NOT NULL, total DECIMAL(12,2) NOT NULL, pedido_id INT NOT NULL, PRIMARY KEY (numero), INDEX fk_venda_pedido1_idx (pedido_id ASC), CONSTRAINT fk_venda_pedido1 FOREIGN KEY (pedido_id) REFERENCES outlet.pedido (id) ON DELETE NO ACTION ON UPDATE NO ACTION) ENGINE = InnoDB;";
                prep = conectar.prepareStatement(sql);
                prep.execute();
                sql = "CREATE TABLE IF NOT EXISTS outlet.fornecedor (cnpj CHAR(18) NOT NULL, razaosocial VARCHAR(100) NOT NULL, email VARCHAR(80) NOT NULL, telefone CHAR(15) NOT NULL, logradouro VARCHAR(80) NOT NULL, numero VARCHAR(10) NOT NULL, complemento VARCHAR(45) NULL, bairro VARCHAR(45) NOT NULL, cidade VARCHAR(45) NOT NULL, estado VARCHAR(45) NOT NULL, cep CHAR(10) NOT NULL, PRIMARY KEY (cnpj)) ENGINE = InnoDB;";
                prep = conectar.prepareStatement(sql);
                prep.execute();
                sql = "CREATE TABLE IF NOT EXISTS outlet.produtofornecedor (produto_cod INT NOT NULL, fornecedor_cnpj CHAR(18) NOT NULL, PRIMARY KEY (produto_cod, fornecedor_cnpj), INDEX fk_produtofornecedor_fornecedor1_idx (fornecedor_cnpj ASC), CONSTRAINT fk_produtofornecedor_produto1 FOREIGN KEY (produto_cod) REFERENCES outlet.produto (cod) ON DELETE NO ACTION ON UPDATE NO ACTION, CONSTRAINT fk_produtofornecedor_fornecedor1 FOREIGN KEY (fornecedor_cnpj) REFERENCES outlet.fornecedor (cnpj) ON DELETE NO ACTION ON UPDATE NO ACTION) ENGINE = InnoDB; ";
                prep = conectar.prepareStatement(sql);
                prep.execute();
                
            } else {
                System.out.println("Conexão com o banco de dados realizada com sucesso!");
            }
        } catch (SQLException erro_conectar_banco) {
            System.out.println("Falha ao conectar com o banco de dados!\n" + erro_conectar_banco.getMessage());
        }
    }

    //método para retornar a conexão
    public Connection getConexao() {
        return conectar;
    }

    //método sem retorno para finalizar a conexão
    public void finalizar_conexao() {
        try {
            conectar.close();
        } catch (SQLException erro_finalizar_conexao){
            System.out.println("Falha ao finalizar conexão com o banco de dados!\n" + erro_finalizar_conexao.getMessage());
        }
    }
}
