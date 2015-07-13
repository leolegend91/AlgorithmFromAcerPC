package minStack;

import java.util.Stack;

public class Solution {

	private Stack<Integer> minStack = new Stack<Integer>();//Ҫʵ�ֵ���Сջ
	
	private Stack<Integer> assistStack = new Stack<Integer>();//��������ջ��ջ��ֻѹ�����ջ��Ԫ��С�����֣�
	
	public void push(int x) {
		
		//ջ��������ѹ��
		if(minStack.size()==Integer.MAX_VALUE)
		{
			return;
		}
		minStack.push(x);
		//��ջ��ʱ����Ҫ������ջ���������ջΪ�գ���ֱ��ѹ��
		if(assistStack.isEmpty())
		{
			assistStack.push(x);
		}
		//�������ջ��Ϊ�գ�����Ԫ�ز����ڸ���ջջ��Ԫ�أ�����ѹ�븨��ջ
		else if(!(x>assistStack.peek()))
		{
			assistStack.push(x);
		}
    }

    public void pop() {
    	//�ж�ջ�Ƿ�Ϊ�գ�
    	if(minStack.isEmpty())
    	{
    		return;
    	}
        int topInteger = minStack.pop();
        
        //��ջ��ʱ����Ҫ�Ѹ���ջ�ж�Ӧ�����ֵ���
        if(topInteger==assistStack.peek())
        {
        	assistStack.pop();
        }
        return;
    }

    public int top() {
    	//�ж�ջ�Ƿ�Ϊ�գ�
        if(minStack.isEmpty())
        {
        	return -1;
        }
        
        return minStack.peek();        
    }

    public int getMin() {
    	if(assistStack.isEmpty())
    	{
    		return -1;
    	}
    	
    	return assistStack.peek();
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Solution s = new Solution();
		s.push(2);
		s.push(3);
		s.push(5);
		s.push(1);
		s.push(4);
		s.push(1);
		System.out.println(s.getMin());
		s.pop();
		s.pop();
		System.out.println(s.getMin());
		s.pop();
		System.out.println(s.getMin());
		
	}

}
