/*
The bitmap will be represented as a 2d array of integers

This is a DFS question, you begin at the point indicated and recurse until there is no direction left to go to,

*/


public class Solution
{
    private int[][] picture;
    private int fill_color;
    
    // True = dfs preformed, False = not preformed
    public boolean floodFill(int[][] picture, int start_row, int start_col, int fill_color)
    {
        this.picture = picture;
        this.fill_color = fill_color;

        // Checking for the color that needs to be filled
        if (start_row < 0 || start_row >= picture.length || start_col < 0 || start_col >= picture[0].length)
        {
            return false;
        }
        int start_color  = picture[start_row][start_col];


        // Check if start color already equals fill color
        if ( start_color == fill_color )
        {
            return false;
        }

        dfs(start_row, start_col, start_color);

        return true;


    }

    private void dfs(int row, int col, int start_color)
    {
        // Deal with current value
        picture[row][col] = fill_color;


        // Recurse to children

        // Up
        if (isSafe( row - 1, col, start_color))
        {
            dfs(row - 1, col, start_color);
        }

        // Right
        if (isSafe( row , col + 1))
        {
            dfs(row , col + 1, start_color);
        }

        // Down
        if (isSafe( row + 1 , col))
        {
            dfs(row + 1, col, start_color);
        }

        // Left
        if (isSafe( row , col - 1))
        {
            dfs(row, col - 1, start_color);
        }
        
    }

    private boolean isSafe(int row, int col, int start_color)
    {
        return (row >= 0) && (row < picture.length) && (col >= 0) && (col < picture[0].length) && (picture[row][col] == start_color);
    }


}
