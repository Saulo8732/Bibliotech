package br.com.bibliotech.controller;

import br.com.bibliotech.model.Reserva;
import br.com.bibliotech.dao.ReservasDao;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ReservaController {
    
    private ReservasDao dao;
    
    public ReservaController(){
        dao = new ReservasDao();
    }
        
    public boolean salvarReserva(String login, String idLivro, String dataInicial, String dataFinal){
        try{
            dao.inserirNovoReserva(login, idLivro, dataInicial, dataFinal);
        } catch (Exception e){
            System.out.println(e);
            return false;
        }
        
        return true;
    }
    
    
    public boolean deletarReserva(String id){
        try{
            dao.deletarReserva(id);
            
        } catch (Exception e){
            System.out.println(e);
            return false;
        }
        return true;
    }
    
    public ArrayList listarReservas(){
        ArrayList listaDeResultados = new ArrayList();
        try{
            ResultSet resultados = dao.listarReservasTabela();
            
            while(resultados.next()){
                
                String id = resultados.getString("id");
                String login = resultados.getString("loginUsuario");
                String idLivro = resultados.getString("idLivro");
                String dataInicial = resultados.getString("dataInicial");
                String dataFinal = resultados.getString("dataFinal");
                Reserva l = new Reserva(login, idLivro, dataInicial, dataFinal);
                l.setId(id);
                listaDeResultados.add(l);
            }
            dao.fecharConexao();
        } catch (Exception e){
            System.out.println(e);
            
        }
        return listaDeResultados;
    }
    
    public ArrayList listarReservasPorUsuario(String loginUsuario){
        ArrayList listaDeResultados = new ArrayList();
        try{
            ResultSet resultados = dao.listarReservasPorUsuario(loginUsuario);
            
            while(resultados.next()){
                
                String id = resultados.getString("id");
                String login = resultados.getString("loginUsuario");
                String idLivro = resultados.getString("idLivro");
                String dataInicial = resultados.getString("dataInicial");
                String dataFinal = resultados.getString("dataFinal");
                Reserva l = new Reserva(login, idLivro, dataInicial, dataFinal);
                l.setId(id);
                listaDeResultados.add(l);
            }
            dao.fecharConexao();
        } catch (Exception e){
            System.out.println(e);
            
        }
        return listaDeResultados;
    }
    
    public String listarNumeroDeReservas(){
        String numeroDeReservas = "0";
        try{
            ResultSet resultados = dao.listarNumeroDeReservas();
            while(resultados.next()){
                numeroDeReservas = resultados.getString("numeroDeReservas");
            }
            dao.fecharConexao();
        } catch (Exception e){
            System.out.println(e);   
        }
        return numeroDeReservas;
    }
    
    
}
