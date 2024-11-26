import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Number in any base 2-16 with the letter 'b' between the value and base.");
        sc.nextLine();
        String s = sc.nextLine();
        System.out.println(isValidNumber(s));
    }

    public static int NumtoDecimalVal(String s) {
        int finalvalue = 0;
        if (!isValidNumber(s))
            return 0;
        String[] num = s.split("b");
        int baseval = BaseValue(num[1]);
        char[] ch = num[0].toCharArray();
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] >= '0' && ch[i] <= '9') {
                finalvalue += (int) (Character.getNumericValue(ch[i]) * (Math.pow(baseval, i)));
            } else if (ch[i] >= 'A' && ch[i] <= 'Z') {
                finalvalue += (int) (CharValue(ch[i]) * Math.pow(baseval, i));
            }
        }
        return finalvalue;
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
        String base = num[1];
        parsebase = BaseValue(base);
        char[] c = val.toCharArray();
        for (char value : c) {
            if (Character.digit(value, parsebase) == -1)
                return false;
        }

        return true;

    }

    public static int BaseValue(String base) {
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