import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner q = new Scanner(System.in);
        System.out.println("Enter Password:");
        String pass1 = q.nextLine();
        int sm = 0, up = 0, sp = 0, dg = 0;

        if (pass1.length() > 7) {
            for (char ch : pass1.toCharArray()) {
                if (Character.isUpperCase(ch))
                    up++;
                else if (Character.isLowerCase(ch))
                    sm++;
                else if (Character.isDigit(ch))
                    dg++;
                else
                    sp++;
            }
            
            if (dg > 0 && sm > 0 && up > 0 && sp > 0) {
                System.out.println("Good");
            } else {
                System.out.println("Bad");
            }
        } else {
            System.out.println("Weak due to less characters");
        }
    }
}
