package validSudoku;

import java.util.HashSet;

public class Solution {

	public boolean isValidSudoku(char[][] board) {
		HashSet validSet = new HashSet<Character>();
		//判断每一行是否有效
		for(int i=0;i<9;i++)
		{
			for(int j=0;j<9;j++)
			{
				//把数字放入hashset中
				if(board[j][i]!='.')
				{
					//如果已经有重复数字，直接返回false
					if(!validSet.add(board[j][i]))return false;
				}
					
			}
			validSet.clear();
		}
		//判断每一列是否有效
		for(int i=0;i<9;i++)
		{
			for(int j=0;j<9;j++)
			{
				//把数字放入hashset中
				if(board[i][j]!='.')
				{
					//如果已经有重复数字，直接返回false
					if(!validSet.add(board[i][j]))return false;
				}
					
			}
			validSet.clear();
		}
        //判断每一个九宫格内是否有效,i代表行号，j代表列号
		for(int i=0;i<9;i+=3)
		{
			for(int j=0;j<9;j+=3)
			{
				//开始遍历一个九宫格				
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
				//一次遍历结束，清空hashset
				validSet.clear();
			}
		}
		return true;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
