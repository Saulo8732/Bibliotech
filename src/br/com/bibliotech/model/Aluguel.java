package br.com.bibliotech.model;

import java.util.Date;




public class Aluguel {
    private String id;
    private String idLivro;
    private String login;
    private String dataInicial;
    private String dataDeEntrega;

    public Aluguel(String login, String idLivro, String dataInicial, String dataDeEntrega) {
        this.idLivro = idLivro;
        this.login = login;
        this.dataInicial = dataInicial;
        this.dataDeEntrega = dataDeEntrega;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdLivro() {
        return idLivro;
    }

    public void setIdLivro(String idLivro) {
        this.idLivro = idLivro;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getDataInicial() {
        return dataInicial;
    }

    public void setDataInicial(String dataInicial) {
        this.dataInicial = dataInicial;
    }

    public String getDataDeEntrega() {
        return dataDeEntrega;
    }

    public void setDataDeEntrega(String dataDeEntrega) {
        this.dataDeEntrega = dataDeEntrega;
    }
    
    
    
    
    
}
