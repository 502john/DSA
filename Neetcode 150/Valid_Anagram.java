class Solution {
    public boolean isAnagram(String s, String t) 
    {
        // If Strings are not the same length, return false immediately
        if (s.length() != t.length())
        {
            return false;
        }
        // Possible Solutions
        // HashMap, keep track of each char and count
        // O(n) Time & Space
        // Sorting, sort the string and compare
        // O(nlogn) Time, O(1) Space

        HashMap<Character, Integer> map = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();

        // map for string s
        for (char c : s.toCharArray())
        {
            // If we haven't seen the character, add it
            if (!map.containsKey(c))
            {
                map.put(c, 1);
            }
            else
            {
                int temp = map.get(c);
                map.put(c, temp + 1);
            }
        }

        // map for string t
        for (char c : t.toCharArray())
        {
            // If we haven't seen the character, add it
            if (!map2.containsKey(c))
            {
                map2.put(c, 1);
            }
            else
            {
                int temp = map2.get(c);
                map2.put(c, temp + 1);
            }
        }
        
        // check equality for HashMap
        for (char c : map.keySet())
        {
            if (!map2.containsKey(c))
            {
                return false;
            }

            // This fails since we're comparing Integer Objects references
            // HashMaps in Java don't store primitives, they store objects like the 
            // Integer wrapper class. 
            // if (map.get(c) != map2.get(c))

            if (!map.get(c).equals(map2.get(c)))
            {
                return false;
            }
        }
        return true;         
    }
}
