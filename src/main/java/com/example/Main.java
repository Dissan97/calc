package com.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    private final Label resultText = new Label("");
    private final Label valueText = new Label("");

    private final char[] BUTTON_VALUES =
            {'C', '%', '<' , '/',
            '7', '8', '9', '*',
            '4', '5', '6', '-',
            '1', '2', '3', '+',
            'A', '0', '.', '='};


    @Override
    public void start(Stage stage) {
            

        VBox root = new VBox();
        HBox[] hBoxButtons = new HBox[5];

        Button[] buttons = new Button[20];


        //LABEL SETUP
        int WIDTH_TEXT = 50;
        int HEIGHT_TEXT = 50;


        resultText.setMinWidth(WIDTH_TEXT);
        resultText.setMinHeight(HEIGHT_TEXT);
        resultText.setStyle("-fx-font-size: 20px;-fx-font-style: italic;");
        valueText.setMinWidth(WIDTH_TEXT);
        valueText.setMinHeight(HEIGHT_TEXT);
        valueText.setStyle("fx-font-size: 20px;-fx-font-style: italic;");

        root.getChildren().add(resultText);
        
        root.getChildren().add(valueText);


        int j = 0;
        for (int i = 0; i < 20; i++){
            //BUTTON SETUP
            buttons[i] = new Button(String.valueOf(BUTTON_VALUES[i]));
            buttons[i].setStyle("-fx-color: rgba(231, 8, 146, 0.815); -fx-border: 2px; -fx-border-color: black; -fx-border-radius: 8px;");
            int BTN_WIDTH = 50;
            buttons[i].setMinWidth(BTN_WIDTH);
            int BTN_HEIGHT = 50;
            buttons[i].setMinHeight(BTN_HEIGHT);

            if(i % 4 == 0 && j <5){
                hBoxButtons[j] = new HBox();
                root.getChildren().add(hBoxButtons[j]);
                j++;
            }
            hBoxButtons[j - 1].getChildren().add(buttons[i]);
            hBoxButtons[j - 1].setStyle("-fx-background-color: black;");
        }


        new MainController(buttons, resultText, valueText);

        Scene scene = new Scene(root);
        stage.setTitle("Calculator");
        stage.setScene(scene);
        stage.resizableProperty().set(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}