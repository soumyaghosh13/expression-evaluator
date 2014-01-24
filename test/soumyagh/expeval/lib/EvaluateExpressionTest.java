package soumyagh.expeval.lib;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class EvaluateExpressionTest {
    @Test
    public void additionOfTwoNumbers() throws Exception {
        EvaluateExpression evaluator = new EvaluateExpression("22 + 3");
        double expected = 25;

        double actual = evaluator.expressionEvaluation();

        assertEquals(expected, actual);
    }

    @Test
    public void subtractionOfTwoNumbers() throws Exception {
        EvaluateExpression eval = new EvaluateExpression("25 - 3");
        double result = eval.expressionEvaluation();
        assertEquals(22.0, result);
    }
    @Test
    public void multiplicationOfTwoNumbers() throws Exception {
        String args = "10 * 20";
        EvaluateExpression eval = new EvaluateExpression(args);
        double result = eval.expressionEvaluation();
        assertEquals(200.0, result);
    }

    @Test
    public void divisionOfEvenNumbers() throws Exception {
        EvaluateExpression eval = new EvaluateExpression("22 / 2");
        double result = eval.expressionEvaluation();
        assertEquals(11.0, result);
    }

    @Test
    public void divisionOfOddNumbers() throws Exception {
        EvaluateExpression eval = new EvaluateExpression("22 / 7");
        double result = eval.expressionEvaluation();
        assertEquals(3.142857142857143, result);
    }

    @Test
    public void powerOfTwoNumber() throws Exception {
        EvaluateExpression eval = new EvaluateExpression("2 ^ 10");
        double result = eval.expressionEvaluation();
        assertEquals(1024.0, result);
    }

    @Test
    public void additionOfMultipelNumbers() throws Exception {
        EvaluateExpression eval = new EvaluateExpression("10 + 20 + 5 + 30");
        double result = eval.expressionEvaluation();
        assertEquals(65.0, result);
    }


    @Test
    public void subtractionOfMultipelNumbers() throws Exception {
        EvaluateExpression eval = new EvaluateExpression("100 - 20 - 50 - 30");
        double result = eval.expressionEvaluation();
        assertEquals(0.0, result);
    }


    @Test
    public void multiplicationOfMultipelNumbers() throws Exception {
        EvaluateExpression eval = new EvaluateExpression("10 * 2 * 5 * 3");
        double result = eval.expressionEvaluation();
        assertEquals(300.0, result);
    }


    @Test
    public void divisionOfMultipelNumbers() throws Exception {
        EvaluateExpression eval = new EvaluateExpression("100 / 2 / 5 / 2");
        double result = eval.expressionEvaluation();
        assertEquals(5.0, result);
    }

    @Test
    public void combinationOfAdditinAndSubtraction() throws Exception {
        EvaluateExpression eval = new EvaluateExpression("10 + 20 - 5");
        double result = eval.expressionEvaluation();
        assertEquals(25.0, result);
    }

    @Test
    public void combinationOfMultiplicationAndSubtraction() throws Exception {
        EvaluateExpression eval = new EvaluateExpression("10 * 2 / 5");
        double result = eval.expressionEvaluation();
        assertEquals(4.0, result);
    }

    @Test
    public void combinationOfMultiplicationAndAddition() throws Exception {
        String args = "10 + 20 * 30 + 10";
        EvaluateExpression eval = new EvaluateExpression(args);
        double result = eval.expressionEvaluation();
        assertEquals(910.0, result);
    }

    @Test
    public void combinationOfSubtractionAndDivison() throws Exception {
        String args = "10 - 2 / 4";
        EvaluateExpression eval = new EvaluateExpression(args);
        double result = eval.expressionEvaluation();
        assertEquals(2.0, result);
    }


    @Test
    public void combinationOfPowerAndAddition() throws Exception {
        String args = "2 + 2 ^ 2";
        EvaluateExpression eval = new EvaluateExpression(args);
        double result = eval.expressionEvaluation();
        assertEquals(16.0, result);
    }


    @Test
    public void combinationOfAllBasicOperand() throws Exception {
        String args = "10 + 20 - 5 * 4 / 4 ^ 2";
        EvaluateExpression eval = new EvaluateExpression(args);
        double result = eval.expressionEvaluation();
        assertEquals(625.0, result);
    }

    @Test
    public void OnePairOfBracketAtStarting() throws Exception {
        String args = "(2 + 3) + 5";
        EvaluateExpression eval = new EvaluateExpression(args);
        double result = eval.expressionEvaluation();
        assertEquals(10.0, result);
    }

    @Test
    public void OneBracketInMiddle() throws Exception {
        String args = "5 + (2 + 3) + 5";
        EvaluateExpression eval = new EvaluateExpression(args);
        double result = eval.expressionEvaluation();
        assertEquals(15.0, result);
    }


    @Test
    public void OnePairOfBracketAtTheEnd() throws Exception {
        String args = "5 + (2 + 3)";
        EvaluateExpression eval = new EvaluateExpression(args);
        double result = eval.expressionEvaluation();
        assertEquals(10.0, result);
    }

    @Test
    public void oneNumberInOnePairOfBracket() throws Exception {
        String args = "1 + (2)";
        EvaluateExpression eval = new EvaluateExpression(args);
        double result = eval.expressionEvaluation();
        assertEquals(3.0, result);
    }

    @Test
    public void singleNumberWithoutOperand() throws Exception {
        String args = "1";
        EvaluateExpression eval = new EvaluateExpression(args);
        double result = eval.expressionEvaluation();
        assertEquals(1.0, result);
    }

    @Test
    public void multiplePairOfBrackets() throws Exception {
        String args = "(10 + 20 + 10) * (20 + 10)";
        EvaluateExpression eval = new EvaluateExpression(args);
        double result = eval.expressionEvaluation();
        assertEquals(1200.0, result);
    }

    @Test
    public void MultiplePairOfBracketInDifferentPlaces() throws Exception {
        String args = "(1 + 1) - 1 + (1 + 1) * 1 + (1 + 1) * 1 + (1 + 1)";
        EvaluateExpression eval = new EvaluateExpression(args);
        double result = eval.expressionEvaluation();
        assertEquals(7.0, result);
    }


    @Test
    public void floatNumbersWithSingleBracket() throws Exception {
        String args = "(22.22 + 22.22)";
        EvaluateExpression eval = new EvaluateExpression(args);
        double result = eval.expressionEvaluation();
        assertEquals(44.44, result);
    }

    @Test
    public void floatNumbersInMultipleBrackets() throws Exception {
        String args = "(22.22 + 22.22) * (22.22 + 33.33)";
        EvaluateExpression eval = new EvaluateExpression(args);
        double result = eval.expressionEvaluation();
        assertEquals(2468.642, result);
    }

    @Test
    public void rangeIncreaseFromIntToDouble() throws Exception {
        String args = "2 ^ 32";
        EvaluateExpression eval = new EvaluateExpression(args);
        double result = eval.expressionEvaluation();
        assertEquals(4.294967296E9, result);
    }

    @Test
    public void anyNumberOfSpaceInAnyPositonTrimmed() throws Exception {
        String args = "2 + (          22            /        3) + 1";
        EvaluateExpression eval = new EvaluateExpression(args);
        double result = eval.expressionEvaluation();
        assertEquals(10.333333333333333, result);
    }

    @Test
    public void workWithAndWithoutSpaces() throws Exception {
        String args = "   2 +(22/ 3) + 1";
        EvaluateExpression eval = new EvaluateExpression(args);
        double result = eval.expressionEvaluation();
        assertEquals(10.333333333333333, result);
    }

    @Test
    public void workWithoutSpaces() throws Exception {
        String args = "2+(22/3)+1";
        EvaluateExpression eval = new EvaluateExpression(args);
        double result = eval.expressionEvaluation();
        assertEquals(10.333333333333333, result);
    }

    @Test
    public void negetiveNumberHandel() throws Exception {
        String args = "   -5 +1";
        EvaluateExpression eval = new EvaluateExpression(args);
        double result = eval.expressionEvaluation();
        assertEquals(-4.0, result);
    }

    @Test
    public void negetiveNumberInBracket() throws Exception {
        String args = "25 + ( -5)";
        EvaluateExpression eval = new EvaluateExpression(args);
        double result = eval.expressionEvaluation();
        assertEquals(20.0, result);
    }

    @Test
    public void forNegetiveNumbersInsetSpace() throws Exception {
        String input = "(5.5+(-4.6-3)^-2^4+-8.9)";
        EvaluateExpression evaluator = new EvaluateExpression(input);
        double expected = -8.897356096242076;
        double actual = evaluator.expressionEvaluation();
        assertEquals(expected, actual);
    }

    @Test
    public void nestedBracket() throws Exception {
        String input = "(((((2)))))";
        EvaluateExpression evaluator = new EvaluateExpression(input);
        double expected = 2.0;
        double actual = evaluator.expressionEvaluation();
        assertEquals(expected, actual);
    }

    @Test
    public void nestedBracketExpression() throws Exception {
        String input = "((((5*(2+3)))))";
        EvaluateExpression evaluator = new EvaluateExpression(input);
        double expected = 25.0;
        double actual = evaluator.expressionEvaluation();
        assertEquals(expected, actual);
    }



    @Test
    public void nestedBracketWithCombinations() throws Exception {
        String input = "(5*(5/5+5^5)-(5^5)+(5+(5/5)))";
        EvaluateExpression evaluator = new EvaluateExpression(input);
        double expected = 35761.0;

        double actual = evaluator.expressionEvaluation();

        assertEquals(expected, actual, 1);
    }

    @Test
    public void nestedBracketWithFloatAndNegetiveNumber() throws Exception {
        String input = "13.453--53.545*(34.55--943.55-(1452.554+-150.554)+1540.45)";
        EvaluateExpression evaluator = new EvaluateExpression(input);
        double expected = 81506.4169;

        double actual = evaluator.expressionEvaluation();

        assertEquals(expected, actual, 1);
    }
}