package Arrays;

import java.util.Arrays;

public class PlusOne {

/*
Plus One

You are given a large integer represented as an integer array digits, where each digits[i] is the ith digit of the integer. The digits are ordered from most significant to least significant in left-to-right order. The large integer does not contain any leading 0's.

Increment the large integer by one and return the resulting array of digits.



Example 1:

Input: digits = [1,2,3]
Output: [1,2,4]
Explanation: The array represents the integer 123.
Incrementing by one gives 123 + 1 = 124.
Thus, the result should be [1,2,4].
Example 2:

Input: digits = [4,3,2,1]
Output: [4,3,2,2]
Explanation: The array represents the integer 4321.
Incrementing by one gives 4321 + 1 = 4322.
Thus, the result should be [4,3,2,2].
Example 3:

Input: digits = [9]
Output: [1,0]
Explanation: The array represents the integer 9.
Incrementing by one gives 9 + 1 = 10.
Thus, the result should be [1,0].


Constraints:

1 <= digits.length <= 100
0 <= digits[i] <= 9
digits does not contain any leading 0's.


*/

    public static void main(String[] args) {
        System.out.println(Arrays.toString(plusOne(new int[] {9,9,9})));
    }

    //Brute Force Approach
    public static int[] plusOne(int[] digits) {
        int carry = 1;
        int i = digits.length-1;
        while(i>=0 && carry !=0) {
            int val = digits[i]+1;
            digits[i] = val%10;
            carry  = val/10;
            i--;
        }

        if(carry!=0) { //Size would only increase in case of 9, 99, 999 and so on..
            int[] arr = new int[digits.length+1];
            arr[0] = 1; // Setting first digit to one as default other int values will be zero
            return arr;
        }
        return digits;
    }

    //More Optimized
    public static int[] plusOne1(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }

        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }
}
