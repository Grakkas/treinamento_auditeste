package model;

public class ClientModel {

    private String nome;
    private String sobrenome;
    private String cep;

    public ClientModel(String nome, String sobrenome, String cep) {
        setNome(nome);
        setSobrenome(sobrenome);
        setCep(cep);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }
}
