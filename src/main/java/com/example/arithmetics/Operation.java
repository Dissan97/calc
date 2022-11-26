package com.example.arithmetics;

import java.util.List;

public interface Operation {

    int doOperation(List<String> args);

    double getLastResult();
    double getResult();
    
}
