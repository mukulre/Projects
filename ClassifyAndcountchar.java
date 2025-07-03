import java.util.Scanner;

public class ClassifyAndcountchar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        
        int lowercaseCount = 0;
        int uppercaseCount = 0;
        int specialCount = 0;
        int digitCount = 0;

        for (char c : input.toCharArray()) {
            if (Character.isLowerCase(c)) {
                lowercaseCount++;
            } else if (Character.isUpperCase(c)) {
                uppercaseCount++;
            } else if (Character.isDigit(c)) {
                digitCount++;
            } else {
                specialCount++;
            }
        }

        System.out.println(lowercaseCount + " " + uppercaseCount + " " + specialCount + " " + digitCount);
    }
}

