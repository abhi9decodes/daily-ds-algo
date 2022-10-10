package Arrays;
/*
Problem Description
You're given a read-only array of N integers. Find out if any integer occurs more than N/3 times in the array in linear time and constant additional space.
If so, return the integer. If not, return -1.

If there are multiple solutions, return any one.



Problem Constraints
1 <= N <= 7*105
1 <= A[i] <= 109


Input Format
The only argument is an integer array A.


Output Format
Return an integer.


Example Input
[1 2 3 1 1]


Example Output
1


Example Explanation
1 occurs 3 times which is more than 5/3 times.
 
 */
public class Moores {
	public static void main(String[] args) {
		System.out.println(repeatedNumber(new int[] {1,2,3,1,1}));
	}
	
	public static int repeatedNumber(int[] A) {
	      int num1 =-1;
	      int num2=-1;
	      int c1=0;
	      int c2=0;

	      for(int i : A) {
	          if(i==num1) {
	              c1++;
	          }
	          else if(i==num2) {
	        	  c2++;
	          }
	          else if(c1==0) {
	        	  num1=i;
	        	  c1=1;
	          }
	          else if(c2==0) {
	        	  num2=i;
	        	  c2=1;
	          } 
	          else {
	        	c1--;
	        	c2--;
	          }
	      }
	      
	      c1=0;
	      c2=0;
	      for(int i: A) {
	    	  if(i==num1) {
	              c1++;
	          }
	          else if(i==num2) {
	        	  c2++;
	          }
	    	  if(c1>(A.length/3)) {
	    		  return num1;
	    	  }
	    	  if(c2>(A.length/3)) {
	    		  return num2;
	    	  }
	      }
	      return -1;

	    }

}
