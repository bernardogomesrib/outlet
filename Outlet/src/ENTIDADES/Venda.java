package ENTIDADES;

public class Venda {
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
    private String numero;
    private String data;
    private String formapagamento;
    private double total;
    private String pedido_id;
    public Venda(){}
    public Venda(String numero,String formapagamento,double total, String pedido_id){
        this.setNumero(numero);
        this.setFormapagamento(formapagamento);
        this.setTotal(total);
        this.setPedido_id(pedido_id);
    }
    public String getNumero() {
        return numero;
    }
    public void setNumero(String numero) {
        this.numero = numero;
    }
    public String getData(boolean invertido) {
        if(invertido){
            
            String[] dividido = this.data.split("/");
            String dt = dividido[2]+"-"+dividido[1]+"-"+dividido[0];            
            return dt;
        }else{
            return data;
        }
    }
    public void setData(String data,boolean invertido) {
        if(invertido){
            String[] dividido = data.split("-");
            this.data = dividido[2]+"/"+dividido[1]+"/"+dividido[0];            
        }else{
            this.data = data;
        }
    }
    public String getFormapagamento() {
        return formapagamento;
    }
    public void setFormapagamento(String formapagamento) {
        this.formapagamento = formapagamento;
    }
    public double getTotal() {
        return total;
    }
    public void setTotal(double total) {
        this.total = total;
    }
    public String getPedido_id() {
        return pedido_id;
    }
    public void setPedido_id(String pedido_id) {
        this.pedido_id = pedido_id;
    }
    
}
