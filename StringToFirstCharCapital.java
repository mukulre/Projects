import java.util.*;
public class Main
{
	public static void main(String[] args) {
	    Scanner sc=new Scanner(System.in);
	    System.out.println("Enter num of names");
	    int a=sc.nextInt();
	    String[] names=new String[a];
        sc.nextLine();
        //String[] b=new String(b);
        for(int i=0;i<a;i++){
            System.out.println("Enter name"+(i+1)+": ");
            names[i]=sc.nextLine();
        }
            for(int j=0;j<a;j++){
                char st=names[j].charAt(0);
                String sub=names[j].substring(1,names[j].length()).toLowerCase();
                String l1=Character.toString(st).toUpperCase();
                System.out.println(l1+sub);
            }
        }
	}
