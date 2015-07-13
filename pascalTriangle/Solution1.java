package pascalTriangle;

import java.util.LinkedList;
import java.util.List;

public class Solution1 {

	public List<List<Integer>> generate(int numRows) {
		
		//输入不合规范，直接返回null
		if(numRows<1)
		{
			return null;
		}
        List<List<Integer>> resultList = new LinkedList<List<Integer>>();
        for(int i=0;i<numRows;i++)
        {
        	List<Integer> newList = new LinkedList<Integer>();
        	//第一行直接填入1
        	if(i==0)
        	{
        		newList.add(1);
        		resultList.add(newList);
        		continue;
        	}
        	else
        	{
        		//列数等于行数
        		int column = i;
        		int temp=1;
        		//第一列直接填入1
        		newList.add(1);
        		//填充中间几列
        		for(int j=1;j<column;j++)
        		{
        			temp = ((i-j+1)*(temp))/j;
        			newList.add(temp);
        		}
        		//最后一列填入1
        		newList.add(1);
        		resultList.add(newList);
        	}
        }
        return resultList;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Solution1 s = new Solution1();
		System.out.println(s.generate(5));
	}

}
