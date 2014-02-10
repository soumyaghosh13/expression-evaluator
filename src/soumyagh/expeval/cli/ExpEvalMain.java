package soumyagh.expeval.cli;

import soumyagh.expeval.lib.Expression;

public class ExpEvalMain {
    public static void main(String[] args) throws Exception {
        Expression evaluator = new Expression(args[0]);
        System.out.println(evaluator.spaceHandling());
    }
}