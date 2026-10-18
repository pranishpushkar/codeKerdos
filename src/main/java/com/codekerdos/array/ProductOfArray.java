package com.codekerdos.array;

import java.util.*;

public class ProductOfArray {

    public int[] productExceptSelf(int[] nums){

        int leftProduct=1;
        int rightProduct=1;

        int[] ans = new int[nums.length];

        for(int i=0; i<nums.length; i++){
            ans[i] = leftProduct;
            leftProduct *= nums[i];
        }

        for(int j=nums.length-1; j>=0; j--){
            ans[j] *= rightProduct;
            rightProduct *= nums[j];
        }

        return ans;


    }

}
