class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        rows = [set() for i in range(10)]
        cols = [set() for i in range(10)]
        boxes = [set() for i in range(10)]

        for i in range( len(board) ):
            for j in range( len(board[i]) ):
                val = board[i][j]
                boxIndex = (i // 3) * 3 + (j // 3)

                if val == '.':
                    continue
                if (val in rows[i]) or (val in cols[j]) or (val in boxes[boxIndex]):
                    return False
                else:
                    # semi colons are allowed in python? 
                    rows[i].add(val);
                    cols[j].add(val);

                    boxes[boxIndex].add(val)

        return True
        