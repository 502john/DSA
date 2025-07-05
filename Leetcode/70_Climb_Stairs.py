class Solution(object):
    def climbStairs(self, n):
        """
        :type n: int
        :rtype: int
        """
        def recFib(n, memo):
            if n < 0:
                return 0

            # Not seen before
            if memo[n] == -1:
                memo[n - 1] = recFib(n - 1, memo)
                memo[n - 2] = recFib(n - 2, memo)
                memo[n] = memo[n-1] + memo[n - 2]
                return memo[n]
            
            return memo[n]
        
        memo = [-1] * (n + 1)
        memo[0] = 1
        memo[1] = 1

        return recFib(n, memo)



