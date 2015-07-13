package maximumProductSubarray;

public class Solution {

	public int maxProduct(int[] nums) {
        if(nums==null)return -1;
        
        int length = nums.length;
        int maxNum = nums[0],minNum = nums[0];
        int maxProd = maxNum;
        int tmp1,tmp2;
        for(int i=1;i<length;i++)
        {
        	tmp1 = maxNum*nums[i];
        	tmp2 = minNum*nums[i];
        	
        	maxNum = max(max(tmp1,tmp2),nums[i]);
        	minNum = min(min(tmp1,tmp2),nums[i]);
        	
        	maxProd = max(maxProd,maxNum);
        }
        return maxProd;
        
    }
	
	public int max(int a,int b)
	{
		return a>b?a:b;
	}
	public int min(int a,int b)
	{
		return a<b?a:b;
	}
	public static void main(String[] args) {
		int nums[] = {2,3,-2,4};
		Solution s = new Solution();
		System.out.println(s.maxProduct(nums));

	}

}
