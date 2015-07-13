package excelSheetColumnTitle;

public class Solution {

	public String convertToTitle(int n) {
        StringBuilder myBuilder = new StringBuilder();
        //输入不符合规范，返回null
        if(n<1)
        {
        	return null;
        }
        //存储数字，从0开始计数
        int temp = n;

        while(true)
        {
        	//先求余数
        	myBuilder.append((char)((temp-1)%26+65));
        	//向前进位
        	temp=(temp-1)/26;
        	//当temp达到0时跳出循环
        	if(temp==0)
        	{
        		break;
        	}
        	
        }
        //把myBuilder反转，得到正确结果
        myBuilder.reverse();
        return myBuilder.toString();
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println((int)'A');

		Solution s = new Solution();
		System.out.println(s.convertToTitle(676+25));
	}

}
