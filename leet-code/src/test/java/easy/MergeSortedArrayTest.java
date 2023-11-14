package easy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class MergeSortedArrayTest {

    @ParameterizedTest
    @MethodSource("provideTestData")
    void testMerge(int[] nums1, int m, int[] nums2, int n, int[] expected) {
        MergeSortedArray.merge(nums1, m, nums2, n);
        assertArrayEquals(expected, nums1);
    }

    private static Stream<Arguments> provideTestData() {
        return Stream.of(
                Arguments.of(
                        new int[]{1, 2, 3, 0, 0, 0},
                        3,
                        new int[]{2, 5, 6},
                        3,
                        new int[]{1, 2, 2, 3, 5, 6}
                ),
                Arguments.of(
                        new int[]{0, 0, 0},
                        0,
                        new int[]{2, 5, 6},
                        3,
                        new int[]{2, 5, 6}
                ),
                Arguments.of(
                        new int[]{1, 2, 3},
                        3,
                        new int[]{},
                        0,
                        new int[]{1, 2, 3}
                ),
                Arguments.of(
                        new int[]{},
                        0,
                        new int[]{},
                        0,
                        new int[]{}
                )
        );
    }
}