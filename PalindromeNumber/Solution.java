package PalindromeNumber;
//判断一个数字是否为回文数字
public class Solution {

	public boolean isPalindrome(int x) {
		
		//如果为负数，直接返回false
		if(x<0)
		{
			return false;
		}
        //如果小于10大于-1，则直接判断为true
		if(x<10)
		{
			return true;
		}
		int start = x;
		int end = 0;//存储反过来的x
		//如果不小于10，start不断求余，把余数不断乘以10，并加上新的余数，最终得到end，与start比较
		while(start!=0)
		{
			int remain = start%10;
			end = 10*end+remain;
			start=start/10;
		}
		return end==x;
		
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Solution s = new Solution();
		System.out.println(s.isPalindrome(1));
		System.out.println(s.isPalindrome(0));
		System.out.println(s.isPalindrome(-1));
		System.out.println(s.isPalindrome(11));
		System.out.println(s.isPalindrome(12321));
		System.out.println(s.isPalindrome(1001));
		
	}

}
