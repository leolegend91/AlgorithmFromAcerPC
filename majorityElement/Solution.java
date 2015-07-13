package majorityElement;
//用hashmap实现，算法较为耗时
import java.util.HashMap;

public class Solution {

	public int majorityElement(int[] num) {
		
		//如果数组中只有一个元素，则该元素就是最大，直接返回
		if(num.length==1)
		{
			return num[0];
		}
		//设计一个hashmap，其关键字设置为数组中的数字，值设置为数字统计个数；
		HashMap<Integer,Integer> statmap = new HashMap<Integer,Integer>();
        
		for(int i=0;i<num.length;i++)
        {
			//如果hashmap中不包含当前值，将其加入其中，并把value设置为1
        	if(!statmap.containsKey(num[i]))
        	{
        		statmap.put(num[i], 1);
        	}
        	//如果hashmap包含当前值，则对应的value值加1
        	else
        	{
        		int oldValue = statmap.get(num[i]);
        		int newValue = oldValue+1;        		
        		
        		//如果value值大于num长度的一半，则已经找到majority int，不必再查找，跳出循环
        		if(newValue>num.length/2)
        		{
        			return num[i];
        		}
        		//如果还未找到，则写入新的value
        		else
        		{
        			statmap.put(num[i], newValue);
        		}
        		
        	}
        }
		
		return -1;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int test[]={1};
		Solution s = new Solution();
		System.out.println(s.majorityElement(test));
	}

}
