import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Conexao;

public class App extends Application {

    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("./view/teladelogin.fxml"));
        Parent root = loader.load();
        primaryStage.setTitle("Sistema de Atendimento");
        primaryStage.setScene(new Scene(root, 900, 600));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args); //

        Conexao c = new Conexao();
        c.getConexao();

        System.exit(0);
    }
}
