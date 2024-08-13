
package com.mycompany.projetoe;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AccountBalanceScreen extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Saldo da Conta");

        VBox vbox = new VBox(10);
        vbox.setPrefSize(300, 200);
        vbox.setSpacing(10);

        Label saldoLabel = new Label("Seu saldo atual é: R$ 1000,00");
        vbox.getChildren().add(saldoLabel);

        Scene scene = new Scene(vbox);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}