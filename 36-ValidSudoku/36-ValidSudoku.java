// Last updated: 5/26/2026, 12:34:14 PM
class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<Character>[] rows = new HashSet[9];
        HashSet<Character>[] cols = new HashSet[9];
        HashSet<Character>[][] boxes = new HashSet[3][3];

        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                boxes[i][j] = new HashSet<>();
            }
        }

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                char val = board[r][c];
                if (val == '.') continue;

                if (rows[r].contains(val) || cols[c].contains(val) || boxes[r / 3][c / 3].contains(val)) {
                    return false;
                }

                rows[r].add(val);
                cols[c].add(val);
                boxes[r / 3][c / 3].add(val);
            }
        }

        return true;
    }
}