package br.com.bibliotech.dao;

import br.com.bibliotech.repositorio.Conexaodb;
import java.sql.ResultSet;


public class UsuariosDao extends Conexaodb{
    public ResultSet testarUsuario(String usuario, String senha) throws Exception {
        String sql = "SELECT * FROM usuarios WHERE login = '"+usuario+"' AND  senha = '"+senha+"';";
        ResultSet resultados;
        conectarMySql();
        resultados = executarSql(sql);
        return resultados;
    }
}
