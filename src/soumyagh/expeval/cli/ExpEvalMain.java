package soumyagh.expeval.cli;

import soumyagh.expeval.lib.ExpEvaluator;

public class ExpEvalMain {
    public static void main(String[] args) {
        ExpEvaluator eval = new ExpEvaluator();
        int result = eval.hello(args);
        System.out.println(result);
    }
}
