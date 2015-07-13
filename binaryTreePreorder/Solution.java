package binaryTreePreorder;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
}
public class Solution {

	public List<Integer> preorderTraversal(TreeNode root) {
        
		List<Integer> result = new LinkedList<Integer>();
		if(root==null)return result;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        result.add(root.val);
        stack.push(root);
        TreeNode curNode = root;
        while(stack.size()>0)
        {
        	if(curNode.left!=null)
        	{
        		result.add(curNode.left.val);
        		stack.push(curNode.left);
        		curNode = curNode.left;
        	}
        	else
        	{
        		curNode = stack.pop();
        		if(curNode.right!=null)
        		{
        			result.add(curNode.right.val);
        			stack.push(curNode.right);
        			curNode = curNode.right;
        		}
        		else
        		{
        			while(stack.size()>0&&curNode.right==null)
        			{
        				curNode=stack.pop();
        			}
        			if(curNode.right!=null)
        			{
        				result.add(curNode.right.val);
        				stack.push(curNode.right);
        				curNode = curNode.right;
        			}
        			
        		}
        	}
        }
        return result;
    }
	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(3);
		TreeNode t4 = new TreeNode(4);
		TreeNode t5 = new TreeNode(5);
		TreeNode t6 = new TreeNode(6);
		TreeNode t7 = new TreeNode(7);
		TreeNode t8 = new TreeNode(8);
		TreeNode t9 = new TreeNode(9);
		TreeNode t10 = new TreeNode(10);
		TreeNode t11 = new TreeNode(11);
		
		t1.left=t2;
		t1.right=t3;
		t2.left=t4;
		t2.right=t5;
		t3.left=t6;
		t3.right=t7;
		t4.right=t8;
		t5.right=t10;
		t8.left=t9;
		
		Solution s = new Solution();
		List<Integer> l = s.preorderTraversal(null);
		Iterator ite = l.iterator();
		
		while(ite.hasNext())
		{
			System.out.print(ite.next());
			System.out.print("->");
		}
		
	}

}
