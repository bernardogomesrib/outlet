package ENTIDADES;

public class Pedido {
    /*-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `outlet`.`pedido` (
  `id` INT NOT NULL,
  `data` DATETIME NOT NULL,
  `cliente_cpf` CHAR(14) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_pedido_cliente_idx` (`cliente_cpf` ASC),
  CONSTRAINT `fk_pedido_cliente`
    FOREIGN KEY (`cliente_cpf`)
    REFERENCES `outlet`.`cliente` (`cpf`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB; */
    private String id;
    private String data;
    private String cliente_cpf;
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
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
    public String getCliente_cpf() {
        return cliente_cpf;
    }
    public void setCliente_cpf(String cliente_cpf) {
        this.cliente_cpf = cliente_cpf;
    }


}
