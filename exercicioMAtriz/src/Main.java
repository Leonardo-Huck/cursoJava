import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int[][] matrix = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        int number = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == number) {
                    System.out.println("Position: " + i + ", " + j + ":");
                    if (j > 0) System.out.println( "LEFT: " + matrix[i][j - 1]);
                    if (i > 0) System.out.println( "UP: " + matrix[i - 1][j]);
                    if (j < m - 1) System.out.println( "RIGHT: " + matrix[i][j + 1]);
                    if (i < n - 1) System.out.println( "DOWN: " + matrix[i + 1][j]);
                }
            }
        }

    }
}