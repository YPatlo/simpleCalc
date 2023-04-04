import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

import java.beans.Expression;
import java.util.Scanner;

public class Main {

    static Scanner scanner;

    public static void main(String[] args){
        calculate();
    }

    static int factorial(double a){
        if(a < 0){
            System.out.println("Factorials of negative numbers don't exist, you IDIOT!");
        }
        int inta = (int) a;
        int result = 1;
        while (inta > 1){
            result = result * inta;
            inta--;
        }
        return result;
    }

    static void inputError(){
        String abc = "";
        System.out.println("Invalid Input");
        System.out.println("Enter <> to Restart or >< to Quit");
        try {abc = scanner.nextLine();}
        catch (Exception e){inputError();}
        finally{scanner.close();}
        restart(abc);
    }

    static void restart(String abc){
        if (abc.equals("<>")){
            calculate();
        } else if (abc.equals("><")) {
            System.out.println("GoodBye!!");
        }else {
            inputError();
        }

    }

    static String quadEq(String def){
        Expression exp;
        int i = 1000;
        int X = 0;
        String x = "";
        while (i>0 && exp.evaluate() == 0){
            x = Integer.toString(X);
            def = def.replaceAll("x",x);
            exp = new ExpressionBuilder(def).build();
            X++;
            x = Integer.toString(X);
            def = def.replaceAll("x",x);
            i--;
        }
        return x;
    }

    static void calculate(){
        String abc = "";
        String eq = "";
        String operator = "";
        double num1 = 1;
        double num2 = 1;
        scanner = new Scanner(System.in);

        //takingInputFromUsers
        System.out.println("""
                -----------------------------------------
                            Lets Calculate
                -----------------------------------------
                Press + for Addition,
                Press - for Subtraction,
                Press * for Multiplication,
                Press / for Division,
                Press ^ for Exponentiation,
                Press !^ for Roots,
                Press ! for Factorial or
                or Press x**2 for Quadratic Equations (WIP)""");
        try {operator = scanner.nextLine();}
        catch (Exception e) {inputError();}

        //takingMoreInputFromUsers
        switch (operator) {
            case "+"-> {System.out.print("Enter the First Number:");
                try {num1 = scanner.nextDouble();} catch (Exception e) {inputError();}

                System.out.print("Enter the Second Number:");
                try {num2 = scanner.nextDouble();} catch (Exception e) {inputError();}}

            case "-"->{System.out.print("Enter a Number:");
                try {num1 = scanner.nextDouble();} catch (Exception e) {inputError();}

                System.out.print("Enter the Number to be subtracted:");
                try {num2 = scanner.nextDouble();} catch (Exception e) {inputError();}}

            case "*"->{System.out.print("Enter a Number:");
                try {num1 = scanner.nextDouble();} catch (Exception e) {inputError();}

                System.out.print("Enter another Number:");
                try {num2 = scanner.nextDouble();} catch (Exception e) {inputError();}}

            case "/"->{System.out.print("Enter the dividend:");
                try {num1 = scanner.nextDouble();} catch (Exception e) {inputError();}

                System.out.print("Enter the divisor:");
                try {num2 = scanner.nextDouble();} catch (Exception e) {inputError();}}

            case "^"->{System.out.print("Enter the base:");
                try {num1 = scanner.nextDouble();} catch (Exception e) {inputError();}

                System.out.print("Enter the power:");
                try {num2 = scanner.nextDouble();} catch (Exception e) {inputError();}}

            case "!^"->{System.out.print("Enter a Number:");
                try {num1 = scanner.nextDouble();} catch (Exception e) {inputError();}

                System.out.print("Which Root of the Number do you want:");
                try {num2 = scanner.nextDouble();} catch (Exception e) {inputError();}}

            case "!"->{System.out.print("Enter the Number:");
                try {num1 = scanner.nextInt();} catch (Exception e) {inputError();}}

            case "x**2"->{System.out.print("Enter the Equation, Separate variable and number with *, if there is no coefficient, use 1, and use x**2 for x squared. \n [Note:Works only for positive values below 1000.] :");
                try {eq = scanner.nextLine();} catch (Exception e) {inputError();}}

            default-> inputError();
        }

        String num1Str = Double.toString(num1);
        String num2Str = Double.toString(num2);

        //confirmingInput
        if (operator.equals("x**2")) {
            System.out.println("Confirm Equation "+ eq);
            System.out.println("Press any key to continue, <> to Restart or >< to Quit");
            try {abc = scanner.nextLine();}
            catch (Exception e){inputError();}
            if (abc.equals("<>") || abc.equals("><")){
                restart(abc);
            }
            eq = eq.replaceAll("\\*x\\*\\*2","*math.power(x,2");
        } else if (operator.equals("!")) {
            System.out.println("Confirm Number " + num1Str);
            System.out.println("Press any key to continue, <> to Restart or >< to Quit");
            try {abc = scanner.nextLine();}
            catch (Exception e){inputError();}
            if (abc.equals("<>") || abc.equals("><")){
                restart(abc);
            }
        } else {
            System.out.println("Confirm First Number " + num1Str);
            System.out.println("Confirm Second Number " + num2Str);
            System.out.println("Press any key to continue, <> to Restart or >< to Quit");
            try {abc = scanner.nextLine();}
            catch (Exception e){inputError();}
            if (abc.equals("<>") || abc.equals("><")){
                restart(abc);
            }
        }

        System.out.print("The Result is:");

        //calculating
        switch (operator) {
            case "+" -> System.out.println(num1 + num2);
            case "-" -> System.out.println(num1 - num2);
            case "*" -> System.out.println(num1 * num2);
            case "/" -> System.out.println(num1 / num2);
            case "^" -> System.out.println(Math.pow(num1, num2));
            case "!^" -> System.out.println(Math.pow(num1, 1 / num2));
            case "!" -> System.out.println(factorial(num1));
            case "x**2" -> System.out.println(quadEq(eq));
        }

        System.out.println("Press <> to Restart or >< to Quit");
        try {abc = scanner.nextLine();}
        catch (Exception e){inputError();}
        finally{scanner.close();}
        restart(abc);

    }

}
