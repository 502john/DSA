class Solution(object):
    def maxProfit(self, prices):
        """
        :type prices: List[int]
        :rtype: int
        """
        if (len(prices) == 0):
            return 0


        l = 0
        r = 1
        max_profit = 0
        
        # Right pointer travels until the end, this is the "sell" pointer 
        while (r< len(prices)):

            # Is our window profitable?

            # Yes
            if (prices[l] < prices[r]):
                profit = prices[r] - prices[l]
                max_profit = max(profit, max_profit)
            
            # No
            else:
                l = r
            
            #Move up
            r += 1
                
        return max_profit