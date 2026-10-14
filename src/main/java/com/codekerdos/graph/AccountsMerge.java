package com.codekerdos.graph;

import java.util.*;

public class AccountsMerge {

    public List<List<String>> mergeAccounts(List<List<String>> accounts){

        Map<String,List<String>> graph = new HashMap<>();
        Map<String,String> emailToName = new HashMap<>();

        for(List<String> account : accounts){
            String name = account.get(0);
            String firstEmail = account.get(1);

            emailToName.put(firstEmail, name);
            graph.putIfAbsent(firstEmail, new ArrayList<>());

            for(int i=2; i<account.size(); i++){
                String email = account.get(i);
                emailToName.put(email, name);

                graph.putIfAbsent(email, new ArrayList<>());

                graph.get(firstEmail).add(email);
                graph.get(email).add(firstEmail);

            }
        }

        List<List<String>> mergedAccounts = new ArrayList<>();
        Set<String> visited = new HashSet<>();

        for(String email : graph.keySet()){
            if(visited.contains(email)){
                continue;
            }

            List<String> emails = new ArrayList<>();
            Deque<String> stack = new ArrayDeque<>();

            stack.push(email);
            visited.add(email);

            while(!stack.isEmpty()){
                String current = stack.pop();
                emails.add(current);

                for(String neighbor : graph.get(current)){
                    if(visited.add(neighbor)){
                        stack.push(neighbor);
                    }
                }
            }

            Collections.sort(emails);

            List<String> merged = new ArrayList<>();
            merged.add(emailToName.get(email));
            merged.addAll(emails);
            mergedAccounts.add(merged);
        }



        return mergedAccounts;
    }

}
