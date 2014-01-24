package soumyagh.expeval.cli;

import soumyagh.expeval.lib.EvaluateExpression;

public class ExpEvalMain {
    public static void main(String[] args) throws Exception {
        EvaluateExpression evaluator = new EvaluateExpression(args[0]);
        System.out.println(evaluator.expressionEvaluation());
    }
}