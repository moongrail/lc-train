package easy;

import java.util.Scanner;

public class TimePalindrome {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            int count = 0;

            int maxDigits = Math.max((int) Math.log10(n - 1) + 1, (int) Math.log10(m - 1) + 1);

            for (int hour = 0; hour < n; hour++) {
                for (int minute = 0; minute < m; minute++) {
                    String hourLine = String.format("%0" + maxDigits + "d", hour);
                    String minuteLine = String.format("%0" + maxDigits + "d", minute);

                    if (hourLine.contentEquals(new StringBuilder(minuteLine).reverse())) {
                        count++;
                    }
                }
            }

            System.out.println(count);
        }
    }
}
