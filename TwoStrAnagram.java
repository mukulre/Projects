import java.util.Arrays;
import java.util.Scanner;

public class TwoStrAnagram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String S1 = scanner.nextLine();
        String S2 = scanner.nextLine();
        
        if (areAnagrams(S1, S2)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
        
        scanner.close();
    }

    private static boolean areAnagrams(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        
        char[] charArray1 = s1.toCharArray();
        char[] charArray2 = s2.toCharArray();
        
        Arrays.sort(charArray1);
        Arrays.sort(charArray2);
        
        return Arrays.equals(charArray1, charArray2);
    }
}