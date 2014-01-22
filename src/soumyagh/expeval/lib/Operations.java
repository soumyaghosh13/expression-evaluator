package soumyagh.expeval.lib;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

interface Operatable {
    void runOperation(int a, int b);
}

public class Operations {
    int result;
    public int getOperationResult(String operator,int a,int b) throws Exception {
        Map<String, Operatable> methodMap = new HashMap<String, Operatable>();

        methodMap.put("+", new Operatable() {
            public void runOperation(int a, int b) { result = a + b; };
        });

        methodMap.put("-", new Operatable() {
            public void runOperation(int a , int b) { result = a - b; };
        });

        methodMap.put("*", new Operatable() {
            public void runOperation(int a , int b) { result = a * b; };
        });

        methodMap.put("/", new Operatable() {
            public void runOperation(int a , int b) { result = a / b; };
        });

        methodMap.put("^", new Operatable() {
            public void runOperation(int a , int b) { result = (int) Math.pow((double)a,(double)b); };
        });

        methodMap.get(operator).runOperation(a,b);
        return result;
    }
}