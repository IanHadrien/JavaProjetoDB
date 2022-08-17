package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class ClienteRelatorios {
  private Conexao conexao;
  private Connection conn;
  public static double total = 0;

  public ClienteRelatorios(){
    this.conexao = new Conexao();
    this.conn = this.conexao.getConexao();
  }

  public static List<Cliente> listaTodosRelatorios() throws SQLException {
    Conexao conexao = new Conexao();
    Connection conn = conexao.getConexao();
    String query = "SELECT nome, plano, valor FROM cliente WHERE pagamento = 'Sim'";
    PreparedStatement querySt = conn.prepareStatement(query);
    ResultSet resultado = querySt.executeQuery();

    List<Cliente> listaCliente = new LinkedList<>();

    while(resultado.next()){
      Cliente cli = new Cliente();
      cli.setNome(resultado.getString(1));
      cli.setPlano(resultado.getString(2));
      cli.setValor(resultado.getDouble(3));
      // System.out.println(resultado.getDouble(3));
      total = resultado.getDouble(3) + total;
      listaCliente.add(cli);
    }

    return listaCliente;
  }

  public static List<Cliente> listaTodosRelatoriosComum() throws SQLException{
    Conexao conexao = new Conexao();
    Connection conn = conexao.getConexao();
    String query = "SELECT nome, plano, valor from cliente WHERE pagamento = 'Sim' AND plano = 'Comum'";
    PreparedStatement querySt = conn.prepareStatement(query);
    ResultSet resultado = querySt.executeQuery();

    List<Cliente> listaCliente = new LinkedList<>();

    while(resultado.next()){
      Cliente cli = new Cliente();
      cli.setNome(resultado.getString(1));
      cli.setPlano(resultado.getString(2));
      cli.setValor(resultado.getDouble(3));
      total = resultado.getDouble(3) + total;
      listaCliente.add(cli);
    }

    return listaCliente;
  }

  public static List<Cliente> listaTodosRelatoriosMaster() throws SQLException{
    Conexao conexao = new Conexao();
    Connection conn = conexao.getConexao();
    String query = "SELECT nome, plano, valor from cliente WHERE pagamento = 'Sim' AND plano = 'Master'";
    PreparedStatement querySt = conn.prepareStatement(query);
    ResultSet resultado = querySt.executeQuery();

    List<Cliente> listaCliente = new LinkedList<>();

    while(resultado.next()){
      Cliente cli = new Cliente();
      cli.setNome(resultado.getString(1));
      cli.setPlano(resultado.getString(2));
      cli.setValor(resultado.getDouble(3));
      total = resultado.getDouble(3) + total;
      listaCliente.add(cli);
    }

    return listaCliente;
  }
}
