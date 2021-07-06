package com.ly.leetcode;

/**
 *
 * @author ly.
 * @date 2021/7/4
 */
public class Question79 {
    public boolean exist(char[][] board, String word) {
        boolean flag;
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                flag = backtrack(i, j, board, visited, word, 0);
                if (flag) {
                    return flag;
                }
            }
        }
        return false;
    }

    // visited用于标识该位置是否已经被访问过
    private boolean backtrack(int rowIndex, int colIndex, char[][] board, boolean[][] visited, String word, int point) {
        if (board[rowIndex][colIndex] != word.charAt(point)) {
            return false;
        }
        if(point == word.length()-1) {
            return true;
        }
        visited[rowIndex][colIndex] = true;
        boolean result = false;
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int newi, newj;
        boolean flag;
        for (int[] dir : directions) {
            flag = false;
            newi = rowIndex + dir[0];
            newj = colIndex + dir[1];
            if (newi < board.length && newi >= 0 && newj < board[0].length && newj >= 0) {
                if (!visited[newi][newj]) {
                    flag = backtrack(newi, newj, board, visited, word, point + 1);
                }
                if (flag) {
                    result = true;
                    break;
                }
            }
        }
        visited[rowIndex][colIndex] = false;
        return result;
    }

    public static void main(String[] args) {
        char[][] arr = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String word = "ABCCED";
        System.out.println(new Question79().exist(arr, word));
    }
}
