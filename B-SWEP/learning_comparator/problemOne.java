/*******
// Notes
Call out questions with a bunch of edge cases to not waste time on them
List out edge cases

SHOW Object oriented solutions



Write a function that evaluates a mathematical expression written in postfix notation.

Usually we write mathematical expressions as 1 * 2 + 3. Postfix notation, has the
operator after the operands, i.e. 1 2 * 3 +.

Expression: 1 2 *
Result: 1 * 2 = 2

Expression: 1 2 * 3 +
Result: (1 * 2) + 3 = 5

Note that operators may not always be next to their operands, multiple operators can appear sequentially, and multiple numbers can appear sequentially in more than one place. The following expressions are also valid:

Expression: 1 1 1 1 + + +
Result: 1 + 1 + 1 + 1 = 4

Expression: 2 3 5 * +
Result: 2 + (3 * 5) = 17

Expression: 1 2 * 3 2 * +
Result: (1 * 2) + (3 * 2) = 8

Add an assignment operator and support for variables, for example:
  a 5 = a a * sets a to 5, and the result should be 25.


Assumptions/requirements:
- The input type is an array of strings
- Support the 4 basic arithmetic operations ( + - * / ), but make it flexible to
  extension, e.g. if a new operation like ^, %, or 1/x wants to be added later.
- Supporting integers only is fine

*/////


import java.io.*;
import java.util.*;
import java.lang.*;

// Main class should be named 'Solution' and should not be public.
class Solution {
    public static void main(String[] args) 
    {
        System.out.println("Hello, World");
    }
    
    // https://docs.oracle.com/javase/8/docs/api/java/util/Deque.html
    
    // Input: 10 13 +
    
    /*
    
    Method 1:
    // No setters on purpose
    class Entry {
        private int number;
        private String variable;
        private boolean isNumber;
        public Entry(int number) {
            this.number = number;
            isNumber = true;
        }
        public Entry(String variable) {
            ...
        }
        public int number();
        public String variable();
        public boolean isNumber();
    }
        Deque<Entry> stack = 
    
    Method 2:
    Another approach: 
        public record Entry(Integer number, String variable) {}
        Entry x = new Entry(null, "a");
        x.number()
        x.variable()
        
    
    Method 3:
    
    Using two stacks, trickier 
    one string and one number stack

    */
    
    // Good practice to make classes immutable, records are immutable




    public record Entry(Integer number, String variable) {}

    public static int answer(List<String> input)
    {
        // Initialize a "stack"
        Deque<Entry> stack = new LinkedList<>();
        HashMap<String, Integer> lookup = new HashMap<>();
        

        
        // Iterate through the input
        for (String value : input)
        {
            // = Operator Consumes input
            if (value.equals("="))
            {
                // Make the calculation 
                int right = stack.pop().number();
                
                // Identify the variable
                String left = stack.pop().variable();
                
                // Add to the look up table
                lookup.add(left, right);

            }
            
            if ( value.equals("+") )
            {
                int right = stack.pop().number();
                int left =  stack.pop().number();
                stack.push(left + right);
            }
            else if ( value.equals("-"))
            {
                int right = stack.pop();
                int left =  stack.pop();
                stack.push(left - right);
        
            }
            
            else if ( value.equals("*"))
            {
                int right = stack.pop();
                int left =  stack.pop();
                stack.push(left * right);
                
            }
            
            else if ( value.equals("/"))
            {
                int right = stack.pop();
                int left =  stack.pop();
                
                if (right == 0)
                {
                    // throw DivisionByZero;
                    return -1;
                }
                
            }
            // 
            else
            {
                stack.push(Integer.parseInt(value));
            }
        }
        
        return stack.pop();
        
        
        
        
        
        
        
        
        
        return 0;
    }

    
    
    
}
