package numberOfOneBits;

public class main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int n=2147483647+1;//2^31-1
		Solution s1 = new Solution();
		System.out.println(n);
		System.out.println(s1.hammingWeight(n));
		
		int i=-2;
		i=i>>1;
		System.out.println(i);
		
		System.out.println(2147483647+1+Integer.MAX_VALUE+1);
		StringBuilder myBuilder = new StringBuilder();
		StringBuffer myBuffer = new StringBuffer();
		String myString = new String();
	}

}
