package br.com.bibliotech.controller;

import br.com.bibliotech.model.Categoria;
import br.com.bibliotech.dao.CategoriasDao;
import java.sql.ResultSet;
import java.util.ArrayList;


public class CategoriaController{
    
    private CategoriasDao dao;
    
    public CategoriaController(){
        dao = new CategoriasDao();
    }
    
    
    public ArrayList listarNomeCategorias() {
        ArrayList rs = new ArrayList();

        try {
            ResultSet resultados = dao.listarNomeCategorias();

            while (resultados.next()) {
                String nome = resultados.getString("nome");
                rs.add(nome);
            }
            dao.fecharConexao();
        } catch (Exception e) {
            System.out.println(e);
        }
        
        return rs;
    }
    
    public boolean salvarCategoria(String nome, String descricao){
        try{
            dao.inserirNovaCategoria(nome, descricao);
            
        } catch (Exception e){
            System.out.println(e);
            return false;
        }
        
        return true;
    }
    
    public boolean alterarCategoria(String id, String valor, String coluna){
        try{
            System.out.println("Alterando categoria id: " + id);
            if(coluna.equals("1")){
                System.out.println("Alterando nome");
                dao.alterarNomeCategoria(id, valor);
            } else if(coluna.equals("2")){
                System.out.println("Alterando descricao");
                dao.alterarDescricaoCategoria(id, valor);
            } else{
                return false;
            } 
            
        } catch (Exception e){
            System.out.println(e);
            return false;
        }
        
        return true;
    }
    
    public boolean deletarCategoria(String id){
        try{
            dao.deletarCategoria(id);
            
        } catch (Exception e){
            System.out.println(e);
            return false;
        }
        return true;
    }
    
    public ArrayList listarCategorias(){
        ArrayList listaDeResultados = new ArrayList();
        try{
            ResultSet resultados = dao.listarCategorias();
            
            while(resultados.next()){
                
                String id = resultados.getString("id");
                String nome = resultados.getString("nome");
                
                String descricao = resultados.getString("descricao");
                Categoria l = new Categoria(nome, descricao);
                l.setId(id);
                listaDeResultados.add(l);
            }
            dao.fecharConexao();
        } catch (Exception e){
            System.out.println(e);
            
        }
        return listaDeResultados;
    }
    
    
    
    
    
    
    
    
    
}
