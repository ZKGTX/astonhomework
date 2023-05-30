package com.trch.homework;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SorterTest {

    @Test
    @DisplayName("Сортировать список с помощью Comparable")
    public void sortWithComparable () {
        CustomArrayList<Integer> list = new CustomArrayList<>(new Integer[] {9, 5, 13, -2, 0, -56});
        Sorter.sortByComparable(list);
        Integer[] resultArray = new Integer[list.size()];
        for (int i = 0; i < list.size(); i++) {
            resultArray[i] = list.get(i);
        }
        assertArrayEquals(new Integer[] {-56, -2, 0, 5, 9, 13}, resultArray);
    }

    @Test
    @DisplayName("Сортировать список с помощью Comparator")
    public void sortWithComparator () {
        CustomArrayList<String> list = new CustomArrayList<>();
        Comparator<String> comparator = Comparator.comparing(String::length);
        list.add("Amsterdam");
        list.add("Moscow");
        list.add("Tokyo");
        list.add("Saint-Petersburg");
        Sorter.sortByComparator(list, comparator);
        assertEquals("Tokyo", list.get(0));
        assertEquals("Moscow", list.get(1));
        assertEquals("Amsterdam", list.get(2));
        assertEquals("Saint-Petersburg", list.get(3));
    }
}
