package com.codekerdos.graph;

import java.util.*;

public class AlienDictionary {

    public String alienOrder(String[] words){

        StringBuilder answer = new StringBuilder();
        Map<Character,Integer> indegree = new HashMap<>();
        Map<Character,List<Character>> graph = new HashMap<>();

        for(String word : words){
            for(Character c : word.toCharArray()){
                graph.putIfAbsent(c, new ArrayList<>());
                indegree.putIfAbsent(c, 0);

            }
        }

        for(int i=0; i<words.length-1; i++){
            String first = words[i];
            String second = words[i+1];

            int length = Math.min(first.length(), second.length());
            boolean foundDifference = false;


            for(int j=0; j<length; j++){
                if(first.charAt(j) != second.charAt(j)){
                    if(!graph.get(first.charAt(j)).contains(second.charAt(j))){
                        graph.get(first.charAt(j)).add(second.charAt(j));

                        indegree.put(second.charAt(j),indegree.get(second.charAt(j))+1);

                    }

                    foundDifference = true;
                    break;

                }
            }

            if(!foundDifference && (first.length() > second.length())){
                    return "";
                }

        }

        Queue<Character> queue = new ArrayDeque<>();

        for (char character : indegree.keySet()) {
            if (indegree.get(character) == 0) {
                queue.offer(character);
            }
        }

        while(!queue.isEmpty()){
            char current = queue.poll();
            answer.append(current);
            for(Character c : graph.get(current)){
                indegree.put(c,indegree.get(c) - 1);

                if (indegree.get(c) == 0) {
                    queue.offer(c);
                }
            }
        }

        if(answer.length()!=indegree.size()){
            return "";
        }


        return answer.toString();

    }

}
