package Sorting;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solve(new int[] {3, 7, 1})));
    }
    public static int[] solve(int[] A) {
        quickSort(A,0, A.length-1);
        return A;
    }

    public static void quickSort(int[] arr, int l, int r) {
        if(l>=r)
            return;
        int idx = rearrange(arr,l,r);
        quickSort(arr,l, idx-1);
        quickSort(arr,idx+1,r);
    }

    public static int rearrange(int[] arr, int l, int r){
        int p1=l+1;
        int p2=r;

        while(p1<=p2){
            if(arr[p1]<=arr[l]) {
                p1++;
            }
            else if(arr[p2]>arr[l]) {
                p2--;
            }
            else {
                int tmp = arr[p1];
                arr[p1] = arr[p2];
                arr[p2] = tmp;
                p1++;
                p2--;
            }
        }
        int tmp = arr[l];
        arr[l] = arr[p2];
        arr[p2] = tmp;
        return p2;
    }

}
