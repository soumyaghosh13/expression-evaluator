package soumyagh.expeval.lib;

public class SpaceHandler {
    private final Expression expression;

    public SpaceHandler(Expression expression) {
        this.expression = expression;
    }

    String refactorInput() {
        return expression.getExpression().replaceAll(" +", "").replaceAll("\\+", " + ").replaceAll("\\/", " / ")
                .replaceAll("\\-", " - ").replaceAll("\\*", " * ").replaceAll("\\^", " ^ ")
                .replaceAll("\\(", "( ").replaceAll("\\)", " )").replaceAll("  - ", " -")
                .replaceFirst("^ - ", "-");
    }
}