package com.example.arithmetics;

import java.util.List;

public class Calculator implements Operation{

    private double lastResult = 0;
    private double ret = 0;


    /**
     * Calculator main method implemented to do operation by getting a list of string that will be passed to
     * @param args : List<String> That will be analyzed
     * @return returning error code if all ok return 0 else return -1
     */

    @Override
    public int doOperation(List<String> args) {
        this.ret = 0;

        String op = "+";
        boolean isThereValue = false;

        for (String arg : args){

            switch (arg){
                case "+", "-", "/", "*", "%"-> {
                    op = arg;
                    continue;
                }
                default -> {}

            }

            isThereValue = true;

            switch (op){
                case "+" ->
                    ret += Double.parseDouble(arg);

                case "-" ->
                    ret -= Double.parseDouble(arg);

                case "*" ->
                    ret *= Double.parseDouble(arg);

                case "/" -> {
                    if (Double.parseDouble(arg) == 0)
                        return -1;
                    ret /= Double.parseDouble(arg);
                }
                case "%" ->
                        ret = ret*Double.parseDouble(arg)/100;

            }

        }

        if (!isThereValue){
            return -1;
        }

        return 0;
    }

    @Override
    public double getLastResult(){
        return this.lastResult;
    }

    @Override
    public double getResult() {
        this.lastResult = this.ret;
        return this.ret;
    }
}
