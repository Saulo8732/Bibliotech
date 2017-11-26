package br.com.bibliotech.dao;

import br.com.bibliotech.repositorio.Conexaodb;
import java.sql.ResultSet;


public class CategoriasDao extends Conexaodb{
    
    public ResultSet listarNomeCategorias() throws Exception {
        String sql = "SELECT nome FROM categorias;";
        ResultSet resultados;

        conectarMySql();
        resultados = executarSql(sql);
        return resultados;
        
    }
    
    public void inserirNovaCategoria(String nome, String descricao) throws Exception{
        String sql = "INSERT INTO categorias (nome, descricao) VALUES ('"+nome+"', '"+descricao+"');";
        conectarMySql();
        insertSql(sql);
    }
    
    public ResultSet listarCategorias() throws Exception {
        String sql = "SELECT * FROM categorias";
        ResultSet resultados;
        conectarMySql();
        resultados = executarSql(sql);
        return resultados;
    }
        
    
    public void deletarCategoria(String id) throws Exception{
        String sql = "DELETE FROM categorias WHERE `id`="+id+";";
        conectarMySql();
        insertSql(sql);
    }
    
    public void alterarNomeCategoria(String id, String valor) throws Exception{
        String sql = "UPDATE categorias SET nome = '"+valor+"' WHERE  id ='"+id+"';";
        conectarMySql();
        insertSql(sql);
    }
    
    public void alterarDescricaoCategoria(String id, String valor) throws Exception{
        String sql = "UPDATE categorias SET `descricao`= '"+valor+"' WHERE  `id`='"+id+"';";
        conectarMySql();
        insertSql(sql);
    }
    
    
    
    
    
    
}
