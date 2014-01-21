package soumyagh.expeval.lib;

import java.util.ArrayList;
import java.util.List;

public class ExpEvaluator {
    public int getResultByEvaluating(String[] args) throws Exception {
        String[] splittedExp = args[0].split(" ");
        List<Integer> operands = new ArrayList<Integer>();
        List<String> operators = new ArrayList<String>();
        for (String s : splittedExp) {
            try {
                operands.add(Integer.parseInt(s));
            } catch (Exception ex) {
                operators.add(s);
            }
        }
        Operations op = new Operations();
        return op.getOperationResult(operators.get(0), operands.get(0), operands.get(1));
    }
}

