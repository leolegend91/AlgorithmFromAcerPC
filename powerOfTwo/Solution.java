package powerOfTwo;

public class Solution {

	public boolean isPowerOfTwo(int n) {
		if(n<1)return false;
        return ((n&(n-1))==0);
    }
	public static void main(String args[])
	{
		Solution s = new Solution();
		System.out.println(s.isPowerOfTwo(1));
	}
}
