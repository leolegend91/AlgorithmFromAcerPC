package getLastOrderTreeBYPreAndMiddle;

class TreeNode{
	char val;
	TreeNode leftNode;
	TreeNode rightNode;
	public TreeNode(){}
	public TreeNode(char val)
	{
		this.val=val;
	}
}

class TreeManager{
	
	public void printLastOrderTree(TreeNode node)
	{
		if(node==null)return;
		//打印左子树
		if(node.leftNode!=null)
		{
			printLastOrderTree(node.leftNode);
		}
		//打印右子树
		if(node.rightNode!=null)
		{
			printLastOrderTree(node.rightNode);
		}
		//打印根节点
		System.out.print(node.val);
	}
	
	public TreeNode getLastOrderTree(String preOrder,String middleOrder)
	{
		if(preOrder==null||middleOrder==null)return null;
		TreeNode root = new TreeNode(preOrder.charAt(0));//找到根节点
		
		int leftLength = middleOrder.indexOf(preOrder.charAt(0));//左子树的长度
		//获取左子树的根节点
		if(leftLength>0)
		{
			String leftPreString = preOrder.substring(1,leftLength+1);
			String leftMiddleString = middleOrder.substring(0,leftLength);
			root.leftNode=getLastOrderTree(leftPreString,leftMiddleString);
		}
		
		//获取右子树的根节点
		if((middleOrder.length()-leftLength)>1)
		{
			
			String rightPreString = preOrder.substring(leftLength+1,preOrder.length());
			String rightMiddleString = preOrder.substring(leftLength+1,middleOrder.length());
			root.rightNode=getLastOrderTree(rightPreString, rightMiddleString);
		}
		return root;
	}
}
public class main {

	public static void main(String[] args) {
		TreeNode node1 = new TreeNode('A');
		TreeNode node2 = new TreeNode('B');
		TreeNode node3 = new TreeNode('C');
		TreeNode node4 = new TreeNode('D');
		TreeNode node5 = new TreeNode('E');
		TreeNode node6 = new TreeNode('F');
		TreeNode node7 = new TreeNode('G');
		
		node1.leftNode=node2;
		node1.rightNode=node6;
		node2.leftNode=node3;
		node2.rightNode=node4;
		node4.leftNode=node5;
		node6.rightNode=node7;
		
		TreeManager myManager = new TreeManager();
		myManager.printLastOrderTree(node1);
		System.out.println();
		myManager.printLastOrderTree(myManager.getLastOrderTree("ABCDEFG", "CBEDAFG"));

	}

}
