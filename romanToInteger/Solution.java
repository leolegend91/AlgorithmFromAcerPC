package romanToInteger;

public class Solution {

	public int romanToInt(String s) {
        char s2char[] = s.toCharArray();
        //用一个缓冲存储前一个
        int tempInt=charToNum(s2char[0]);
        int result = tempInt;
        //从第二个字符开始判断
        for(int i=1;i<s2char.length;i++)
        {
        	//如果前一个字符小于当前字符，则在结果中加上当前字符，并减去前一个字符的两倍
    		//减两倍的原因是，前一个字符已经被加到结果中，需要把它减掉，还要按照计数规则再减一次
        	if(tempInt<charToNum(s2char[i]))
        	{
        		
        		result = result+charToNum(s2char[i])-2*tempInt;
        	}
        	//如果前一个字符不小于当前字符，则直接在结果中加上当前字符
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
