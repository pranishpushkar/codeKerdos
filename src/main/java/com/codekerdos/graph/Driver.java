package com.codekerdos.graph;

import java.util.ArrayList;
import java.util.List;

public class Driver {

    public static void main(String[] args) {
        int numberOfNodes = 5;

        // adjacencyList[node] = list of {neighborNode, edgeWeight}
        List<int[]>[] adjacencyList = new ArrayList[numberOfNodes];
        for (int node = 0; node < numberOfNodes; node++) {
            adjacencyList[node] = new ArrayList<>();
        }

        // Example directed graph
        adjacencyList[0].add(new int[]{1, 4});
        adjacencyList[0].add(new int[]{2, 1});
        adjacencyList[2].add(new int[]{1, 2});
        adjacencyList[1].add(new int[]{3, 1});
        adjacencyList[2].add(new int[]{3, 5});
        adjacencyList[3].add(new int[]{4, 3});

        int sourceNode = 0;

        int[] shortestDistance = DijkstraShortestPath.getShortestDistance(numberOfNodes, adjacencyList, sourceNode);

        System.out.println("Shortest distances from source node " + sourceNode + ":");
        for (int node = 0; node < numberOfNodes; node++) {
            System.out.println("To node " + node + " = " + shortestDistance[node]);
        }
    }
}
