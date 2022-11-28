package com.example;

import com.example.arithmetics.Operation;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MainController {

    private final List<String> valuesToOperate = new ArrayList<>();
    private double results = 0;
    private final Label[] labels = new Label[3];
    private String text = "";
    private String value = "0";

    private final Operation calculator = CalculatorFactory.getCalculations();

    /**
     * Generating the controller for the application
     * @param buttons passing the button needed for the application
     * @param labelOne Label that shall show value inserted by user
     * @param labelTwo Label use to provide result to the user
     */
    public MainController(Button[] buttons, Label labelOne, Label labelTwo){

        this.labels[0] = labelOne;
        this.labels[1] = labelTwo;

        for (Button button : buttons) {
            try {
                new ButtonHandler(button, this);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * Operation that will use method doOperation implemented in calculator
     * @return error code -1 or 0 it's all ok
     */

    private int operation(){
        if(calculator.doOperation(valuesToOperate) == -1){
            this.clearValues();
            return -1;
        }
        this.results = calculator.getResult();
        this.clearValues();
        return 0;
    }

    private Label getLabel(int index){
        return labels[index];
    }

    private void addValue(String value){
            valuesToOperate.add(value);
    }

    private void clearValues() {
        this.valuesToOperate.clear();
    }

    private void getLastResult() {
        this.getLabel(1).setText(String.valueOf(calculator.getLastResult()));
    }

    /**
     * This method will analyze the passed string to avoid errors
     */

    private void operate() {
        this.results = 0;
        switch (this.value){
            case "+", "-", "/", "*" ,"", "%"-> {
            }
            default -> this.addValue(this.value);
        }

        switch (this.value){

            case "+", "-", "/", "*" ,"", "%"-> {
                try {
                    this.getLabel(1).setText("ERROR");
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }

            default -> {
                String res;
                if(this.operation() == -1)
                    res = "ERROR";
                else
                    res = String.valueOf(this.results);
                try {
                    this.getLabel(1).setText(res);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }

        this.value = "0";
        this.text = "";
    }

    private void addOperation(String op) {
        this.addValue(this.value);
        this.addValue(op);
        this.value = "0";
        this.text += op;
    }

    private void undo() {
        if(!Objects.equals(this.value, "0")) {
            StringBuilder stringBuffer = new StringBuilder(this.value);
            stringBuffer.deleteCharAt(stringBuffer.length() - 1);
            this.value = stringBuffer.toString();
        }
        if(!Objects.equals(this.text, "")) {
            StringBuilder stringBuffer = new StringBuilder(this.text);
            stringBuffer.deleteCharAt(stringBuffer.length() - 1);
            this.text = stringBuffer.toString();
        }
    }


    private void clear() {
        this.text = "";
        this.value = "0";
        this.clearValues();
    }

    /**
     * Parsing input from button handler
     * @param in button input handled by buttons
     */
    public void input(String in){
        switch (in){
            case "C" -> clear();
            case "<" -> undo();
            case "+" -> addOperation("+");
            case "-" -> addOperation("-");
            case "/" -> addOperation("/");
            case "*" -> addOperation("*");
            case "=" -> operate();
            case "A" -> getLastResult();
            case "%" -> addOperation("%");
            default -> {
                this.value += in;
                this.text += in;
            }
        }

        try {
            this.getLabel(0).setText(this.text);

        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}

