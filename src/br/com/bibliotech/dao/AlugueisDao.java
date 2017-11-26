
package br.com.bibliotech.dao;

import br.com.bibliotech.repositorio.Conexaodb;
import java.sql.ResultSet;


public class AlugueisDao extends Conexaodb{
    
    public void inserirNovoAluguel(String login, String idLivro, String dataInicial, String dataFinal) throws Exception{
        String sql = "INSERT INTO alugueis (loginUsuario, idLivro, dataInicial, dataFinal) VALUES ('"+login+"', '"+idLivro+"', now(), '"+dataFinal+"');";
        conectarMySql();
        insertSql(sql);
    }
    
    public ResultSet listarAluguels() throws Exception {
        String sql = "SELECT * FROM alugueis";
        ResultSet resultados;
        conectarMySql();
        resultados = executarSql(sql);
        return resultados;
    }
    
    public ResultSet listarNumeroDeAlugueis() throws Exception{
        String sql = "SELECT count(*) as numeroDeAlugueis FROM alugueis;";
        ResultSet resultados;
        conectarMySql();
        resultados = executarSql(sql);
        return resultados;
    }
    
    public ResultSet listarAlugueisTabela() throws Exception {
        String sql = "SELECT a.id, a.loginUsuario, "
                + "l.nome as idLivro, a.datainicial, a.datafinal "
                + "FROM alugueis a LEFT JOIN livros l ON a.idLivro = l.id;";
        ResultSet resultados;
        conectarMySql();
        resultados = executarSql(sql);
        return resultados;
    }
    
    public ResultSet listarAlugueisTabelaNaoDevolvidos() throws Exception {
        String sql = "SELECT a.id, a.loginUsuario, l.nome as "
                + "idLivro, a.datainicial, a.datafinal "
                + "FROM alugueis a LEFT JOIN livros l "
                + "ON a.idLivro = l.id WHERE a.dataFinal < now();";
        ResultSet resultados;
        conectarMySql();
        resultados = executarSql(sql);
        return resultados;
    }
    
    public ResultSet listarAlugueisPorUsuario(String loginUsuario) throws Exception {
        String sql = "SELECT a.id, a.loginUsuario, "
                + "l.nome as idLivro, a.datainicial, a.datafinal "
                + "FROM alugueis a LEFT JOIN livros l ON a.idLivro = l.id "
                + "WHERE a.loginUsuario = '"+loginUsuario+"';";
        ResultSet resultados;
        conectarMySql();
        resultados = executarSql(sql);
        return resultados;
    }
    
    public void deletarAluguel(String id) throws Exception{
        String sql = "DELETE FROM alugueis WHERE `id`="+id+";";
        conectarMySql();
        insertSql(sql);
    }
    
    
}
