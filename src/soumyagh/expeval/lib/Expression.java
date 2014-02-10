package soumyagh.expeval.lib;

import java.util.ArrayList;
import java.util.List;

public class Expression {

    private String expression;
    private final SpaceHandler spaceHandler = new SpaceHandler(this);
    private final BracketHandler bracketHandler = new BracketHandler(this);

    public Expression(String expression) {
        this.expression = expression;
    }

    public double evaluateExpression(String expression) throws Exception {
        String[] splittedExpression = expression.trim().split(" ");
        List<String> operators = new ArrayList<String>();
        List<Double> operands = new ArrayList<Double>();
        getOperatorsOperands(splittedExpression, operators, operands);
        return getResultForMultipleOperations(operators, operands);
    }

    private double getResultForMultipleOperations(List<String> operators, List<Double> operands) throws Exception {
        Evaluator operations = new Evaluator();
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
            bracketHandler.handlingParentheses(exp);
            return expressionEvaluation(exp.toString());
        }
        return evaluateExpression(exp.toString());
    }

    private void handlingParentheses(StringBuilder expression) throws Exception {
        bracketHandler.handlingParentheses(expression);
    }

    public double spaceHandling() throws Exception {
        String expressionWithoutSpaces = spaceHandler.refactorInput();
        return expressionEvaluation(expressionWithoutSpaces);
    }

    public String getExpression() {
        return expression;
    }
}
