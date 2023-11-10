package ENTIDADES;

import java.text.DecimalFormat;

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
    private String cliente_cpf;
    public String getCliente_cpf() {
        return cliente_cpf;
    }
    public void setCliente_cpf(String cliente_cpf) {
        this.cliente_cpf = cliente_cpf;
    }
    public Venda(){}
    public Venda(String numero,String formapagamento,double total, String pedido_id){
        this.setNumero(numero);
        this.setFormapagamento(formapagamento);
        this.setTotal(total);
        this.setPedido_id(pedido_id);
    }
    public Venda(String numero,String cliente_cpf,String formapagamento,String data,double total){        
        this.setNumero(numero);
        this.setFormapagamento(formapagamento);
        this.setTotal(total);
        this.setPedido_id(pedido_id);
        this.setData(data, true);
        this.setCliente_cpf(cliente_cpf);
    }
    public String getNumero() {
        return numero;
    }
    public void setNumero(String numero) {
        this.numero = numero;
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
    public String getTotalf(){
        DecimalFormat df = new DecimalFormat("0.00");
        return "R$ "+df.format(this.total);
    }
    public String getPedido_id() {
        return pedido_id;
    }
    public void setPedido_id(String pedido_id) {
        this.pedido_id = pedido_id;
    }
    
}
