package validSudoku;

import java.util.HashSet;

public class Solution {

	public boolean isValidSudoku(char[][] board) {
		HashSet validSet = new HashSet<Character>();
		//�ж�ÿһ���Ƿ���Ч
		for(int i=0;i<9;i++)
		{
			for(int j=0;j<9;j++)
			{
				//�����ַ���hashset��
				if(board[j][i]!='.')
				{
					//����Ѿ����ظ����֣�ֱ�ӷ���false
					if(!validSet.add(board[j][i]))return false;
				}
					
			}
			validSet.clear();
		}
		//�ж�ÿһ���Ƿ���Ч
		for(int i=0;i<9;i++)
		{
			for(int j=0;j<9;j++)
			{
				//�����ַ���hashset��
				if(board[i][j]!='.')
				{
					//����Ѿ����ظ����֣�ֱ�ӷ���false
					if(!validSet.add(board[i][j]))return false;
				}
					
			}
			validSet.clear();
		}
        //�ж�ÿһ���Ź������Ƿ���Ч,i�����кţ�j�����к�
		for(int i=0;i<9;i+=3)
		{
			for(int j=0;j<9;j+=3)
			{
				//��ʼ����һ���Ź���				
				for(int k=0;k<3;k++)
				{
					for(int l=0;l<3;l++)
					{
						if(board[i+k][j+l]!='.')
						{
							if(!validSet.add(board[i+k][j+l]))
								return false;
						}
					}
				}
				//һ�α������������hashset
				validSet.clear();
			}
		}
		return true;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
