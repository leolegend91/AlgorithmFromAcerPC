package atoi;
//����ⷨ��ʱ�临�ӶȽϸ�
//������long��result�ĳ�int����ͼ�������Ч�ʣ���ʼ�ղ���ͨ�����в����������ʷ�������������δ�Ļ���
public class Solution {

	public int atoi(String str) {
        if(str==null)
        {
        	return 0;
        }
        char str2char[] = str.toCharArray();
        int result = 0;//���صĽ��
        int i=0;//����ָ��
        boolean sign=true;//����λ��true��ʾ����������Ϊ����
        //�����ո񣬴������λ��
        for(;i<str2char.length;i++)
        {
        	//���ǰ����ַ��ǿո�������
        	if(str2char[i]==' ')
        	{
        		continue;
        	}
        	else
        	{
        		//�������λΪ+����i��1��������ѭ����
        		if(str2char[i]=='+')
        		{
        			i++;
        			break;
        		}
        		//�������λΪ-����sign��Ϊfalse��i��1������ѭ��
        		else if(str2char[i]=='-')
        		{
        			i++;
        			sign=!sign;
        			break;
        		}
        		//û��+��-�ţ��������ȴ���������
        		else
        		{
        			break;
        		}
        	}
        }
        //��ʼ������������
        for(;i<str2char.length;i++)
        {
        	//ֻ�е��ַ�λ��0-9֮�����������������
        	if((str2char[i]+1>'0')&&(str2char[i]-1<'9'))
        	{
        		int oldresult = result;
        		result = 10*result+(str2char[i]-48);
        		//����������������32λ�з����������ֵ
        		if((sign)&&(result<oldresult))
        		{
        			return Integer.MAX_VALUE;
        		}
        		//����������(��ʱ��������Сֵ)������32λ�з���������Сֵ
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
