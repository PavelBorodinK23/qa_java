package com.example;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class LionParameterizedTest {
    @Mock
    private Predator predator;

    @ParameterizedTest
    @MethodSource("provideSexAndManeStatus")
    void testDoesHaveMane(String sex, boolean expectedHasMane) throws Exception {
        Lion lion = new Lion(sex, predator);
        assertEquals(expectedHasMane, lion.doesHaveMane());
    }

    private static Stream<Arguments> provideSexAndManeStatus() {
        return Stream.of(
                Arguments.of("Самец", true),
                Arguments.of("Самка", false)
        );
    }

    @ParameterizedTest
    @MethodSource("provideChildrenCounts")
    void testGetKittens(int childrenCount) throws Exception {
        when(predator.getChildrenCount()).thenReturn(childrenCount);
        Lion lion = new Lion("Самец", predator);
        assertEquals(childrenCount, lion.getKittens());
    }

    private static Stream<Arguments> provideChildrenCounts() {
        return Stream.of(
                Arguments.of(0),
                Arguments.of(1),
                Arguments.of(3),
                Arguments.of(5)
        );
    }
}
