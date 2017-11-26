package br.com.bibliotech.controller;

import br.com.bibliotech.model.Livro;
import br.com.bibliotech.dao.LivrosDao;
import java.sql.ResultSet;
import java.util.ArrayList;

public class LivroController {
    
    private LivrosDao dao;
    
    public LivroController(){
        dao = new LivrosDao();
    }
    
    
    public boolean salvarLivro(String nome, String descricao, String categoria, int quantidade){
        try{
            dao.inserirNovoLivro(nome, descricao, categoria, quantidade);
            
        } catch (Exception e){
            System.out.println(e);
            return false;
        }
        
        return true;
    }
    
    public boolean alterarLivro(String id, String valor, String coluna){
        try{
            System.out.println("Alterando livro id: " + id);
            if(coluna.equals("1")){
                System.out.println("Alterando nome");
                dao.alterarNomeLivro(id, valor);
            } else if(coluna.equals("2")){
                System.out.println("Alterando descricao");
                dao.alterarDescricaoLivro(id, valor);
            } else if(coluna.equals("4")){
                System.out.println("Alterando quantidade");
                dao.alterarQuantidadeLivro(id, valor);
            } else{
                return false;
            } 
            
        } catch (Exception e){
            System.out.println(e);
            return false;
        }
        
        return true;
    }
    
    public boolean deletarLivro(String id){
        try{
            dao.deletarLivro(id);
            
        } catch (Exception e){
            System.out.println(e);
            return false;
        }
        return true;
    }
    
    public ArrayList listarLivros(){
        ArrayList listaDeResultados = new ArrayList();
        try{
            ResultSet resultados = dao.listarLivros();
            
            
            while(resultados.next()){
                
                String id = resultados.getString("id");
                String nome = resultados.getString("nome");
                
                String descricao = resultados.getString("descricao");
                String quantidade = resultados.getString("quantidade");
                String categoria = resultados.getString("categoria");
                Livro l = new Livro(nome, descricao, quantidade, categoria);
                l.setId(id);
                listaDeResultados.add(l);
            }
            dao.fecharConexao();
        } catch (Exception e){
            System.out.println(e);
            
        }
        return listaDeResultados;
    }
    
    public ArrayList listarLivrosDisponiveis(){
        ArrayList listaDeResultados = new ArrayList();
        try{
            ResultSet resultados = dao.listarLivrosDisponiveis();
            
            while(resultados.next()){
                String id = resultados.getString("id");
                String nome = resultados.getString("nome");
                String descricao = resultados.getString("descricao");
                String quantidade = resultados.getString("quantidade");
                String categoria = resultados.getString("categoria");
                Livro l = new Livro(nome, descricao, quantidade, categoria);
                l.setId(id);
                listaDeResultados.add(l);
            }
            dao.fecharConexao();
        } catch (Exception e){
            System.out.println(e);   
        }
        return listaDeResultados;
    }
    
    public String listarNumeroDeLivros(){
        String numeroDeLivros = "0";
        try{
            ResultSet resultados = dao.listarNumeroDeLivros();
            while(resultados.next()){
                numeroDeLivros = resultados.getString("numeroDeLivros");
            }
            dao.fecharConexao();
        } catch (Exception e){
            System.out.println(e);   
        }
        return numeroDeLivros;
    }
    
    
}
