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
    	//�������������һ��Ϊ�գ���ֱ�ӷ���null
    	if(headA==null||headB==null)
    	{
    		return null;
    	}
    	//��������ĳ��ȣ�����ͷ����nextΪnull��ѭ����ֹ����Ϊ�ڵ��nextΪnull������ʼ����Ϊ1
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
    	//�Ƚ����������ȣ�������Ȳ
    	int lengthDiffer = Math.abs(lengthA-lengthB);
    	//A��С��Bʱ����AΪ�ϳ���
    	ListNode longListNode = lengthA>lengthB?headA:(lengthA==lengthB?headA:headB);
    	ListNode shortListNode = lengthA<lengthB?headA:headB;
    	//��������ȥ������Ĳ���
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
    		//����ҵ�����ͬ�ڵ㣬����
    		if(longListNode.val == shortListNode.val)
    		{
    			return longListNode;
    		}
    		//���û���ҵ�����������������λ
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

	//�Զ���������ͷ����valueΪ����ʱ���룬����ڵ��valueΪ�����
	public ListNode generateList(int headValue,int length)
	{
		ListNode headNode = new ListNode(headValue);
		ListNode currentNode = headNode;
		//ͷ���Ϊ0����˴�1��ʼ����
		for(int i=1;i<length;i++)
		{
			ListNode newNode = new ListNode(2*i-1);
			currentNode.next = newNode;
			currentNode = newNode;
		}
		
		return headNode;
	}

}
