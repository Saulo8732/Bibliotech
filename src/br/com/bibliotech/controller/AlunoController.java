package br.com.bibliotech.controller;

import br.com.bibliotech.model.Aluno;
import br.com.bibliotech.dao.AlunosDao;
import java.sql.ResultSet;
import java.util.ArrayList;

public class AlunoController {
    
    private AlunosDao dao;
    
    public AlunoController(){
        dao = new AlunosDao();
    }
    
    public boolean salvarAluno(String nome, String login, String senha){
        try{
            dao.inserirNovoAluno(nome, login, senha);
        } catch (Exception e){
            System.out.println(e);
            return false;
        }
        
        return true;
    }
    
    public boolean alterarAluno(String id, String valor, String coluna){
        try{
            System.out.println("Alterando aluno id: " + id);
            if(coluna.equals("1")){
                System.out.println("Alterando nome");
                dao.alterarNomeAluno(id, valor);
            } else if(coluna.equals("2")){
                System.out.println("Alterando login");
                dao.alterarLoginAluno(id, valor);
            } else if(coluna.equals("3")){
                System.out.println("Alterando senha");
                dao.alterarSenhaAluno(id, valor);
            } else{
                return false;
            } 
            
        } catch (Exception e){
            System.out.println(e);
            return false;
        }
        
        return true;
    }
    
    public boolean deletarAluno(String id){
        try{
            dao.deletarAluno(id);
            
        } catch (Exception e){
            System.out.println(e);
            return false;
        }
        return true;
    }
    
    public ArrayList listarAlunos(){
        ArrayList listaDeResultados = new ArrayList();
        try{
            ResultSet resultados = dao.listarAlunos();
            
            while(resultados.next()){
                
                String id = resultados.getString("id");
                String nome = resultados.getString("nome");
                String login = resultados.getString("login");
                String senha = resultados.getString("senha");
                Aluno l = new Aluno(nome, login, senha);
                l.setId(id);
                listaDeResultados.add(l);
            }
            dao.fecharConexao();
        } catch (Exception e){
            System.out.println(e);
            
        }
        return listaDeResultados;
    }
    
    public ArrayList listarLoginAlunosDisponiveis(){
        ArrayList listaDeResultados = new ArrayList();
        try{
            ResultSet resultados = dao.listarAlunosDisponiveis();
            
            while(resultados.next()){
                String login = resultados.getString("login");;
                Aluno l = new Aluno("", login, "");
                listaDeResultados.add(l);
            }
            dao.fecharConexao();
        } catch (Exception e){
            System.out.println(e);   
        }
        return listaDeResultados;
    }
    
    
}
