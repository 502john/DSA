// We're going to keep a separate Trie class, and an inner private TriNode class.

public class PrefixMatcher
{
    private TrieNode root;

    // Inner class
    static class TrieNode
    {
        // No need for constructor
        TrieNode[] children = new TrieNode[26];
        boolean endOfWord = false;
        int wordsAssociated = 0;


    }

    // Constructor
    public PrefixMatcher()
    {
        this.root = new TrieNode();

    }

    // Overloaded Constructor
    public PrefixMatcher(String[] words)
    {
        this.root = new TrieNode();

        // Iterate through every single word
        for (String word : words)
        {
            // Insert each word

            insertWord(word);

        }

    }

    // The difference here is our trie will keep track of words associated with it 
    private void insertWord(String word)
    {
        TrieNode curr = root; 


        // Iterate through every single character
        for (char ch : word.toCharArray())
        {
            curr.wordsAssociated += 1;


            // Find index
            int index = ch - 'a';

            // Is our word present in the children?
            if (curr.children[index] == null)
            {
                // Add if not
                curr.children[index] = new TrieNode();
            }
            
            // Update the count associated with each word


            // Keep iterating through to more words
            curr = curr.children[index];
            
            // Update the count
            curr.wordsAssociated += 1;



        }

        curr.endOfWord = true;


    }

    public int count(String word)
    {
        TrieNode curr = this.root;

        for (char ch : word.toCharArray())
        {
            int index = ch - 'a';

            // Word is not found 
            if (curr.children[index] == null )
            {
                return 0;
            }

            curr = curr.children[index];

        }
        
        // Return the count of the last trie node ()
        return curr.wordsAssociated;
    }

}