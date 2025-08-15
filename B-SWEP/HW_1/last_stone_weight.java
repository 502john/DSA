class Solution {
    public int lastStoneWeight(int[] stones) 
    {

        // Ideal Problem for MaxHeap
        // Look out for odd / even edge cases & size 1
        if (stones.length == 1)
        {
            return stones[0];
        }

        // Create Heap O(nlogn) Time, O(n) Space
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int stone : stones)
        {
            maxHeap.add(stone);
        }


        // Poll Twice 
        while (maxHeap.size() > 0)
        {
            // Grabbing First Stone
            int stone1 = maxHeap.poll();

            // Checking if there is a second stone
            if (maxHeap.peek() == null)
            {
                return stone1;
            }
            else
            {
                int stone2 = maxHeap.poll();
                int result = Math.abs(stone1 - stone2);
                if (result > 0)
                {
                    maxHeap.offer(result);
                } 
            }
        }
        
        // If we have a stone left, we can return that stone. Otherwise return 0 like the problem states; 
        return (maxHeap.size() == 1) ? maxHeap.poll() : 0;

    }
}