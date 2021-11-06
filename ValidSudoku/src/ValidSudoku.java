import java.util.HashSet;

class ValidSudoku {
    public static void main(String[] args) {
        try {
            ValidSudoku obj = new ValidSudoku();
            obj.run(args);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void run(String[] run) {
        char[][] sudokuBoard = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'}
                , {'6', '.', '.', '1', '9', '5', '.', '.', '.'}
                , {'.', '9', '8', '.', '.', '.', '.', '6', '.'}
                , {'8', '.', '.', '.', '6', '.', '.', '.', '3'}
                , {'4', '.', '.', '8', '.', '3', '.', '.', '1'}
                , {'7', '.', '.', '.', '2', '.', '.', '.', '6'}
                , {'.', '6', '.', '.', '.', '.', '2', '8', '.'}
                , {'.', '.', '.', '4', '1', '9', '.', '.', '5'}
                , {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        System.out.println(isValidSudoku(sudokuBoard));
    }

    public boolean isValidSudoku(char[][] board) {
        for (int y = 0; y < 9; y++) {
            HashSet<Character> holdUsedVals = new HashSet<Character>();
            for (int x = 0; x < 9; x++) {
                if (holdUsedVals.contains(board[y][x])) {
                    return false;
                }
                if (board[y][x] != '.') {
                    holdUsedVals.add(board[y][x]);
                }
            }
        }

        for (int x = 0; x < 9; x++) {
            HashSet<Character> holdUsedVals = new HashSet<Character>();
            for (int y = 0; y < 9; y++) {
                if (holdUsedVals.contains(board[y][x])) {
                    return false;
                }
                if (board[y][x] != '.') {
                    holdUsedVals.add(board[y][x]);
                }
            }
        }
        int[][] holdMiniBoxCorners = new int[][]{{0, 0}, {0, 3}, {0, 6}, {3, 0}, {3, 3}, {3, 6}, {6, 0}, {6, 3}, {6, 6}};
        for (int currentBox = 0; currentBox < 9; currentBox++) {
            int topYCoord = holdMiniBoxCorners[currentBox][0];
            int topXCoord = holdMiniBoxCorners[currentBox][1];
            HashSet<Character> holdUsedVals = new HashSet<Character>();
            for (int y = topYCoord; y <= topYCoord + 2; y++) {
                for (int x = topXCoord; x <= topXCoord + 2; x++) {
                    if (holdUsedVals.contains(board[y][x])) {
                        return false;
                    }
                    if (board[y][x] != '.') {
                        holdUsedVals.add(board[y][x]);
                    }
                }
            }
        }
        return true;
    }
}