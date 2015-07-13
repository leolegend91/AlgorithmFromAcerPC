package lowestCommonAncestorofaBinarySearchTree;

class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
}
public class Solution {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null)return root;
        if(root.left==null && root.right==null)return root;
        TreeNode parent = root;
        TreeNode max = p.val>q.val?p:q;
        TreeNode min = p.val<q.val?p:q;
        while(parent != null)
        {
        	if(parent.val>max.val)
        	{
        		parent = parent.left;
        	}
        	else if(parent.val<min.val)
        	{
        		parent = parent.right;
        	}
        	else
        	{
        		break;
        	}
        }
        return parent;
    }
	
	public static void main(String args[])
	{
		Solution s = new Solution();
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(3);
		TreeNode t4 = new TreeNode(4);
		TreeNode t5 = new TreeNode(5);
		TreeNode t6 = new TreeNode(6);
		
		t4.left=t2;
		t2.left=t1;
		t2.right=t3;
		t4.right=t5;
		
		System.out.println(s.lowestCommonAncestor(t4, t6, t3).val);
	}

}
