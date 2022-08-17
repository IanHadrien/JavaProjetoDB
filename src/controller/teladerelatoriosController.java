package controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import com.mysql.cj.xdevapi.Client;

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
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import model.Cliente;
import model.ClienteRelatorios;

public class teladerelatoriosController implements Initializable {

    @FXML
    private Button Comum;

    @FXML
    private Button Master;

    @FXML
    private Button botaoRelatorios;

    @FXML
    private Button botaoTelaCadastro;

    @FXML
    private Button botaoTelaLista;

    @FXML
    private TableColumn<Cliente, String> colunaNome;

    @FXML
    private TableColumn<Cliente, String> colunaPlano;

    @FXML
    private TableColumn<Cliente, Double> colunaValor;

    @FXML
    private ImageView logo;

    @FXML
    private TableView<Cliente> tabelaRelatorios;

    @FXML
    private TextArea textQuantidade;

    @FXML
    private TextArea texteTotal;

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
    void btnLista(ActionEvent event) throws Exception {
        Stage secondStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../view/telalistafila.fxml"));
        Parent root = loader.load();
        Scene cenario = new Scene(root, 900, 600);

        secondStage.setTitle("Fila");
        secondStage.setScene(cenario);
        secondStage.show();
    }

    ObservableList<Cliente> observableList;

    @FXML
    void btnRelarios(ActionEvent event) {
        try {
            List<Cliente> cliente = ClienteRelatorios.listaTodosRelatorios();

            observableList.clear();

            if(cliente.size() > 0) {
                observableList.addAll(cliente);
                textQuantidade.setText("Quantidade de clientes: " + cliente.size());
                texteTotal.setText("Total arrecadado: " + ClienteRelatorios.total);
                ClienteRelatorios.total = 0;
            } else {
                System.out.println("Não ha informações");
            }

        } catch(Exception e) {
            System.out.println("Erro ao tentar consultar BD");
            e.printStackTrace();
        }
    }

    @FXML
    void btnComum(ActionEvent event) {
        try {
            List<Cliente> cliente = ClienteRelatorios.listaTodosRelatoriosComum();

            observableList.clear();

            if(cliente.size() > 0) {
                observableList.addAll(cliente);
                textQuantidade.setText("Quantidade de clientes: " + cliente.size());
                texteTotal.setText("Total arrecadado: " + ClienteRelatorios.total);
                ClienteRelatorios.total = 0;
            } else {
                System.out.println("Não ha informações");
            }

        } catch(Exception e) {
            System.out.println("Erro ao tentar consultar BD");
            e.printStackTrace();
        }
    }

    @FXML
    void btnMaster(ActionEvent event) {
        try {
            List<Cliente> cliente = ClienteRelatorios.listaTodosRelatoriosMaster();

            observableList.clear();

            if(cliente.size() > 0) {
                observableList.addAll(cliente);
                textQuantidade.setText("Quantidade de clientes: " + cliente.size());
                texteTotal.setText("Total arrecadado: " + ClienteRelatorios.total);
                ClienteRelatorios.total = 0;
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
        colunaPlano.setCellValueFactory(new PropertyValueFactory<>("Plano"));
        colunaValor.setCellValueFactory(new PropertyValueFactory<>("Valor"));

        tabelaRelatorios.setItems(observableList);
    }

}
