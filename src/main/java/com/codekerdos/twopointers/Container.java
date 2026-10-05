package com.codekerdos.twopointers;

public class Container {

    public int maxArea(int[] heights){

        int maxArea = 0;
        int left = 0;
        int right = heights.length-1;

        while(left < right){
            int currentArea = (right - left)* Math.min(heights[left],heights[right]);

            maxArea = Math.max(maxArea, currentArea);

            if(heights[left]<heights[right]){
                left++;
            }else{
                right--;
            }
        }

        return maxArea;
    }
}
