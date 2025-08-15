public class Solution
{

    public List<String> suggestFriends(Map<String, Set<String>> network, int top_k, String target_user)
    {

        // Friends in common map 
        HashMap<String, Integer> degree_map = new HashMap<>();

        
        // Sanity Check
        Set<String> first_friends = network.get(target_user);

        if (first_friends == null)
        {
            return new ArrayList<>();
        }

        // We don't want to recommend the target user, or the target users friends
        Set<String> exclude = new HashSet<>(first_friends);
        exclude.add(target_user);



        // For each friend of the target 

        for (String first_friend : first_friends)
        {
            
            // Sanity Check 
            Set<String> second_friends = network.get(first_friend);

            if (second_friends == null)
            {
                continue;
            }

            for ( String second_friend : second_friends)
            {
                if (exclude.contains(second_friend))
                {
                    continue;
                }

                if (!degree_map.containsKey(second_friend))
                {
                    degree_map.put(second_friend, 1);
                }
                else
                {
                    int curr_count = degree_map.get(second_friend);
                    degree_map.put(second_friend, curr_count + 1);
                }

            }

        }
        
        // Entry set trick from Jordi
        List<Map.Entry<String,Integer>> entry_results = new ArrayList<>(degree_map.entrySet());
        Collections.sort(entry_results, Comparator.comparing(Map.Entry::getValue).reversed());

        List<String> final_results = new ArrayList<>();

        // The example given only has 2 candidates but wants top 3 so we need to make sure k is within bounds 
        int actual_k = Math.min(top_k, entry_results.size());

        for (int i = 0 ; i < actual_k ; i ++)
        {
            final_results.add(entry_results.get(i).getKey());

        }

        return final_results;




    }
}