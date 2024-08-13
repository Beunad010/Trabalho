
package com.mycompany.projetoe;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class TransactionScreen extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Sacar/Depositar Dinheiro");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20, 20, 20, 20));
        grid.setVgap(10);
        grid.setHgap(10);

        Label transactionLabel = new Label("Tipo de Transação:");
        GridPane.setConstraints(transactionLabel, 0, 0);

        ComboBox<String> transactionType = new ComboBox<>();
        transactionType.getItems().addAll("Depositar", "Sacar");
        GridPane.setConstraints(transactionType, 1, 0);

        Label amountLabel = new Label("Valor:");
        GridPane.setConstraints(amountLabel, 0, 1);

        TextField amountInput = new TextField();
        GridPane.setConstraints(amountInput, 1, 1);

        Button confirmButton = new Button("Confirmar");
        GridPane.setConstraints(confirmButton, 1, 2);

        grid.getChildren().addAll(transactionLabel, transactionType, amountLabel, amountInput, confirmButton);

        Scene scene = new Scene(grid, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}