package longestPalindromicSubstring;

public class Solution {

	public String longestPalindrome(String s) {
        if (s.length()<2)return s;
        StringBuilder sb = new StringBuilder();
        String str;
        int id=0,mx=0;//id和mx分别表示当前最长子串中心位置和边界位置
        int subLengthOfStr[];
        String result0;//带#的结果
        String result;//删除#后的结果
        //在s上插入#分隔符
        for(int i=0;i<s.length();i++)
        {
        	sb.append("#").append(s.charAt(i));
        }
        str = sb.append("#").toString();
        subLengthOfStr = new int[str.length()];
        
        for(int i=0;i<str.length();i++)
        {
        	subLengthOfStr[i] = mx>i?(min(subLengthOfStr[2*id-i],mx-i)):1;
        	
        	while(subLengthOfStr[i]<i && subLengthOfStr[i]<(str.length()-i))
        	{
        		if(str.charAt(i+subLengthOfStr[i]) == str.charAt(i-subLengthOfStr[i]))
        			subLengthOfStr[i]++;
        		else break;
        	}
        	
        	if(subLengthOfStr[i]>(mx-id))
        	{
        		id=i;
        		mx = i+subLengthOfStr[i];
        	}
        }
        result0 = str.substring(2*id-mx+1, mx);
        sb=new StringBuilder();
        for(int i=0;i<result0.length();i++)
        {
        	if(result0.charAt(i)!='#')
        		sb.append(result0.charAt(i));
        }
        result = sb.toString();
        return result;
        
    }
	
	public int min(int a,int b)
	{
		return a<b?a:b;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Solution s = new Solution();
		System.out.println(s.longestPalindrome("a"));
	}

}
