
package com.mycompany.projetoe;


import com.mycompany.projetoe.dao.UserDAO;
import com.mycompany.projetoe.model.User;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class LoginScreen extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Login");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20, 20, 20, 20));
        grid.setVgap(10);
        grid.setHgap(10);

        Label usernameLabel = new Label("Número da Conta:");
        GridPane.setConstraints(usernameLabel, 0, 0);

        TextField usernameInput = new TextField();
        usernameInput.setPromptText("Digite seu número de conta");
        GridPane.setConstraints(usernameInput, 1, 0);

        Label passwordLabel = new Label("Senha:");
        GridPane.setConstraints(passwordLabel, 0, 1);

        PasswordField passwordInput = new PasswordField();
        passwordInput.setPromptText("Digite sua senha");
        GridPane.setConstraints(passwordInput, 1, 1);

        Button loginButton = new Button("Login");
        GridPane.setConstraints(loginButton, 1, 2);
        
        loginButton.setOnAction(e -> {
            String numeroConta = usernameInput.getText();
            String senha = passwordInput.getText();
            UserDAO userDao = new UserDAO();
            try {
                User user = userDao.authenticateUser(numeroConta, senha);
                if (user != null) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Login bem-sucedido");
                    alert.setHeaderText(null);
                    alert.setContentText("Bem-vindo, " + user.getNome() + "!");
                    alert.showAndWait();
                    // Aqui você pode redirecionar para a próxima tela, como a tela de saldo
                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Erro de login");
                    alert.setHeaderText(null);
                    alert.setContentText("Número da conta ou senha incorretos.");
                    alert.showAndWait();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        grid.getChildren().addAll(usernameLabel, usernameInput, passwordLabel, passwordInput, loginButton);

        Scene scene = new Scene(grid, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}