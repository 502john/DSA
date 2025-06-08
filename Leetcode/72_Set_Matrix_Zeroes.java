class Solution {
    int[][] matrix;
    public void setZeroes(int[][] matrix) 
    {
        this.matrix = matrix;

        // Two Sets, hold the rows and columns that need to be marked as 0s.
        HashSet<Integer> rows = new HashSet<>();
        HashSet<Integer> cols = new HashSet<>();


        // Identify zeros
        // Rows
        for (int i = 0 ; i < matrix.length; i ++)
        {
            // Cols
            for (int j = 0; j < matrix[0].length; j ++)
            {
                if (matrix[i][j] == 0)
                {
                    rows.add(i);
                    cols.add(j);
                }

            }
        }

        // Replace Zeros
        // Rows
        for (int i = 0 ; i < matrix.length; i ++)
        {
            // Cols
            for (int j = 0; j < matrix[0].length; j ++)
            {
                if (rows.contains(i) || cols.contains(j))
                {
                    matrix[i][j] = 0;
                }

            }

        
    }


}
}