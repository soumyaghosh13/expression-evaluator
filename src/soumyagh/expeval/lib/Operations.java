package soumyagh.expeval.lib;

import java.util.HashMap;
import java.util.Map;


interface Operatable {
    void runOperation(double a, double b);
}

public class Operations {
    double result;

    public double getOperationResult(String operator, double a, Double b) throws Exception {
        Map<String, Operatable> methodMap = new HashMap<String, Operatable>();

        methodMap.put("+", new Operatable() {
            public void runOperation(double a, double b) {
                result = a + b;
            }

            ;
        });

        methodMap.put("-", new Operatable() {
            public void runOperation(double a, double b) {
                result = a - b;
            }

            ;
        });

        methodMap.put("*", new Operatable() {
            public void runOperation(double a, double b) {
                result = a * b;
            }

            ;
        });

        methodMap.put("/", new Operatable() {
            public void runOperation(double a, double b) {
                result = a / b;
            }

            ;
        });

        methodMap.put("^", new Operatable() {
            public void runOperation(double a, double b) {
                result = Math.pow((double) a, (double) b);
            }

            ;
        });

        methodMap.get(operator).runOperation(a, b);
        return result;
    }
}