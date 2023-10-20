package ENTIDADES;

public class Cliente {
    /*  `cpf` CHAR(14) NOT NULL PRIMARY KEY,
  `nome` VARCHAR(100) NOT NULL,
  `datanascimento` DATE NOT NULL,
  `email` VARCHAR(45) NOT NULL UNIQUE,
  `telefone` CHAR(15) NOT NULL */
  private String cpf;
  private String nome;
  private String datanascimento;
  private String email;
  private String telefone;
public String getCpf() {
    return cpf;
}
public void setCpf(String cpf) {
    this.cpf = cpf;
}
public String getNome() {
    return nome;
}
public void setNome(String nome) {
    this.nome = nome;
}
public String getDatanascimento(boolean invertido) {
    if(invertido){
            
        String[] dividido = this.datanascimento.split("/");
        String dt = dividido[2]+"-"+dividido[1]+"-"+dividido[0];            
        return dt;
    }else{
        return this.datanascimento;
    }
}
public void setDatanascimento(String datanascimento,boolean invertido) {
    if(invertido){
        String[] dividido = datanascimento.split("-");
        datanascimento = dividido[2]+"/"+dividido[1]+"/"+dividido[0];            
    }else{
        this.datanascimento = datanascimento;
    }
}
public String getEmail() {
    return email;
}
public void setEmail(String email) {
    this.email = email;
}
public String getTelefone() {
    return telefone;
}
public void setTelefone(String telefone) {
    this.telefone = telefone;
}

    
}
