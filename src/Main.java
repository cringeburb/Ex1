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

    public static boolean isValidNumber(String input) {
        //checks if given input is a number which fits its base
        int parsebase;
        int parseval;
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
        for (int i = 0; i < c.length; i++) {
            if (Character.digit(c[i], parsebase) == -1)
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
            for (int i = 0; i < valarray.length; i++) {
                p += Character.getNumericValue(valarray[i]);
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