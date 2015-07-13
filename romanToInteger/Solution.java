package romanToInteger;

public class Solution {

	public int romanToInt(String s) {
        char s2char[] = s.toCharArray();
        //��һ������洢ǰһ��
        int tempInt=charToNum(s2char[0]);
        int result = tempInt;
        //�ӵڶ����ַ���ʼ�ж�
        for(int i=1;i<s2char.length;i++)
        {
        	//���ǰһ���ַ�С�ڵ�ǰ�ַ������ڽ���м��ϵ�ǰ�ַ�������ȥǰһ���ַ�������
    		//��������ԭ���ǣ�ǰһ���ַ��Ѿ����ӵ�����У���Ҫ������������Ҫ���ռ��������ټ�һ��
        	if(tempInt<charToNum(s2char[i]))
        	{
        		
        		result = result+charToNum(s2char[i])-2*tempInt;
        	}
        	//���ǰһ���ַ���С�ڵ�ǰ�ַ�����ֱ���ڽ���м��ϵ�ǰ�ַ�
        	else
        	{
        		result+=charToNum(s2char[i]);
        	}
        	
        	tempInt = charToNum(s2char[i]);
        }
        return result;
    }
	
	public int charToNum(char input)
	{
		switch(input)
		{
		case 'I':return 1;
		case 'V':return 5;
		case 'X':return 10;
		case 'L':return 50;
		case 'C':return 100;
		case 'D':return 500;
		case 'M':return 1000;
		default:return 0;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Solution s = new Solution();
		System.out.println(s.romanToInt("DCXXI"));
	}

}
