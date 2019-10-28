import java.util.Date;
import java.util.HashSet;

//public class EightQueen {
//
//    private static int count = 0;
//
//    public static void main(String[] args) {
//        int[] test = new int[8];
//        test[0] = 0;
//        test[1] = 2;
//        int[] result = choice(test, 2);
//
//        for (int i = 0; i < result.length; i++) {
//            System.out.println(result[i]);
//        }
//    }
//
//    public static void command(int[] queens, int index) {
//        for (int i = 0; i < queens.length; i++) {
//
//        }
//    }
//
//    public static int[] choice(int[] queens, int index) {
//        if (index == 0) {
//            return new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8};
//        }
//        HashSet<Integer> hashSet = new HashSet<>();
//        for (int i = 0; i < index; i++) {
//            int current = queens[i];
//            hashSet.add(current);
//            hashSet.add(current + 1);
//            hashSet.add(current - 1);
//        }
//        if (hashSet.size() == 8) {
//            return null;
//        }
//        int[] result = new int[9 - hashSet.size()];
//        int j = 0;
//        for (int i = 0; i < 8; i++) {
//            if (!hashSet.contains(i)) {
//                result[j] = i;
//                j++;
//            }
//        }
//        return result;
//    }
//}

public class EightQueen {
    private static final short K = 15;        //使用常量来定义，方便之后解N皇后问题
    private static int count = 0;            //结果计数器
    private static short N = 8;

    public static void main(String[] args) {
//        for (N = 9; N <= K; N++) {
        Date begin = new Date();
        /**
         * 初始化棋盘，使用一维数组存放棋盘信息
         * chess[n]=X:表示第n行X列有一个皇后
         */
        short chess[] = new short[N];
        for (int i = 0; i < N; i++) {
            chess[i] = 0;
        }

        putQueenAtRow(chess, (short) 0);
        Date end = new Date();
        System.out.println("解决 " + N + "皇后问题，用时：" + String.valueOf(end.getTime() - begin.getTime()) + "毫秒，计算结果：" + count);
//        }
    }

    private static void putQueenAtRow(short[] chess, short row) {
        /**
         * 递归终止判断：如果row==N，则说明已经成功摆放了8个皇后
         * 输出结果，终止递归
         */
        if (row == N) {
            count++;
            return;
        }

        short[] chessTemp = chess.clone();

        /**
         * 向这一行的每一个位置尝试排放皇后
         * 然后检测状态，如果安全则继续执行递归函数摆放下一行皇后
         */
        for (short i = 0; i < N; i++) {
            //摆放这一行的皇后
            chessTemp[row] = i;

            if (isSafety(chessTemp, row, i)) {
                putQueenAtRow(chessTemp, (short) (row + 1));
            }
        }
    }

    private static boolean isSafety(short[] chess, short row, short col) {
        //判断中上、左上、右上是否安全
        short step = 1;
        for (short i = (short) (row - 1); i >= 0; i--) {
            if (chess[i] == col)    //中上
                return false;
            if (chess[i] == col - step)    //左上
                return false;
            if (chess[i] == col + step)    //右上
                return false;

            step++;
        }

        return true;
    }
}
