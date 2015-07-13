package mergeTowSortedLists;

class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) 
	      {
	          val = x;
	          next = null;
	      }
}
public class Solution {

	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //���l1��l2Ϊ�գ���ֱ�ӷ�����һ������
		if(l1==null)return l2;
		if(l2==null)return l1;
		//����һ���µ������洢��Ϻ�Ľ��
		ListNode newListHead = null;
		
		if(l1.val<l2.val)
		{
			newListHead=l1;
			l1=l1.next;
		}
		else
		{
			newListHead=l2;
			l2=l2.next;
		}
		ListNode currentNode = newListHead;//��������ʱ�õ��������ڵ�
		
		//����һ������Ϊ��ʱ������ѭ��
		while(l1!=null&&l2!=null)
		{
			if(l1.val<l2.val)
			{
				currentNode.next = new ListNode(l1.val);
				l1 = l1.next;
				currentNode = currentNode.next;
			}
			else
			{
				currentNode.next = new ListNode(l2.val);
				l2 = l2.next;
				currentNode = currentNode.next;
			}
		}
		
		if(l1!=null)currentNode.next=l1;
		if(l2!=null)currentNode.next=l2;
		return newListHead;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Solution s  = new Solution();
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode newList = s.mergeTwoLists(l1, l2);
		while(newList!=null)
		{
			System.out.println(newList.val);
			newList = newList.next;
		}
	}

}
