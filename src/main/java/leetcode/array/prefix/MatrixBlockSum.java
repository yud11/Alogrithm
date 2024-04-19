package leetcode.array.prefix;

/**
 * @autor yud1
 * @date 2024/4/16 13:15
 */
public class MatrixBlockSum {


    public int[][] matrixBlockSum(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] preMatrix = new int[m+1][n+1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                preMatrix[i][j] = preMatrix[i - 1][j] + preMatrix[i][j - 1] - preMatrix[i - 1][j - 1] + mat[i-1][j-1];
            }
        }
        int[][] answer = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int row1 = i - k < 0 ? 0: i-k;
                int row2 = i + k > m - 1 ? m-1: i+k;
                int col1 = j - k < 0 ? 0: j-k;
                int col2 = j + k > n - 1 ? n-1: j+k;
                answer[i][j] = sumRegion(row1,col1,row2,col2,preMatrix);
            }
        }
        return answer;
    }

    public int sumRegion(int row1, int col1, int row2, int col2, int[][] preMatrix) {
        return preMatrix[row2+1][col2+1] - preMatrix[row1][col2+1] - preMatrix[row2+1][col1] + preMatrix[row1][col1];
    }
}
