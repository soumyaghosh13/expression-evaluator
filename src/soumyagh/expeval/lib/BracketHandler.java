package soumyagh.expeval.lib;

public class BracketHandler {
    private final Expression expression;

    public BracketHandler(Expression expression) {
        this.expression = expression;
    }

    void handlingParentheses(StringBuilder expression) throws Exception {
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
        double result = this.expression.evaluateExpression(parenthesesExpression);
        expression.replace(openingBracketIndex, closingBracketIndex + 1, Double.toString(result));
    }
}