package com.ly.leetcode;

/**
 * 思路：运用两次二分查找
 * @author ly.
 * @date 2021/6/29
 */
public class Question74 {
    public static boolean searchMatrix(int[][] matrix, int target)
    {
        int start, end = matrix.length - 1, mid, rowIndex = -1;
        while (rowIndex < end)
        {
            mid = rowIndex + (end - rowIndex+1) / 2;
            if (matrix[mid][0] == target)
            {
                return true;
            }
            if (matrix[mid][0] < target)
            {
                rowIndex = mid;
            } else if (matrix[mid][0] > target)
            {
                end = mid-1;
            }
        }

        if (rowIndex > -1)
        {
            start = 0;
            end = matrix[rowIndex].length - 1;
            while (start <= end)
            {
                mid = start + (end - start) / 2;
                if (matrix[rowIndex][mid] == target)
                {
                    return true;
                }
                if (matrix[rowIndex][mid] > target)
                {
                    end = mid - 1;
                } else
                {
                    start = mid + 1;
                }
            }
        }
        return false;
    }

    public static void main(String[] args)
    {
        int[][] matrix =
                {
                        { 1, 3, 5, 7 },
                        { 10, 11, 16, 20 },
                        { 23, 30, 34, 60 } };
        System.out.println(searchMatrix(matrix, 13));
    }
}
