package sameTree;

class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }
public class Solution {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        boolean result = true;
        //如果pq同时为null则返回true，这种情况只有在根节点为null时才会出现，因为后面都控制了p不为null时才执行递归操作
        if(p==null&&q==null)return true;
        //如果q为null则返回false
        if(p==null||q==null)return false;
        if(p.val!=q.val)   	return false;
        if(p.left!=null)
        {
        	result = isSameTree(p.left,q.left);
        	if(!result)return result;
        	
        }
        //如果不加下面的判断，则对于p的空左子树，如果q对应位置有值，是不同的树，但不能正确判断
    	if(p.left==null&&q.left!=null)return false;
        if(p.right!=null)
        {
        	result = isSameTree(p.right,q.right);
        	if(!result)return result;
        	
        }
        if(p.right==null&&q.right!=null)return false;
        return result;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(6);
		
		
		TreeNode node6 = new TreeNode(1);
		TreeNode node7 = new TreeNode(2);
		TreeNode node8 = new TreeNode(3);
		TreeNode node9 = new TreeNode(4);
		TreeNode node0 = new TreeNode(5);
		
		node1.left=null;
		node1.right=node3;
		node2.left=node4;
		node3.right=node5;
		
		node6.left=node7;
		node6.right=node8;
		node7.left=node9;
		node8.right=node0;
		
		Solution s = new Solution();
		System.out.println(s.isSameTree(node1, node6));
	}

}
