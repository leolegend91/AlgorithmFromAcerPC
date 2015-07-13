package pascalTriangle;
//用数组实现的，空间复杂度较高，并且结果也不符合标准
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Collections;

public class Solution {

	public List<List<Integer>> generate(int numRows) {
		Integer arrayResult[][] = new Integer[numRows][numRows];
        //二维数组中的所有行和列，都从0开始计数
        for(int i=0;i<numRows;i++)
        {
        	//第一行，直接填充1
        	if(i==0)
        	{
        		arrayResult[0][0]=1;
        		continue;
        	}
        	else
        	{
        		int column = i;//列数，等于行数
        		//对第二行之后的所有行，首位和末位都是1，直接填充
        		arrayResult[i][0]=1;
        		arrayResult[i][column]=1;
        		//填充中间几位
        		for(int j=1;j<column;j++)
        		{
        			arrayResult[i][j]=arrayResult[i-1][j-1]+arrayResult[i-1][j];
        		}        		
        	}        	
        }
		int rows = 0;
		List<List<Integer>> resultList = new LinkedList<List<Integer>>();		
		
		while(rows<numRows)
		{
			List<Integer> newList = Arrays.asList(arrayResult[rows]);
			resultList.add(newList);
			rows++;
		}
        return resultList;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//测试用，用于验证在for循环中每次循环创建一个新的对象，对象名称即使相同，也是代表不同的对象；
//		for(Integer i=0;i<5;i++)
//		{
//			String s = new String(i.toString());
//			System.out.println(s);
//		}
		
		Solution s = new Solution();		
		List<List<Integer>> testList = s.generate(5);
		System.out.println(testList);

	}

}
