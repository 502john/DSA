class Solution {
    public int[] topKFrequent(int[] nums, int k) 
    {   

        // Create map   < num : count > 
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int n : nums)
        {
            if (!map.containsKey(n))
            {
                map.put(n, 1);
            }
            else
            {
                int temp = map.get(n);
                map.put(n, temp + 1);
            }
        }

        // Create Buckets, fill with empty arraylists
        ArrayList<Integer>[] buckets = new ArrayList[nums.length + 1];
        for (int i = 0; i < buckets.length; i++)
        {
            buckets[i] = new ArrayList<>();
        }

        // Iterating through map
        // count value = bucket index
        // num key = bucket value
        for (int n : map.keySet())
        {
            int count = map.get(n);
            buckets[count].add(n);
        }

        // Collect k elements 
        int[] result = new int[k];

        int count= 0;

        outer: // kapleu taught us this 
        for (int i =  buckets.length - 1; i >= 0; i--)
        {
            ArrayList<Integer> bucket = buckets[i];
            for (int j = bucket.size() - 1; j >= 0; j--)
            {
                if (count >= k )
                {
                    break outer;
                }

                result[count] = bucket.get(j);
                count++;
                
            }
        }

        
        return result;


    }
}
