

public class Main
{
	public static void main(String[] args) {
	    int c;
	    for (int i=100;i<1000;i++){
	        c=0;
	        for(int j=2;j<i;j++){
	            if(i%j==0){
	                c++;
	            }
	        }
	        if(c==0)
	        System.out.println(i);
	    }
		
	}
}