package com.codekerdos.graph;

public class NumberOfIslands {

    public int numIslands(char[][] grid){

        int ans=0;

        int rows= grid.length;
        int columns= grid[0].length;

        for(int i=0; i<rows; i++){
            for(int j=0; j<columns; j++){
                if(grid[i][j] == '1'){
                    ans++;
                    dfs(grid,i,j,rows,columns);
                }
            }
        }

        return ans;

    }

    private void dfs(char[][] grid, int row, int column, int rows, int columns){

        if(row<0 || row>=rows || column<0 || column>= columns || grid[row][column]!='1'){
            return;

        }

        grid[row][column] = '0';

        dfs(grid, row+1,column,rows,columns);
        dfs(grid,row-1,column,rows,columns);
        dfs(grid,row,column+1,rows,columns);
        dfs(grid,row,column-1,rows,columns);

    }

}
