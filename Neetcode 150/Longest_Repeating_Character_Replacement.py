class Solution:
    def max_in_map(self, dictionary):
        res = 0
        for elem in dictionary:
            res = max(res, dictionary[elem])
        return res

    def characterReplacement(self, s: str, k: int) -> int:
        ## Dynamic Sliding Window 
        # We are allowed to change at most k values in a window
        # This means the size of our biggest window satisfies this condition
        # length_of_window - most_frequent_item = k

        # Pointers
        left = 0
        right = 0

        # Data Structure for window
        char_count = dict()

        # Result
        res = 0

        # x2 Loop Structure
        while (right < len(s)):
            
            # Add current value to data structure
            char_count[s[right]] = char_count.get(s[right], 0) + 1

            # Check if we are violating our condition
            while ( (right - left + 1 ) - self.max_in_map(char_count) > k):
                char_count[s[left]] = char_count.get(s[left]) - 1
                if char_count[s[left]] <= 0:
                    del char_count[s[left]]
                left += 1

            # Update max
            # Our while loop above already checked if it was valid

            res = max(res, (right - left + 1 ) )

            # Move problem forward
            right += 1
        
        return res
            
        
            





    

        