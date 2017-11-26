package br.com.bibliotech.model;

public final class Funcionario extends Usuario{

    public Funcionario(String nome, String login, String senha) {
        super.nome = nome;
        super.login = login;
        super.senha = senha;
        super.tipoUsuario = "funcionario";
    }
}
