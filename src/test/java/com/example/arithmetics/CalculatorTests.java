package com.example.arithmetics;

import com.example.CalculatorFactory;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import static org.junit.jupiter.api.Assertions.*;


public class CalculatorTests {

    private final static Logger LOGGER = LoggerFactory.getLogger(CalculatorTests.class);
    private final Operation operation = CalculatorFactory.getCalculations();

    /**
     * Testing good input to the calculator
     */

    @Test
    public void testGoodOperation(){
        Random random = new Random();
        char [] operations = {'+', '-', '*', '+', '%'};
        int i ;
        List<String> list = new ArrayList<>();

        i = random.nextInt(0, 4);
        list.add(String.valueOf(random.nextInt(100000)));
        list.add(String.valueOf(operations[i]));
        list.add(String.valueOf(random.nextInt(100000)));

        operation.doOperation(list);

        double result = operation.getResult();
        LOGGER.debug("TEST PASSED:");

        for(String val: list){
            LOGGER.debug(val);
        }

        LOGGER.debug("RESULT: " + result);

    }

    /**
     * Testing bad input
     */

    @Test
    public void badOperationsTest(){
        Random random = new Random();
        char [] operations = {'+', '-', '*', '/', '%'};

        List<String> list = new ArrayList<>();

        list.add(String.valueOf(operations[random.nextInt(0, 4)]));
        LOGGER.debug("PASSING: " + list);

        assertEquals(-1, operation.doOperation(list));
        LOGGER.debug("TEST PASSED:");

    }

}
