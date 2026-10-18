package com.codekerdos.graph;

import java.util.*;

public class RottingOranges {

    public int orangesRotting(int[][] grid){

        int freshOranges =0;
        int rows = grid.length;
        int columns = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        int minutes =0;
        int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};

        for(int i=0; i<rows; i++){
            for(int j=0; j<columns; j++){
                if(grid[i][j]==1){
                    freshOranges++;
                }
                if(grid[i][j]==2){
                    q.offer(new int[]{i,j});
                }
            }
        }

        while(!q.isEmpty() && freshOranges>0){
            int levelSize = q.size();

            for(int k=0;k<levelSize;k++){
                int[] currentOrange = q.poll();

                for(int[] dir : directions){
                    int nextRow = currentOrange[0]+dir[0];
                    int nextColumn = currentOrange[1]+dir[1];

                    if(nextRow>=rows || nextRow<0 || nextColumn>= columns || nextColumn<0 || grid[nextRow][nextColumn]!=1){
                        continue;
                    }else{
                        grid[nextRow][nextColumn] = 2;
                        freshOranges--;
                        q.offer(new int[]{nextRow,nextColumn});
                    }
                }
            }
            minutes++;
        }

        return freshOranges==0 ? minutes : -1;

    }

}
