package com.codekerdos.graph;

import java.util.*;

public class MST {

    public static int getMinimumSpanningTreeCost(int numberOfNodes, List<int[]>[] graph, int sourceNode) {

        boolean[] isInMST = new boolean[numberOfNodes];
        int totalCost = 0;
        int nodesIncludedInMST = 0;

        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(edge -> edge[1]));

        isInMST[sourceNode] = true;
        nodesIncludedInMST++;

        for (int[] neighbourInfo : graph[sourceNode]) {
            minHeap.offer(neighbourInfo);
        }

        while (!minHeap.isEmpty() && nodesIncludedInMST < numberOfNodes) {
            int[] currentEdge = minHeap.poll();

            int neighbourNode = currentEdge[0];
            int edgeWeight = currentEdge[1];

            if (isInMST[neighbourNode]) {
                continue;
            }

            isInMST[neighbourNode] = true;
            totalCost += edgeWeight;
            nodesIncludedInMST++;

            for (int[] nextNeighbourInfo : graph[neighbourNode]) {
                if (!isInMST[nextNeighbourInfo[0]]) {
                    minHeap.offer(nextNeighbourInfo);
                }
            }
        }

        return nodesIncludedInMST == numberOfNodes ? totalCost : -1;
    }
}