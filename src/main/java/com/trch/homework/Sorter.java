package com.trch.homework;

import java.util.Comparator;
/**
 * Класс содержит статические методы, предназначенные для сортировки {@link com.trch.homework.CustomArrayList}.
 *
 * Сортировка выполняется с помощью рекурсивного алгоритма quickSort.
 * Выбирается стержневой элемент (далее стержень), затем список разделяется на два подсписка:
 * элементы с меньшим значением располагаются перед стержнем,
 * элементы с большим значением - после него. Затем сортировка применяется рекурсивно к двум подспискам,
 * пока не дойдет до списка из одного элемента, который всегда является отсортированным.
 *
 *
 *
 * См. также {@link com.trch.homework.CustomArrayList} - список объектов.
 *
 * @author Сергей Семёнов
 * @since 29/05/23
 *
 *
 */
public class Sorter {
    /**
     * Метод сортирует список объектов с помощью пользовательского объекта Comparator.
     *
     *
     * @param list список объектов
     * @param comparator объект класса Comparator
     * @param <E> тип элементов в этом методе
     */
    public static <E> void sortByComparator(CustomArrayList<E> list, Comparator<E> comparator) {
        if (list.size() == 0) {
            return;
        }

        int left = 0;
        int right = list.size() - 1;
        quickSortByComparator(list, left, right, comparator);
    }

    /**
     * Метод сортирует список объектов реализующих интерфейс Comparable.
     *
     *
     * @param list список объектов Comparable
     *
     * @param <E> тип элементов в этом методе
     */
    public static <E extends Comparable<E>> void sortByComparable(CustomArrayList<E> list) {
        if (list.size() == 0) {
            return;
        }

        int left = 0;
        int right = list.size() - 1;
        quickSortByComparable(list, left, right);

    }
    private static <E> void quickSortByComparator(CustomArrayList<E> list, int left, int right, Comparator<E> comparator) {
        if (left < right) {
            int partitionIndex = partitionByComparator(list, left, right, comparator);

            quickSortByComparator(list, left, partitionIndex - 1, comparator);
            quickSortByComparator(list, partitionIndex + 1, right, comparator);
        }
    }

    private static <E extends Comparable<E>> void quickSortByComparable(CustomArrayList<E> list, int left, int right) {
        if (left < right) {
            int partitionIndex = partitionByComparable(list, left, right);

            quickSortByComparable(list, left, partitionIndex - 1);
            quickSortByComparable(list, partitionIndex + 1, right);
        }
    }
    private static <E extends Comparable<E>> int partitionByComparable (CustomArrayList<E> list, int left, int right) {
        E pivot = list.get(right);
        int i = (left - 1);
        for (int j = left; j < right; j++) {
            if (list.get(j).compareTo(pivot) <= 0) {
                i++;
                E temp = list.get(i);
                list.set(list.get(j), i);
                list.set(temp, j);
            }
        }
        E temp = (E) list.get(i + 1);
        list.set(list.get(right), i + 1);
        list.set(temp, right);
        return i + 1;
    }

    private static <E> int partitionByComparator (CustomArrayList<E> list, int left, int right, Comparator<E> comparator) {
        E pivot = list.get(right);
        int i = (left - 1);

        for (int j = left; j < right; j++) {
            if (comparator.compare(list.get(j), pivot) <= 0) {
                i++;
                E temp = list.get(i);
                list.set(list.get(j), i);
                list.set(temp, j);
            }
        }
        E temp = list.get(i + 1);
        list.set(list.get(right), i + 1);
        list.set(temp, right);
        return i + 1;
    }
}
