package easy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static easy.RemoveElement.removeElement;
import static org.junit.jupiter.api.Assertions.*;

class RemoveElementTest {

    @ParameterizedTest
    @MethodSource("provideTestData")
    void testMerge(int[] nums1,  int val , int[] expected) {
        removeElement(nums1, val);
        assertArrayEquals(expected, nums1);
    }

    private static Stream<Arguments> provideTestData() {
        return Stream.of(
                Arguments.of(
                        new int[]{3, 2, 2, 3},
                        3,
                        new int[]{2, 2, 3, 3}
                ),
                Arguments.of(
                        new int[]{0, 1, 2, 2, 3, 0, 4, 2},
                        2,
                        new int[]{0, 1, 3, 0, 4, 2, 2, 2}
                ));
    }
}