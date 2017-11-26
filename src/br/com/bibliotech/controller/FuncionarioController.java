package br.com.bibliotech.controller;

import br.com.bibliotech.model.Funcionario;
import br.com.bibliotech.dao.FuncionariosDao;
import java.sql.ResultSet;
import java.util.ArrayList;

public class FuncionarioController {
    
    private FuncionariosDao dao;
    
    public FuncionarioController(){
        dao = new FuncionariosDao();
    }
    
    
    public boolean salvarFuncionario(String nome, String login, String senha){
        try{
            dao.inserirNovoFuncionario(nome, login, senha);
        } catch (Exception e){
            System.out.println(e);
            return false;
        }
        
        return true;
    }
    
    public boolean alterarFuncionario(String id, String valor, String coluna){
        try{
            System.out.println("Alterando funcionario id: " + id);
            if(coluna.equals("1")){
                System.out.println("Alterando nome");
                dao.alterarNomeFuncionario(id, valor);
            } else if(coluna.equals("2")){
                System.out.println("Alterando login");
                dao.alterarLoginFuncionario(id, valor);
            } else if(coluna.equals("3")){
                System.out.println("Alterando senha");
                dao.alterarSenhaFuncionario(id, valor);
            } else{
                return false;
            } 
            
        } catch (Exception e){
            System.out.println(e);
            return false;
        }
        
        return true;
    }
    
    public boolean deletarFuncionario(String id){
        try{
            dao.deletarFuncionario(id);
            
        } catch (Exception e){
            System.out.println(e);
            return false;
        }
        return true;
    }
    
    public ArrayList listarFuncionarios(){
        ArrayList listaDeResultados = new ArrayList();
        try{
            ResultSet resultados = dao.listarFuncionarios();
            
            while(resultados.next()){
                
                String id = resultados.getString("id");
                String nome = resultados.getString("nome");
                String login = resultados.getString("login");
                String senha = resultados.getString("senha");
                Funcionario l = new Funcionario(nome, login, senha);
                l.setId(id);
                listaDeResultados.add(l);
            }
            dao.fecharConexao();
        } catch (Exception e){
            System.out.println(e);
            
        }
        return listaDeResultados;
    }
    
    public ArrayList listarLoginFuncionariosDisponiveis(){
        ArrayList listaDeResultados = new ArrayList();
        try{
            ResultSet resultados = dao.listarFuncionariosDisponiveis();
            
            while(resultados.next()){
                String login = resultados.getString("login");;
                Funcionario l = new Funcionario("", login, "");
                listaDeResultados.add(l);
            }
            dao.fecharConexao();
        } catch (Exception e){
            System.out.println(e);   
        }
        return listaDeResultados;
    }
    
    
    
}
