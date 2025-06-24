# Problem Name

# Longest Substring With K Distinct Characters

# Problem Statement

# Given a string s consisting only of ASCII letters and an integer k, return the length of the longest 
#  contiguous substring of s that contains at most k distinct characters.
# If every substring of s contains more than k distinct characters, return 0.

# Examples

# s    k    Output    Explanation
# "eceba"    2    3    "ece" has 2 distinct letters (e,c).
# "aa"    1    2    Whole string fits.
# "world"    3    3    Longest such substrings are "wor", "orl", "rld".
# "abcd"    1    1    Any single-char slice only.
# "aabbcc"    0    0    No substring satisfies “≤ 0 distinct”.
# Constraints

# 1 ≤ |s| ≤ 100 000
# 0 ≤ k ≤ 26 (only letters)
# s contains uppercase or lowercase letters ('A'–'Z', 'a'–'z')
# Follow-up

# Can you solve it in O(n) time using O(k) extra space?

# Why recruiters like it
# Tests grasp of sliding-window / two-pointer patterns.
# Requires solid hashing / frequency-map fundamentals.
# Edge-case awareness (k = 0, string shorter than k, etc.).
# Straightforward to code & debug within 20–25 minutes, yet still allows discussion of optimizations and alternative approaches (e.g., ordered map vs. array counts).
# Good luck!

def solution(s, k):
    if k == 0:
        return 0
    
    freq = {}
    left = 0
    res = 0

    for right in range(len(s)):
        freq[s[right]] = freq.get(s[right], 0) + 1

        while (len(freq > k)):
            freq[s[left]] -= 1
            if (freq[s[left]] == 0):
                del freq[s[left]]
            left += 1
        
        res = max(res, right - left + 1)
    
    return res


