package majorityElement;
//��hashmapʵ�֣��㷨��Ϊ��ʱ
import java.util.HashMap;

public class Solution {

	public int majorityElement(int[] num) {
		
		//���������ֻ��һ��Ԫ�أ����Ԫ�ؾ������ֱ�ӷ���
		if(num.length==1)
		{
			return num[0];
		}
		//���һ��hashmap����ؼ�������Ϊ�����е����֣�ֵ����Ϊ����ͳ�Ƹ�����
		HashMap<Integer,Integer> statmap = new HashMap<Integer,Integer>();
        
		for(int i=0;i<num.length;i++)
        {
			//���hashmap�в�������ǰֵ������������У�����value����Ϊ1
        	if(!statmap.containsKey(num[i]))
        	{
        		statmap.put(num[i], 1);
        	}
        	//���hashmap������ǰֵ�����Ӧ��valueֵ��1
        	else
        	{
        		int oldValue = statmap.get(num[i]);
        		int newValue = oldValue+1;        		
        		
        		//���valueֵ����num���ȵ�һ�룬���Ѿ��ҵ�majority int�������ٲ��ң�����ѭ��
        		if(newValue>num.length/2)
        		{
        			return num[i];
        		}
        		//�����δ�ҵ�����д���µ�value
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
