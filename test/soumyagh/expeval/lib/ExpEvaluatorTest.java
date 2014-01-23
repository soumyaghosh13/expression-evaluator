package soumyagh.expeval.lib;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class ExpEvaluatorTest {

    @Test
    public void AdditionForTwoPositiveIntegers() throws Exception {
        ExpEvaluator eval = new ExpEvaluator();
        String[] args = {"2 + 3"};
        int result = eval.getResultByEvaluating(args);
        assertEquals(result,5);
    }

    @Test
    public void SubtractionForTwoPositiveIntegers() throws Exception {
        ExpEvaluator eval = new ExpEvaluator();
        String[] args = {"5 - 2"};
        int result = eval.getResultByEvaluating(args);
        assertEquals(result,3);
    }

    @Test
    public void MultiplicationForTwoPositiveIntegers() throws Exception {
        ExpEvaluator eval = new ExpEvaluator();
        String[] args = {"5 * 5"};
        int result = eval.getResultByEvaluating(args);
        assertEquals(result,25);
    }

    @Test
    public void DivisionForTwoPositiveIntegers() throws Exception {
        ExpEvaluator eval = new ExpEvaluator();
        String[] args = {"4 / 2"};
        int result = eval.getResultByEvaluating(args);
        assertEquals(result,2);
    }

    @Test
    public void PowerOperationForPositiveIntegers() throws Exception {
        ExpEvaluator eval = new ExpEvaluator();
        String[] args = {"2 ^ 10"};
        int result = eval.getResultByEvaluating(args);
        assertEquals(result,1024);
    }

    @Test
    public void DivisionOfOddNumberGiveInteger() throws Exception {
        ExpEvaluator eval = new ExpEvaluator();
        String[] args = {"22 / 3"};
        int expected = 7;
        int result = eval.getResultByEvaluating(args);
        assertEquals(result,expected);
    }

    @Test
    public void AdditionForMultipleNumbers() throws Exception {
        ExpEvaluator eval = new ExpEvaluator();
        String[] args = {"1 + 2 + 3"};
        int result = eval.getResultByEvaluating(args);
        assertEquals(6, result);
    }

    @Test
    public void SubtractionForMultipleNumbers() throws Exception {
        ExpEvaluator eval = new ExpEvaluator();
        String[] args = {"10 - 1 - 2 - 3"};
        int result = eval.getResultByEvaluating(args);
        assertEquals(4, result);
    }

    @Test
    public void MultiplicationOfMultipleNumbers() throws Exception {
        ExpEvaluator eval = new ExpEvaluator();
        String[] args = {"2 * 3 * 5 * 5 * 2"};
        int result = eval.getResultByEvaluating(args);
        assertEquals(300, result);
    }

    @Test
    public void DivisionOfThreeNumbers() throws Exception {
        ExpEvaluator eval = new ExpEvaluator();
        String[] args = {"100 / 2 / 5 / 5 / 2 / 1"};
        int result = eval.getResultByEvaluating(args);
        assertEquals(1, result);
    }

    @Test
    public void CombinationOfAdditinAndSubtraction() throws Exception {
        ExpEvaluator eval = new ExpEvaluator();
        String[] args = {"100 + 50 - 50"};
        int result = eval.getResultByEvaluating(args);
        assertEquals(100, result);
    }

    @Test
    public void CombinationOfMultiplication_Division_Power() throws Exception {
        ExpEvaluator eval = new ExpEvaluator();
        String[] args = {"10 * 2 / 2 ^ 3"};
        int result = eval.getResultByEvaluating(args);
        assertEquals(1000, result);
    }

    @Test
    public void CombinationOf_Addition_Subtraction_Multiplication_Division_Power() throws Exception {
        ExpEvaluator eval = new ExpEvaluator();
        String[] args = {"10 + 15 - 5 * 5 / 2 ^ 2"};
        int result = eval.getResultByEvaluating(args);
        assertEquals(2500, result);
    }

    @Test
    public void OnePairOfBracketEvaluateFirst() throws Exception {
        ExpEvaluator eval = new ExpEvaluator();
        String[] args = {"1 + (5 - 3)"};
        int result = eval.getResultByEvaluating(args);
        assertEquals(3, result);
    }
    @Test
    public void BracketShouldEvaluateFirstThenLeftToRight() throws Exception {
        ExpEvaluator eval = new ExpEvaluator();
        String[] args = {"10 - (2 + 3) * 2"};
        int result = eval.getResultByEvaluating(args);
        assertEquals(10, result);
    }

    @Test
    public void EvaluatingExpressionWithSingleValueWithInABracket() throws Exception {
        ExpEvaluator eval = new ExpEvaluator();
        String[] args = {"1 + (1)"};
        int result = eval.getResultByEvaluating(args);
        assertEquals(2, result);
    }
    @Test
    public void EvaluatingExpressionWithOneOperand() throws Exception {
        ExpEvaluator eval = new ExpEvaluator();
        String[] args = {"5"};
        int result = eval.getResultByEvaluating(args);
        assertEquals(5, result);
    }
}