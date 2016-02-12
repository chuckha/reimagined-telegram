package misc;

public class SpiralPrint {
    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.printf("%02d ", matrix[i][j]);
            }
            System.out.println();
        }

    }

    public static void main(String[] args) {
        int[][] matrix = new int[2][2];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = i * matrix[i].length + j;
            }
        }
        printMatrix(matrix);
        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;

        int dir = 0;
        while (top <= bottom && left <= right) {
            switch (dir) {
                case 0:
                    for (int r = left; r <= right; r++)
                        System.out.printf("%02d ", matrix[top][r]);
                    top += 1;
                    break;
                case 1:
                    for (int d = top; d <= bottom; d++)
                        System.out.printf("%02d ", matrix[d][right]);
                    right -= 1;
                    break;
                case 2:
                    for (int l = right; l >= left; l--)
                        System.out.printf("%02d ", matrix[bottom][l]);
                    bottom -= 1;
                    break;
                case 3:
                    for (int u = bottom; u >= top; u--)
                        System.out.printf("%02d ", matrix[u][left]);
                    left += 1;
                    break;
            }
            dir = (dir + 1) % 4;
        }
    }
}
