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
		int cur=0;//��ǰ���ʽڵ�����
		int last=1;//��ǰ��ĩβ�����
		List<TreeNode> list = new ArrayList<TreeNode>();
		list.add(root);
		//��curС��list.sizeʱ˵������û�з��ʵ��Ľڵ㣻��cur����list.sizeʱȫ����������
		//��curС��lastʱ˵����ǰ�㻹δ�����ꣻ��cur����lastʱ��ǰ�����������
outer:	while(cur<list.size())
		{
			last=list.size();
insider:	while(cur<last)
			{
				//�ҵ���һ��Ҷ�ӽڵ㣬����ѭ��
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
