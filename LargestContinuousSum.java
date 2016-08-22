package codingProblems;

public class LargestContinuousSum {
	public static void main(String args[]){
		int[] arr={-1,-3,4,3,7};
		if (arr.length==0)
			return;
		int tstart = 0;
		int startpos = 0;
		int endpos = 0;
		int cursum = arr[0];
		int maxsum = arr[0];

		if(arr.length > 1){	
			for(int i = 1; i < arr.length; i++){
				if(cursum > cursum + arr[i] || arr[i] > cursum + arr[i] ){
					cursum = arr[i];
					tstart = i;
				}
				else
					cursum += arr[i];
				if(cursum > maxsum)
				{
					maxsum = cursum;	
					startpos = tstart;	
					endpos = i;
				}
			}
		}
		System.out.println(maxsum + "; " + startpos+1 + ":" + endpos+1);
	}
}
