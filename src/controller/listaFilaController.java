package controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Cliente;
import model.ClienteConexao;

public class listaFilaController implements Initializable {

    @FXML
    private Button atender;

    @FXML
    private Button cadastro;

    @FXML
    private TableColumn<Cliente, String> colunaNome;

    @FXML
    private TableColumn<Cliente, String> colunaPlano;

    @FXML
    private TableColumn<Cliente, String> colunaTelefone;

    @FXML
    private Button comum;

    @FXML
    private Button lista;

    @FXML
    private Button master;

    @FXML
    private Button relatorios;

    @FXML
    private Button remover;

    @FXML
    private TableView<Cliente> tabelaClientes;

    @FXML
    void atenderCliente(ActionEvent event) throws Exception {
        Cliente cli = tabelaClientes.getSelectionModel().getSelectedItem();
        System.out.println(cli.getNome() + "" + cli.getTelefone() +""+ cli.getPlano());

        ClienteConexao conect = new ClienteConexao();
        conect.atender(cli);
    }

    @FXML
    void btnCadastro(ActionEvent event) throws Exception {
        Stage secondStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../view/teladecadastro.fxml"));
        Parent root = loader.load();
        Scene cenario = new Scene(root, 900, 600);

        secondStage.setTitle("Cadastro");
        secondStage.setScene(cenario);
        secondStage.show();
    }

    @FXML
    void btnLista(ActionEvent event) {
        try {
            List<Cliente> cliente = ClienteConexao.listaTodosClientes();

            observableList.clear();

            if(cliente.size() > 0) {
                observableList.addAll(cliente);
            } else {
                System.out.println("Não ha informações");
            }

        } catch(Exception e) {
            System.out.println("Erro ao tentar consultar BD");
            e.printStackTrace();
        }
    }

    @FXML
    void btnRelatorios(ActionEvent event) throws Exception {
        Stage secondStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../view/teladerelatorios.fxml"));
        Parent root = loader.load();
        Scene cenario = new Scene(root, 900, 600);

        secondStage.setTitle("Relatorios");
        secondStage.setScene(cenario);
        secondStage.show();
    }

    @FXML
    void removerCliente(ActionEvent event) {
        Cliente cli = tabelaClientes.getSelectionModel().getSelectedItem();
        
        ClienteConexao conect = new ClienteConexao();
        conect.remover(cli);
    }

    ObservableList<Cliente> observableList;

    @FXML
    void listarClientescomum(ActionEvent event) {
        try {
            List<Cliente> cliente = ClienteConexao.listaClienteC();

            observableList.clear();

            if(cliente.size() > 0) {
                observableList.addAll(cliente);
                // areaTexto.setText("" + academico.get(0) +"\n droga" );
            } else {
                System.out.println("Não ha informações");
                // areaTexto.setText("Não ha informações");
            }

        } catch(Exception e) {
            System.out.println("Erro ao tentar consultar BD");
            e.printStackTrace();
        }
    }

    @FXML
    void listarClientesmaster(ActionEvent event) {
        try {
            List<Cliente> cliente = ClienteConexao.listaClienteM();

            observableList.clear();

            if(cliente.size() > 0) {
                observableList.addAll(cliente);
            } else {
                System.out.println("Não ha informações");
            }

        } catch(Exception e) {
            System.out.println("Erro ao tentar consultar BD");
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        observableList = FXCollections.observableArrayList();

        colunaNome.setCellValueFactory(new PropertyValueFactory<>("Nome"));
        colunaTelefone.setCellValueFactory(new PropertyValueFactory<>("Telefone"));
        colunaPlano.setCellValueFactory(new PropertyValueFactory<>("Plano"));

        tabelaClientes.setItems(observableList);
    }

}
