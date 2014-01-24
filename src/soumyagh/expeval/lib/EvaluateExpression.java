package soumyagh.expeval.lib;

import java.util.ArrayList;
import java.util.List;

public class EvaluateExpression {
    private String expression;

    public EvaluateExpression(String expression) {
        this.expression = expression;
    }

    private double evaluateExpression(String expression) throws Exception {
        String[] splittedExpression = expression.trim().split(" ");
        List<String> operators = new ArrayList<String>();
        List<Double> operands = new ArrayList<Double>();
        getOperatorsOperands(splittedExpression, operators, operands);
        return getResultForMultipleOperations(operators, operands);
    }

    private double getResultForMultipleOperations(List<String> operators, List<Double> operands) throws Exception {
        SingleOperationEvaluator operations = new SingleOperationEvaluator();
        double result = operands.get(0);
        for (int i = 0; i < operators.size(); i++)
            result = operations.getOperationResult(operators.get(i), result, operands.get(i + 1));
        return result;
    }

    private void getOperatorsOperands(String[] expressionParts, List<String> operators, List<Double> operands) {
        for (String exp : expressionParts) {
            try {
                operands.add(Double.parseDouble(exp));
            } catch (Exception ex) {
                operators.add(exp);
            }
        }
    }

    private double expressionEvaluation(String expression) throws Exception {
        StringBuilder exp = new StringBuilder(expression);
        if (exp.indexOf("(") > -1) {
            handlingParentheses(exp);
            return expressionEvaluation(exp.toString());
        }
        return evaluateExpression(exp.toString());
    }

    private void handlingParentheses(StringBuilder expression) throws Exception {
        int openingBracketIndex = -1;
        int closingBracketIndex = -1;
        for (int index = 0; index < expression.length(); index++) {
            if ('(' == expression.charAt(index))
                openingBracketIndex = index;
            if (')' == expression.charAt(index)) {
                closingBracketIndex = index;
                break;
            }
        }
        String parenthesesExpression = expression.substring(openingBracketIndex + 1, closingBracketIndex);
        double result = evaluateExpression(parenthesesExpression);
        expression.replace(openingBracketIndex, closingBracketIndex + 1, Double.toString(result));
    }

    private String refactorInput() {
        return this.expression.replaceAll(" +", "").replaceAll("\\+", " + ").replaceAll("\\/", " / ")
                .replaceAll("\\-", " - ").replaceAll("\\*", " * ").replaceAll("\\^", " ^ ")
                .replaceAll("\\(", "( ").replaceAll("\\)", " )").replaceAll("  - ", " -")
                .replaceFirst("^ - ", "-");
    }

    public double expressionEvaluation() throws Exception {
        String expressionWithoutSpaces = this.refactorInput();
        return expressionEvaluation(expressionWithoutSpaces);
    }
}
