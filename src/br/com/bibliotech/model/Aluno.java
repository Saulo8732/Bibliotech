package br.com.bibliotech.model;


public final class Aluno extends Usuario{
    
    public Aluno(String nome, String login, String senha) {
        super.nome = nome;
        super.login = login;
        super.senha = senha;
        super.tipoUsuario = "aluno";
    }
    
}
