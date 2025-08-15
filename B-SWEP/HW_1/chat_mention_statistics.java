/*
Split up problem into sub problems
1. Create Data Structure to hold ID & counts
Simple Hashmap with id : count 

2. Figure out valid @ mentions
Parse Each String, filter out strings that start with @
After obtaining each string that starts with @, parse strings and remove commas to see if there is a list
For each individual string, input ids into a SET since we only care if they are mentioned once
Use these sets to update master HashMap

3. Format Valid String 
Use Master Hashmap with String Builder to create a return type 

*/
import java.util.*;
public class Solution
{
    public static record Mention(String id, int count) {}

    public ArrayList<String> chat_mention_statistics(String[] messages, String[] members)
    {
        // Use members id to construction master HashMap for storing id & counts
        HashMap<String, Integer> mention_count_map = new HashMap<>();
        for (String member : members)
        {
            mention_count_map.put(member, 0);
        }


        // Iterating through each sentence within messages array
        for (String sentence : messages)
        {
            HashSet<String> sentence_ids = obtain_id_set_from_sentence(sentence);

            for ( String id : sentence_ids)
            {

                // This validates that the correct members are tracked
                if ( mention_count_map.containsKey(id) )
                {
                    int curr_count = mention_count_map.get(id);
                    mention_count_map.put(id, curr_count + 1);
                }
            }
        }



        // Master HashMap should contain id with count for the whole message array

        // Create ArrayList of Mention objects that will hold id : count
        ArrayList<Mention> formatted_mentions = new ArrayList<>();

        // Iterate through HashMap to create & add record to list of records
        for (String id : mention_count_map.keySet())
        {
            formatted_mentions.add(new Mention(id, mention_count_map.get(id)));

        }


        // Sorts FIRST by count in DESCENDING and then by string ASCENDING

        // comparator sort is ascending by default, so we need to reverse the count sort
        
        // use scope resolution operator to indicate field
        formatted_mentions.sort(Comparator.comparing(Mention::count).reversed().thenComparing(Mention::id));



        ArrayList<String> formatted_strings = new ArrayList<>();

        // Use Arraylist of mentions to string
        for (Mention mention : formatted_mentions )
        {
            formatted_strings.add(mention.id() + "=" + mention.count());
        }

        return formatted_strings;

        
    }



    public HashSet<String> obtain_id_set_from_sentence(String str)
    {
        // Split by spaces
        String[] tokens = str.split(" ");

        // Clean up white spaces
        for (int i = 0; i < tokens.length; i ++)
        {
            tokens[i] = tokens[i].trim();
        }

        // HashSet for storing mentions within a sentence
        HashSet<String> sentence_ids = new HashSet<>();
        for (String token : tokens)
        {
            // Start of mention list within sentence + sanity check
            if (token.length() != 0 && token.charAt(0) == '@')
            {
                // Parse }
                String[] individual_ids = parse_mention_list(token);

                for (String id : individual_ids)
                {
                    sentence_ids.add(id);
                }


            }
        }

        return sentence_ids;
    }

    // Returns list of ids present within a mention list
    // This is fine since we are assuming valid list input
    public String[] parse_mention_list(String str)
    {
        // Remove @
        String new_str = str.substring(1);

        return new_str.split(",");
    }


}