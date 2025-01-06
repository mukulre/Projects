import java.util.*;
public class Main
{
	public static void main(String[] args)
	{
		Scanner leo= new Scanner(System.in);
		System.out.println("Enter no of elements");
		int a=leo.nextInt();
		int[]arr = new int[a];
		int sum=0;
		int d;
		for(int i=0;i<a;i++)
		{
		    System.out.println("Enter data"+(i+1));
		    d=leo.nextInt();
		    arr[i]=d;
		    sum=sum+d;
		}
		System.out.println(Arrays.toString(arr));
		System.out.println(sum);
	}
}