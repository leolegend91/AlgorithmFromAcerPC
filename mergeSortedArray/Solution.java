package mergeSortedArray;

public class Solution {

	public void merge(int A[], int m, int B[], int n) {
		//为两个数组设置两个索引
		int aPoi = m-1;
		int bPoi = n-1;
		
		//从第m+n位开始存储数据；
		int i=m+n-1;
		for(;i>-1;i--)
		{
			//两个数组都没有到起始位置
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
			//其中一个数组达到起始位置
			else break;
		}
		//B数组先到达起点，直接返回
		if(aPoi>-1)return;
		//A数组先到达起点，把B数组前面的数字继续复制
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
