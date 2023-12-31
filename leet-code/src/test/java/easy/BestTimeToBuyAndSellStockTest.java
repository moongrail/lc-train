package easy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class BestTimeToBuyAndSellStockTest {

    @ParameterizedTest
    @MethodSource("provideTestData")
    void maxProfit(int[] array, int excepted) {
        int i = BestTimeToBuyAndSellStock.maxProfit(array);
        assertEquals(excepted, i);
    }

    private static Stream<Arguments> provideTestData() {
        return Stream.of(
                Arguments.of(
                        new int[]{7, 1, 5, 3, 6, 4},
                        5
                ),
                Arguments.of(
                        new int[]{7, 6, 4, 3, 1},
                        0
                ));
    }
}