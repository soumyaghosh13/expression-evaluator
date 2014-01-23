package soumyagh.expeval.cli;

import soumyagh.expeval.lib.ExpEvaluator;


public class ExpEvalMain {
    public static void main(String[] args) throws Exception {
        ExpEvaluator eval = new ExpEvaluator();
        double result = eval.getResultByEvaluating(args);
        System.out.println(result);
    }
}