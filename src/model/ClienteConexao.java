package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class ClienteConexao {
  private Conexao conexao;
  private Connection conn;

  public ClienteConexao(){
    this.conexao = new Conexao();
    this.conn = this.conexao.getConexao();
  }

  public void inserir(Cliente cli){
    String sql = "INSERT INTO cliente(nome, telefone, plano, valor) VALUES "
                   + "(?, ?, ?, ?)";

    try {
      PreparedStatement stmt = this.conn.prepareStatement(sql);
      stmt.setString(1, cli.getNome());
      stmt.setString(2, cli.getTelefone());
      stmt.setString(3, cli.getPlano());
      stmt.setDouble(4, cli.getValor());
      stmt.execute();
    } catch(Exception e){
      System.out.println("Erro " + e.getMessage());
    }
  }

  public static List<Cliente> listaTodosClientes() throws SQLException{
    Conexao conexao = new Conexao();
    Connection conn = conexao.getConexao();
    String query = "SELECT nome, telefone, plano from cliente WHERE pagamento is NULL";
    PreparedStatement querySt = conn.prepareStatement(query);
    ResultSet resultado = querySt.executeQuery();

    List<Cliente> listaCliente = new LinkedList<>();

    while(resultado.next()){
      Cliente cli = new Cliente();
      cli.setNome(resultado.getString(1));
      cli.setTelefone(resultado.getString(2));
      cli.setPlano(resultado.getString(3));
      listaCliente.add(cli);
    }

    return listaCliente;
  }

  public static List<Cliente> listaClienteC() throws SQLException{
    Conexao conexao = new Conexao();
    Connection conn = conexao.getConexao();
    String query = "SELECT nome, telefone, plano from cliente WHERE plano = 'Comum' AND pagamento is NULL";
    PreparedStatement querySt = conn.prepareStatement(query);
    ResultSet resultado = querySt.executeQuery();

    List<Cliente> listaCliente = new LinkedList<>();

    while(resultado.next()){
      Cliente cli = new Cliente();
      cli.setNome(resultado.getString(1));
      cli.setTelefone(resultado.getString(2));
      cli.setPlano(resultado.getString(3));
      listaCliente.add(cli);
    }

    return listaCliente;
  }

  public static List<Cliente> listaClienteM() throws SQLException{
    Conexao conexao = new Conexao();
    Connection conn = conexao.getConexao();
    String query = "SELECT nome, telefone, plano from cliente WHERE plano = 'Master' AND pagamento is NULL";
    PreparedStatement querySt = conn.prepareStatement(query);
    ResultSet resultado = querySt.executeQuery();

    List<Cliente> listaCliente = new LinkedList<>();

    while(resultado.next()){
      Cliente cli = new Cliente();
      cli.setNome(resultado.getString(1));
      cli.setTelefone(resultado.getString(2));
      cli.setPlano(resultado.getString(3));
      listaCliente.add(cli);
    }

    return listaCliente;
  }

  public void remover(Cliente cli){
    String sql = "DELETE FROM cliente WHERE cliente.Nome = ?";

    try {
      PreparedStatement stmt = this.conn.prepareStatement(sql);
      stmt.setString(1, cli.getNome());

      stmt.execute();
      stmt.close();
    } catch(Exception e){
      System.out.println("Erro " + e.getMessage());
    }
  }

  public void atender(Cliente cli){
    String sql = "UPDATE Cliente SET pagamento = 'Sim' WHERE nome = ?";

    try {
      PreparedStatement stmt = this.conn.prepareStatement(sql);
      stmt.setString(1, cli.getNome());

      stmt.execute();
      stmt.close();
    } catch(Exception e){
      System.out.println("Erro " + e.getMessage());
    }
  }

}
