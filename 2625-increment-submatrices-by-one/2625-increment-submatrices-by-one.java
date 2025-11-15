class Solution {
    public int[][] rangeAddQueries(int n, int[][] queries) {
        int[][] mat = new int[n][n];
        int[][] diff = new int[n + 1][n + 1];
        
        for (int[] query : queries) {
            int row1 = query[0], col1 = query[1], row2 = query[2], col2 = query[3];
            
        
            diff[row1][col1]++;
            if (col2 + 1 < n) diff[row1][col2 + 1]--;
            if (row2 + 1 < n) diff[row2 + 1][col1]--;
            if (row2 + 1 < n && col2 + 1 < n) diff[row2 + 1][col2 + 1]++;
        }
        
    
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n; j++) {
                diff[i][j] += diff[i][j - 1];
            }
        }
        
    
        for (int j = 0; j < n; j++) {
            for (int i = 1; i < n; i++) {
                diff[i][j] += diff[i - 1][j];
            }
        }
        
        // Copy to result matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                mat[i][j] = diff[i][j];
            }
        }
        
        return mat;
    }
}       
        
    
