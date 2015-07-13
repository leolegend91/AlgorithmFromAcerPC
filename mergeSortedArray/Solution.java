package mergeSortedArray;

public class Solution {

	public void merge(int A[], int m, int B[], int n) {
		//Ϊ��������������������
		int aPoi = m-1;
		int bPoi = n-1;
		
		//�ӵ�m+nλ��ʼ�洢���ݣ�
		int i=m+n-1;
		for(;i>-1;i--)
		{
			//�������鶼û�е���ʼλ��
			if(aPoi>-1&&bPoi>-1)
			{
				if(A[aPoi]>B[bPoi])
				{
					A[i]=A[aPoi];
					aPoi--;
				}
				else
				{
					A[i]=B[bPoi];
					bPoi--;
				}
			}
			//����һ������ﵽ��ʼλ��
			else break;
		}
		//B�����ȵ�����㣬ֱ�ӷ���
		if(aPoi>-1)return;
		//A�����ȵ�����㣬��B����ǰ������ּ�������
		else{
			for(;i>-1;i--)
			{
				A[i]=B[bPoi];
				bPoi--;
			}
			return;
		}
		
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int a[] = new int[20];
		int b[] = {2,4,6,8,10};
		
		for(int i=0;i<5;i++)
		{
			a[i]=2*i+1;
		}
		
		Solution s = new Solution();
		s.merge(a, 5, b, 5);
		for(int i=0;i<a.length;i++)
		{
			System.out.print(a[i]);
			System.out.print(' ');
		}
		
		
	}

}
