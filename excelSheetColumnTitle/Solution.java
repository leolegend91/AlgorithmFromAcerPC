package excelSheetColumnTitle;

public class Solution {

	public String convertToTitle(int n) {
        StringBuilder myBuilder = new StringBuilder();
        //���벻���Ϲ淶������null
        if(n<1)
        {
        	return null;
        }
        //�洢���֣���0��ʼ����
        int temp = n;

        while(true)
        {
        	//��������
        	myBuilder.append((char)((temp-1)%26+65));
        	//��ǰ��λ
        	temp=(temp-1)/26;
        	//��temp�ﵽ0ʱ����ѭ��
        	if(temp==0)
        	{
        		break;
        	}
        	
        }
        //��myBuilder��ת���õ���ȷ���
        myBuilder.reverse();
        return myBuilder.toString();
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println((int)'A');

		Solution s = new Solution();
		System.out.println(s.convertToTitle(676+25));
	}

}
