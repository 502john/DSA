# n*logn time due to sorting the array

# n*logk is preferred using a heap, but max heaps in python sucks
# look at java solution

class Solution(object):
    def findKthLargest(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """
        # Sort array in descending order, return the kth index
        # subtract index by one due to 1-index vs 0-index
        nums.sort(reverse=True)
        return nums[k - 1]

        

