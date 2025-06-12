class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
    # The problem states that the sequence doesn't have to be consecutive,
    # the second example also shows this.

    # If the time constraints weren't O(n), i could just hash the array,
    # sort the array, and then count the longest consecutive sequence

    # Instead
        curr_max = 0

        seen = set()
        nums_set = set(nums)

        for num in nums_set:
            # Start of a new sequence
            if (not ((num - 1) in nums_set)  and not ((num) in seen )):

                # start counting
                count = 1
                curr_val = num
                seen.add(curr_val)

                while True:
                    if ((curr_val + 1) in nums_set):
                        count += 1
                        seen.add(curr_val + 1)
                        curr_val += 1
                    else:
                        break
                
                curr_max = max(count, curr_max)


        return curr_max
            



        