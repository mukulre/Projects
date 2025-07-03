import java.util.Scanner;

public class CaseReversal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        StringBuilder output = new StringBuilder();

        for (char c : input.toCharArray()) {
            if (Character.isUpperCase(c)) {
                output.append(Character.toLowerCase(c));
            } else if (Character.isLowerCase(c)) {
                output.append(Character.toUpperCase(c));
            } else {
                output.append(c);
            }
        }

        System.out.println(output.toString());
        scanner.close();
    }
}