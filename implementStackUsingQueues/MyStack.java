package implementStackUsingQueues;

import java.util.LinkedList;
import java.util.ListIterator;

public class MyStack {
	private LinkedList<Integer> list = new LinkedList<Integer>(); 
	private int size=0;
	
	// Push element x onto stack.
    public void push(int x) {
        list.add(x);
        size++;
    }

    // Removes the element on top of the stack.
    public void pop() {
    	if(empty())return;
    	list.removeLast();
    	--size;
    }

    // Get the top element.
    public int top() {
    	if(empty())return 0;
    	ListIterator<Integer> iter = list.listIterator();
    	while(iter.hasNext())iter.next();
    	return iter.previous();
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return size == 0;
    }
	public static void main(String[] args) {
		MyStack s = new MyStack();
		for(int i=0;i<10;i++)
		{
			s.push(i);
		}
		System.out.println(s.top());
		s.pop();
		System.out.println(s.top());
		for(int i=0;i<10;i++)
		{
			s.pop();
			System.out.println(s.top());
		}

	}

}
