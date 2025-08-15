public int problem(int[] arr)
{

   if (arr.size() == 0)
   {
        return arr[0];
   }


    int left = 0;
    int right = arr.length() - 1;

    while ( left < right )
    {
        int middle = left + ((right - left) / 2 );

        // [5, 12, 17, 22, 25, 37, 23, 11, 6, 4, 2, 1]
        //  Increasing Max Decreasing

        // Storing boolean variables
        boolean greater_than_left = arr[middle] > arr[middle - 1];
        boolean greater_than_right = arr[middle] > arr[middle + 1];

        if ( greater_than_left && greater_than_right )
        {
            return middle;
        }
        else if ( greater_than_left)
        {
            left = middle + 1;
        }
        // greater_than_right 
        else 
        {
            right = middle - 1;
        }


    }


}