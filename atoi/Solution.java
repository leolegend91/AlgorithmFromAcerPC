package atoi;
//常规解法，时间复杂度较高
//后来把long型result改成int型试图提高运算效率，但始终不能通过所有测试用例，故放弃，但代码仍未改回来
public class Solution {

	public int atoi(String str) {
        if(str==null)
        {
        	return 0;
        }
        char str2char[] = str.toCharArray();
        int result = 0;//返回的结果
        int i=0;//当做指针
        boolean sign=true;//符号位，true表示正数，否则为负数
        //跳过空格，处理符号位；
        for(;i<str2char.length;i++)
        {
        	//如果前面的字符是空格，则跳过
        	if(str2char[i]==' ')
        	{
        		continue;
        	}
        	else
        	{
        		//如果符号位为+，则i加1，并跳出循环；
        		if(str2char[i]=='+')
        		{
        			i++;
        			break;
        		}
        		//如果符号位为-，则sign置为false，i加1，跳出循环
        		else if(str2char[i]=='-')
        		{
        			i++;
        			sign=!sign;
        			break;
        		}
        		//没有+或-号，跳出，等待后续处理
        		else
        		{
        			break;
        		}
        	}
        }
        //开始处理后面的数字
        for(;i<str2char.length;i++)
        {
        	//只有当字符位于0-9之间才做处理，否则跳出
        	if((str2char[i]+1>'0')&&(str2char[i]-1<'9'))
        	{
        		int oldresult = result;
        		result = 10*result+(str2char[i]-48);
        		//如果正数溢出，返回32位有符号数的最大值
        		if((sign)&&(result<oldresult))
        		{
        			return Integer.MAX_VALUE;
        		}
        		//如果负数溢出(此时含负数最小值)，返回32位有符号数的最小值
        		else if((!sign)&&(result<oldresult))
        		{
        			return Integer.MIN_VALUE;
        		}
        	}
        	else{
        		break;
        	}
        }
        if(sign)
        {
        	return result;
        }
        else
        {
        	return -result;
        }
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Solution s = new Solution();
		System.out.println(s.atoi("-2147483647"));
		
		//System.out.println((int)'0');
	}

}
