package Hashing;

import java.util.HashMap;

/*

Problem Description
Given an array of N integers as A, find and return whether the given array contains a non-empty subarray with a sum equal to 0.

If the given array contains a sub-array with sum zero return 1, else return 0.



Problem Constraints
1 <= N <= 100000

-10^9 <= A[i] <= 10^9



Input Format
The only argument given is the integer array A.



Output Format
Return whether the given array contains a subarray with a sum equal to 0.



Example Input
Input 1:

 A = [1, 2, 3, 4, 5]
Input 2:

 A = [-1, 1]


Example Output
Output 1:

 0
Output 2:

 1


Example Explanation
Explanation 1:

 No subarray has sum 0.
Explanation 2:

 The array has sum 0.


 */

public class SubArrayWithZeroSum {
	public static void main(String[] args) {
		System.out.println((solve(new int[] {1,2,-2,4,-4})));
	}
	
	 public static int solve(int[] A) {
		 HashMap<Double,Integer> map =  new HashMap<Double, Integer>();
		 double pf[]=new double[A.length];
		 pf[0]=A[0];
		 for(int i=1;i<A.length; i++) {
			 pf[i] =  A[i]+pf[i-1];
		 }

		 for(int i=0;i<A.length; i++) {
			 if(map.containsKey(pf[i])) {
				 return 1;
			 } 
			 else if(pf[i]==0) {
				 return 1;
			 }
			 else {
				 map.put(pf[i], i);
			 }
		 }
		 
		 return 0;
	 }

}
