// Last updated: 5/26/2026, 12:33:56 PM
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        int top = 0;
        int bottom = m - 1;
        int left = 0;
        int right = n - 1;

        // Start going in a Spiral
        while (top <= bottom && left <= right) 
        {
            // Go from left to right
            for (int j = left; j <= right; j++) 
            {
                list.add(matrix[top][j]);
            }
            top++;

            // Go from top to bottom
            for (int i = top; i <= bottom; i++) 
            {
                list.add(matrix[i][right]);
            }
            right--;

            // Go from right to left
            if (top <= bottom) 
            {
                for (int j = right; j >= left; j--) 
                {
                    list.add(matrix[bottom][j]);
                }
                bottom--;
            }

            // Go from bottom to top
            if (left <= right) 
            {
                for (int i = bottom; i >= top; i--) 
                {
                    list.add(matrix[i][left]);
                }
                left++;
            }
        }

        return list;
    }
}