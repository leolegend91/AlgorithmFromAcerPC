package numberOfOneBits;

public class Solution {
	// you need to treat n as an unsigned value
    public int hammingWeight(int n) {
    	if(n==0)return 0;
    	int count=1;//因为除以2最后一定会剩下1，1除以2等于0跳出循环，但余数还是要加上一个1
    	if(n<0)
    	{
    		n=n+Integer.MAX_VALUE+1;
    		if(n==0)
    		{
    			return count;
    		}
    		else{
    			count++;
    		}
    		
    	}
    	
    	while(n/2 != 0)
    	{
    		if(n%2 == 0){
    			n=n/2;
    			continue;
    		}
    		else 
    		{
    			n=n/2;
    			count++;
    		}
    	}
        return count;
    }

}
