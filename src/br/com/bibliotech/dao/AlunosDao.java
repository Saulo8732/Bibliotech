
package br.com.bibliotech.dao;

import br.com.bibliotech.repositorio.Conexaodb;
import java.sql.ResultSet;


public class AlunosDao extends Conexaodb{
    
    public ResultSet listarNomeAlunos() throws Exception {
        String sql = "SELECT nome FROM usuarios WHERE tipoUsuario = 'aluno';";
        ResultSet resultados;
        conectarMySql();
        resultados = executarSql(sql);
        return resultados;
    }
    
    public void inserirNovoAluno(String nome, String login, String senha) throws Exception{
        String sql = "INSERT INTO usuarios (nome, login, senha, tipoUsuario) VALUES ('"+nome+"', '"+login+"', '"+senha+"', 'aluno');";
        conectarMySql();
        insertSql(sql);
    }
    
    public ResultSet listarAlunos() throws Exception {
        String sql = "SELECT * FROM usuarios WHERE tipoUsuario = 'aluno'";
        ResultSet resultados;
        conectarMySql();
        resultados = executarSql(sql);
        return resultados;
    }
    
    public ResultSet listarAlunosDisponiveis() throws Exception{
        String sql = "SELECT u.* FROM usuarios u "
                + "LEFT JOIN alugueis a ON a.loginUsuario = u.login "
                + "WHERE u.tipoUsuario = 'aluno' "
                + "GROUP BY u.login HAVING COUNT(u.login) < 3 ORDER BY u.id;";
        ResultSet resultados;
        conectarMySql();
        resultados = executarSql(sql);
        return resultados;
    }
    
    public void deletarAluno(String id) throws Exception{
        String sql = "DELETE FROM usuarios WHERE `id`="+id+";";
        conectarMySql();
        insertSql(sql);
    }
    
    public void alterarNomeAluno(String id, String valor) throws Exception{
        String sql = "UPDATE usuarios SET nome = '"+valor+"' WHERE  id ='"+id+"';";
        conectarMySql();
        insertSql(sql);
    }
    
    public void alterarLoginAluno(String id, String valor) throws Exception{
        String sql = "UPDATE usuarios SET `login`= '"+valor+"' WHERE  `id`='"+id+"';";
        conectarMySql();
        insertSql(sql);
    }
    
    public void alterarSenhaAluno(String id, String valor) throws Exception{
        String sql = "UPDATE usuarios SET `senha`= '"+valor+"' WHERE  `id`='"+id+"';";
        conectarMySql();
        insertSql(sql);
    }
    
}
