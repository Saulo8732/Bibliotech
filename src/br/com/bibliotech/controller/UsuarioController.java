package br.com.bibliotech.controller;

import br.com.bibliotech.model.Aluno;
import br.com.bibliotech.model.Funcionario;
import br.com.bibliotech.model.Professor;
import br.com.bibliotech.model.Usuario;
import br.com.bibliotech.dao.UsuariosDao;
import java.sql.ResultSet;

public class UsuarioController {
    
    public static String tipoUsuario;
    
    private UsuariosDao dao;
    
    public UsuarioController(){
        dao = new UsuariosDao();
    }
    
    public Usuario testarUsuario(String usuario, String Senha){
        Usuario Resultado = null;
        try{
            ResultSet resultados = dao.testarUsuario(usuario, Senha);
            
            while(resultados.next()){
                String nome = resultados.getString("nome");
                String login = resultados.getString("login");
                String senha = resultados.getString("senha");
                String tipo = resultados.getString("tipoUsuario");
                
                if(tipo.equals("aluno")){
                    Resultado = new Aluno(nome, login, senha);
                    Resultado.setTipoUsuario(tipo);
                } 
                else if (tipo.equals("professor")){
                    Resultado = new Professor(nome, login, senha);
                    Resultado.setTipoUsuario(tipo);
                } 
                else if (tipo.equals("funcionario")){
                    Resultado = new Funcionario(nome, login, senha);
                    Resultado.setTipoUsuario(tipo);
                }
            }
            dao.fecharConexao();
        } catch (Exception e){
            System.out.println(e);
        }
        return Resultado;
    }
    
}
