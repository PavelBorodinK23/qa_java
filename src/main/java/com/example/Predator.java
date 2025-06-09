package com.example;

import java.util.List;

public interface Predator {
    List<String> eatMeat() throws Exception;
    int getKittens(); // Добавляем этот метод
}