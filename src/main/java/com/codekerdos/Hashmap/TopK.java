package com.codekerdos.Hashmap;

import java.util.*;

public class TopK {

    public int[] topKFrequent(int[] nums, int k){

        Map<Integer,Integer> frequencyMap = new HashMap<>();

        for(int num : nums){

            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
            
        }

        List<Integer>[] bucket = new List[nums.length+1];
        int index=0;
        int[] ans = new int[k];

        for(int temp : frequencyMap.keySet()){

            int frequency = frequencyMap.get(temp);

            if (bucket[frequency] == null) {
                bucket[frequency] = new ArrayList<>();
            }
            bucket[frequencyMap.get(temp)].add(temp);
        }

        

        for(int i=nums.length; i>=0 && index<k; i--){
            if(bucket[i]!=null){

                for(int j : bucket[i]){

                    if(index==k){
                        break;
                    }
                    ans[index] = j;
                    index++;

                }

            }
        }

        return ans;


    }

}
