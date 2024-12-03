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
        System.out.println("Enter a string as number#1 (or \"quit\" to end the program)");
        input1 = sc.nextLine();
        while (!input1.equals("quit")) {
            if (Ex1.isNumber(input1)) {
                System.out.println("num1 =" + input1 + "is valid , value: " + Ex1.number2Int(input1));
            } if (!Ex1.isNumber(input1)) {
                System.out.println("num1 =" + input1 + "is not valid , value: -1");
                System.out.println("ERR: num1 is in the wrong format" + "(" + input1 + ")");
                break;
            }
            System.out.println("Enter a string as number#2 (or \"quit\" to end the program)");
            input2 = sc.nextLine();
            if (Ex1.isNumber(input2)) {
                System.out.println("num1 =" + input2 + "is valid , value: " + Ex1.number2Int(input2));
            } if(!Ex1.isNumber(input2)) {
                System.out.println("num1 =" + input1 + "is not valid , value: -1");
                System.out.println("ERR: num1 is in the wrong format" + "(" + input2 + ")");
                break;
            }
            System.out.println("enter a base for output [2 , 16]");
            base=sc.nextInt();
            sc.nextLine(); //consumes next input after loop ends
            sum = Ex1.int2Number((Ex1.number2Int(input1) + Ex1.number2Int(input2)),base);
            mult = Ex1.int2Number((Ex1.number2Int(input1) * Ex1.number2Int(input2)), base);
            System.out.println(input1 + " + " + input2 + " = " + sum );
            System.out.println(input1 + " * " + input2 + " = " + mult);
            String [] ss = new String[4];
            input1= ss[0];
            input2 = ss[1];
            sum = ss[2];
            mult = ss[3];
            System.out.println("Max Over [" + input1 + "," + input2 + "," + mult + "," + sum + "] " + Ex1.maxIndex(ss) );
            System.out.println("Enter a string as number#1 (or \"quit\" to end the program)");
            input1 = sc.nextLine();
        }
    }


}