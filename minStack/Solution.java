package minStack;

import java.util.Stack;

public class Solution {

	private Stack<Integer> minStack = new Stack<Integer>();//要实现的最小栈
	
	private Stack<Integer> assistStack = new Stack<Integer>();//辅助排序栈的栈，只压入比其栈顶元素小的数字；
	
	public void push(int x) {
		
		//栈满，不再压入
		if(minStack.size()==Integer.MAX_VALUE)
		{
			return;
		}
		minStack.push(x);
		//入栈的时候需要处理辅助栈。如果辅助栈为空，则直接压入
		if(assistStack.isEmpty())
		{
			assistStack.push(x);
		}
		//如果辅助栈不为空，并且元素不大于辅助栈栈顶元素，则将其压入辅助栈
		else if(!(x>assistStack.peek()))
		{
			assistStack.push(x);
		}
    }

    public void pop() {
    	//判断栈是否为空；
    	if(minStack.isEmpty())
    	{
    		return;
    	}
        int topInteger = minStack.pop();
        
        //出栈的时候需要把辅助栈中对应的数字弹出
        if(topInteger==assistStack.peek())
        {
        	assistStack.pop();
        }
        return;
    }

    public int top() {
    	//判断栈是否为空；
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
