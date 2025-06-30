class Solution(object):
    def findMaxConsecutiveOnes(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        # Result 
        res = 0
        # Temporary Count
        count = 0

        # Restart count once we hit a 0
        for num in nums:
            if num == 0:
                res = max(count, res)
                count = 0
            else:
                count += 1
        
        # If last character isn't a 0, we need to compare the last count with the max
        return max(res, count)

        