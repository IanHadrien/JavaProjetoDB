package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginConexao {
  
  private Conexao conexao;
  private Connection conn;

  public LoginConexao(){
    this.conexao = new Conexao();
    this.conn = this.conexao.getConexao();
  }

  public boolean validarLogin(String usuario, String senha) throws SQLException {

    String query = "SELECT login, senha from administrador WHERE login = '"+usuario+"' AND senha = '" +senha+"'";
    PreparedStatement querySt = conn.prepareStatement(query);
    ResultSet rs = querySt.executeQuery();

    while(rs.next()){
        if(rs.getString(1).equals(usuario)&& rs.getString(2).equals(senha)){
          System.out.println("Login Certo");
          return true;
        }
    }

    return false;
  }

}
