package ModularArithmetic;

public class PairSum {

/*

Problem Description
Given an array of integers A and an integer B, find and return the number of pairs in A whose sum is divisible by B.

Since the answer may be large, return the answer modulo (109 + 7).



Problem Constraints
1 <= length of the array <= 100000
1 <= A[i] <= 109
1 <= B <= 106



Input Format
The first argument given is the integer array A.
The second argument given is the integer B.



Output Format
Return the total number of pairs for which the sum is divisible by B modulo (109 + 7).



Example Input
Input 1:

 A = [1, 2, 3, 4, 5]
 B = 2
Input 2:

 A = [5, 17, 100, 11]
 B = 28


Example Output
Output 1:

 4
Output 2:

 1


Example Explanation
Explanation 1:

 All pairs which are divisible by 2 are (1,3), (1,5), (2,4), (3,5). 
 So total 4 pairs.
 
*/
	
	public static void main(String[] args) {
		System.out.println(solve(new int[] {1, 2, 3, 4, 5}, 2));
	}
	
	public static int solve(int[] A, int B) {
        long count[]= new long[B];
        for(int i: A) {
        	count[i%B]++;
        }
        int modulus = 1000000007;
        long ans = (count[0] * (count[0]-1)) /2;
        int i=1, j=B-1;
        while(i<=j) {
        	if(i==j) {
        		ans+=(count[i]*(count[j]-1))/2;
        	}
        	else {
        		ans+= count[i] * count[j];
        	}
        	i++;
        	j--;
        }
        return (int)(ans%modulus);
    }
	
	
}
