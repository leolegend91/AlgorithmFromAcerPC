package balancedBinaryTree;

class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }
public class Solution {

	public boolean isBalanced(TreeNode root) {
        
		if(root == null)
			return true;
        int leftdepth = getDepth(root.left);
        int rightdepth = getDepth(root.right);
        
        if(Math.abs(leftdepth-rightdepth)>1)return false;
        else{
        	if(root.left!=null)
        	{
        		if(!isBalanced(root.left))
        		{
        			return false;
        		}
        					
        	}
        	if(root.right!=null)
        	{
        		if(!isBalanced(root.right))
        		{
        			return false;
        		}
        	}            
        }
        return true;
    }
	
	//求树的深度
	public int getDepth(TreeNode rootNode)
	{
		if(rootNode==null)
		{
			return 0;
		}
		
		int leftDepth = getDepth(rootNode.left);
		int rightDepth = getDepth(rootNode.right);
		
		return Math.max(leftDepth, rightDepth)+1;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		TreeNode rootNode = new TreeNode(1);
		TreeNode node1 = new TreeNode(2);
		TreeNode node2 = new TreeNode(3);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(3);
		TreeNode node5 = new TreeNode(4);
		TreeNode node6 = new TreeNode(4);
		TreeNode node7 = new TreeNode(4);
		rootNode.left=node1;
		rootNode.right=node2;
		node1.left=node3;
		node1.right=node4;
		node2.right=node5;
		node3.left=node6;
		node5.right=node7;
		
		Solution s =new Solution();
		System.out.println(s.isBalanced(rootNode));
		
	}

}
