package com.codekerdos.recursion;

public class QuickSort {

    public static void sort(int[] arr, int left, int right){

        if(left>=right){
            return;
        }
        int pivotIndex = partition(arr,left,right);

        sort(arr,left,pivotIndex-1);
        sort(arr,pivotIndex+1,right);

    }

    private static int partition(int[] arr, int left, int right){
        int pivot = arr[right];
        int count =0;

        for(int i = left; i < right; i++){
            if(arr[i]<=pivot){
                count++;

            }
        }
        int pivotIndex = left+count;
        swap(arr,pivotIndex,right);

        int leftPointer = left;
        int rightPointer = right;

        while (leftPointer < pivotIndex &&
                rightPointer > pivotIndex) {

            while (leftPointer < pivotIndex &&
                    arr[leftPointer] <= pivot) {
                leftPointer++;
            }

            while (rightPointer > pivotIndex &&
                    arr[rightPointer] > pivot) {
                rightPointer--;
            }

            if (leftPointer < pivotIndex &&
                    rightPointer > pivotIndex) {
                swap(arr, leftPointer, rightPointer);
            }
        }

        return pivotIndex;
    }

    private static void swap(int[] arr,int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

}
