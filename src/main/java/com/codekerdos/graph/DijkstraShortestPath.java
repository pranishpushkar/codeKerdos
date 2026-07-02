package com.codekerdos.graph;

import java.util.*;

public class DijkstraShortestPath {

    public static int[] getShortestDistance(int numberOfNodes, List<int[]>[] graph, int sourceNode){

        int[] shortestDistance = new int[numberOfNodes];
        Arrays.fill(shortestDistance, Integer.MAX_VALUE);
        shortestDistance[sourceNode] = 0;

        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(pair -> pair[0]));
        minHeap.offer(new int[]{0,sourceNode});

        while(!minHeap.isEmpty()){
            int[] temp = minHeap.poll();

            int currentDistance = temp[0];
            int currentNode = temp[1];

            if(currentDistance > shortestDistance[currentNode]){
                continue;
            }

            for(int[] neighbourArray : graph[currentNode]){

                int neighbourNode = neighbourArray[0];
                int edgeWeight = neighbourArray[1];

                int newDistance = currentDistance + edgeWeight;

                if(newDistance < shortestDistance[neighbourNode]){
                    shortestDistance[neighbourNode] = newDistance;
                    minHeap.offer(new int[]{newDistance,neighbourNode});
                }

            }

        }

        return shortestDistance;
    }

}
