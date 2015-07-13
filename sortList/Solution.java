package sortList;
public class Solution {

	/**
	public ListNode sortList(ListNode head) {
        if(head == null || head.next == null)return head; 
        
        ListNode prev=head;
        int length = 0;
        while(prev!=null)
        {
        	length++;
        	prev = prev.next;
        }
        sortList(head,length);
        return head;
        
    }
	public void sortList(ListNode head,int length)
	{
		if(head == null || head.next==null)return;
		if(length<=1)return;
		ListNode fore = head.next,behind=head.next;
		ListNode p = head;
		ListNode q = head;
		int foreLength = 0;
		int behiLength = 0;
		
		//找到第一个比标志位大的数字
		while(fore!=null && foreLength<(length-1) && fore.val<head.val)
		{
			fore = fore.next;
			p = p.next;
			foreLength++;
			behiLength++;
		}
		behind = fore;
		q=p;
		
		while(behind != null && behiLength<(length-1))
		{
			while(fore!=null && fore.val<=head.val && foreLength<(length-1))
			{
				fore = fore.next;
				p = p.next;
				foreLength++;
			}
			
//			if(fore==null || foreLength==(length-1))
//			{
//				swapVal(head,p);
//				break;
//			}
			while(behind != null && behind.val>head.val && behiLength<(length-1))
			{
				behind = behind.next;
				q = q.next;
				behiLength++;
			}
			if(fore == null || behind == null || foreLength==((length-1)) || behiLength==((length-1)))
			{
				break;
			}
			else
			{
				swapVal(behind,fore);
				behind = behind.next;
			}
		}
		if(foreLength==((length-1)))
		{
			swapVal(head,p);
			sortList(head,foreLength-1);
		}
		else if(behiLength==((length-1)))
		{
			swapVal(head,p);
			sortList(head.next,behiLength-1);
		}
		else
		{
			sortList(head,foreLength-1);
			sortList(fore.next,length-foreLength-1);
		}
		
		return;
	}
	public void swapVal(ListNode n1,ListNode n2)
	{
		int val = n1.val;
		n1.val = n2.val;
		n2.val = val;
	}
	
	**/
	
	public ListNode sortList(ListNode head) {
        return mergeSort(head);
    }
	
	public ListNode mergeSort(ListNode head)
	{
		if(head == null || head.next == null)return head;
		ListNode p=head,q=head,r=new ListNode(0);
		r.next=q;
		while(p!=null && p.next!=null)
		{
			p=p.next.next;
			q=q.next;
			r=r.next;
		}
		r.next=null;
		ListNode left = mergeSort(head);
		ListNode right = mergeSort(q);
		
		return merge(left,right);
	}
	public ListNode merge(ListNode h1,ListNode h2)
	{
		if(h1==null)return h2;
		else if(h2==null)return h1;
		ListNode head;
		ListNode p = new ListNode(0);
		if(h1.val<h2.val)
		{
			head = h1;
			h1=h1.next;
		}
		else
		{
			head = h2;
			h2=h2.next;
		}
		p.next=head;
		while(h1!=null && h2!=null)
		{
			if(h1.val<h2.val)
			{
				p.next.next=h1;
				h1 = h1.next;
				p=p.next;
			}
			else
			{
				p.next.next=h2;
				h2 = h2.next;
				p=p.next;
			}
		}
		if(h1==null)p.next.next=h2;
		else p.next.next=h1;
		return head;
	}
	
	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(5);
		ListNode n6 = new ListNode(6);
		
		n6.next=n5;
		n5.next=n4;
		n4.next=n3;
		n3.next=n2;
		n2.next=n1;
//		n4.next=n5;
//		n5.next=n3;
//		n3.next=n6;
//		n6.next=n2;
//		n2.next=n1;
//		ListNode head=n4;
		
		String str = "-470,-346,602,625,819,861,439,722,706,800,894,855,-385,597,-101,-84,558,-16,-236,284,349,24,-268,100,-96,-432,514,10,152,502,-29,-475,-436,571,278,632,959,397,-322,-409,712,125,-181,779,361,514,882,139,54,314,272,-42,787,329,731,312,-333,-46,-152,798,-362,819,952,791,251,-232,977,-183,-140,-229,-256,-203,-230,170,-153,-360,938,-123,-83,447,898,710,-101,64,830,-403,217,-320,531,-471,727,-408,-368,218,842,891,-205,-37,-428,-93,374,330,-189,-445,814,240,290,254,-131,-344,895,36,-240,497,378,67,927,115,193,-256,-497,-82,406,637,-417,-452,518,-205,600,26,-373,-489,476,-287,-100,-361,783,101,147,-233,703,613,931,572,21,498,379,-168,-350,166,139,-62,-285,313,901,-432,858,172,-39,-354,117,-278,367,224,455,-198,559,403,2,690,-321,831,820,-146,424,-7,618,90,-377,70,705,770,-96,953,210,331,220,-275,146,949,-345,193,38,154,915,-241,-402,-128,-88,496,-234,811,690,960,-334,665,-405,-475,579,-134,515,-185,395,304,318,-246,-386,541,191,59,-138,-161,-317,-207,-134,202,925,-140,416,57,665,568,189,148,228,747,565,-124,510,-282,-41,400,790,783,-79,453,415,-334,784,376,-203,831,-311,460,54,583,688,330,267,14,-27,752,-344,-100,-373,545,937,944,465,-289,193,735,-170,403,-153,-482,41,335,301,-350,845,634,-213,-486,-406,-10,71,986,-107,418,211,-17,951,98,934,701,-362,-153,843,819,78,576,158,-477,-71,454,200,570,420,-176,716,488,-269,617,413,357,681,178,796,951,983,710,844,661,464,-386,942,-483,-240,955,-203,966,292,39,-270,924,527,984,810,-425,-479,404,724,-83,162,520,-334,-348,189,949,-99,-443,136,-475,216,415,80,530,127,635,831,794,778,335,-101,577,853,-118,976,-354,537,9,575,-430,685,51,707,-26,584,-482,968,-194,-91,832,-84,-330,188,171,712,66,-263,-376,741,55,410,990,688,-437,-430,-121,-207,426,186,552,528,136,-470,-222,436,465,994,-266,-404,353,117,454,-95,826,254,917,426,-29,63,-348,303,869,-167,270,-426,816,971,-282,83,809,906,93,-378,114,410,-354,104,-188,381,933,919,391,-99,570,274,717,11,637,-185,914,918,277,397,561,-262,-451,752,55,-68,134,401,257,591,489,465,-115,-444,-177,8,-204,519,517,-305,292,207,943,453,392,-339,400,57,-445,-11,542,25,-256,510,0,543,-422,696,732,307,443,-297,321";
		String num[] = str.split(",");
		
		ListNode head = new ListNode(Integer.parseInt(num[0]));
		ListNode p = head;
		for(int i=1;i<num.length;i++)
		{
			ListNode cur = new ListNode(Integer.parseInt(num[i]));
			p.next=cur;
			p=p.next;
		}
		p=head;
		
		while(p!=null)
		{
			System.out.print(p.val);
			System.out.print("->");
			p = p.next;
		}
		System.out.println();
		p=head;
		Solution s = new Solution();
		p = s.sortList(p);
		while(p!=null)
		{
			System.out.print(p.val);
			System.out.print("->");
			p = p.next;
		}
		

	}

}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
