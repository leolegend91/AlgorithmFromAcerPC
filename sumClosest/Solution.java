package sumClosest;

import java.util.Arrays;

public class Solution {

	public int threeSumClosest(int[] nums, int target) {
        
		Arrays.sort(nums);
        int length = nums.length;
        
        int pHead = length-1,pMiddle = 1,pTail = 0;
        int curClosest=nums[pHead]+nums[pMiddle]+nums[pTail];
        int minDistance = Math.abs(curClosest-target);
        int curSum,curDistance;
        while(pTail<length-2)
        {
        	while(pMiddle<pHead)
        	{
        		curSum = nums[pHead]+nums[pMiddle]+nums[pTail];
        		curDistance = Math.abs(curSum-target);
        		if(curDistance == 0)return target;
        		if(curDistance<minDistance)
        		{
        			minDistance = curDistance;
        			curClosest = curSum;
        		}
        		if(curSum>target)
        		{
        			pHead--;
        		}
        		else
        		{
        			pMiddle++;
        		}
        	}
        	pTail++;
        	pMiddle = pTail+1;
        	pHead = length-1;
        }
        return curClosest;
        
    }
	public static void main(String[] args) {
		int nums[] = {0,2,1,-3};
		int target = 1;
		Solution s = new Solution();
		System.out.println(s.threeSumClosest(nums, target));

	}

}
