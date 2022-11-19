package org.example;

import java.util.Arrays;

public class StringMethods implements StringList {

    private Integer[] storage;
    private int size;

    public StringMethods() {
        storage = new Integer[100_000];
    }

    public StringMethods(int initSize) {
        storage = new Integer[initSize];
    }

    @Override
    public Integer add(Integer item) {
        return add(size, item);
    }

    @Override
    public Integer add(int index, Integer item) {
        growIfNeeded();
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
    public Integer set(int index, Integer item) {
        checkIndex(index);
        checkItem(item);
        storage[index] = item;
        return item;
    }

    @Override
    public Integer remove(Integer item) {
        checkItem(item);
        return remove(indexOf(item));
    }

    @Override
    public Integer remove(int index) {
        checkIndex(index);
        Integer item = storage[index];
        size--;
        if (!(index == size)) {
            System.arraycopy(storage, index + 1, storage, index, size - index);
        }
        return item;
    }

    @Override
    public boolean contains(Integer item) {
        Integer[] storageCopy = toArray();
        sortBubble(storageCopy);
        return binarySearch(storageCopy, item);
    }

    @Override
    public int indexOf(int item) {
        for (int i = 0; i < size; i++) {
            if (storage[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Integer item) {
        for (int i = size - 1; i >= 0; i--) {
            if (storage[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public Integer get(int index) {
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
    public Integer[] toArray() {
        return Arrays.copyOf(storage, size);
    }

    private void checkItem(Integer item) {
        if (item == null) {
            throw new WrongItemException("Нельзя вводить пустое поле в массив!");
        }
    }

    private void checkIndex(int index) {
        if (index < 0 || index > size) {
            throw new WrongIndexException("Индекс не может быть больше размера массива либо отрицательным!");
        }
    }


    public void sortBubble(Integer[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int j;
            for (j = 0; j < array.length - 1 - i; j++) ;
            if (array[j] > array[i + 1]) {
                growIfNeeded();
                swapElements(array, j, j + 1);
            }
        }
    }

    public void sortSelection(Integer[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int minElementIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minElementIndex]) {
                    minElementIndex = j;
                }
            }
            swapElements(array, i, minElementIndex);
        }
    }

    public void sortInsertion(Integer[] array) {
        for (int i = 1; i < array.length; i++) {
            int temp = array[i];
            int j = i;
            while (j > 0 && array[j - 1] >= temp) {
                array[j] = array[j - 1];
                j--;
            }
            array[j] = temp;
        }
    }

   public void sort (Integer[] array){
        quickSort(array,0,array.length-1);

    }

    private void quickSort(Integer[] array, int begin, int end) {
        if(begin < end) {
            int partitionIndex = partition (array,begin,end);

            quickSort(array,begin,partitionIndex-1);
            quickSort(array,partitionIndex+1,end);
        }

    }

    private int partition(Integer[] array, int begin, int end) {
        int pivot = array[end];
        int i = (begin - 1);

        for (int j = begin; j < end; j++) {
            if (array[j] <= pivot) {
                i++;

                swapElements(array, i, j);
            }
        }
        swapElements(array, i + 1, end);
        return i + 1;
    }

    private void swapElements(Integer[] array, int i1, int i2) {
        int temp = array[i1];
        array[i1] = array[i2];
        array[i2] = temp;

    }



    private boolean binarySearch(Integer[] arr, int item) {
        int min = 0;
        int max = arr.length - 1;

        while (min <= max) {
            int mid = (min + max) / 2;

            if (item == arr[mid]) {
                return true;
            }

            if (item < arr[mid]) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return false;
    }

    private void grow() {
        storage = Arrays.copyOf(storage, size + size / 2);
    }

        private void growIfNeeded() {
            if (size == storage.length) {
                grow();
            }
        }


}



