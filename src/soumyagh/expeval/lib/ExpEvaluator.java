package soumyagh.expeval.lib;

import java.util.ArrayList;
import java.util.List;

public class ExpEvaluator {
    public int getResultByEvaluating (String[] args) throws Exception {
        String[] splittedExp = args[0].split(" ");
        List<Integer> operands = new ArrayList<Integer>();
        List<String> operators = getOperatorsOperands(splittedExp, operands);
        Operations op = new Operations();
        int result = getResultForMultipleOperations(operands, operators, op);
        return result;
    }

    private int getResultForMultipleOperations(List<Integer> operands, List<String> operators, Operations op) throws Exception {
        int result = op.getOperationResult(operators.get(0),operands.get(0),operands.get(1));
        for (int i = 1; i < operators.size(); i++) {
            result = op.getOperationResult(operators.get(i),result,operands.get(i+1));
        }
        return result;
    }

    private List<String> getOperatorsOperands(String[] splittedExp, List<Integer> operands) {
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
}

