import java.util.*;
public class Main
{
	public static void main(String[] args) {
	    String a="aaabbcccccddddddddaaaaa";
	    String res="";
	    int count=1;
	    for(int i=0;i<a.length();i++){
	        if((i+1)<a.length()&&a.charAt(i)==a.charAt(i+1)){
	            count++;
	        }
	        else{
	            res=res+a.charAt(i);
	            res=res+count;
	            count=1;
	        }
	    }
		System.out.print(res);
	}
}