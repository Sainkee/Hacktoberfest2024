public class nqueen {

    public static void main(String[] args) {
        int n = 5;
        int mat[][] = new int[n][n];
        int row = 0;
        System.out.println(solve(n, mat, row));
    }

    public static int solve(int n, int[][] mat, int r) {

        if (r == n) {

            printans(mat);
            System.err.println();
            return 1;

        }

        int count = 0;

        for (int i = 0; i < n; i++) {

            if (issafe(mat, r, i)) {
                mat[r][i] = 1;
                count += solve(n, mat, r + 1);
                mat[r][i] = 0; // backtrack
            }

        }

        return count;

    }

    public static boolean issafe(int[][] mat, int r, int c) {

        for (int i = 0; i < r; i++) {
            if (mat[i][c] == 1) {
                return false;
            }

        }

        int maxleft = Math.min(r, c);
        for (int i = 1; i <= maxleft; i++) {

            if (mat[r - i][c - i] == 1) {
                return false;

            }

        }

        int maxright = Math.min(r, mat.length - c - 1);
        for (int i = 1; i <= maxright; i++) {
            if (mat[r - i][c + i] == 1) {
                return false;
            }
        }

        return true;
    }

    public static void printans(int mat[][]) {
        for (int[] r : mat) {
            for (int val : r) {
                if (val == 1) {
                    System.out.print("Q ");

                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
    }
}
