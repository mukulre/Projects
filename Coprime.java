import java.util.*;
public class Main
{
	public static void main(String[] args) {
	    Scanner q = new Scanner(System.in);
		System.out.println("Enter num1");
		int a =q.nextInt();
		System.out.println("Enter num2");
		int b =q.nextInt();
		int temp;
		while(b>0){
		    temp=b;
		    b=a%b;
		    a=temp;
		}
		if(a==1)
		System.out.println("Coprime");
		else
		System.out.println("No");
	}
}