package climbingStairs;

public class Solution {

	//用递归实现，计算时间超时
//	public int climbStairs(int n) {
//        if(n<=3)return n;
//        int result;
//        result = climbStairs(n-1)+climbStairs(n-2);
//        return result;
//    }
	public int climbStairs(int n) {
		if(n<2)return n;
		int fiboArray[] = new int[n+1];//有一个第0项作为辅助，所以要申请n+1个长度空间
		fiboArray[0]=0;
		fiboArray[1]=1;
		for(int i=2;i<n+1;i++)
		{
			fiboArray[i]=fiboArray[i-1]+fiboArray[i-2];
		}
		return fiboArray[n];
	}
	
	public int Fibonacci(int n)
	{
		double temp1 = (1+Math.sqrt(5))/2;
		double temp2 = (1-Math.sqrt(5))/2;
		return (int)Math.round((Math.pow(temp1, n+1)-Math.pow(temp2, n+1))/Math.sqrt(5));
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Solution s = new Solution();
		int length = 50;
		for(int i=0;i<length;i++)
		{
			System.out.print(s.climbStairs(i));
			System.out.print(" ");
		}
		System.out.println();
		for(int i=0;i<length;i++)
		{
			System.out.print(s.Fibonacci(i));
			System.out.print(" ");
		}
		
	}

}
