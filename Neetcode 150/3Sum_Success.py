class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        '''
        1. Sort Array
        2. Iterate with a for loop
        3. Ensure no repetition of the i pointer
        4. Preform Two Sum 2
        5. Ensure left & right pointer are not repeated
        '''

        nums.sort()
        res = []

        for i, num in enumerate(nums):
            if ( i > 0 and nums[i] == nums[i - 1]):
                continue
            left = i + 1
            right = len(nums) - 1
            while (left < right):
                sum = nums[i] + nums[left] + nums[right]

                if (sum < 0):
                    left += 1
                elif (sum > 0):
                    right -= 1
                else:
                    res.append([nums[i], nums[left], nums[right]])
                    left += 1
                    right -= 1
                    while ( left < right and nums[left] == nums[left - 1]):
                        left += 1
                    
        

        return res
                    

        
        