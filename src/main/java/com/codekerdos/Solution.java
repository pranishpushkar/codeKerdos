package com.codekerdos;

import java.util.HashSet;
import java.util.Set;

class Solution{

	public int longestConsecutive(int[] nums){

		Set<Integer> set = new HashSet<>();
		for(int num : nums){
			set.add(num);

		}
		int answer =0;

		for(int number : set){
			if(!set.contains(number-1)){

				int current = number;
				int currentLength = 1;
				while(set.contains(current+1)){
					current++;
					currentLength++;
				}
				
				answer = Math.max(answer,currentLength);
			}

			
		}
        return answer;

    }

}
