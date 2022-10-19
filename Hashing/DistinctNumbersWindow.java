package Hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Arrays;
/*
Problem Description
You are given an array of N integers, A1, A2 ,..., AN and an integer B. Return the of count of distinct numbers in all windows of size B.

Formally, return an array of size N-B+1 where i'th element in this array contains number of distinct elements in sequence Ai, Ai+1 ,..., Ai+B-1.

NOTE: if B > N, return an empty array.



Input Format
First argument is an integer array A
Second argument is an integer B.



Output Format
Return an integer array.



Example Input
Input 1:

 A = [1, 2, 1, 3, 4, 3]
 B = 3
Input 2:

 A = [1, 1, 2, 2]
 B = 1


Example Output
Output 1:

 [2, 3, 3, 2]
Output 2:

 [1, 1, 1, 1]


Example Explanation
Explanation 1:

 A=[1, 2, 1, 3, 4, 3] and B = 3
 All windows of size B are
 [1, 2, 1]
 [2, 1, 3]
 [1, 3, 4]
 [3, 4, 3]
 So, we return an array [2, 3, 3, 2].
Explanation 2:

 Window size is 1, so the output array is [1, 1, 1, 1].

 */
public class DistinctNumbersWindow {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(dNums(new int[] {1, 2, 1, 3, 4, 3},3)));
    }

    public static int[] dNums(int[] A, int B) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < B; i++) {
            if(map.containsKey(A[i])) {
                map.put(A[i], map.get(A[i])+1);
            } else {
                map.put(A[i], 1);
            }
        }
        List<Integer> list = new ArrayList<>();
        list.add(map.size());
        for (int i = 1; i <= A.length-B; i++) {
            int e=i+B-1;
            //Remove
            map.put(A[i-1],map.get(A[i-1])-1);
            if(map.get(A[i-1]) == 0) {
                map.remove(A[i-1]);
            }
            //Add
            if(map.containsKey(A[e])) {
                map.put(A[e], map.get(A[e])+1);
            } else {
                map.put(A[e], 1);
            }
            list.add(map.size());
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
