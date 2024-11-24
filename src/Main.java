import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    System.out.println("Enter Number in any base 2-16 with the letter 'b' between the value and base.");
    sc.nextLine();
    String base = sc.nextLine();
    System.out.println(isNumber(base));
    }
    public static boolean isNumber(String input) {
        int charcount = 0;
        for (int i = 0; i < input.length(); i++) {
            if(input.charAt(i) != 'b' && String input.charAt(i)) {
                return false;
            }
            if(input.charAt(i) == 'b') {
                charcount++;
                if(charcount == 2)
                    return false;
            }

        }
        return true;
    }
}