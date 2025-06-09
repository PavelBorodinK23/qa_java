package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class LionTest {

    @Mock
    private Predator predator;

    @Test
    void testDoesHaveManeForMale() throws Exception {
        Lion lion = new Lion("Самец", predator);
        assertTrue(lion.doesHaveMane());
    }

    @Test
    void testDoesHaveManeForFemale() throws Exception {
        Lion lion = new Lion("Самка", predator);
        assertFalse(lion.doesHaveMane());
    }

    @Test
    void testInvalidSex() {
        Exception exception = assertThrows(Exception.class, () -> new Lion("Неизвестно", predator));
        assertEquals("Используйте допустимые значения пола животного - самец или самка", exception.getMessage());
    }

    @Test
    void testGetKittens() throws Exception {
        Lion lion = new Lion("Самец", predator);
        when(predator.getKittens()).thenReturn(3);
        assertEquals(3, lion.getKittens());
    }

    @Test
    void testGetFood() throws Exception {
        Lion lion = new Lion("Самец", predator);
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        when(predator.eatMeat()).thenReturn(expectedFood);
        assertEquals(expectedFood, lion.getFood());
    }
}
