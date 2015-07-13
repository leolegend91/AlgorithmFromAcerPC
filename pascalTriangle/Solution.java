package pascalTriangle;
//������ʵ�ֵģ��ռ临�ӶȽϸߣ����ҽ��Ҳ�����ϱ�׼
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Collections;

public class Solution {

	public List<List<Integer>> generate(int numRows) {
		Integer arrayResult[][] = new Integer[numRows][numRows];
        //��ά�����е������к��У�����0��ʼ����
        for(int i=0;i<numRows;i++)
        {
        	//��һ�У�ֱ�����1
        	if(i==0)
        	{
        		arrayResult[0][0]=1;
        		continue;
        	}
        	else
        	{
        		int column = i;//��������������
        		//�Եڶ���֮��������У���λ��ĩλ����1��ֱ�����
        		arrayResult[i][0]=1;
        		arrayResult[i][column]=1;
        		//����м伸λ
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
		//�����ã�������֤��forѭ����ÿ��ѭ������һ���µĶ��󣬶������Ƽ�ʹ��ͬ��Ҳ�Ǵ���ͬ�Ķ���
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
