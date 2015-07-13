package validateBinarySearchTree;

import java.util.Iterator;
import java.util.LinkedList;


public class Solution {

	public boolean isValidBST(TreeNode root) {
		if(root == null)return true;
        LinkedList<TreeNode> list = new LinkedList<TreeNode>();
        list = midTranversal(root,list);
        Iterator<TreeNode> iter = list.iterator();
        TreeNode preNode = iter.next();
        TreeNode lastNode;
        if(list == null || !iter.hasNext())return true;
        while(iter.hasNext())
        {
        	lastNode = iter.next();
        	if(preNode.val>=lastNode.val)return false;
        	preNode = lastNode;
        }
        return true;   
    }
	
	public LinkedList<TreeNode> midTranversal(TreeNode root,LinkedList<TreeNode> list)
	{
		if(root==null)return null;
		midTranversal(root.left,list);
		list.add(root);
		midTranversal(root.right, list);
		return list;
	}
	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		
		n1.left=n2;
		n1.right=n3;
		n3.left=n4;
		n4.right=n5;
		
		Solution s = new Solution();
		System.out.println(s.isValidBST(n1));

	}

}

class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
     public String toString()
     {
    	 return String.valueOf(this.val);
     }
}
