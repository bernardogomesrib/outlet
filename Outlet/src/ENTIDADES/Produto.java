package ENTIDADES;

public class Produto {
    /*-- -----------------------------------------------------
-- Table `outlet`.`produto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `outlet`.`produto` (
  `cod` INT NOT NULL,
  `descricao` VARCHAR(100) NOT NULL,
  `marca` VARCHAR(45) NULL,
  `preco` DECIMAL(8,2) NOT NULL,
  `quantidadeestoque` INT NOT NULL,
  PRIMARY KEY (`cod`))
ENGINE = InnoDB; */
    private String cod;
    private String descricao;
    private String marca;
    private double preco;
    private int quantidadeestoque;
    public String getCod() {
        return cod;
    }
    public void setCod(String cod) {
        this.cod = cod;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public double getPreco() {
        return preco;
    }
    public void setPreco(double preco) {
        this.preco = preco;
    }
    public int getQuantidadeestoque() {
        return quantidadeestoque;
    }
    public void setQuantidadeestoque(int quantidadeestoque) {
        this.quantidadeestoque = quantidadeestoque;
    }


}
