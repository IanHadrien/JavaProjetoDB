package controller;

import java.util.Date;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.Cliente;
import model.ClienteConexao;

public class telaDeCadastroController {

    @FXML
    private Button Lista;

    @FXML
    private Button botaoLogin;

    @FXML
    private Button botaoLogin1;

    @FXML
    private Button butaoTelatorios;

    @FXML
    private Button cadastro;

    @FXML
    private DatePicker campoDataNascimento;

    @FXML
    private TextField campoNome;

    @FXML
    private TextField campoTelefone;

    @FXML
    private TextField campoValor;

    @FXML
    private RadioButton comun;

    @FXML
    private RadioButton master;

    @FXML
    private ToggleGroup planos;

    @FXML
    void btnCadastro(ActionEvent event) {
    
    }

    @FXML
    void btnCancelar(ActionEvent event) {
        System.exit(1);
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
    void btnSalvar(ActionEvent event) {
        String nome = campoNome.getText();
        String telefone = campoTelefone.getText();
        double valor = Float.parseFloat(campoValor.getText());

        System.out.println(nome);
        System.out.println(telefone);

        System.out.println(comun.selectedProperty().getValue());
        System.out.println(master.selectedProperty().getValue());

        Cliente cli = new Cliente();
        cli.setNome(nome);
        cli.setTelefone(telefone);


        if(comun.selectedProperty().getValue()){
            cli.setPlano("Comum");
            valor = ((10.0/100) * valor) + valor;
        } else {
            cli.setPlano("Master");
            valor = ((1.5/100) * valor) + valor;
        }

        System.out.println(valor);
        cli.setValor(valor);

        ClienteConexao conect = new ClienteConexao();
        conect.inserir(cli);

        campoNome.setText("");
        campoTelefone.setText("");
        campoValor.setText("");
        campoDataNascimento.setValue(null);
    }

    @FXML
    void event(MouseEvent event) {

    }

}
