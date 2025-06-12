class Solution {
    public boolean isValidSudoku(char[][] board) 
    {
        HashSet<Character>[] rows = new HashSet[9];
        HashSet<Character>[] cols = new HashSet[9];

        for (int i = 0; i < 9; i++)
        {
            rows[i] = new HashSet<Character>();
            cols[i] = new HashSet<Character>();
        }

        // rows
        for (int i = 0; i < board.length; i++)
        {
            // cols
            for ( int j = 0; j < board[i].length; j++)
            {
                char value = board[i][j];
                if (value == '.')
                {
                    continue;
                }


                if (rows[i].contains(value) || cols[j].contains(value) )
                {
                    return false;
                }
                else
                {
                    rows[i].add(value);
                    cols[j].add(value);
                }

            }
        }
        HashSet<Character>[] boxes = new HashSet[9];
        for (int i = 0; i < 9; i++)
        {
            boxes[i] = new HashSet<Character>();
        }
        
        /*
        Convert 2D -> 1D
        0 1 2
        3 4 5
        6 7 8
        
        flatten equation
        row * 3 + col
        ex: (1,1) =  4
        1 * 3 + 1 = 4
        */

        // 
        for (int i = 0; i < board.length; i++)
        {
            // cols
            for ( int j = 0; j < board[i].length; j++)
            {
                char value = board[i][j];
                if (value == '.')
                {
                    continue;
                }



                int boxIndex = (((i / 3) * 3 ) + j / 3);

                if (boxes[boxIndex].contains(value))
                {
                    return false;
                }
                else
                {
                    boxes[boxIndex].add(value);
                }


            }
        }

        return true;
        
    }
}
