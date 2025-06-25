class Solution(object):
    def lengthOfLongestSubstring(self, s):
        """
        :type s: str
        :rtype: int
        """
        length = len(s)
        if length < 2:
            return length
        
        left = 0
        right = 0
        seen = set()
        res = 0

        while (right < length):

            # Seen the character before
            while s[right] in seen:
                seen.remove(s[left])
                left += 1


            # New Character
            seen.add(s[right])
            res = max(res, len(seen))
            right += 1

        return res



            

        
        