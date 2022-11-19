package ba.unsa.etf.rpr;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Class that will test each method of ExpressionEvaluator.
 * @author nmiralem1
 * @version 1.0
 */

public class ExpressionEvaluatorTest {
    /**
     * Testing whether the entered operators and/or operands are valid
     */
    @Test
   public void testvalue(){
        double expected=2;
        double result=ExpressionEvaluator.value("+",1,1);
        assertEquals(expected,result);
    }

    /**
     * Testing whether the brackets are put at the right place
     */
    @Test
    public void testevaluate1(){
        double expected=14;
        double result=ExpressionEvaluator.evaluate("( ( 1 + 1 ) + ( 6 * 2 ) )");
        assertEquals(expected,result);
    }

    /**
     * Testing method parsedString that should separate every element of the given string.
     */
    @Test
    public void testparsedString(){
        String[] expected = new String[]{"(","3","+","2",")"};
        String[] result = ExpressionEvaluator.parsedString("( 3 + 2 )");
        assertArrayEquals(expected,result);
    }

    /**
     * Testing method with multiply operators to check the number of brackets
     */
    @Test
    public void testevaluate2(){
        double expected=3.5;
        double result=ExpressionEvaluator.evaluate("( ( 20 - ( 3 * 2 ) ) / 4 )");
    }

    /**
     * // Testing the exception if the operator is not valid
     */
    @Test
    public void testexception(){
        assertThrows(RuntimeException.class,()->ExpressionEvaluator.validate("1 + 1 & 2"), "invalid operands or operators");
    }

    /**
     * Testing the function "sqrt"
     */
    @Test
    public void testevaluate3(){
        double expected=3;
        double result=ExpressionEvaluator.evaluate("( 1 + sqrt ( 4 ) )");
        assertEquals(expected,result);
    }
}
