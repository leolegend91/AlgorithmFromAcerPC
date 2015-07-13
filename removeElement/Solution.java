package removeElement;

public class Solution {

	public int removeElement(int[] A, int elem) {
        if(A==null)return 0;
		int count=0;
		for(int i=0;i<A.length;i++)
        {
        	if(A[i]!=elem)
        	{
        		A[count]=A[i];
        		count++;
        	}
        }
		return count;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int test[] = {4,5};
		Solution s = new Solution();
		System.out.println(s.removeElement(test, 4));
	}

}
