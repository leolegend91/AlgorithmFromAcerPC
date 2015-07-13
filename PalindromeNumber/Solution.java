package PalindromeNumber;
//�ж�һ�������Ƿ�Ϊ��������
public class Solution {

	public boolean isPalindrome(int x) {
		
		//���Ϊ������ֱ�ӷ���false
		if(x<0)
		{
			return false;
		}
        //���С��10����-1����ֱ���ж�Ϊtrue
		if(x<10)
		{
			return true;
		}
		int start = x;
		int end = 0;//�洢��������x
		//�����С��10��start�������࣬���������ϳ���10���������µ����������յõ�end����start�Ƚ�
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
