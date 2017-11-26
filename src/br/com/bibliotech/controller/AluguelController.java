package br.com.bibliotech.controller;

import br.com.bibliotech.model.Aluguel;
import br.com.bibliotech.dao.AlugueisDao;
import java.sql.ResultSet;
import java.util.ArrayList;

public class AluguelController {
    
    private AlugueisDao dao;
    
    public AluguelController(){
        dao = new AlugueisDao();
    }
        
    public boolean salvarAluguel(String login, String idLivro, String dataInicial, String dataFinal){
        try{
            dao.inserirNovoAluguel(login, idLivro, dataInicial, dataFinal);
        } catch (Exception e){
            System.out.println(e);
            return false;
        }
        
        return true;
    }
    
    
    public boolean deletarAluguel(String id){
        try{
            dao.deletarAluguel(id);
            
        } catch (Exception e){
            System.out.println(e);
            return false;
        }
        return true;
    }
    
    public ArrayList listarAlugueis(){
        ArrayList listaDeResultados = new ArrayList();
        try{
            ResultSet resultados = dao.listarAlugueisTabela();
            
            while(resultados.next()){
                
                String id = resultados.getString("id");
                String login = resultados.getString("loginUsuario");
                String idLivro = resultados.getString("idLivro");
                String dataInicial = resultados.getString("dataInicial");
                String dataFinal = resultados.getString("dataFinal");
                Aluguel l = new Aluguel(login, idLivro, dataInicial, dataFinal);
                l.setId(id);
                listaDeResultados.add(l);
            }
            dao.fecharConexao();
        } catch (Exception e){
            System.out.println(e);
            
        }
        return listaDeResultados;
    }
    
    public ArrayList listarAlugueisNaoDevolvidos(){
        ArrayList listaDeResultados = new ArrayList();
        try{
            ResultSet resultados = dao.listarAlugueisTabelaNaoDevolvidos();
            
            while(resultados.next()){
                
                String id = resultados.getString("id");
                String login = resultados.getString("loginUsuario");
                String idLivro = resultados.getString("idLivro");
                String dataInicial = resultados.getString("dataInicial");
                String dataFinal = resultados.getString("dataFinal");
                Aluguel l = new Aluguel(login, idLivro, dataInicial, dataFinal);
                l.setId(id);
                listaDeResultados.add(l);
            }
            dao.fecharConexao();
        } catch (Exception e){
            System.out.println(e);
            
        }
        return listaDeResultados;
    }
    
    public ArrayList listarAlugueisPorUsuario(String loginUsuario){
        ArrayList listaDeResultados = new ArrayList();
        try{
            ResultSet resultados = dao.listarAlugueisPorUsuario(loginUsuario);
            
            while(resultados.next()){
                
                String id = resultados.getString("id");
                String login = resultados.getString("loginUsuario");
                String idLivro = resultados.getString("idLivro");
                String dataInicial = resultados.getString("dataInicial");
                String dataFinal = resultados.getString("dataFinal");
                Aluguel l = new Aluguel(login, idLivro, dataInicial, dataFinal);
                l.setId(id);
                listaDeResultados.add(l);
            }
            dao.fecharConexao();
        } catch (Exception e){
            System.out.println(e);
            
        }
        return listaDeResultados;
    }
    
    public String listarNumeroDeAlugueis(){
        String numeroDeAlugueis = "0";
        try{
            ResultSet resultados = dao.listarNumeroDeAlugueis();
            while(resultados.next()){
                numeroDeAlugueis = resultados.getString("numeroDeAlugueis");
            }
            dao.fecharConexao();
        } catch (Exception e){
            System.out.println(e);   
        }
        return numeroDeAlugueis;
    }
    
}
