import com.example.CalculatorFactory;
import com.example.arithmetics.Operation;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class CalculatorTests {

    private Operation operation = CalculatorFactory.getCalculations();

    @Test
    public void testGoodAddition(){

        List<String> list = new ArrayList<>();

        list.add("12");
        list.add("+");
        list.add("15");

        operation.doOperation(list);
    }
}
