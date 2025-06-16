class Solution:
    def twoSum(self, numbers: List[int], target: int) -> List[int]:
        # How is this different then 2sum?
        # Array is sorted, in the regular two sum we could use
        # O(n) space, here we can only keep constant space.

        # We need to use some form of two pointers to find our numbers
        # It will be similar to binary search
        # Keep in mind this is one indexed

        # 1, 2, 3, 4     target = 3
#         x        y
        #  1 + 4 = 5 too big, move y down

        # 1, 2, 3, 4     target = 3
#         x     y
        #  1 + 3 = 5 too big, move y down
#       ...

        left = 0
        right = len(numbers) - 1

        while (left != right):
            curr = numbers[left] + numbers[right]
            if (curr > target):
                right -= 1
                continue
            if (curr < target):
                left += 1
                continue
            if (curr == target):
                res = []
                res.append(left + 1)
                res.append(right + 1)
                return res
                


        