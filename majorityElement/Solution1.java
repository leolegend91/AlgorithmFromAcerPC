package majorityElement;

import java.util.Arrays;

public class Solution1 {

	public int majorityElement(int[] num) {
		Arrays.sort(num);
		return num[num.length/2];
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int test[]={1,2,3,4,5,5,5,5,5,5,5,5,5};
		Solution1 s = new Solution1();
		System.out.println(s.majorityElement(test));
	}

}
