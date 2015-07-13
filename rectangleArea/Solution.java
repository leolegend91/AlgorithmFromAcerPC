package rectangleArea;

public class Solution {

	public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int area1 = ((C-A)*(D-B));
        int area2 = ((G-E)*(H-F));
        if(A>G || E>C || F>D || B>H)
        {
        	return area1+area2;
        }
        else
        {
        	return area1+area2-commonArea(A,B,C,D,E,F,G,H);
        }
        
    }
	
	public int commonArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        return (min(C,G)-max(A,E))*(min(D,H)-max(B,F));
    }
	int min(int a,int b)
	{
		return a<b?a:b;
	}
	int max(int a,int b)
	{
		return a>b?a:b;
	}
	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.computeArea(0,0,0,0,-1,-1,1,1));

	}

}
