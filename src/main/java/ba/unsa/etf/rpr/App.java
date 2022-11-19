package ba.unsa.etf.rpr;
import java.util.Scanner;
/**
 * Main class that checks validation of expression.
 * @author nmiralem1
 * @version 1.0
 */
public class App 
{
    /**
     * Method for storing entered String and checking if the operands and operators are valid.
     * @param args String that is entered.
     * @throws RuntimeException If the input is incorrect.
     */
    public static void main( String[] args ) throws RuntimeException{
        try{

            ExpressionEvaluator.validate(args[0]);
            String s="";
            for(int i=0;i<args.length;i++){
                if(i<args.length-1) s=s+args[i]+" ";
                else s=s+args[i];
            }
            double result1=ExpressionEvaluator.evaluate(s);
            System.out.println("Result is: "+ result1);
        } catch(RuntimeException e){
            System.out.println("Invalid expression");
        }
    }

}
