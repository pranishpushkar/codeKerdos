package com.codekerdos.twopointers;

public class Trap {

    public int trap(int[] heights){

        int totalWater =0;
        int left = 0;
        int right = heights.length -1;
        int leftMax =0;
        int rightMax =0;
        
        while(left < right){
            if(heights[left] <= heights[right]){
                if(heights[left]>leftMax){
                    leftMax = heights[left];
                }else{
                    totalWater += leftMax - heights[left];
                }
                left++;

            }else{
                if(heights[right] > rightMax){
                    rightMax = heights[right];
                }else{
                    totalWater += rightMax - heights[right];
                }
                right--;

            }
        }


        return totalWater;
    }

}
