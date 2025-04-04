public class Main
{
    public static int[] findTwoSum (int[] arr, int target){
        int left =0;;
        int right =arr.length-1;
        while(left<right){
            int sum = arr[left] + arr[right];
            if (sum==target){
                return new int[] {left,right};
            }else if(sum<target){
                left++;
            }else
            right--;
        }return new int[]{};
    }
	public static void main(String[] args) {
	    int []arr={2,7,11,15};
	    int target =19;
	    int[]result = findTwoSum(arr,target);
	    if(result.length==2){
	        System.out.println("Indices:["+result[0]+","+result[1]+"]");
	    }else{
	        System.out.println("No Solution");
	    }
	}
}