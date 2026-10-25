package com.codekerdos.graph;

import java.util.*;

public class Bridge {

    List<List<Integer>> answer;
    int currentTime;

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {

        List<List<Integer>> graph = new ArrayList<>();
        int[] discovery = new int[n];
        int[] low = new int[n];
        Arrays.fill(discovery, -1);

        currentTime = 0;
        answer = new ArrayList<>();

        for(int i=0; i<n; i++){
            graph.add(new ArrayList<>());
        }

        for (List<Integer> connection : connections) {

            int firstNode = connection.get(0);
            int secondNode = connection.get(1);

            graph.get(firstNode).add(secondNode);
            graph.get(secondNode).add(firstNode);
        }

        dfs(0,-1,graph,discovery,low);

        return answer;
    }

    private void dfs(int currentNode, int parent, List<List<Integer>> graph, int[] discovery, int[] low){
        discovery[currentNode] = currentTime;
        low[currentNode] = currentTime;
        currentTime++;

        for(int neighbor : graph.get(currentNode)){
            if(neighbor == parent){
                continue;
            }
            if(discovery[neighbor] == -1){
                dfs(neighbor, currentNode, graph, discovery, low);

                low[currentNode] = Math.min(low[currentNode], low[neighbor]);
                if(low[neighbor]>discovery[currentNode]){
                    answer.add(Arrays.asList(currentNode,neighbor));
                }

            }else{
                low[currentNode] = Math.min(low[currentNode],discovery[neighbor]);
            }
        }
    }

}
