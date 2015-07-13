package removeDuplicatesFromSortedArray;

import java.util.Arrays;

//题目限制不能用额外空间，空间复杂度应该为O（1），所以不能考虑额外数组
public class Solution {

	public int removeDuplicates(int[] A) {
		if(A==null)return 0;
		if(A.length<1)return 0;
		
        int count = 1;
        int point=1;
        while(point<A.length)
        {
        	if(A[point]!=A[count-1])
        	{
        		A[count]=A[point];
        		++count;
        	}
        	++point;
        }
        return count;
    }
	@SuppressWarnings("null")
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int test[] = {1,2};
		
		Solution s = new Solution();
		System.out.println(s.removeDuplicates(test));
		
		System.out.println(Arrays.asList(test));
	}

}
