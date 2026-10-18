package com.codekerdos.graph;
import java.util.*;

public class CheapestFlightsKStops {

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k){
        int[] dist = new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[src]=0;

        for(int i=0; i<=k; i++){
            int[] temp = dist.clone();

            for(int[] flight : flights){
                int from = flight[0];
                int to = flight[1];
                int price = flight[2];

                if(temp[from]!= Integer.MAX_VALUE){
                    dist[to] = Math.min(dist[to],temp[from]+price);
                }
            }
        }

        return dist[dst] == Integer.MAX_VALUE ? -1:dist[dst];

    }

}
