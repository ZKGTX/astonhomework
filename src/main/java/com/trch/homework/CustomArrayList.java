package com.trch.homework;


/**
 * Класс представляет собой список объектов с массивом в качестве структуры данных.
 *
 * Поддерживаемые операции: добавление, вставка по индексу, получение,
 * замена по индексу, удаление, удаление по индексу, очистка,
 * получение размера списка.
 *
 * См. также {@link com.trch.homework.Sorter} - класс с методами сортировки списка.
 *
 * @author Сергей Семёнов
 * @since 29/05/23
 *
 * @param <E> тип элементов в этом списке
 */
public class CustomArrayList <E> {

    private int capacity;
    private Object[] array;
    private int counter;

    /**
     * Конструктор создает пустой список с начальной вместимостью 10 и размером 0.
     */
    public CustomArrayList () {
        this.capacity = 10;
        this.array = new Object[capacity];
        this.counter = 0;
    }
    /**
     * Конструктор создает пустой список с начальной вместимостью, равной значению переданного параметра, и размером 0.
     * @param customCapacity начальная вместимость списка
     * @throws IllegalArgumentException метод выбрасывает исключение если передано отрицательное число.
     */
    public CustomArrayList (int customCapacity) {
        if (customCapacity <= 0) {
            throw new IllegalArgumentException("Размер внутреннего массива не может быть равен " + customCapacity);
        }
        this.capacity = customCapacity;
        this.array = new Object[capacity];
        this.counter = 0;
    }
    /**
     * Конструктор создает пустой список на основе переданного массива объектов. Список имеет вместимость и размер как у переданного массива.
     * @param someArray массив объектов.
     *
     */
    public CustomArrayList (E[] someArray) {
        this.capacity = someArray.length;
        this.array = someArray;
        this.counter = array.length;
    }
    /**
     * Метод добавляет элемент в конец списка. Если при этом размер списка сравняется с вместимостью, произойдет увеличение
     * вместимости в два раза.
     * @param e добавляемый элемент.
     *
     */
    public void add (E e) {
        if (isFull()) {
            resize(array.length * 2);
        }
        array[counter] = e;
        counter++;
      }

    /**
     * Метод вставляет элемент по заданному индексу. При этом происходит сдвиг элементов, находящихся правее индекса, вправо. Если при этом размер списка сравняется с вместимостью, произойдет увеличение
     * вместимости в два раза.
     * @param e добавляемый элемент.
     * @param index индекс добавляемого элемента.
     * @throws IndexOutOfBoundsException если переданный индекс выходит за рамки списка.
     *
     */
    public void add (E e, int index) {

        if (index < 0 || index > counter) {
            throw new IndexOutOfBoundsException("Индекс [" + index + "] выходит за рамки [" + counter + "]" );
        }
        if (isFull()) {
            resize(array.length * 2);
        }

        Object current = array[index];

        array[index] = e;

        Object next;

        for (int i = index; i < counter; i++) {
            next = array[i + 1];
            array[i + 1] = current;
            current = next;
        }
        counter++;
    }
    /**
     * Метод возвращает элемент списка по индексу.
     * @param index индекс возвращаемого элемента.
     * @throws IndexOutOfBoundsException если переданный индекс выходит за рамки списка.
     *
     */
    public E get(int index) {
        if (index < 0 || index > counter) {
            throw new IndexOutOfBoundsException("Индекс [" + index + "] выходит за рамки [" + counter + "]" );
        }
        return (E) array[index];
    }
    /**
     * Метод заменяет элемент списка по индексу на переданный элемент.
     * @param e переданный для замены элемент.
     * @param index индекс заменяемого элемента.
     * @throws IndexOutOfBoundsException если переданный индекс выходит за рамки списка.
     *
     */
    public void set (E e, int index) {
        if (index < 0 || index > counter) {
            throw new IndexOutOfBoundsException("Индекс [" + index + "] выходит за рамки [" + counter + "]" );
        }
        array[index] = e;
    }
    /**
     * Метод удаляет элемент списка по индексу. При этом происходит сдвиг элементов, находящихся правее удаляемого, влево.
     * @param index индекс удаляемого элемента.
     * @throws IndexOutOfBoundsException если переданный индекс выходит за рамки списка.
     *
     */
    public void remove(int index) {
        if (index < 0 || index > counter) {
            throw new IndexOutOfBoundsException("Индекс [" + index + "] выходит за рамки [" + counter + "]" );
        }
        Object [] newArray = new Object[counter - 1];
        System.arraycopy(array, 0, newArray, 0, index);
        System.arraycopy(array, index + 1, newArray, index, counter - index - 1);
        array = newArray;
        counter--;
    }
    /**
     * Метод удаляет элемент списка. При этом происходит сдвиг элементов, находящихся правее удаляемого, влево.
     * @param o удаляемый элемент.
     */
    public void remove (Object o) {
        for (int i = 0; i < counter; i++) {
            if (o.equals(array[i])) {
                Object [] newArray = new Object[counter - 1];
                System.arraycopy(array, 0, newArray, 0, i);
                System.arraycopy(array, i + 1, newArray, i, counter - i - 1);
                array = newArray;
                counter--;
                return;
                }
            }
        }
    /**
     * Метод очищает список от всех хранящихся элементов.
     */
    public void clear() {
        capacity = 1;
        array = new Object[capacity];
        counter = 0;
    }
    /**
     * Метод возвращает размер списка.
     */
    public int size() {
        return counter;
    }

    private Object[] toArray() {
        Object[] result = new Object[counter];
        System.arraycopy(array, 0, result, 0, counter);
        return result;
    }

    private void resize(int length) {
        Object[] newArray = new Object[length];
        System.arraycopy(array, 0, newArray, 0, counter);
        array = newArray;
    }

    private boolean isFull() {
        return counter == array.length;
    }
}
