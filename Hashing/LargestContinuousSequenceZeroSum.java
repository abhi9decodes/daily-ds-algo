package Hashing;

import java.util.HashMap;
import java.util.Arrays;

/*
Problem Description
Given an array A of N integers.

Find the largest continuous sequence in a array which sums to zero.



Problem Constraints
1 <= N <= 106

-107 <= A[i] <= 107



Input Format
Single argument which is an integer array A.



Output Format
Return an array denoting the longest continuous sequence with total sum of zero.

NOTE : If there are multiple correct answers, return the sequence which occurs first in the array.



Example Input
A = [1,2,-2,4,-4]


Example Output
[2,-2,4,-4]


Example Explanation
[2,-2,4,-4] is the longest sequence with total sum of zero.

 */
public class LargestContinuousSequenceZeroSum {
	
	public static void main(String[] args) {
		System.out.println(Arrays.toString(lszero(new int[] {1,2,-2,4,-4})));
	}
	
	 public static int[] lszero(int[] A) {
		 HashMap<Integer,Integer> map =  new HashMap<Integer, Integer>();
		 int pf[]=new int[A.length];
		 pf[0]=A[0];
		 for(int i=1;i<A.length; i++) {
			 pf[i] =  A[i]+pf[i-1];
		 }
		 int maxLength=0;
		 int i1=-1;
		 int i2=-1;
		 for(int i=0;i<A.length; i++) {
			 if(map.containsKey(pf[i])) {
				 int length = i-map.get(pf[i]);
				 if(length > maxLength) {
					 maxLength = length;
					 i1=map.get(pf[i])+1;
					 i2=i;
				 }
			 } 
			 else if(pf[i]==0) {
				 int length = i;
				 if(length > maxLength) {
					 maxLength = length;
					 i1=0;
					 i2=i;
				 }
			 }
			 else {
				 map.put(pf[i], i);
			 }
		 }
		 
		 return Arrays.copyOfRange(A, i1, i2+1);
	 }
}
