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
        
            String dt ="";
            try {
                System.out.println(data);
                dt = data.substring(6, 10)+"-"+data.substring(3, 5)+"-"+data.substring(0, 2)+" "+data.substring(13,data.length());    
            } catch (Exception e) {
                System.out.println("exeption no pedido.getdata(invertido:true)");
                System.out.println(dt);               
            }            
            System.out.println(dt);
            return dt;
        }else{
            System.out.println(data);
            return data;
        }
    }
    public void setData(String data,boolean invertido) {
        if(invertido){            
            this.data = data.substring(8,10)+"/"+data.substring(5,7)+"/"+data.substring(0,4)+" as"+data.substring(10, data.length());
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
