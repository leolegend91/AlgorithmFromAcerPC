package medianOfTwoSortedArrays;

public class Solution {

	public static boolean odd;//两个数组加起来是奇数还是偶数
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		double result;
		if(nums1.length<1)return findMedianSortedArrays(nums2);
		else if(nums2.length<1)return findMedianSortedArrays(nums1);
		else if((nums1.length+nums2.length)%2==0)odd=false;
		else odd=true;
		if(nums1.length==1 && nums2.length==1)
		{
			result = ((double)nums1[0]+(double)nums2[0])/2;
		}
		else result = findMedianSortedArrays(nums1,nums2,0,nums1.length-1,0,nums2.length-1);
		return result;
    }
	public double findMedianSortedArrays(int[] nums1, int[] nums2,int start1,int end1,int start2,int end2) {
        //如果某个数组被二分成只有一个数字
		int[] singleNum=null;
		int[] multiNum=null;
		int singleStart=0,singleEnd=0,multiStart=0,multiEnd=0;
		int totalMid=0;
		boolean midInSingle=true;
		if(start1==end1)
		{
			singleNum=nums1;
			multiNum=nums2;
			singleStart=start1;
			singleEnd=end1;
			multiStart=start2;
			multiEnd=end2;
		}
		else if(start2==end2)
		{
			singleNum=nums2;
			multiNum=nums1;
			singleStart=start2;
			singleEnd=end2;
			multiStart=start1;
			multiEnd=end1;
		}
		if(singleNum!=null)
        {
        	int aMid = singleNum[singleStart];
        	if((multiEnd-multiStart)%2!=0)
        	{
        		int bMidLow = multiNum[(multiEnd+multiStart)/2];
        		int bMidUp  = multiNum[(multiEnd+multiStart)/2+1];
        	    totalMid = middle(aMid,bMidLow,bMidUp);
        	    if(totalMid==aMid)midInSingle=true;
        	    else midInSingle=false;
        	}
        	else
        	{
        		int bMid = multiNum[(multiEnd+multiStart)/2];
        		totalMid = min(aMid,bMid);
        		if(totalMid==aMid)midInSingle=true;
        	    else midInSingle=false;
        	}
        	if(odd)
        	{
        		return totalMid; 
        	}
        	else
        	{
        		if(midInSingle)
        		{
        			if((singleStart+1)<singleNum.length)
        			{
        				return ((double)totalMid+min(singleNum[singleStart+1],multiNum[(multiEnd-multiStart)/2+1]))/2;
        			}
        			
        			else
        			{
        				return ((double)totalMid+multiNum[(multiEnd+multiStart)/2+1])/2;
        			}
        		}
        		else
        		{
        			if((multiEnd+multiStart)/2+2<multiNum.length)
        			{
        				return ((double)totalMid+min(multiNum[(multiEnd+multiStart)/2+2],singleNum[singleStart]))/2;
        			}
        			else
        			{
        				return ((double)totalMid+singleNum[singleStart])/2;
        			}
        			
        		}
        	}
        }
		
		int aMid = (start1+end1)/2;
		int bMid = (start2+end2)/2;
		
		if(nums1[aMid]<nums2[bMid])
		{
			return findMedianSortedArrays(nums1,nums2,aMid,end1,start2,bMid);
		}
		else 
		{
			return findMedianSortedArrays(nums1,nums2,start1,aMid,bMid,end2);
		}
		
		
		
    }
	public double findMedianSortedArrays(int arrays[])
	{
		if(arrays.length%2 == 0)
		{
			return ((double)arrays[arrays.length/2-1]+arrays[arrays.length/2])/2;
		}
		else
		{
			return arrays[arrays.length/2];
		}
	}
	
	public int middle(int a,int b,int c)
	{
		if(a>b)
		{
			if(a>c)return b>c?b:c;
			else return a;
		}
		else
		{
			if(b>c)return a>c?a:c;
			else return b;
		}
	}
	
	public int max(int a,int b)
	{
		return a>b?a:b;
	}
	public int min(int a,int b)
	{
		return a<b?a:b;
	}
	public static void main(String args[])
	{
		Solution s = new Solution();
		int nums1[] = {1,2};
		int nums2[] = {1,2,3};
		System.out.println(s.findMedianSortedArrays(nums1, nums2));
	}
}
