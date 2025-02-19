import java.util.Scanner;
class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int num = sc.nextInt();
        boolean isComposite = false;
        for(int i = 2; i < num; i++) {
            if(num % i == 0) {
                System.out.println(num + " is a composite number"); // Fixed spacing
                isComposite = true;
                break;
            }
        }
       
        if (!isComposite) { // If no divisor was found, it's prime
            System.out.println(num + " is a Prime Number"); // Fixed spacing
        }
    }
}
