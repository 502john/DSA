from collections import deque, defaultdict

class Solution:
    def findShortestPath(self, dictionary, start, end ):
        graph = self.buildGraph(dictionary)

         
        # Implement BFS
        # BFS = PreOrder DFS but with queue
        q = deque()
        seen = set()

        q.append((start, 0))
        while (len(q) > 0 ):

                # Deal with Root
                curr, step = q.popleft()
                if (curr == end):
                    return step
                if (curr in seen):
                    continue
                
                seen.add(curr)
            

                # Iterate through Children
                for child in graph[curr]:
                    # Update steps here
                    q.append((child, step + 1))

        # Incase we never find end
        return -1 
    


	


 

    # O(n^2) Time complexity for comparing each pair
    def buildGraph( self, dictionary ): 
        # Building Adjacency List
        # key : [set of values]
        graph = defaultdict(set)

        for i in range(len(dictionary)):
                # Skip Duplicate comparisons
                for j in range(i + 1, len(dictionary)):
                    key = dictionary[i]
                    value = dictionary[j]

                    if key != value and self.offByOne(key, value):
                        graph[key].add(value)
                        graph[value].add(key)
                    

        return graph

        
    # O(k) where k is the size of each word 
    def offByOne(self, first_word, second_word):
            count = 0
            for x, y in zip(first_word, second_word):
                if x != y:
                    count = count + 1
            return count == 1

ans = Solution()
dictionary = ["boat", "moat", "most", "mist", "mast", "miso"]
print(ans.findShortestPath(dictionary, "boat", "miso"))