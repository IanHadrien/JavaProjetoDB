package model;

public class Cliente {
  private int id;
  private String nome;
  private String telefone;
  private String plano;

  private double valor;
  private String pagamento;

  public int getId(){ return id; }
  public String getNome(){ return nome; }
  public String getPlano(){ return plano; }
  public String getTelefone(){ return telefone; }

  public double getValor(){ return valor; }
  public String getPagamenento(){ return pagamento; }

  public void setId(int id){ this.id = id; }
  public void setNome(String nome){ this.nome = nome; }
  public void setPlano(String plano){ this.plano = plano; }
  public void setTelefone(String telefone){ this.telefone = telefone; }

  public void setValor(double v){ this.valor = v; }
  public void setPagamenento(String p){ this.pagamento = p; }
}
