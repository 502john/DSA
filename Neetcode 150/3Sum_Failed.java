// Failed First Attempt
/*
class Solution {
    public List<List<Integer>> threeSum(int[] nums) 
    {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++)
        {
            if (i != 0 && nums[i] == nums[i - 1])
            {
                continue;
            }

            int target = 0 - nums[i];
            int left = i;
            int right = nums.length - 1;
            while (left != right )
            {
                if (nums[left] + nums[right] > target)
                {
                    right--;
                    continue;
                }
                if (nums[left] + nums[right] < target )
                {
                    left++;
                    continue;
                }
                if (nums[left] + nums[right] == target)
                {

                    res.add(new ArrayList<>(Arrays.asList(i, left, right)));
                    continue;
                }


            }

        }
        return res;
        
    }
}

*/