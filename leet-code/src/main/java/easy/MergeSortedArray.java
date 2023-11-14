package easy;

public class MergeSortedArray {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int sumLength = m + n;
        if (nums1.length != sumLength) return;
        if (nums2.length != n) return;
        if (m < 0 || 200 < m || 200 < n) return;
        if (sumLength < 1 || sumLength > 200) return;

        if (m == 0) {
            System.arraycopy(nums2, 0, nums1, m, n);
        } else if (n != 0) {
            System.arraycopy(nums2, 0, nums1, m, n);
            quickSort(nums1, 0, sumLength - 1);
        }
    }

    private static void quickSort(int[] nums1, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(nums1, low, high);
            // СОРОК МЕГАБУТОВ ПАМЯТИ ЦЕЛЫХ АЙ ЯЙ. Runtime
            //Java
            //0 ms
            //41.5 MB
            quickSort(nums1, pivotIndex + 1, high);
            quickSort(nums1, low, pivotIndex - 1);
        }
    }

    private static int partition(int[] nums1, int low, int high) {
        int pivot = nums1[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (nums1[j] <= pivot) {
                i++;

                int temp = nums1[i];
                nums1[i] = nums1[j];
                nums1[j] = temp;
            }
        }

        int temp = nums1[i + 1];
        nums1[i + 1] = nums1[high];
        nums1[high] = temp;

        return i + 1;
    }
}

