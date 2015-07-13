package palindromeLinkedList;

class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
 }

public class Solution {
	
	public boolean isPalindrome(ListNode head) {
		if(head==null || head.next==null)return true;
        ListNode fast = head;
        ListNode slow = new ListNode(-1);
        slow.next=head;
        
        ListNode next = slow.next;
        ListNode tmp;
        boolean odd;
        
        while(fast!=null && fast.next!=null)
        {
        	fast = fast.next.next;
        	tmp = next.next;
        	next.next=slow;
        	slow = next;
        	next = tmp;
        }
        if(fast==null)
        {
        	odd=false;
        }
        else
        {
        	odd = true;
        }
        
        if(odd)next = next.next;
        
        while(slow!=null && next !=null)
        {
        	if(slow.val!=next.val)return false;
        	slow = slow.next;
        	next = next.next;
        }
        return true;
    }
	
	public static void main(String args[])
	{
		Solution s = new Solution();
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(3);
		ListNode l5 = new ListNode(2);
		ListNode l6 = new ListNode(1);
	
		l1.next=l2;
		l2.next=l3;
		l3.next=l5;
		l4.next=l5;
		l5.next=l6;
		
		System.out.println(s.isPalindrome(l1));
	}
	

}
