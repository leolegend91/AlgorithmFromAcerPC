package minumumDepthOfBinaryTree;

import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {

	public int minDepth(TreeNode root) {
		if(root==null)
			return 0;
		int minDepth = 1;
		int cur=0;//当前访问节点的序号
		int last=1;//当前层末尾的序号
		List<TreeNode> list = new ArrayList<TreeNode>();
		list.add(root);
		//当cur小于list.size时说明还有没有访问到的节点；当cur等于list.size时全部遍历结束
		//当cur小于last时说明当前层还未遍历完；当cur等于last时当前层遍历结束；
outer:	while(cur<list.size())
		{
			last=list.size();
insider:	while(cur<last)
			{
				//找到第一个叶子节点，跳出循环
				if((list.get(cur).left==null)&&(list.get(cur).right==null))break outer;
				if(list.get(cur).left!=null)list.add(list.get(cur).left);
				if(list.get(cur).right!=null)list.add(list.get(cur).right);
				
				cur++;
			}
			minDepth++;
		}
		return minDepth;
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
		node1.right=null;
		node2.left=node4;
		node3.right=node5;
		
		node6.left=node7;
		node6.right=node8;
		node7.left=node9;
		node8.right=node0;
		
//		Solution s = new Solution();
//		System.out.println(s.minDepth(node1));
		
		 
		
	}

}
