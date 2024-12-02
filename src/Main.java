import java.util.ArrayList;
import java.util.Scanner;

/*
 ---plan---
 use external functions for the following:
 1.convert a number to its decimal value and vice versa(done)
 2.check if a number is valid (done)
 3.find value of letters
 ---
    Execute all the following in a while loop in main function in the order shown in the example.
 */
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int base = 1;
        String sum= "";
        String mult = "";
        String input1 = "";
        String input2 = "";
        Scanner sc = new Scanner(System.in);
        while (!input1.equals("quit")) {
            System.out.println("Enter a string as number#1 (or \"quit\" to end the program)");
            input1 = sc.nextLine();
            if (isValidNumber(input1)) {
                System.out.println("num1 =" + input1 + "is valid , value: " + NumtoDecimalVal(input1));
            } else {
                System.out.println("num1 =" + input1 + "is not valid , value: -1");
                System.out.println("ERR: num1 is in the wrong format" + "(" + input1 + ")");
                break;
            }
            System.out.println("Enter a string as number#2 (or \"quit\" to end the program)");
            input2 = sc.nextLine();
            if (isValidNumber(input2)) {
                System.out.println("num1 =" + input2 + "is valid , value: " + NumtoDecimalVal(input2));
            } else {
                System.out.println("num1 =" + input1 + "is not valid , value: -1");
                System.out.println("ERR: num1 is in the wrong format" + "(" + input2 + ")");
                break;
            }
            System.out.println("enter a base for output [2 , 16]");
            base=sc.nextInt();
            sum = DecimaltoBase((NumtoDecimalVal(input1) + NumtoDecimalVal(input2)),base);
            mult = DecimaltoBase((NumtoDecimalVal(input1) * NumtoDecimalVal(input2)), base);
            System.out.println(input1 + " + " + input2 + " = " + sum );
            System.out.println(input1 + " * " + input2 + " = " + mult);
            System.out.println(DecimaltoBase(Math.max(Math.max(NumtoDecimalVal(input1), NumtoDecimalVal(input2)), Math.max(NumtoDecimalVal(sum), NumtoDecimalVal(mult))) , base));
            
        }
    }

    public static int NumtoDecimalVal(String s) {
        int finalvalue = 0;
        if (!isValidNumber(s))
            return 0;
        String[] num = s.split("b");
        int baseval = BaseValue(s);
        char[] ch = num[0].toCharArray();
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] >= '0' && ch[i] <= '9') {
                finalvalue += (int) (Character.getNumericValue(ch[i]) * (Math.pow(baseval, ch.length - 1 - i)));
            } else if (ch[i] >= 'A' && ch[i] <= 'Z') {
                finalvalue += (int) (CharValue(ch[i]) * Math.pow(baseval, ch.length - 1 - i));
            }
        }
        return finalvalue;
    }

    public static String DecimaltoBase(int num, int base) {
        ArrayList<Character> c = new ArrayList<Character>();
        int bit = 0;
        while (num != 0) {
            bit = num % base;
            num = num / base;
            if (bit == 10)
                c.add('A');
            if (bit == 11)
                c.add('B');
            if (bit == 12)
                c.add('C');
            if (bit == 13)
                c.add('D');
            if (bit == 14)
                c.add('E');
            if (bit == 15)
                c.add('F');
            else {
                c.add((char) (bit + '0'));
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = c.size() - 1; i >= 0; i--) {
            sb.append(c.get(i));
        }
        return sb.toString();
    }

    public static boolean isValidNumber(String input) {
        //checks if given input is a number which fits its base
        int parsebase;
        if (!input.contains("b") || input.indexOf('b') != input.lastIndexOf('b')) // checks number of times the letter 'b' appears in the input
            return false;
        String[] num = input.split("b");
        if (num.length != 2)
            return false;
        if (BaseValue(input) == 0)
            return false;
        String val = num[0];
        parsebase = BaseValue(input);
        char[] c = val.toCharArray();
        for (char value : c) {
            if (Character.digit(value, parsebase) == -1) // Base output for a false base to value ratio.
                return false;
        }

        return true;

    }

    public static int BaseValue(String num) {
        String[] parts = num.split("b");
        String base = parts[1];
        int p = 0;
        char c;
        if (base.length() == 1) {
            c = base.charAt(0);
            if (Character.isDigit(c))
                return Integer.parseInt(base);

            if (base.charAt(0) >= 'A' && base.charAt(0) <= 'Z') {
                return CharValue(base.charAt(0));
            }
        } else {
            char[] valarray = base.toCharArray();
            for (char value : valarray) {
                p += Character.getNumericValue(value);
                p *= 10;
            }
            p /= 10;

        }
        return p;
    }

    public static int CharValue(char ch) {
        if (ch == 'A')
            return 10;
        if (ch == 'B')
            return 11;
        if (ch == 'C')
            return 12;
        if (ch == 'D')
            return 13;
        if (ch == 'E')
            return 14;
        if (ch == 'F')
            return 15;
        if (ch == 'G')
            return 16;
        return 0;
    }

}