package soumyagh.expeval.lib;

import java.util.ArrayList;
import java.util.List;

public class ExpEvaluator {
    public int getResultByEvaluating(String[] args) throws Exception {
        List<Integer> operands = new ArrayList<Integer>();
        String exp = args[0];
        if (args[0].contains("(")) exp = handlingParentheses(args[0]);
        List<String> operators = getOperatorsOperands(exp, operands);
        if (operands.size() < 2) return operands.get(0);
        Operations op = new Operations();
        int result = getResultForMultipleOperations(operands, operators, op);
        return result;
    }

    private int getResultForMultipleOperations(List<Integer> operands, List<String> operators, Operations op) throws Exception {
        int result = op.getOperationResult(operators.get(0), operands.get(0), operands.get(1));
        for (int i = 1; i < operators.size(); i++) {
            result = op.getOperationResult(operators.get(i), result, operands.get(i + 1));
        }
        return result;
    }

    private List<String> getOperatorsOperands(String exp, List<Integer> operands) {
        String[] splittedExp = exp.split(" ");
        List<String> operators = new ArrayList<String>();
        for (String s : splittedExp) {
            try {
                operands.add(Integer.parseInt(s));
            } catch (Exception ex) {
                operators.add(s);
            }
        }
        return operators;
    }

    private String handlingParentheses(String exp) throws Exception {
        StringBuffer parenthesesExp = new StringBuffer(exp);
        int startingIndex = exp.indexOf("(");
        int endingIndex = exp.indexOf(")");
        String SExp = parenthesesExp.substring(startingIndex + 1, endingIndex);
        List<Integer> parentheseOperands = new ArrayList<Integer>();

        List<String> parenthesesOperators = getOperatorsOperands(SExp.toString(), parentheseOperands);

        validatingNumOfOperands(parentheseOperands, parenthesesOperators);

        Operations op = new Operations();
        int result = getResultForMultipleOperations(parentheseOperands, parenthesesOperators, op);
        parenthesesExp.replace(startingIndex, endingIndex + 1, Integer.toString(result));
        return parenthesesExp.toString();
    }

    private void validatingNumOfOperands(List<Integer> operands, List<String> operators) {
        if (operands.size() < 2) {
            operands.add(0);
            operators.add("+");
        }
    }
}