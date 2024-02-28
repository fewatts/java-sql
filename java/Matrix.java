public class Matrix {

    public static int determinant(int[][] matrix) {
        int matrixSize = matrix.length;

        if (matrixSize == 1) {
            return matrix[0][0];
        }

        if (matrixSize == 2) {
            return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
        }

        int determinant = 0;
        int sign = 1;
        for (int j = 0; j < matrixSize; j++) {
            int[][] minorMatrix = getMinor(matrix, 0, j);
            determinant += sign * matrix[0][j] * determinant(minorMatrix);
            sign = -sign;
        }
        return determinant;
    }

    private static int[][] getMinor(int[][] matrix, int rowToRemove, int colToRemove) {
        int matrixSize = matrix.length;
        int[][] minor = new int[matrixSize - 1][matrixSize - 1];
        int minorRow = 0;
        for (int row = 0; row < matrixSize; row++) {
            if (row == rowToRemove) {
                continue;
            }
            int minorCol = 0;
            for (int col = 0; col < matrixSize; col++) {
                if (col == colToRemove) {
                    continue;
                }
                minor[minorRow][minorCol] = matrix[row][col];
                minorCol++;
            }
            minorRow++;
        }
        return minor;
    }
    
}
