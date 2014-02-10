package soumyagh.expeval.lib;

import java.util.HashMap;
import java.util.Map;

public class Evaluator {
    double result;

    public double getOperationResult(String operator, double a, Double b) throws Exception {
        Map<String, Evaluable> methodMap = new HashMap<String, Evaluable>();

        methodMap.put("+", new Evaluable() {
            public void runOperation(double a, double b) {
                result = a + b;
            }

            ;
        });

        methodMap.put("-", new Evaluable() {
            public void runOperation(double a, double b) {
                result = a - b;
            }

            ;
        });

        methodMap.put("*", new Evaluable() {
            public void runOperation(double a, double b) {
                result = a * b;
            }

            ;
        });

        methodMap.put("/", new Evaluable() {
            public void runOperation(double a, double b) {
                result = a / b;
            }

            ;
        });

        methodMap.put("^", new Evaluable() {
            public void runOperation(double a, double b) {
                result = Math.pow((double) a, (double) b);
            }

            ;
        });

        methodMap.get(operator).runOperation(a, b);
        return result;
    }
}
