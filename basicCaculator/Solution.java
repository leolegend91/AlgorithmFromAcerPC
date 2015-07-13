package basicCaculator;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {

	Deque<Character> operStack = new ArrayDeque<Character>();
	Deque<Integer> numStack = new ArrayDeque<Integer>();
	public int calculate(String s) {
		StringBuilder sb = new StringBuilder();
		char c;
		for(int i=0;i<s.length();i++)
		{
			c=s.charAt(i);
			switch(c)
			{
			case ' ':break;
			case '(':
			{
				if(sb.length()>0)
				{
					numStack.add(Integer.parseInt(sb.toString()));
					sb.delete(0, sb.length());
				}
				operStack.add('(');
				break;
			}
			case ')':
			{
				if(sb.length()>0)
				{
					numStack.add(Integer.parseInt(sb.toString()));
					sb.delete(0, sb.length());
				}
				char oper;
				while(!operStack.isEmpty())
				{
					oper = operStack.pollLast();
					if(oper == '(')break;
					else if(oper == '+')
					{
						int a = numStack.pollLast();
						int b = numStack.pollLast();
						numStack.add(b+a);
					}
					else if(oper == '-')
					{
						int a = numStack.pollLast();
						int b = numStack.pollLast();
						numStack.add(b-a); 
					}
					//else{}
				}
				break;
			}
			case '+':
			{
				if(sb.length()>0)
				{
					numStack.add(Integer.parseInt(sb.toString()));
					sb.delete(0, sb.length());
				}
				if(operStack.isEmpty() || operStack.getLast()=='(')
				{
					operStack.add('+');
				}
				else
				{
					char oper = operStack.pollLast();
					int a = numStack.pollLast();
					int b = numStack.pollLast();
					if(oper == '+')
					{
						numStack.add(a+b);
					}
					else
					{
						numStack.add(b-a);
					}
					operStack.add('+');
				}
				break;
			}
			case '-':
			{
				if(sb.length()>0)
				{
					numStack.add(Integer.parseInt(sb.toString()));
					sb.delete(0, sb.length());
				}
				if(operStack.isEmpty() || operStack.getLast()=='(')
				{
					operStack.add('-');
				}
				else
				{
					char oper = operStack.pollLast();
					int a = numStack.pollLast();
					int b = numStack.pollLast();
					if(oper == '+')
					{
						numStack.add(a+b);
					}
					else
					{
						numStack.add(b-a);
					}
					operStack.add('-');
				}
				break;
			}
			default:sb.append(c);
			}
		}
		if(sb.length()>0)numStack.add(Integer.parseInt(sb.toString()));
		while(!operStack.isEmpty())
		{
			char oper = operStack.pollLast();
			int a = numStack.pollLast();
			int b = numStack.pollLast();
			if(oper == '+')
			{
				numStack.add(b+a);
			}
			else 
			{
				numStack.add(b-a);
			}
		}
		return numStack.getLast();
	}
	
	public static void main(String[] args) {
		Solution s = new Solution();
		String str1 = "1 + 1";
		String str2 = " 2-1 + 2 ";
		String str3 = "(1+(4+5+2)-3)+(6+8)";
		String str4 = "12345";
		String str5 = "1-1";
		System.out.println(s.calculate(str1));
		System.out.println(s.calculate(str2));
		System.out.println(s.calculate(str3));
		System.out.println(s.calculate(str4));
		System.out.println(s.calculate(str5));
	}
}
