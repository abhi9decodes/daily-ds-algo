package Sorting;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
 
Problem Description
Given an array A of non-negative integers, arrange them such that they form the largest number.

Note: The result may be very large, so you need to return a string instead of an integer.



Problem Constraints
1 <= len(A) <= 100000
0 <= A[i] <= 2*109



Input Format
The first argument is an array of integers.



Output Format
Return a string representing the largest number.



Example Input
Input 1:

 A = [3, 30, 34, 5, 9]
Input 2:

 A = [2, 3, 9, 0]


Example Output
Output 1:

 "9534330"
Output 2:

 "9320"


Example Explanation
Explanation 1:

Reorder the numbers to [9, 5, 34, 3, 30] to form the largest number.
Explanation 2:

Reorder the numbers to [9, 3, 2, 0] to form the largest number 9320.


*/
public class FormLargestNumber {

	public static void main(String[] args) {
		
		System.out.println(largestNumber(Arrays.asList( 0, 0, 0, 0)));

	}
	
	public static String largestNumber(final List<Integer> A) {
	        Collections.sort(A, new Comparator<Integer>() {
				@Override
				public int compare(Integer A, Integer B) {
					String s1=Integer.toString(A)+Integer.toString(B);
			        String s2=Integer.toString(B)+Integer.toString(A);
			        if(Long.valueOf(s1)<Long.valueOf(s2))
			        {
			            return 1;
			        }
			        return -1;
				}
	        });

	        StringBuffer sb=new StringBuffer();
	        for(int i=0;i<A.size();i++)
	        {
	            sb.append(Integer.toString(A.get(i)));
	        }
	        String s=sb.toString();
	        if(s.charAt(0)=='0')
	        {
	            return "0";
	        }
	        return s;
	}

}
