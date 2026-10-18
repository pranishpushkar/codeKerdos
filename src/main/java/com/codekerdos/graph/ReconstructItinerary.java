package com.codekerdos.graph;

import java.util.*;

public class ReconstructItinerary {

    LinkedList<String> answer = new LinkedList<>();
    Map<String,PriorityQueue<String>> graph = new HashMap<>();

    public List<String> findItinerary(List<List<String>> tickets){

        for(List<String> ticket : tickets){
            if(graph.containsKey(ticket.get(0))){
                graph.get(ticket.get(0)).offer(ticket.get(1));
            }else{
                PriorityQueue<String> temp = new PriorityQueue<>();
                temp.offer(ticket.get(1));
                graph.put(ticket.get(0),temp);
            }
        }

        dfs("JFK");

        return answer;

    }

    private void dfs(String node){
        PriorityQueue<String> pq = graph.get(node);

        while(pq != null && !pq.isEmpty()){
            dfs(pq.poll());
        }
        answer.addFirst(node);
    }

}
