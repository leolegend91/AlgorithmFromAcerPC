package threeSum;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Solution {

	List<List<Integer>> list = new LinkedList<List<Integer>>();
	public List<List<Integer>> threeSum(int[] nums) {
        if(nums==null || nums.length<3)return list;
		Arrays.sort(nums);
		int pre=nums[nums.length-1]+1;
        int first,second,third;
        for(int i=0;i<nums.length-2;i++)
        {
        	first=i;
        	if(nums[first]==pre)continue;
        	second = i+1;
        	third = nums.length-1;
        	int sum = 0-nums[first];
        	
        	while(second < third)
        	{
        		int tmp = nums[second]+nums[third];
        		if(tmp<sum)second++;
        		else if(tmp>sum)third--;
        		else
        		{
        			LinkedList<Integer> tmpList = new LinkedList<Integer>();
        			tmpList.add(nums[first]);
        			tmpList.add(nums[second]);
        			tmpList.add(nums[third]);
        			list.add(tmpList);
        			int tmpSecond = nums[second];
        			second++;
        			while(second<third && nums[second]==tmpSecond)
        			{
        				++second;
        			}
        		}
        	}
        	pre=nums[first];
        }
        return list;
    }
	
	
	
	public static void main(String[] args) {
		Solution s = new Solution();
		int nums[] = {-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6};
		List<List<Integer>> list = s.threeSum(nums);
		Iterator<List<Integer>> iter = list.iterator();
		while(iter.hasNext())
		{
			List<Integer> tmpList = iter.next();
			Iterator<Integer> tmpIter = tmpList.iterator();
			while(tmpIter.hasNext())
			{
				System.out.print(tmpIter.next());
				System.out.print(" ");
			}
			System.out.println();
		}

	}

}
