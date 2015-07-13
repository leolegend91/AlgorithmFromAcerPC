package PascalsTriangleII;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Solution {

	public List<Integer> getRow(int rowIndex) {
		
        List<Integer> resultList = new ArrayList<Integer>();
        for(int i=0;i<rowIndex+1;i++)
        {
        	resultList.add(cacuCombination(rowIndex,i));
        }
        return resultList;
    }
	//������Ͻ����n���£�m����
	public static int cacuCombination(int n,int m)
	{
		if(n<m)return 0;//nһ���Ǵ���m��
		if(m==0)return 1;//��m����0ʱ���ֵΪ1
		BigInteger temp1 = new BigInteger(String.valueOf(1));//�洢n!����m!
		BigInteger temp2 = new BigInteger(String.valueOf(1));//�洢��n-m��!
		for(int i=n;i>m;i--)
		{
			temp1 = temp1.multiply(new BigInteger(String.valueOf(i)));
			
		}
		for(int i=1;i<(n-m+1);i++)
		{
			temp2 = temp2.multiply(new BigInteger(String.valueOf(i)));
		}
		return (Integer.parseInt(temp1.divide(temp2).toString()));
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(cacuCombination(13,1));
		
		Solution s = new Solution();
		for(int i=0;i<15;i++)
		{
			System.out.println(s.getRow(i));
		}
		int temp = 1;
		for(int i=1;i<20;i++)
		{
			temp*=i;
			System.out.println(i+" "+temp);
		}
		System.out.println();
		
	}

}
