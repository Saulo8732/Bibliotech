package br.com.bibliotech.controller;

import br.com.bibliotech.model.Professor;
import br.com.bibliotech.dao.ProfessoresDao;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ProfessorController {
    
    private ProfessoresDao dao;
    
    public ProfessorController(){
        dao = new ProfessoresDao();
    }
    
    
    public boolean salvarProfessor(String nome, String login, String senha){
        try{
            dao.inserirNovoProfessor(nome, login, senha);
        } catch (Exception e){
            System.out.println(e);
            return false;
        }
        
        return true;
    }
    
    public boolean alterarProfessor(String id, String valor, String coluna){
        try{
            System.out.println("Alterando professor id: " + id);
            if(coluna.equals("1")){
                System.out.println("Alterando nome");
                dao.alterarNomeProfessor(id, valor);
            } else if(coluna.equals("2")){
                System.out.println("Alterando login");
                dao.alterarLoginProfessor(id, valor);
            } else if(coluna.equals("3")){
                System.out.println("Alterando senha");
                dao.alterarSenhaProfessor(id, valor);
            } else{
                return false;
            } 
            
        } catch (Exception e){
            System.out.println(e);
            return false;
        }
        
        return true;
    }
    
    public boolean deletarProfessor(String id){
        try{
            dao.deletarProfessor(id);
            
        } catch (Exception e){
            System.out.println(e);
            return false;
        }
        return true;
    }
    
    public ArrayList listarProfessors(){
        ArrayList listaDeResultados = new ArrayList();
        try{
            ResultSet resultados = dao.listarProfessors();
            
            while(resultados.next()){
                
                String id = resultados.getString("id");
                String nome = resultados.getString("nome");
                String login = resultados.getString("login");
                String senha = resultados.getString("senha");
                Professor l = new Professor(nome, login, senha);
                l.setId(id);
                listaDeResultados.add(l);
            }
            dao.fecharConexao();
        } catch (Exception e){
            System.out.println(e);
            
        }
        return listaDeResultados;
    }
    
    public ArrayList listarLoginProfessoresDisponiveis(){
        ArrayList listaDeResultados = new ArrayList();
        try{
            ResultSet resultados = dao.listarProfessoresDisponiveis();
            
            while(resultados.next()){
                String login = resultados.getString("login");;
                Professor l = new Professor("", login, "");
                listaDeResultados.add(l);
            }
            dao.fecharConexao();
        } catch (Exception e){
            System.out.println(e);   
        }
        return listaDeResultados;
    }
    
    
}
