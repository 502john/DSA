class Solution {
    public int evalRPN(String[] tokens) 
    {   
        HashSet<String> operatorSet = new HashSet<>();
        operatorSet.add("+"); 
        operatorSet.add("-"); 
        operatorSet.add("*"); 
        operatorSet.add("/"); 

        Stack<Integer> stack = new Stack<>();

        // Iterate through every token
        for ( String s : tokens )
        {
            // If Number
            if (!operatorSet.contains(s))
            {
                stack.push(Integer.parseInt(s));
            }

            // If operator
            else
            {
                int right = stack.pop();
                int left = stack.pop();
                char op = s.charAt(0);

                if (op == '+')
                {
                    stack.push(left + right);
                }
                else if (op == '-')
                {
                    stack.push(left - right);
                }
                else if (op == '*')
                {
                    stack.push(left * right);
                }
                else 
                {
                    stack.push(left / right);
                }
            }
        
        }
        return stack.pop();
        
        
    }



}