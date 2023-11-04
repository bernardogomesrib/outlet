package ENTIDADES;

import java.text.DecimalFormat;

public class ConsultaPedido {
    private String id;
    private String cpf;
    private String data;
    private double subTotal;
    private int quanidadeDeItens;
    private int quanidadeDeItensdist;
    private String concluido;
    public int getQuanidadeDeItensdist() {
        return quanidadeDeItensdist;
    }
    public void setQuanidadeDeItensdist(int quanidadeDeItensdist) {
        this.quanidadeDeItensdist = quanidadeDeItensdist;
    }
    public ConsultaPedido(String id, String data, String cpf,double subtotal,int quantidadeDeItens,int quanidadeDeItensdist,String concluido){
        this.setId(id);
        this.setData(data);
        this.setCpf(cpf);
        this.setSubTotal(subtotal);
        this.setQuanidadeDeItens(quantidadeDeItens);
        this.setConcluido(concluido);
        this.setQuanidadeDeItensdist(quanidadeDeItensdist);
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public String getData() {
        return data;
    }
    public void setData(String data) {
       this.data = data.substring(8,10)+"/"+data.substring(5,7)+"/"+data.substring(0,4)+" as"+data.substring(10, data.length());
    }
    public double getSubTotal() {
        return subTotal;
    }
    public String getSubTotalf() {
        DecimalFormat df = new DecimalFormat("0.00");
        return "R$ "+df.format(subTotal);
    }
    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }
    public int getQuanidadeDeItens() {
        return quanidadeDeItens;
    }
    public void setQuanidadeDeItens(int quanidadeDeItens) {
        this.quanidadeDeItens = quanidadeDeItens;
    }
    public String getConcluido() {
        return concluido;
    }
    public void setConcluido(String concluido) {
        this.concluido = concluido;
    }
}
