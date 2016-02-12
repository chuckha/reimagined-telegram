package misc;

public class SpiralPrint {

    public static void main(String[] args) {
        int[][] matrix = new int[5][6];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = i * j + j;
            }
        }
    }
}
