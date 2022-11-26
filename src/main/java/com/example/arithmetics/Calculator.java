package com.example.arithmetics;

import java.util.List;

public class Calculator implements Operation{

    private double lastResult = 0;
    private double ret = 0;


    @Override
    public int doOperation(List<String> args) {
        this.ret = 0;

        String op = "+";

        for (String arg : args){

            switch (arg){
                case "+", "-", "/", "*", "%"-> {
                    op = arg;
                    continue;
                }
                default -> {}
            }

            switch (op){
                case "+" -> {
                    if(arg.isEmpty())
                        return -1;
                    ret += Double.parseDouble(arg);
                }
                case "-" -> {
                    if(arg.isEmpty())
                        return -1;
                    ret -= Double.parseDouble(arg);
                }
                case "*" -> {
                    if(arg.isEmpty())
                        return -1;
                    ret *= Double.parseDouble(arg);
                }
                case "/" -> {
                    if(arg.isEmpty())
                        return -1;
                    if (Double.parseDouble(arg) == 0)
                        return -1;
                    ret /= Double.parseDouble(arg);

                }
                case "%" -> {
                    if(!arg.isEmpty())
                        ret = ret*Double.parseDouble(arg)/100;
                }

            }

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
