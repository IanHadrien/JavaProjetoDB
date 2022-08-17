package model;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;

public class Conexao {

  public Connection getConexao(){
    try {
      Connection conn = DriverManager.getConnection(
        "jdbc:mysql://localhost/consultorio?serverTimezone=UTC", 
        "root", 
        "");
        return conn;
    } catch (Exception e) {
      System.out.println("Erro ao conectar " + e.getMessage());
      return null;
    }
  }
}
