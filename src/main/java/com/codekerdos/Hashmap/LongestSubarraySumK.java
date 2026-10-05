package com.codekerdos.Hashmap;

import java.util.*;

public class LongestSubarraySumK {

    public int findLength(int[] nums, int k){

        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,-1);
        int currentSum = 0;

        for(int i=0; i<nums.length; i++){
            currentSum+=nums[i];

            if(map.containsKey(currentSum-k)){
                int currentLength = i - map.get(currentSum-k);
                answer = Math.max(answer,currentLength);
            }

            if(!map.containsKey(currentSum)){
                map.put(currentSum, i);
            }

        }

        return answer;
    }

}
