package Hashing;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

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
		int[] arr = new int[] {1,2,-2,4,-4 };
		ArrayList<Integer> A = new ArrayList<Integer>();
		for (int value : arr) {
		    A.add(value);
		}
		
		System.out.println(lszero(A));
	}
	
	public static ArrayList<Integer> pfSumArray(ArrayList<Integer> A){
        ArrayList<Integer> answer = new ArrayList<Integer>();
        answer.add(A.get(0));
        for(int i = 1 ; i < A.size() ;i++){
            answer.add(answer.get(i-1)  + A.get(i));
        }
        return answer;
    }	
    public static ArrayList<Integer> lszero(ArrayList<Integer> A) {
        ArrayList<Integer> pfSumArray = pfSumArray(A);
        ArrayList<Integer> answer = new ArrayList<Integer>();
        LinkedHashMap<Integer,ArrayList<Integer>> freqMap = new LinkedHashMap<Integer, ArrayList<Integer>>();
         for(int i = 0 ; i < pfSumArray.size() ;i++){
             if(freqMap.containsKey(pfSumArray.get(i))){
                 ArrayList<Integer> temp = freqMap.get(pfSumArray.get(i));
                 temp.add(i);
                 freqMap.put(pfSumArray.get(i),temp);
             }else{
                 ArrayList<Integer> temp = new ArrayList<Integer>();
                 temp.add(i);
                 freqMap.put(pfSumArray.get(i),temp);
             }
         }
        int maxLength = -1;
        for(Map.Entry<Integer,ArrayList<Integer>> entrySet : freqMap.entrySet()){
            ArrayList<Integer> current = entrySet.getValue();
            if(entrySet.getKey() == 0){
                int currentLength = current.get(current.size()-1)+1;
                if(maxLength < currentLength){
                    maxLength = currentLength;
                    answer.clear();
                    answer.addAll(A.subList(0,current.get(current.size()-1)+1));
                }
            }else if(current.size()>1){
                int start = current.get(0);
                int end = current.get(current.size()-1);
                int currentLength = end - start;
                if(currentLength > maxLength){
                    maxLength = currentLength;
                    answer.clear();
                    answer.addAll(A.subList(start+1,end+1));
                }
            }
            
        }
        return answer;
    }
}
