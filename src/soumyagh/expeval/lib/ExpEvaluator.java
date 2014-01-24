package soumyagh.expeval.lib;

import java.util.ArrayList;
import java.util.List;

public class ExpEvaluator {
    public double getResultByEvaluating(String[] args) throws Exception {
        List<Double> operands = new ArrayList<Double>();
        String exp = refactorInput(args[0]);
        List<String> parenthesesExp = new ArrayList<String>();
        gettingExpressionFromMultipleParentheses(exp, parenthesesExp);
        for (String s : parenthesesExp)
            exp = handlingParentheses(exp, s);
        List<String> operators = getOperatorsOperands(exp, operands);
        if (operands.size() < 2) return operands.get(0);
        Operations op = new Operations();
        return getResultForMultipleOperations(operands, operators, op);
    }

    private String refactorInput(String exp) {
        return exp.replaceAll(" +", "").replaceAll("\\+", " + ").replaceAll("\\/", " / ")
                .replaceAll("\\-", " - ").replaceAll("\\*", " * ").replaceAll("\\^", " ^ ")
                .replaceAll("  - ", " -").replaceFirst("^ - ", "-");
    }

    private void gettingExpressionFromMultipleParentheses(String arg, List<String> parenthesesExp) {
        if (arg.contains("(")) {
            String[] ex = arg.split("\\(");
            for (String s : ex) {
                int index = s.indexOf(")");
                if (index > 0) parenthesesExp.add(s.substring(0, index));
            }
        }
    }

    private double getResultForMultipleOperations(List<Double> operands, List<String> operators, Operations op) throws Exception {
        double result = op.getOperationResult(operators.get(0), operands.get(0), operands.get(1));
        for (int i = 1; i < operators.size(); i++)
            result = op.getOperationResult(operators.get(i), result, operands.get(i + 1));
        return result;
    }

    private List<String> getOperatorsOperands(String exp, List<Double> operands) {
        String[] splittedExp = exp.split(" ");
        List<String> operators = new ArrayList<String>();
        for (String s : splittedExp)
            try {
                operands.add(Double.parseDouble(s));
            } catch (Exception ex) {
                operators.add(s);
            }
        return operators;
    }

    private String handlingParentheses(String exp,String parenthesesExp) throws Exception {
        StringBuffer userExp = new StringBuffer(exp);
        int startingIndex = exp.indexOf("(");
        int endingIndex = exp.indexOf(")");
        List<Double> parentheseOperands = new ArrayList<Double>();

        List<String> parenthesesOperators = getOperatorsOperands(parenthesesExp, parentheseOperands);
        validatingNumOfOperands(parentheseOperands, parenthesesOperators);
        Operations op = new Operations();
        double result = getResultForMultipleOperations(parentheseOperands, parenthesesOperators, op);
        userExp.replace(startingIndex, endingIndex + 1, Double.toString(result));
        return userExp.toString();
    }

    private void validatingNumOfOperands(List<Double> operands, List<String> operators) {
        if (operands.size() < 2) {
            operands.add(0.0);
            operators.add("+");
        }
    }
}
