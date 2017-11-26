package br.com.bibliotech.dao;

import br.com.bibliotech.repositorio.Conexaodb;
import java.sql.ResultSet;

public class LivrosDao extends Conexaodb{
    
    public ResultSet listarNomeLivros() throws Exception {
        String sql = "SELECT nome FROM livros;";
        ResultSet resultados;
        conectarMySql();
        resultados = executarSql(sql);
        return resultados;
        
    }
    
    public void inserirNovoLivro(String nome, String descricao, String categoria, int quantidade) throws Exception{
        String sql = "INSERT INTO livros (nome, descricao, categoria, quantidade) VALUES ('"+nome+"', '"+descricao+"', '"+categoria+"', '"+quantidade+"');";
        conectarMySql();
        insertSql(sql);
    }
    
    public ResultSet listarLivros() throws Exception {
        String sql = "SELECT * FROM livros";
        ResultSet resultados;
        conectarMySql();
        resultados = executarSql(sql);
        return resultados;
    }
    
    public ResultSet listarLivrosDisponiveis() throws Exception{
        String sql = "SELECT l.* FROM livros l "
                + "LEFT JOIN alugueis a ON a.idLivro = l.id "
                + "LEFT JOIN reservas r on r.idLivro = l.id "
                + "GROUP BY l.id HAVING COUNT(l.id) < l.quantidade ORDER BY l.id;";
        ResultSet resultados;
        conectarMySql();
        resultados = executarSql(sql);
        return resultados;
    }
    
    public ResultSet listarNumeroDeLivros() throws Exception{
        String sql = "SELECT count(*) as numeroDeLivros FROM livros;";
        ResultSet resultados;
        conectarMySql();
        resultados = executarSql(sql);
        return resultados;
    }
    
    public void deletarLivro(String id) throws Exception{
        String sql = "DELETE FROM livros WHERE `id`="+id+";";
        conectarMySql();
        insertSql(sql);
    }
    
    public void alterarNomeLivro(String id, String valor) throws Exception{
        String sql = "UPDATE livros SET nome = '"+valor+"' WHERE  id ='"+id+"';";
        conectarMySql();
        insertSql(sql);
    }
    
    public void alterarDescricaoLivro(String id, String valor) throws Exception{
        String sql = "UPDATE livros SET `descricao`= '"+valor+"' WHERE  `id`='"+id+"';";
        conectarMySql();
        insertSql(sql);
    }
    
    public void alterarQuantidadeLivro(String id, String valor) throws Exception{
        String sql = "UPDATE livros SET `quantidade`= '"+valor+"' WHERE  `id`='"+id+"';";
        conectarMySql();
        insertSql(sql);
    }
    
    
}
