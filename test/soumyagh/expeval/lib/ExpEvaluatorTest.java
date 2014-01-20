package soumyagh.expeval.lib;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class ExpEvaluatorTest {
    @Test
    public void testHello() throws Exception {
        ExpEvaluator eval = new ExpEvaluator();
        String[] args = {"running"};
        int result = eval.hello(args);
        assertEquals(result,1);
    }
}