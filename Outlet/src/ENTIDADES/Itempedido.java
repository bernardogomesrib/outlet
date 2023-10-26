package ENTIDADES;

public class Itempedido {
    /*
     * CREATE TABLE IF NOT EXISTS `outlet`.`itempedido` (
  `pedido_id` INT NOT NULL,
  `produto_cod` INT NOT NULL,
  `quantidade` INT NOT NULL,
  `valor` DECIMAL(8,2) NOT NULL,
  `subtotal` DECIMAL(10,2) NOT NULL,
  INDEX `fk_itempedido_pedido1_idx` (`pedido_id` ASC),
  INDEX `fk_itempedido_produto1_idx` (`produto_cod` ASC),
  PRIMARY KEY (`pedido_id`, `produto_cod`),
  CONSTRAINT `fk_itempedido_pedido1`
    FOREIGN KEY (`pedido_id`)
    REFERENCES `outlet`.`pedido` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_itempedido_produto1`
    FOREIGN KEY (`produto_cod`)
    REFERENCES `outlet`.`produto` (`cod`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;
     */
    private String pedido_id;
    private String produto_cod;
    private int quantidade;
    private double valor;
    private double subtotal;
    public Itempedido(){
      
    }
    public Itempedido(String pedido_id,String produto_cod,int quantidade,double valor,double subtotal){
      this.pedido_id= pedido_id;
      this.produto_cod = produto_cod;
      this.quantidade = quantidade;
      this.subtotal= subtotal;
      this.valor = valor;
    }
    public String getPedido_id() {
      return pedido_id;
    }
    public void setPedido_id(String pedido_id) {
      this.pedido_id = pedido_id;
    }
    public String getProduto_cod() {
      return produto_cod;
    }
    public void setProduto_cod(String produto_cod) {
      this.produto_cod = produto_cod;
    }
    public int getQuantidade() {
      return quantidade;
    }
    public void setQuantidade(int quantidade) {
      this.quantidade = quantidade;
    }
    public void setQuantidadenova(int quantidade) {
      this.quantidade = quantidade;
      this.subtotal = this.quantidade*this.valor;
    }
    public double getValor() {
      return valor;
    }
    public void setValor(double valor) {
      this.valor = valor;
    }
    public double getSubtotal() {
      return subtotal;
    }
    public void setSubtotal(double subtotal) {
      this.subtotal = subtotal;
    }
    public void addMaisQuantidade(int quantidad){
      System.out.println(quantidad);
      this.quantidade+=quantidad;
      System.out.println(this.quantidade+" é a quantidade mais "+this.valor);
      this.subtotal = this.quantidade*this.valor;
    }
}
