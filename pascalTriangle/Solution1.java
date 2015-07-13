package pascalTriangle;

import java.util.LinkedList;
import java.util.List;

public class Solution1 {

	public List<List<Integer>> generate(int numRows) {
		
		//���벻�Ϲ淶��ֱ�ӷ���null
		if(numRows<1)
		{
			return null;
		}
        List<List<Integer>> resultList = new LinkedList<List<Integer>>();
        for(int i=0;i<numRows;i++)
        {
        	List<Integer> newList = new LinkedList<Integer>();
        	//��һ��ֱ������1
        	if(i==0)
        	{
        		newList.add(1);
        		resultList.add(newList);
        		continue;
        	}
        	else
        	{
        		//������������
        		int column = i;
        		int temp=1;
        		//��һ��ֱ������1
        		newList.add(1);
        		//����м伸��
        		for(int j=1;j<column;j++)
        		{
        			temp = ((i-j+1)*(temp))/j;
        			newList.add(temp);
        		}
        		//���һ������1
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
