package factorialTrailingZeroes;
//问题描述：对n的阶乘，求其末尾0的个数
public class Solution {

	public int trailingZeroes(int n) {
        int result = 0;
        //每一次循环，是计算n中有多少个5/25/125...要注意temp越界问题
        for(long temp=5;;temp=temp*5)
        {
        	result += n/temp;
        	if(temp>n/2)
        	{
        		break;
        	}
        }
        return result;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		System.out.println(s.trailingZeroes(10));

	}

}
