package Arrays;

public class RotatedSortedArraySearch {

/*
Problem Description
Given a sorted array of integers A of size N and an integer B.

array A is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2 ).

You are given a target value B to search. If found in the array, return its index otherwise, return -1.

You may assume no duplicate exists in the array.

NOTE: Users are expected to solve this in O(log(N)) time.



Problem Constraints
1 <= N <= 1000000

1 <= A[i] <= 10^9

all elements in A are distinct.



Input Format
The first argument given is the integer array A.

The second argument given is the integer B.



Output Format
Return index of B in array A, otherwise return -1



Example Input
Input 1:

A = [4, 5, 6, 7, 0, 1, 2, 3]
B = 4
Input 2:

A = [1]
B = 1


Example Output
Output 1:

 0
Output 2:

 0


Example Explanation
Explanation 1:


Target 4 is found at index 0 in A.
Explanation 2:


Target 1 is found at index 0 in A.

*/

    public static void main(String[] args) {
        System.out.println(search(new int[] {1}, 1));
    }

    public static int search(final int[] A, int B) {
        int pivot = 0;
        while(pivot<A.length-1) {
            if(A[pivot]>A[pivot+1])
                break;
            pivot++;
        }
        int resp = binarySearch(A,0,pivot, B);
        return resp == -1 ? binarySearch(A,pivot+1,A.length-1, B) : resp;
    }

    public static int binarySearch(int[] nums, int low, int high, int target) {

        while (low <= high) {
            int mid = (low + high) / 2;
            if (target < nums[mid]) high = mid - 1; // target is on the left side
            else if (target > nums[mid]) low = mid + 1; // target is on the right side
            else return mid;
        }

        return -1;
    }
}
