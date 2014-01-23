package soumyagh.expeval.lib;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class ExpEvaluatorTest {

    @Test
    public void testgetResultByEvaluatingExpressionWhichContainsOneOperand() throws Exception {
        ExpEvaluator eval = new ExpEvaluator();
        String[] args = {"1"};
        double result = eval.getResultByEvaluating(args);
        assertEquals(1.0, result);
    }

    @Test
    public void additionForTwoNumbers() throws Exception {
        ExpEvaluator eval = new ExpEvaluator();
        String[] args = {"1 + 2"};
        double result = eval.getResultByEvaluating(args);
        assertEquals(3.0, result);
    }
    @Test
    public void MultiplicationForTwoNumbers() throws Exception {
        ExpEvaluator eval = new ExpEvaluator();
        String[] args = {"1 * 2"};
        double result = eval.getResultByEvaluating(args);
        assertEquals(2.0, result);
    }
    @Test
    public void DivisionForTwoNumbers() throws Exception {
        ExpEvaluator eval = new ExpEvaluator();
        String[] args = {"14 / 2"};
        double result = eval.getResultByEvaluating(args);
        assertEquals(7.0, result);
    }
//    @Test
//    public void SubtractionForTwoNumbers() throws Exception {
//        ExpEvaluator eval = new ExpEvaluator();
//        String[] args = {"25 - 2"};
//        double result = eval.getResultByEvaluating(args);
//        assertEquals(23.0, result);
//    }
    @Test
    public void PowerOfTwoNumbers() throws Exception {
        ExpEvaluator eval = new ExpEvaluator();
        String[] args = {"5 ^ 2"};
        double result = eval.getResultByEvaluating(args);
        assertEquals(25.0, result);
    }

    @Test
    public void testgetResultByEvaluatingExpressionWhichContains2OperatorsAnd3operands() throws Exception {
        ExpEvaluator eval = new ExpEvaluator();
        String[] args = {"1 + 2 * 3"};
        double result = eval.getResultByEvaluating(args);
        assertEquals(9.0, result);
    }

    @Test
    public void additionOfMultipleNumbers() throws Exception {
        ExpEvaluator eval = new ExpEvaluator();
        String[] args = {"1 + 2 + 3 + 1 + 5"};
        double result = eval.getResultByEvaluating(args);
        assertEquals(12.0, result);
    }
//    @Test
//    public void subtractionOfMultipleNumber() throws Exception {
//        ExpEvaluator eval = new ExpEvaluator();
//        String[] args = {"100 - 50 - 30 -10"};
//        double result = eval.getResultByEvaluating(args);
//        assertEquals(10.0, result);
//    }

    @Test
    public void multiplicationOfMultipleNumbers() throws Exception {
        ExpEvaluator eval = new ExpEvaluator();
        String[] args = {"10 * 2 * 5 * 7"};
        double result = eval.getResultByEvaluating(args);
        assertEquals(700.0, result);
    }

    @Test
    public void DivisionOfMultipleNumber() throws Exception {
        ExpEvaluator eval = new ExpEvaluator();
        String[] args = {"100 / 5 / 2 / 2"};
        double result = eval.getResultByEvaluating(args);
        assertEquals(5.0, result);
    }

    @Test
    public void combinationOfMultipleOperators() throws Exception {
        ExpEvaluator eval = new ExpEvaluator();
        String[] args = {"10 + 40 * 4 / 50 ^ 2"};
        double result = eval.getResultByEvaluating(args);
        assertEquals(16.0, result);
    }

    @Test
    public void ExpressionWithOnePairOfBracketInMiddle() throws Exception {
        ExpEvaluator eval = new ExpEvaluator();
        String[] args = {"1 + (2 + 3) + 1"};
        double result = eval.getResultByEvaluating(args);
        assertEquals(7.0, result);
    }

    @Test
    public void ExpressionWithOneBracketInStarting() throws Exception {
        ExpEvaluator eval = new ExpEvaluator();
        String[] args = {"(2 + 3) + 1"};
        double result = eval.getResultByEvaluating(args);
        assertEquals(6.0, result);
    }

    @Test
    public void ExpressionWithOneBracketInEnd() throws Exception {
        ExpEvaluator eval = new ExpEvaluator();
        String[] args = {"1 + (2 + 3)"};
        double result = eval.getResultByEvaluating(args);
        assertEquals(6.0, result);
    }

    @Test
    public void SingleValueInBracketAllowed() throws Exception {
        ExpEvaluator eval = new ExpEvaluator();
        String[] args = {"1 + (2)"};
        double result = eval.getResultByEvaluating(args);
        assertEquals(3.0, result);
    }


    @Test
    public void twoPairOfBracketAllowed() throws Exception {
        ExpEvaluator eval = new ExpEvaluator();
        String[] args = {"(1 + 2 + 1) * (2 + 1)"};
        double result = eval.getResultByEvaluating(args);
        assertEquals(12.0, result);
    }

    @Test
    public void multiplePairOfBracketAllowed() throws Exception {
        ExpEvaluator eval = new ExpEvaluator();
        String[] args = {"1 + (1 + 1) * (1 + 1) * (1 + 1)"};
        double result = eval.getResultByEvaluating(args);
        assertEquals(12.0, result);
    }

    @Test
    public void combinationOfOperationWithMultipleBrackets() throws Exception {
        ExpEvaluator eval = new ExpEvaluator();
        String[] args = {"1 + (1 + 2) * (2 + 1) * 2 + (1 + 1) + (2 * 1) * (1) + (2 + 2)"};
        double result = eval.getResultByEvaluating(args);
        assertEquals(32.0, result);
    }

    @Test
    public void FloatNumbersWithMultipleBracket() throws Exception {
        ExpEvaluator eval = new ExpEvaluator();
        String[] args = {"(1.5 + 1.5) * (1.5 + 1.5)"};
        double result = eval.getResultByEvaluating(args);
        assertEquals(9.0, result);
    }

    @Test
    public void ExceedingTheRangeOfIntegerAllowed() throws Exception {
        ExpEvaluator eval = new ExpEvaluator();
        String[] args = {"2 ^ 33"};
        double result = eval.getResultByEvaluating(args);
        assertEquals(8.589934592E9, result);
    }

    @Test
    public void evaluateAnswerAsDecimal() throws Exception {
        ExpEvaluator eval = new ExpEvaluator();
        String[] args = {"2 + ( 22 / 3) + 1"};
        double result = eval.getResultByEvaluating(args);
        assertEquals(10.333333333333333, result);
    }

    @Test
    public void withoutSpacesExpressionEvaluated() throws Exception {
        ExpEvaluator eval = new ExpEvaluator();
        String[] args = {"2+(22/3)+1"};
        double result = eval.getResultByEvaluating(args);
        assertEquals(10.333333333333333, result);
    }

    @Test
    public void AnyNumberOfSpacesHandeledInAnyPosition() throws Exception {
        ExpEvaluator eval = new ExpEvaluator();
        String[] args = {"        2+ (   22 /3)+1     "};
        double result = eval.getResultByEvaluating(args);
        assertEquals(10.333333333333333, result);
    }
//    @Test
//    public void testgetResultByGivingNegativeNumbers() throws Exception {
//        ExpEvaluator eval = new ExpEvaluator();
//        String[] args = {" -2 +1"};
//        double result = eval.getResultByEvaluating(args);
//        assertEquals(-1.0, result);
//    }
}