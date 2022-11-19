package ba.unsa.etf.rpr;
/**
 * @author nmiralem1
 * @version 1.0
 * Class for calculating given expression using Dijkstra's algorithm.
 */

import java.util.Stack;
import java.lang.Double;
import java.lang.Math;

/**
 *
 * Class for calculating given expression using Dijkstra's algorithm.
 */
public class ExpressionEvaluator {
    /**
     * Stack for operators.
     */
    private static Stack<String>ops=new Stack<>();
    /**
     * Stack for values.
     */
    private static Stack<Double>vals=new Stack<>();

    /**
     * Splitting String.
     * @param s String that will be separated with spaces.
     * @return Array of Strings without spaces.
     */
    public static String[] parsedString(String s){
        return s.split(" ");
    }

    /**
     * Calculating operation whether it is unary or binary.
     * @param op String that represents operator that will be used.
     * @param a Operand number one.
     * @param b Operand number two
     * @return The result of the operation, type double.
     */
    public static double value(String op, double a, double b){
        double result=0;
        if(op.equals("-")) result=a-b;
        else if(op.equals("+")) result=a+b;
        else if(op.equals("*")) result=a*b;
        else if(op.equals("/")) result=a/b;
        else if(op.equals("sqrt")) result=Math.sqrt(a);//or b
        return result;
    }

    /**
     * Checking whether the input is valid.
     * @param s String that is being checked.
     */
    public static void validate(String s){
        String[] ps=parsedString(s);
        for(String x : ps){
            if(!(x.equals("+") || x.equals("-") || x.equals("*") || x.equals("/") || x.equals("sqrt") || x.equals("0") || x.equals("1") ||
                    x.equals("2") || x.equals("3") || x.equals("4") || x.equals("5") || x.equals("6") || x.equals("7") || x.equals("8") ||
                    x.equals("9"))) throw new RuntimeException("Invalid operands or operators");
        }
    }

    /**
     * Calculating valid expression.
     * @param s Expression given through a String.
     * @return The number type double that is a result of given expression.
     */
    public static double evaluate(String s){
        String[] ps=parsedString(s);
        for(String x : ps) {
            double d = 0;
            if (!(x.equals(")"))) {
                if (x.equals("+") || x.equals("-") || x.equals("/") || x.equals("*") || x.equals("sqrt") || x.equals("(")) ops.push(x);
                else {
                    d = Double.parseDouble(x);
                    vals.push(d);
                }
            }


        else if(x.equals(")")) {
                while(!(ops.peek()).equals("(")){
                    String string=ops.pop();
                    if(string.equals("sqrt")){
                        double sqrt=vals.pop();
                        double t_result=value(string,sqrt,sqrt);
                        vals.push(t_result);
                    }
                    else {
                        double b=vals.pop();
                        double a=vals.pop();
                        double value=value(string,a,b);
                        vals.push(value);
                    }
                }
                ops.pop();
            }
    }
        return vals.pop();

}}