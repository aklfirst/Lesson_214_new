package org.example;

import java.util.Arrays;

public class StringMethods implements StringList {

    private String[] storage;
    private int size;

    public StringMethods(int i) {
        storage = new String[10];
    }


    @Override
    public String add(String item) {
        return add(size, item);
    }

    @Override
    public String add(int index, String item) {
        checkIndex(index);
        checkItem(item);

        if (size == storage.length) {
            storage = Arrays.copyOf(storage, size + 1);
        }

        System.arraycopy(storage, index, storage, index + 1, size - index);
        storage[index] = item;
        size++;
        return item;
    }

    @Override
    public String set(int index, String item) {
        checkIndex(index);
        checkItem(item);
        storage[index] = item;
        return item;
    }

    @Override
    public String remove(String item) {
        checkItem(item);
        return remove(indexOf(item));
    }

    @Override
    public String remove(int index) {
        checkIndex(index);
        String item = storage[index];
        size--;
        if (!(index == size)) {
            System.arraycopy(storage, index + 1, storage, index, size - index);
        }
        return item;
    }

    @Override
    public boolean contains(String item) {
        return indexOf(item) > -1;
    }

    @Override
    public int indexOf(String item) {
        for (int i = 0; i < size; i++) {
            if (storage[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(String item) {
        for (int i = size - 1; i >= 0; i--) {
            if (storage[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String get(int index) {
        checkIndex(index);
        return storage[index];
    }

    @Override
    public boolean equals(StringList otherList) {
        return Arrays.equals(this.toArray(), otherList.toArray());
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        size = 0;
    }

    @Override
    public String[] toArray() {
        return Arrays.copyOf(storage, size);
    }

    private void checkItem(String item) {
        if (item == null) {
            throw new WrongItemException("Нельзя вводить пустое поле в массив!");
        }
    }

    private void checkIndex(int index) {
        if (index < 0 || index > size) {
            throw new WrongIndexException("Индекс не может быть больше размера массива либо отрицательным!");
        }
    }

}
