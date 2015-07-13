package invertBinaryTree;


public class Solution {
	
	public TreeNode invertTree(TreeNode root) {
        if(root==null)return null;
        TreeNode tmp = root.left;
        root.left=root.right;
        root.right=tmp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
	public static void main(String[] args) {
		
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
