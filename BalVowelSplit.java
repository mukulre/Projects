import java.util.Scanner;

public class BalVowelSplit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        System.out.println(areHalvesAlike(s));
    }

    public static String areHalvesAlike(String s) {
        int mid = s.length() / 2;
        String a = s.substring(0, mid);
        String b = s.substring(mid);
        
        return countVowels(a) == countVowels(b) ? "YES" : "NO";
    }

    public static int countVowels(String str) {
        int count = 0;
        for (char c : str.toCharArray()) {
            if ("aeiouAEIOU".indexOf(c) != -1) {
                count++;
            }
        }
        return count;
    }
}
