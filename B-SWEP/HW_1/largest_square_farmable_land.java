/*
1. Initial Approach
At each "1" cell, begin a search in all 8 directions.
Keep a running maximum of the minimum common depth value.

At the individual cell level the worst case scenario would be the center of the matrix.
This means each direction you would travel around n/2 depth. 
This translates to 8 * (n / 2) = 4 n , or O(n) time complexity.

An O(n) search within a O(n^2) search is O(n^3).

O(n^3) is terrible, and this problem smells like Dynamic Programming.

2. DP Approach

Similar to how we were thinking before, we can keep use the "minimum" idea.

Ex: 
1 1 1
1 1 1
1 1 1

Start @ index 1, 1

1 1 1
1 X
1 
Check N, NW, & W
All are 1, so we can add 1 to the minimum, so we get 2. 

1 1 1
1 2 X
1 

Now we shift over, but the minimum is 1, so we add 1 to get 2.

1 1 1
1 2 2
1 X

Same thing here, we get 2.

1 1 1
1 2 2
1 2 X

Only at this point, when we are at the corner of a big square is when can verify that we get a 3x3 square. 


We store the max value and return the coordinates of that max value. 


*/


public int find_largest_square(ArrayList<ArrayList<Integer>> land)
{



	// Maximum value & coordinates
	int max_val = 0;
	int max_row = 0;
	int max_col = 0;

    // Rows 
	for (int i = 1; i < land.size(); i ++)
	{
        ArrayList<Integer> row = land.get(i);

        // Columns 
        for (int j = 1; j < row.size(); j ++ )
        {

            // Check if we are at one
            if (land.get(i).get(j) == 1)
            {
                // Check Directions
                int north  = land.get(i - 1).get(j);
                int north_west = land.get(i-1).get(j-1);
                int west = land.get(i).get(j-1);


                // Find minimum and add one to the current value
                // Chain min function 
                int temp_min = Math.min(north, Math.min(north_west, west) ) + 1;

                if (temp_min > max_val)
                {
                    max_val = temp_min;
                    max_row = i;
                    max_col = j;
                }

                row.set(j, temp_min);

            }


        }



	}

    return max_val* max_val;
	
}
