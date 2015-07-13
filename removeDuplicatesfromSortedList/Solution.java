package removeDuplicatesfromSortedList;
class ListNode {
	int val;
	ListNode next;
	ListNode(int x) {
		val = x;
		next = null;
	}
}
public class Solution {

	public ListNode deleteDuplicates(ListNode head) {
        if(head==null||head.next==null)return head;
        
        ListNode curNode = head;
        while(curNode.next!=null)
        {
        	if(curNode.val==curNode.next.val)
        	{
        		curNode.next=curNode.next.next;
        	}
        	else{
        		curNode=curNode.next;
        	}
        }
        return head;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Solution s = new Solution();
		ListNode node1=new ListNode(1);
		ListNode node2=new ListNode(1);
		ListNode node3=new ListNode(2);
		ListNode node4=new ListNode(3);
		ListNode node5=new ListNode(4);
		ListNode node6=new ListNode(4);
		ListNode node7=new ListNode(5);
		
		node1.next=node2;
		node2.next=node3;
		node3.next=node4;
		node4.next=node5;
		node5.next=node6;
		node6.next=node7;
		
		ListNode newNode = node1;
		while(newNode!=null)
		{
			System.out.print(newNode.val);
			System.out.print("->");
			newNode = newNode.next;
		}
		System.out.print("null");
		
		s.deleteDuplicates(node5);
		System.out.println();
		newNode = node1;
		while(newNode!=null)
		{
			System.out.print(newNode.val);
			System.out.print("->");
			newNode = newNode.next;
		}
		System.out.print("null");
	}

}
