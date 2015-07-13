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
        //���pqͬʱΪnull�򷵻�true���������ֻ���ڸ��ڵ�Ϊnullʱ�Ż���֣���Ϊ���涼������p��Ϊnullʱ��ִ�еݹ����
        if(p==null&&q==null)return true;
        //���qΪnull�򷵻�false
        if(p==null||q==null)return false;
        if(p.val!=q.val)   	return false;
        if(p.left!=null)
        {
        	result = isSameTree(p.left,q.left);
        	if(!result)return result;
        	
        }
        //�������������жϣ������p�Ŀ������������q��Ӧλ����ֵ���ǲ�ͬ��������������ȷ�ж�
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
