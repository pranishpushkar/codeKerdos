package com.codekerdos.graph;

import java.util.*;

public class StringChain {

    public static List<String> longestChain(
            String[] strings,
            String start) {

        int n = strings.length;

        // Build directed graph
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {

            String lastWord = getLastWord(strings[i]);

            for (int j = 0; j < n; j++) {

                if (i == j) {
                    continue;
                }

                String firstWord = getFirstWord(strings[j]);

                if (lastWord.equals(firstWord)) {
                    graph.get(i).add(j);
                }
            }
        }

        // Find starting node
        int startIndex = -1;

        for (int i = 0; i < n; i++) {
            if (strings[i].equals(start)) {
                startIndex = i;
                break;
            }
        }

        if (startIndex == -1) {
            return new ArrayList<>();
        }

        boolean[] visited = new boolean[n];

        List<Integer> bestPath =
                dfs(startIndex, graph, visited);

        List<String> result = new ArrayList<>();

        for (int index : bestPath) {
            result.add(strings[index]);
        }

        return result;
    }

    private static List<Integer> dfs(
            int current,
            List<List<Integer>> graph,
            boolean[] visited) {

        visited[current] = true;

        List<Integer> bestPath = new ArrayList<>();
        bestPath.add(current);

        for (int next : graph.get(current)) {

            if (visited[next]) {
                continue;
            }

            List<Integer> candidate =
                    dfs(next, graph, visited);

            if (candidate.size() + 1 > bestPath.size()) {

                bestPath = new ArrayList<>();
                bestPath.add(current);
                bestPath.addAll(candidate);
            }
        }

        visited[current] = false;

        return bestPath;
    }

    private static String getFirstWord(String str) {
        int space = str.indexOf(' ');

        if (space == -1) {
            return str;
        }

        return str.substring(0, space);
    }

    private static String getLastWord(String str) {
        int space = str.lastIndexOf(' ');

        if (space == -1) {
            return str;
        }

        return str.substring(space + 1);
    }

    public static void main(String[] args) {

        String[] strings = {
            "I love apples",
            "apples are red",
            "red is beautiful",
            "apples grow on trees",
            "trees are green"
        };

        String start = "I love apples";

        System.out.println(
                longestChain(strings, start)
        );
    }
}
