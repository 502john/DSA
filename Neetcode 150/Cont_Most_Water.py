class Solution:
    def maxArea(self, heights: List[int]) -> int:
        left = 0
        right = len(heights) - 1
        max_vol = 0

        while ( left < right ):
            distance = right - left
            h = min(heights[left], heights[right])
            max_vol = max(max_vol, h * distance)
            
            #this is the key, move the index with the smallest height
            if heights[left] < heights[right]:
                left += 1
            else:
                right -= 1
        
        return max_vol
        