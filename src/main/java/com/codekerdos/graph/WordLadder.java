package com.codekerdos.graph;

import java.util.*;

public class WordLadder {

    public int ladderLength(String beginWord, String endWord, List<String> wordList){

        Set<String> set = new HashSet<>(wordList);
        if(!set.contains(endWord)){
            return 0;
        }

        set.remove(beginWord);
        int level=1;
        Queue<String> q = new ArrayDeque<>();
        q.offer(beginWord);

        while(!q.isEmpty()){

            int size = q.size();

            for(int i=0; i<size;i++){

            char[] c = q.poll().toCharArray();

            for(int k=0; k<c.length; k++){
                char original = c[k];

                for(char j='a'; j<='z'; j++){
                    if(j==original){

                        continue;

                    }
                    c[k] = j;

                    String next = new String(c);

                    if(next.equals(endWord)){
                        return level+1;
                    }
                    if(set.remove(next)){
                        q.offer(next);
                    }

                    
                }
                c[k] = original;
                
            }
        }
        level++;
        }


        return 0;
    }

}
