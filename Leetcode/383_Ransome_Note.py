class Solution(object):
    def canConstruct(self, ransomNote, magazine):
        """
        :type ransomNote: str
        :type magazine: str
        :rtype: bool
        """

        note_map = dict()
        magazine_map = dict()

        for ch in ransomNote:
            note_map[ch] = note_map.get(ch, 0) + 1
        
        for ch in magazine:
            magazine_map[ch] = magazine_map.get(ch, 0) + 1

        for ch in note_map:
            if note_map.get(ch) > magazine_map.get(ch):
                return False
        
        return True



        