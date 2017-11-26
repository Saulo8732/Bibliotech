
package br.com.bibliotech.dao;

import br.com.bibliotech.repositorio.Conexaodb;
import java.sql.ResultSet;


public class ReservasDao extends Conexaodb{
    
    public void inserirNovoReserva(String login, String idLivro, String dataInicial, String dataFinal) throws Exception{
        String sql = "INSERT INTO reservas (loginUsuario, idLivro, dataInicial, dataFinal) VALUES ('"+login+"', '"+idLivro+"', '"+dataInicial+"', '"+dataFinal+"');";
        conectarMySql();
        insertSql(sql);
    }
    
    public ResultSet listarReservas() throws Exception {
        String sql = "SELECT * FROM reservas";
        ResultSet resultados;
        conectarMySql();
        resultados = executarSql(sql);
        return resultados;
    }
    
    public ResultSet listarNumeroDeReservas() throws Exception{
        String sql = "SELECT count(*) as numeroDeReservas FROM reservas;";
        ResultSet resultados;
        conectarMySql();
        resultados = executarSql(sql);
        return resultados;
    }
    
    public ResultSet listarReservasTabela() throws Exception {
        String sql = "SELECT a.id, a.loginUsuario, "
                + "l.nome as idLivro, a.datainicial, a.datafinal "
                + "FROM reservas a LEFT JOIN livros l ON a.idLivro = l.id;";
        ResultSet resultados;
        conectarMySql();
        resultados = executarSql(sql);
        return resultados;
    }
    
    public ResultSet listarReservasPorUsuario(String loginUsuario) throws Exception {
        String sql = "SELECT a.id, a.loginUsuario, "
                + "l.nome as idLivro, a.datainicial, a.datafinal "
                + "FROM reservas a LEFT JOIN livros l ON a.idLivro = l.id "
                + "WHERE a.loginUsuario = '"+loginUsuario+"';";
        ResultSet resultados;
        conectarMySql();
        resultados = executarSql(sql);
        return resultados;
    }
    
    public void deletarReserva(String id) throws Exception{
        String sql = "DELETE FROM reservas WHERE `id`="+id+";";
        conectarMySql();
        insertSql(sql);
    }
    
    
}
