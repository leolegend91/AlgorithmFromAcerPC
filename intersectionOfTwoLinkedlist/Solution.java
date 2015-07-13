package intersectionOfTwoLinkedlist;

class ListNode {
     int val;
     ListNode next;
     ListNode(int x) {
         val = x;
         next = null;
     }
 }

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    	//如果两个链表有一个为空，则直接返回null
    	if(headA==null||headB==null)
    	{
    		return null;
    	}
    	//两个链表的长度，由于头结点的next为null，循环终止条件为节点的next为null，故起始长度为1
    	int lengthA = 1,lengthB=1;
    	ListNode currentNodeA = headA.next,currentNodeB = headB.next;
    	while(currentNodeA!=null)
    	{
    		lengthA++;
    		currentNodeA = currentNodeA.next;
    	}
    	while(currentNodeB!=null)
    	{
    		lengthB++;
    		currentNodeB = currentNodeB.next;
    	}
    	//比较两个链表长度，求出长度差；
    	int lengthDiffer = Math.abs(lengthA-lengthB);
    	//A不小于B时，设A为较长者
    	ListNode longListNode = lengthA>lengthB?headA:(lengthA==lengthB?headA:headB);
    	ListNode shortListNode = lengthA<lengthB?headA:headB;
    	//长链表先去除多出的部分
    	while(true)
    	{
    		if(lengthDiffer == 0)
    		{
    			break;
    		}
    		longListNode = longListNode.next;
    		lengthDiffer--;    		
    	}
    	
    	do{
    		//如果找到了相同节点，返回
    		if(longListNode.val == shortListNode.val)
    		{
    			return longListNode;
    		}
    		//如果没有找到，两个链表均向后移位
    		else
    		{
    			longListNode=longListNode.next;
    			shortListNode=shortListNode.next;
    		}
    	}while(longListNode != null);    	
    	
    	return null;    	
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Solution s = new Solution();
		ListNode list1 = s.generateList(1, 11);
		ListNode list2 = s.generateList(2, 1);
		
		System.out.println(s.getIntersectionNode(list1, list2));
		
		ListNode list3 = new ListNode(1);
		ListNode list4 = new ListNode(2);
		System.out.println(s.getIntersectionNode(list3, list4));
		
	}

	//自动生成链表，头结点的value为调用时传入，后面节点的value为其序号
	public ListNode generateList(int headValue,int length)
	{
		ListNode headNode = new ListNode(headValue);
		ListNode currentNode = headNode;
		//头结点为0，因此从1开始计数
		for(int i=1;i<length;i++)
		{
			ListNode newNode = new ListNode(2*i-1);
			currentNode.next = newNode;
			currentNode = newNode;
		}
		
		return headNode;
	}

}
