public class EightQueen2 {

    public static int A = 13;
    public static int count = 0;

    public static void main(String[] args) {
        int[] queens = new int[A];
        for (int i = 0; i < A; i++) {
            queens[i] = 0;
        }
        solution(queens, 0);
        System.out.println(count);
    }

    public static void solution(int[] queens, int row) {
        if (row == A) {
            count++;
            return;
        }
        int[] indexQueens = queens.clone();
        for (int i = 0; i < A; i++) {
            indexQueens[row] = i;
            if (isSafety(indexQueens, row, i)) {
                solution(indexQueens, row + 1);
            }
        }
    }

    public static boolean isSafety(int[] queens, int row, int col) {
        int step = 1;
        for (int i = row - 1; i >= 0; i--) {
            if (queens[i] == col) {
                return false;
            }
            if (queens[i] == (col - step)) {
                return false;
            }
            if (queens[i] == (col + step)) {
                return false;
            }
            step++;
        }
        return true;
    }
}
