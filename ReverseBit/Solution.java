package ReverseBit;

public class Solution {
	// you need treat n as an unsigned value
	int bit[] = new int[32];
    public int reverseBits_v1(int n) {
    	if(n==0)
    	{
    		return 0;
    	}
    	    		
    	for(int i=31;i>-1 && n!=0;i--)
        {
        	bit[i]=n%2;
        	n>>>=1;
        	
        }
    	
//    	for(int i =0;i<32;i++)
//    	{
//    		System.out.print(bit[i]);
//    	}
//    	System.out.println();
//    	
    	//�����ƴ洢��������ʼʵ�ַ�ת����
    		int result=0;
    		int flag=1;
    		for(int j=0;j<32;j++)
    		{
    			result=result+flag*bit[j];
    			flag=flag<<1;//2��j�η�
    		}
    		return result;
        
    }

    public int reverseBits(int n) {
        int temp = n;
    	for(int i=0;i<16;i++)
        {
    		System.out.println(Integer.toBinaryString(temp));
        	temp = this.swapBit(temp, i, i);        	
        }
    	return temp;
    	
    }
    
    public int swapBit(int n,int start,int end)
    {
    	//Ϊ0��Ϊtrue
    	boolean startBit = ((n&(Integer.MIN_VALUE>>>start))==0);
    	boolean endBit = ((n&(1<<end))==0);
    	
    	//��β��λ������0����0
    	if(startBit==endBit)
    		return n;
    	//��λΪ0
    	else if(startBit)
    	{
    		n|=(Integer.MIN_VALUE>>>start);//����λ��1
    		n&=((-2)<<end);//��βλ��0
    	}
    	//βλΪ0
    	else
    	{
    		n&=(Integer.MAX_VALUE>>>start);//����λ��0
    		n|=(1<<end);//��βλ��1
    	}
    	return n;
    	
    }
}
