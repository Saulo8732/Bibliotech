package br.com.bibliotech.repositorio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Conexaodb {
    
    private Connection conexao;
    private PreparedStatement smt;
    
    private String host = "localhost";
    private String porta = "3306";
    private String banco = "bibliotech";
    private String usuario = "root";
    private String senha = "";
    
    
    
    public void conectarMySql() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        conexao = DriverManager.getConnection("jdbc:mysql://"+host+":"+porta+"/"+banco+"", usuario, senha);
        
        
    }
    
    
    public ResultSet executarSql(String sql) throws Exception {
        smt = conexao.prepareStatement(sql);
        ResultSet rs = smt.executeQuery(sql);
        
        return rs;
    }
    
    public void insertSql(String sql) throws Exception {
        System.out.println("executando update");
        smt = conexao.prepareStatement(sql);
        smt.executeUpdate(sql);
        smt.close();
        conexao.close();
    }
    
    
    public void fecharConexao() throws Exception{
        smt.executeQuery();
        smt.close();
        conexao.close();
    }
    
    

}
