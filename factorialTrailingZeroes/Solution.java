package factorialTrailingZeroes;
//������������n�Ľ׳ˣ�����ĩβ0�ĸ���
public class Solution {

	public int trailingZeroes(int n) {
        int result = 0;
        //ÿһ��ѭ�����Ǽ���n���ж��ٸ�5/25/125...Ҫע��tempԽ������
        for(long temp=5;;temp=temp*5)
        {
        	result += n/temp;
        	if(temp>n/2)
        	{
        		break;
        	}
        }
        return result;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		System.out.println(s.trailingZeroes(10));

	}

}
