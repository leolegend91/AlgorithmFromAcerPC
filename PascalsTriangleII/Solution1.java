package PascalsTriangleII;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Solution1 {

	public List<Integer> getRow(int rowIndex) {
		
        List<Integer> resultList = new ArrayList<Integer>();
        
        if(rowIndex==0)
        	{
        		resultList.add(1);
        		return resultList;
        	}
        int temp=1;
        resultList.add(1);
        for(int i=1;i<=rowIndex;i++)
        {
        	if(temp<100000000)
        	{
        		temp = (temp*(rowIndex-i+1))/i;
        		resultList.add(temp);
        	}
        	else
        	{
        		BigInteger bigTemp = new BigInteger(String.valueOf(temp));
        		BigInteger bigroi = new BigInteger(String.valueOf((rowIndex-i+1)));
        		int result = Integer.parseInt(((bigTemp.multiply(bigroi))).divide(new BigInteger(String.valueOf(i))).toString());
        		temp=result;
        		resultList.add(result);
        	}
        	
        	
        }
        
        return resultList;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Solution1 s = new Solution1();
//		for(int i=0;i<40;i++)
//		{
//			System.out.println(i+":"+s.getRow(i));
//		}
		System.out.println(s.getRow(31));
		
	}

}
