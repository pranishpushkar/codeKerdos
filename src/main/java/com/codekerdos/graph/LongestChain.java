package com.codekerdos.graph;

import java.util.*;

public class LongestChain {

    public int findLongest(String[] strings){

        String[] first = new String[strings.length];
        String[] last = new String[strings.length];
        
        for(int i=0; i<strings.length; i++){
            String[] words = strings[i].trim().split("\\s+");
            first[i] = words[0];
            last[i] = words[words.length-1];
        }

        List<Integer>[] graph = new ArrayList[strings.length];

        for(int i=0; i<strings.length; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i=0; i<strings.length; i++){
            for(int j=0; j<strings.length; j++){
                if( i!=j && (last[i].equals(first[j]))){
                    graph[i].add(j);
                }
            }
        }

        boolean[] visited = new boolean[strings.length];
        int longest=0;

        for(int i=0; i<strings.length; i++){
            longest = Math.max(longest,dfs(i,graph,visited));
            
        }

        return longest;

    }

    private int dfs(int node, List<Integer>[] graph, boolean[] visited){

        visited[node] = true;
        int longest=1;

        for(int next : graph[node]){
            if(!visited[next]){
                longest = Math.max(longest,1+dfs(next,graph,visited));
            }
        }

        visited[node] = false;

        return longest;

    }

}
