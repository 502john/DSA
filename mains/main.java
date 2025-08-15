import java.util.*;

// Trie is very similar to n-arry trees

class TicketMachine
{
    // Structure
    private TrieNode root;
    private TrieNode curr;

    // For O(1) look up
    private Deque<TrieNode> input;

    // Constructor
    public TicketMachine(String[] destinations)
    {
        root = new TrieNode();
        input = new LinkedList<>();

        // initialize stack and curr
        this.input.add(root);
        this.curr = root;
        buildTrie(destinations);
    }

    // Tree Constructor
    private void buildTrie(String[] str_array)
    {


        // Iterate through every single word in destinations
        for (String str : str_array)
        {
            TrieNode curr = root;

            // Iterate through every single character within each word
            char[] innerArr = str.toCharArray();
            for ( char ch : innerArr )
            {
                // ascii index value for uppercase
                int index = ch - 'A';

                // If our new character is not present in the children
                if (curr.children[index] == null)
                {
                    // Create the child
                    curr.children[index] = new TrieNode();
                    curr.childrenSet.add(ch);

                }

                // Iterate to children
                curr = curr.children[index];


            }

            // After each word is done, mark it as a word
            curr.completeWord = true;
            

            
        }
    }
        // Similar to before, this time using the trie

        public List<Character> question(char c) 
        {
     
            // Back space
            if (c == '\b') 
            { 
                // Empty input, minimum is size 1 with root
                if (input.size() <= 1) 
                {
                    return new ArrayList<>();
                }

                // Remove last element in the stack, and go back to the previous one 
                input.removeLast();
                curr = input.peekLast();
                return new ArrayList<>(curr.childrenSet);
            }

            // Enter Case
            if (c == '\n') 
            {
                // Empty List
                return new ArrayList<>();
            }

            // Return error if char is not uppercase A-Z
            if (c < 'A' || c > 'Z')
            {
                return new ArrayList<>();
            }

            // Since tries are like trees and we reach null this is an error
            if (curr == null) {
                input.push(null);
                return new ArrayList<>();
            }

            // Get char index, 
            int index = c - 'A';

            // Output before iterating to children set
            List<Character> result = new ArrayList<>(curr.childrenSet);

            // continue iterating through to children 
            curr = curr.children[index];
            input.push(curr);

            return result;

        
    }

    public static void main(String[] args)
    {
        TicketMachine example = new TicketMachine(new String[] {"DELHI", "BANGALORE", "MUMBAI", "CHENNAI", "GURGAON"} );

        System.out.println(example.question('M'));
        System.out.println(example.question('U'));
        System.out.println(example.question('M'));
        System.out.println(example.question('B'));
        System.out.println(example.question('A'));
        System.out.println(example.question('I'));
        System.out.println(example.question('\n'));

        //
    }

}
class TrieNode
{
    // Array Implementation is faster for A-Z alphabet
    TrieNode[] children = new TrieNode[26];

    // Since we used an array, we need some easy way to find children

    Set<Character> childrenSet = new HashSet<>();
    boolean completeWord = false;

}