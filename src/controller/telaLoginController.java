package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import model.LoginConexao;

public class telaLoginController {

    @FXML
    private Button botaoLogin;

    @FXML
    private PasswordField campoSenha;

    @FXML
    private TextField campoUsuario;

    @FXML
    void logar(ActionEvent event) throws Exception {
        String usuario = campoUsuario.getText();
        String senha = campoSenha.getText();

        LoginConexao login = new LoginConexao();
        
        if(login.validarLogin(usuario, senha)){
            try {
                Stage secondStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("../view/teladecadastro.fxml"));
                Parent root = loader.load();
                Scene cenario = new Scene(root, 900, 600);

                secondStage.setTitle("Cadastro");
                secondStage.setScene(cenario);
                secondStage.show();
            } catch(Exception e){
              System.out.println("Erro " + e.getMessage());
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setContentText("Usuario ou senha incorretos");
            alert.showAndWait();
            // taSummary.appendText()
        }
    }

}
