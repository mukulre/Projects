import java.util.Scanner;

public class CharinsecCode {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String securityCode = scanner.nextLine();
        System.out.println(areAllCharactersSame(securityCode) ? "YES" : "NO");
    }

    private static boolean areAllCharactersSame(String code) {
        char firstChar = code.charAt(0);
        for (int i = 1; i < code.length(); i++) {
            if (code.charAt(i) != firstChar) {
                return false;
            }
        }
        return true;
    }
}
