import java.util.ArrayList;

public class Ex1 {
    //converts a number to its decimal value
    public static int number2Int(String s) {
        if (!s.contains("b") && isNumber(s)) //checks if the number is already in its decimal value
            return Integer.parseInt(s);//returns the number if its already in base 10 such as: 1 , 2 , 100 etc.
        if (s.contains("bA"))
        {
            return Integer.parseInt(s.split("b")[0]);
        }

        int ans = 0;
        if (!isNumber(s))//validate the numbers format
            return -1;
        String[] num = s.split("b");//split the number to its value and base
        int baseval = BaseValue(s);//save the value of the base
        char[] ch = num[0].toCharArray();//convert int an array of characters inorder to check each char individually
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] >= '0' && ch[i] <= '9') { //if character is a digit
                ans += (int) (Character.getNumericValue(ch[i]) * (Math.pow(baseval, ch.length - 1 - i)));
            } else if (ch[i] >= 'A' && ch[i] <= 'Z') { //if characters value is greater than 9
                ans += (int) (CharValue(ch[i]) * Math.pow(baseval, ch.length - 1 - i));
            }
        }
        return ans; //return final converted value
    }

    //changes an Integer to its representation with a given base
    public static String int2Number(int num, int base) {
        if (num == 0)
            return "0b" + base; // Handle the case where num is 0
        String ans = "";
        ArrayList<Character> c = new ArrayList<Character>();
        int bit = 0;
        String j = "";

        while (num != 0) {
            bit = num % base;
            num = num / base;
            if (bit >= 10) {
                c.add((char) ('A' + (bit - 10)));
                // Handle bases beyond 10
            } else {
                c.add((char) (bit + '0')); // Convert digit to character
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = c.size() - 1; i >= 0; i--) {
            sb.append(c.get(i)); //appends characters in reverse order

        }
        sb.append('b');//appends base symbol
        sb.append(base); // adds the base representation
        ans = sb.toString(); //converts string builder to a string
        return ans;
    }
    //checks if a given string is a valid number
    public static boolean isNumber(String input) {
        boolean ans = true;
        int InB = input.indexOf('b');
        if (input.contains("b") && input.length() > 2)
            if (!input.substring(0, InB).toUpperCase().equals(input.substring(0, InB)))
                ans = false;
        if (input.contains(" "))
            return false;
        if(!input.trim().equals(input))
            return false;
        if (input.charAt(0) == 'b')
            return false;
        if (!input.contains("b")) { //string might be a decimal number without a base representation
            for (int i = 0; i < input.length(); i++) {
                if (input.charAt(i) >= 'a' && input.charAt(i) <= 'z' || input.charAt(i) >= 'A' && input.charAt(i) <= 'Z') { //if all characters are digits
                    ans = false;
                }
            }
            return ans;
        }

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
        if (parsebase < 2 || parsebase >16)
            return false;
        char[] c = val.toCharArray();
        for (char value : c) {
            if (Character.digit(value, parsebase) == -1) // Base output for a false base to value ratio.
                ans = false;
        }

        return ans;

    }
    //retrieves the value of a given number
    public static int BaseValue(String num) {
        if (!num.contains("b") && isNumber(num))
            return 10; //base 10 can be written without a base representation
        String[] parts = num.split("b");
        if (parts.length>1)
        {
            String base = parts[1];
            int p = 0;
            char c;
            if (base.length() == 1) {
                c = base.charAt(0);
                if (Character.isDigit(c))
                    return Integer.parseInt(base); //returns base value 1-9

                if (base.charAt(0) >= 'A' && base.charAt(0) <= 'Z') {
                    return CharValue(base.charAt(0)); //returns base value 10-16
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
        else
        {
            return -1;
        }
    }
    //retrieves the value of certain letters in the input string
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
    //returns the maximum int value between given strings
    public static int maxIndex(String[] m) {
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < m.length; i++) {
            if (ans < number2Int(m[i]))
                ans = number2Int(m[i]);
        }
        return ans;
    }
    //checks if two numbers are equal
    public static boolean equals(String a, String b) {
        return number2Int(a) == number2Int(b);
    }
}
