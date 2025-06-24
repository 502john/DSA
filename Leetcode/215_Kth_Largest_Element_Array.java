
// STILL n*log(n) because we are maintaining a heap of size n, each add is a heapify operation that takes log(n) time

// n*log(n) + k = n * log(n)

/*
class Solution {
    public int findKthLargest(int[] nums, int k) 
    {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int num : nums)
        {
            maxHeap.add(num);
        }

        for (int i = 0; i < k - 1; i ++)
        {
            maxHeap.poll();
        }
        int res = maxHeap.poll();
        return res;
        
    }
}
*/

// Get creative, use a min heap to get rid of the n - k smallest numbers. (No sorting)
/*
k = 3

Removing n - k smallest numbers
[1,2,3,4,5,6,7,8]   -> minheap.poll * n - k

= [6, 7, 8]

the top of this new min heap is the kth largest element 
  6
7   8 

min


*/


class Solution {
    public int findKthLargest(int[] nums, int k) 
    {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num : nums)
        {
            minHeap.add(num);
            if (minHeap.size() > k)
            {
                minHeap.poll();
            }
        }

        return minHeap.poll();
    
        
    }
}
