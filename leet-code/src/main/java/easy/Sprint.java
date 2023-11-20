package easy;

import java.util.Scanner;

public class Sprint {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int n = scanner.nextInt();
            int[] difficulties = new int[n];

            for (int i = 0; i < n; i++) {
                difficulties[i] = scanner.nextInt();
            }

            int left = 0;
            int right = difficulties.length - 1;
            int totalDifficulty = 0;

            while (left < right) {
                int currentDifficulty = difficulties[left] + difficulties[right];

                if (totalDifficulty == 0) {
                    totalDifficulty = currentDifficulty;
                } else if (currentDifficulty != totalDifficulty) {
                    System.out.println(-1);
                    return;
                }

                left++;
                right--;
            }

            System.out.println(totalDifficulty);
        }
    }
}
