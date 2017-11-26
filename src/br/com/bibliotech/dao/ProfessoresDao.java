package br.com.bibliotech.dao;

import br.com.bibliotech.repositorio.Conexaodb;
import java.sql.ResultSet;


public class ProfessoresDao extends Conexaodb{
    
    public ResultSet listarNomeProfessors() throws Exception {
        String sql = "SELECT nome FROM usuarios WHERE tipoUsuario = 'professor';";
        ResultSet resultados;
        conectarMySql();
        resultados = executarSql(sql);
        return resultados;
    }
    
    public void inserirNovoProfessor(String nome, String login, String senha) throws Exception{
        String sql = "INSERT INTO usuarios (nome, login, senha, tipoUsuario) VALUES ('"+nome+"', '"+login+"', '"+senha+"', 'professor');";
        conectarMySql();
        insertSql(sql);
    }
    
    public ResultSet listarProfessors() throws Exception {
        String sql = "SELECT * FROM usuarios WHERE tipoUsuario = 'professor'";
        ResultSet resultados;
        conectarMySql();
        resultados = executarSql(sql);
        return resultados;
    }
    
    public ResultSet listarProfessoresDisponiveis() throws Exception{
        String sql = "SELECT u.* FROM usuarios u "
                + "LEFT JOIN alugueis a ON a.loginUsuario = u.login "
                + "WHERE u.tipoUsuario = 'professor' "
                + "GROUP BY u.login HAVING COUNT(u.login) < 5 ORDER BY u.id;";
        ResultSet resultados;
        conectarMySql();
        resultados = executarSql(sql);
        return resultados;
    }
    
    public void deletarProfessor(String id) throws Exception{
        String sql = "DELETE FROM usuarios WHERE `id`="+id+";";
        conectarMySql();
        insertSql(sql);
    }
    
    public void alterarNomeProfessor(String id, String valor) throws Exception{
        String sql = "UPDATE usuarios SET nome = '"+valor+"' WHERE  id ='"+id+"';";
        conectarMySql();
        insertSql(sql);
    }
    
    public void alterarLoginProfessor(String id, String valor) throws Exception{
        String sql = "UPDATE usuarios SET `login`= '"+valor+"' WHERE  `id`='"+id+"';";
        conectarMySql();
        insertSql(sql);
    }
    
    public void alterarSenhaProfessor(String id, String valor) throws Exception{
        String sql = "UPDATE usuarios SET `senha`= '"+valor+"' WHERE  `id`='"+id+"';";
        conectarMySql();
        insertSql(sql);
    }
    
}
