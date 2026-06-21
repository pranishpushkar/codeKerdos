package com.codekerdos.recursion;

public class MergeSortArrays {

    public static int[] mergeSort(int[] arr){

        if(arr == null || arr.length==0){
            return arr;
        }


        return helper(arr,0,arr.length-1);
    }

    private static int[] helper(int[] arr, int left, int right){

        if(left == right){
            int[] newArr = {arr[left]};
            return newArr;
        }

        int mid = left + (right-left)/2;

        int[] leftArray = helper(arr, left, mid);
        int[] rightArray = helper(arr, mid+1, right);

        return merge(leftArray,rightArray);

    }

    private static int[] merge(int[] arr1, int[] arr2){

        int[] arr = new int[arr1.length+arr2.length];
        int p = 0;
        int p1 = 0;
        int p2 = 0;

        while(p1<arr1.length && p2<arr2.length){
            if(arr1[p1]<=arr2[p2]){
                arr[p] = arr1[p1];

                p1++;
                p++;
            }else{
                arr[p] = arr2[p2];
                p++;
                p2++;
            }
        }
        while(p1<arr1.length){
            arr[p] = arr1[p1];
            p++;
            p1++;
        }
        while(p2<arr2.length){
            arr[p] = arr2[p2];
            p++;
            p2++;
        }

        return arr;
    }



}
