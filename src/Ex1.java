import java.util.ArrayList;

public class Ex1 {
    public static int number2Int(String s) {
        if(!s.contains("b") && isNumber(s))
            return Integer.parseInt(s);
        int ans = -1;
        if (!isNumber(s))
            return 0;
        String[] num = s.split("b");
        int baseval = BaseValue(s);
        char[] ch = num[0].toCharArray();
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] >= '0' && ch[i] <= '9') {
                ans += (int) (Character.getNumericValue(ch[i]) * (Math.pow(baseval, ch.length - 1 - i)));
            } else if (ch[i] >= 'A' && ch[i] <= 'Z') {
                ans += (int) (CharValue(ch[i]) * Math.pow(baseval, ch.length - 1 - i));
            }
        }
        return ans;
    }

    public static String int2Number(int num, int base) {
        String ans = "";
        ArrayList<Character> c = new ArrayList<Character>();
        int bit = 0;
        String j = "";
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
        sb.append('b');
        sb.append(base);
        ans = sb.toString();
        return ans;
    }

    public static boolean isNumber(String input) {
        boolean ans = true;
        if(!input.contains("b") ){
            for(int i = 0; i<input.length(); i++){
                if(input.charAt(i)>='a' && input.charAt(i)<='z' || input.charAt(i)>='A' && input.charAt(i)<='Z'){
                    ans = false;
                }
            }
            return ans;
        }

        //checks if given input is a number which fits its base
        int parsebase;
        if (!input.contains("b") || input.indexOf('b') != input.lastIndexOf('b')) // checks number of times the letter 'b' appears in the input
            ans = false;
        String[] num = input.split("b");
        if (num.length != 2)
            ans = false;
        if (BaseValue(input) == 0)
            ans = false;
        String val = num[0];
        parsebase = BaseValue(input);
        char[] c = val.toCharArray();
        for (char value : c) {
            if (Character.digit(value, parsebase) == -1) // Base output for a false base to value ratio.
                ans = false;
        }

        return ans;

    }

    public static int BaseValue(String num) {
        if(!num.contains("b") && isNumber(num))
            return 10;
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
    public static int maxIndex(String[] s){
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < s.length; i++){
            if (ans < number2Int(s[i]))
                ans = number2Int(s[i]);
        }
        return ans;
    }
    public static boolean equals (String a, String b) {
        boolean ans = true;
        if(a.length() != b.length()){
            ans = false;
            return ans;
        }
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i))
                ans = false;
        }
        return ans;
    }

}
