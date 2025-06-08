class Solution {
    public boolean hasDuplicate(int[] nums) 
    {
        // O(n) Time, O(n) Space
        // Create a HashSet, no need for HashMap
        HashSet<Integer> seen = new HashSet<>();

        for (int i = 0; i < nums.length; i++)
        {
            // Is it in our set?

            // Yes
                if (seen.contains(nums[i]))
                {
                    return true;
                }

            // No
                else
                {
                    seen.add(nums[i]);
                }
        }
        return false;

    }
}


// 
