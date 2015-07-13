package countCompleteTreeNodes;

import java.util.ArrayList;

class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }
public class Solution {

    public int countNodes(TreeNode root) {
        int nodeNum = 0;
    	int depth = countDepth(root);
        if(depth == 0)return 0;
        else if(depth == 1)return 1;
        else
        {
        	nodeNum += (Math.pow(2, depth-1)-1);//上面n-1层的数量
        	int lastLevelNum = (int)Math.pow(2, depth-1);//最后一层的初始数量
        	int curDepth = 2;
        	TreeNode p = root;
        	
        	while(curDepth<depth)
        	{
        		//如果左子树不为满树，则最后一层数量减半，从左子树开始继续查找
        		if(!fullTreeCheck(p.left,depth+1-curDepth))
        		{
        			lastLevelNum -= Math.pow(2, depth-curDepth);
        			p = p.left;
        		}
        		//左子树不为空，从左子树继续查找
        		else
        		{
        			p = p.right;
        		}
        		curDepth++;
        	}
        	if(p.left == null)lastLevelNum -= 2;
        	else if(p.right == null)lastLevelNum -= 1;
        	else lastLevelNum -= 0;
        	
        	nodeNum += lastLevelNum;
        	return nodeNum;        	
        }
    }
    
    public int countDepth(TreeNode root)
    {
    	int depth = 0;
    	TreeNode p = root;
    	while(p!=null)
    	{
    		p = p.left;
    		depth++;
    	}
    	return depth;
    }
    
    public boolean fullTreeCheck(TreeNode root,int depth)
    {
    	if(root == null)return true;
    	//int depth = countDepth(root);
    	TreeNode n = root;
    	int rightDepth = 0;
    	while(n!=null)
    	{
    		n = n.right;
    		rightDepth++;
    	}
    	return (rightDepth==depth);
    }
	public static void main(String[] args) {
		//int nodeNum = 8923;
		int nodeNum=1;
		while(nodeNum<1000){
		int halfNum = nodeNum>>>1; 
		TreeNode[] treeNodeList = new TreeNode[nodeNum];
		for(int i=0;i<nodeNum;i++)
		{
			treeNodeList[i] = new TreeNode(i);
		}
		
		for(int i=0;i<halfNum;i++)
		{
			if(((i<<1)+1)<nodeNum)
			{
				treeNodeList[i].left = treeNodeList[(i<<1)+1];
			}
			if(((i<<1)+2)<nodeNum)
			{
				treeNodeList[i].right = treeNodeList[(i<<1)+2];
			}
		}
		
		Solution s = new Solution();
		System.out.print("realNum:");
		System.out.print(nodeNum);
		System.out.print("-countNum:");
		System.out.print(s.countNodes(treeNodeList[0]));
		System.out.println();
		nodeNum++;
		}
		//System.out.println(8923-8192);
		//System.out.println(s.countNodes(null));
		

	}

}
