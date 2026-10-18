package com.codekerdos.graph;

import java.util.*;

public class CourseScheduleTwo {

    public int[] findOrder(int numCourses, int[][] prerequisites){

        int[] indegree = new int[numCourses];
        Map<Integer,List<Integer>> graph = new HashMap<>();

        for(int[] temp : prerequisites){
            indegree[temp[0]]++;

            if(graph.get(temp[1]) != null){
                graph.get(temp[1]).add(temp[0]);
            }else{
                List<Integer> neighbor = new ArrayList<>();
                neighbor.add(temp[0]);
                graph.put(temp[1], neighbor);
            }
        }

        Queue<Integer> q = new ArrayDeque<>();
        int counter = 0;
        int[] answer = new int[numCourses];

        for(int i=0; i<indegree.length; i++){
            if(indegree[i]==0){
                q.offer(i);
            }

        }

        while(!q.isEmpty()){
            int node = q.poll();
            answer[counter] = node;
            counter++;

            for(int neighbor : graph.getOrDefault(node, new ArrayList<>())){

                indegree[neighbor]--;

                    if(indegree[neighbor]==0){
                        q.offer(neighbor);
                    }

            }
        }
        if(counter == numCourses){
            return answer;
        }

        return new int[0];

    }

}
