package removeNthNode;

import java.util.HashMap;

 class ListNode {
     int val;
     ListNode next;
     ListNode(int x) {
         val = x;
         next = null;
     }
 }
public class Solution {

	public ListNode removeNthFromEnd(ListNode head, int n) {
		if(head==null)return null;
		HashMap<Integer,ListNode> listMap = new HashMap<Integer,ListNode>();
        ListNode curNode = head;
        int count = 0;
        //遍历链表，统计节点个数
        while(curNode!=null)
        {
        	listMap.put(count, curNode);//把第n个节点放入listMap中
        	count++;
        	curNode = curNode.next;
        }
        int size = listMap.size();
        //如果要删除的节点是头结点
        if(n==size)return head.next;
        //如果要删除的节点是尾节点
        if(n==1)
        {
        	ListNode foreNode = listMap.get(size-n-1);
        	foreNode.next=null;
        	return head;
        }
        //如果要删除的是中间节点
        else
        {
        	ListNode foreNode = listMap.get(size-n-1);
        	ListNode deleteNode = listMap.get(size-n);
        	ListNode nextNode = listMap.get(size-n+1);
        	foreNode.next=nextNode;
        	return head;
        }
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Solution s = new Solution();
		ListNode head = new ListNode(0);
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		int n=2;
		head.next=node1;
		node1.next=node2;
		node2.next=node3;
		node3.next=node4;
		
		s.removeNthFromEnd(head, n);
		ListNode curNode = head;
		while(curNode!=null)
		{
			System.out.println(curNode.val);
			curNode = curNode.next;
		}
	}

}
