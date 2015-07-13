package singleNumber;

public class Solution {

	public int singleNumber(int[] A) {
		if(A==null)return 0;
		if(A.length==0)return 0;
		if(A.length==1)return A[0];
		int i=0;
        //用异或，把相同数字抵消掉
        for(;i<A.length-1;i++)
        {
        	A[i+1]=A[i+1]^A[i];
        }
        return A[i];
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int test[] = {1,2,1};
		Solution s = new Solution();
		System.out.println(s.singleNumber(test));
	}

}
