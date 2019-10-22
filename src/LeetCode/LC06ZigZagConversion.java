package LeetCode;

public class LC06ZigZagConversion {

    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING", 1).equals("PINALSIGYAHRPI"));
    }

    public static String convert(String s, int numRows) {
        int count = s.length();
        if (numRows == 0) {
            return "";
        }
        if (numRows == 1){
            return s;
        }
        int base = 2 * numRows - 2;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            int index = i;
            if (i == 0 || i == numRows - 1) {
                while (index < count) {
                    sb.append(s.charAt(index));
                    index += base;
                }
            } else {
                boolean is = true;
                while (index < count) {
                    sb.append(s.charAt(index));
                    if (is) {
                        index += base - 2 * i;
                    } else {
                        index += 2 * i;
                    }
                    is = !is;
                }
            }

        }
        return sb.toString();
    }

}
