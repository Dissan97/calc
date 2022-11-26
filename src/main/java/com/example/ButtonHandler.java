package com.example;

import javafx.scene.control.Button;

public class ButtonHandler {
    public ButtonHandler(Button button, MainController mainController){
        button.setOnAction(e -> {
            // SWITCH STATEMENT TO TRIGGER CALCULATOR WHEN SPECIAL CHAR ARE CLICKED
           mainController.input(button.getText());
        });
    }

}
