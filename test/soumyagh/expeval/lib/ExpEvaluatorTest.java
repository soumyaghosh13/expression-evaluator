package soumyagh.expeval.lib;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class ExpEvaluatorTest {

    @Test
    public void EvaluatingExpressionWithOneOperand() throws Exception {
        ExpEvaluator eval = new ExpEvaluator();
        String[] args = {"5"};
        double result = eval.getResultByEvaluating(args);
        assertEquals(5.0, result);
    }

    @Test
    public void AdditionForTwoPositiveIntegers() throws Exception {
        ExpEvaluator eval = new ExpEvaluator();
        String[] args = {"2 + 3"};
        double result = eval.getResultByEvaluating(args);
        assertEquals(result, 5.0);
    }

    @Test
    public void SubtractionForTwoPositiveIntegers() throws Exception {
        ExpEvaluator eval = new ExpEvaluator();
        String[] args = {"5 - 2"};
        double result = eval.getResultByEvaluating(args);
        assertEquals(result, 3.0);
    }

    @Test
    public void MultiplicationForTwoPositiveIntegers() throws Exception {
        ExpEvaluator eval = new ExpEvaluator();
        String[] args = {"5 * 5"};
        double result = eval.getResultByEvaluating(args);
        assertEquals(result, 25.0);
    }

    @Test
    public void DivisionForTwoPositiveIntegers() throws Exception {
        ExpEvaluator eval = new ExpEvaluator();
        String[] args = {"4 / 2"};
        double result = eval.getResultByEvaluating(args);
        assertEquals(result, 2.0);
    }

    @Test
    public void PowerOperationForPositiveIntegers() throws Exception {
        ExpEvaluator eval = new ExpEvaluator();
        String[] args = {"2 ^ 10"};
        double result = eval.getResultByEvaluating(args);
        assertEquals(result, 1024.0);
    }

    @Test
    public void DivisionOfOddNumberGiveInteger() throws Exception {
        ExpEvaluator eval = new ExpEvaluator();
        String[] args = {"22 / 3"};
        double expected = 7.333333333333333;
        double result = eval.getResultByEvaluating(args);
        assertEquals(result, expected);
    }

    @Test
    public void AdditionForMultipleNumbers() throws Exception {
        ExpEvaluator eval = new ExpEvaluator();
        String[] args = {"1 + 2 + 3"};
        double result = eval.getResultByEvaluating(args);
        assertEquals(6.0, result);
    }

    @Test
    public void SubtractionForMultipleNumbers() throws Exception {
        ExpEvaluator eval = new ExpEvaluator();
        String[] args = {"10 - 1 - 2 - 3"};
        double result = eval.getResultByEvaluating(args);
        assertEquals(4.0, result);
    }

    @Test
    public void MultiplicationOfMultipleNumbers() throws Exception {
        ExpEvaluator eval = new ExpEvaluator();
        String[] args = {"2 * 3 * 5 * 5 * 2"};
        double result = eval.getResultByEvaluating(args);
        assertEquals(300.0, result);
    }

    @Test
    public void DivisionOfThreeNumbers() throws Exception {
        ExpEvaluator eval = new ExpEvaluator();
        String[] args = {"100 / 2 / 5 / 5 / 2 / 1"};
        double result = eval.getResultByEvaluating(args);
        assertEquals(1.0, result);
    }

    @Test
    public void CombinationOfAdditinAndSubtraction() throws Exception {
        ExpEvaluator eval = new ExpEvaluator();
        String[] args = {"100 + 50 - 50"};
        double result = eval.getResultByEvaluating(args);
        assertEquals(100.0, result);
    }

    @Test
    public void CombinationOfMultiplication_Division_Power() throws Exception {
        ExpEvaluator eval = new ExpEvaluator();
        String[] args = {"10 * 2 / 2 ^ 3"};
        double result = eval.getResultByEvaluating(args);
        assertEquals(1000.0, result);
    }

    @Test
    public void CombinationOf_Addition_Subtraction_Multiplication_Division_Power() throws Exception {
        ExpEvaluator eval = new ExpEvaluator();
        String[] args = {"10 + 15 - 5 * 5 / 2 ^ 2"};
        double result = eval.getResultByEvaluating(args);
        assertEquals(2500.0, result);
    }

    @Test
    public void EvaluatingExpressionWithSingleValueWithInABracket() throws Exception {
        ExpEvaluator eval = new ExpEvaluator();
        String[] args = {"1 + (1)"};
        double result = eval.getResultByEvaluating(args);
        assertEquals(2.0, result);
    }

    @Test
    public void OnePairOfBracketEvaluateFirst() throws Exception {
        ExpEvaluator eval = new ExpEvaluator();
        String[] args = {"1 + (5 - 3)"};
        double result = eval.getResultByEvaluating(args);
        assertEquals(3.0, result);
    }

    @Test
    public void BracketShouldEvaluateFirstThenLeftToRight() throws Exception {
        ExpEvaluator eval = new ExpEvaluator();
        String[] args = {"10 - (2 + 3) * 2"};
        double result = eval.getResultByEvaluating(args);
        assertEquals(10.0, result);
    }

    @Test
    public void multipleBracketHandels() throws Exception {
        ExpEvaluator eval = new ExpEvaluator();
        String[] args = {"(5 + 5) + (5 + 5)"};
        double result = eval.getResultByEvaluating(args);
        assertEquals(20.0, result);
    }

    @Test
    public void floatValueWithPowerOperation() throws Exception {
        ExpEvaluator eval = new ExpEvaluator();
        String[] args = {"(2.5 + 2.5 + 2.5 + 2.5) ^ (2 + 2)"};
        double result = eval.getResultByEvaluating(args);
        assertEquals(10000.0, result);
    }

    @Test
    public void multipleBracketWithFloatingNumbers() throws Exception {
        ExpEvaluator eval = new ExpEvaluator();
        String[] args = {"2 + (22 / 3) + (22 / 3)"};
        double result = eval.getResultByEvaluating(args);
        assertEquals(16.666666666666666, result);
    }



}