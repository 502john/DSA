'''
Ex:
string_a = tact 
string_b = cat

"ANY ANAGRAM" = any order of a fixed amount of characters
c = 1
a = 1
t = 1

substring of  = we need some kind of order 

Smells like Fixed Size Sliding Window 
'''

'ANAGRAM of B of occurs in A'
def substring_anagram(a, b):

    # Worst Case 26 or 52 operations
    def compare_dicts(one, two):
        if len(one) != len(two):
            return False
        for item in one:
            if one[item] != two[item]:
                return False
        return True

    # Check Base case
    
    if len(b) > len(a):
        return False
    k = len(b)

    
    # Create dict of b
    anagram_map = dict()
    for ch in b:
        anagram_map[ch] = anagram_map.get(ch,0) + 1
    
    # Build initial sliding window for string a
    window_map = dict()
    for ch in a[:k]:
        window_map[ch] = window_map.get(ch, 0) + 1

    # First Comparison 
    if compare_dicts(window_map, anagram_map) == True:
        return True


    for i in range(0, len(a) - k):

        # Add new character
        new = a[i + k]
        window_map[new] = window_map.get(new, 0) + 1

        # Remove old character
        old = a[i]
        window_map[old] = window_map.get(old, 0) - 1
        if window_map[old] < 1:
            del window_map[old]
        
        # Do Comparison
        if compare_dicts(window_map, anagram_map) == True:
            return True
    
    # Return False if we never returned true
    return False



