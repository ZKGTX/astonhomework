package com.trch.homework;

import com.trch.homework.CustomArrayList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CustomArrayListTest {

    @Test
    @DisplayName("Добавить элемент")
    public void add() {
        CustomArrayList<Object> list = new CustomArrayList<>();
        int initialSize = list.size();
        list.add("Element");
        int size = list.size();
        assertEquals(initialSize + 1, size);
    }

    @Test
    @DisplayName("Добавить элемент по индексу")
    public void addToIndex() {
        CustomArrayList<Object> list = new CustomArrayList<>();
        int initialSize = list.size();
        list.add("First Element", 0);
        list.add("Second Element", 0);
        int size = list.size();
        assertEquals(initialSize + 2, size);
        assertEquals("Second Element", list.get(0));
        assertEquals("First Element", list.get(1));
    }

    @Test
    @DisplayName("Получить элемент по индексу")
    public void getByIndex () {
        CustomArrayList<Object> list = new CustomArrayList<>(new String[] {"First Element", "Second Element"});
        String s1 = (String) list.get(0);
        String s2 = (String) list.get(1);
        assertEquals("First Element", s1);
        assertEquals("Second Element", s2);
    }

    @Test
    @DisplayName("Заменить элемент по индексу")
    public void setByIndex () {
        CustomArrayList<Object> list = new CustomArrayList<>(new String[] {"First Element", "Second Element"});
        String s1 = "New element";
        String s2 = "Another new element";
        list.set(s1, 0);
        list.set(s2, 1);
        assertEquals(s1, list.get(0));
        assertEquals(s2, list.get(1));
    }

    @Test
    @DisplayName("Удалить элемент по индексу")
    public void removeByIndex () {
        CustomArrayList<Object> list = new CustomArrayList<>(new Integer[] {10, 14, 29, 63});
        int initialSize = list.size();
        list.remove(1);
        list.remove(1);
        int size = list.size();
        assertEquals(initialSize - 2, size);
    }

    @Test
    @DisplayName("Удалить элемент")
    public void removeElement () {
        CustomArrayList<Object> list = new CustomArrayList<>(new String[] {"First Element", "Second Element", "Third Element"});
        int initialSize = list.size();
        list.remove("First Element");
        list.remove("Second Element");
        list.remove("Third Element");
        int size = list.size();
        assertEquals(initialSize - 3, size);
    }

    @Test
    @DisplayName("Очистить список")
    public void clearList() {
        CustomArrayList<Object> list = new CustomArrayList<>(new Integer[] {10, 14, 29, 63});
        list.clear();
        int size = list.size();
        assertEquals(0, size);
    }

    @Test
    @DisplayName("Получить размер списка")
    public void listSize() {
        CustomArrayList<Object> list = new CustomArrayList<>();
        list.add(new Object());
        int size = list.size();
        assertEquals(1, size);
    }
}
