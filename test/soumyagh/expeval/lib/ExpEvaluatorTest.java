package soumyagh.expeval.lib;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class ExpEvaluatorTest {

//    @Test
//    public void onlyOneNumber() throws Exception {
//        ExpEvaluator eval = new ExpEvaluator();
//        String[] args = {"1"};
//        int result = eval.getResultByEvaluating(args);
//        assertEquals(result,1);
//    }

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
        String[] args = {"5 / 2"};
        int expected = 2; //expected should be 2.5 but No Float Handling in this version.
        int result = eval.getResultByEvaluating(args);
        assertEquals(result,expected);
    }
}