package org.example;

import java.util.*;

public class Main {

        public static void main(String[] args) {
                ArrayList<Integer> arrayList = new ArrayList<>(100000);
                StringMethods stringList = new StringMethods();

                Random random = new Random();

                random.setSeed(System.currentTimeMillis());

                for (int i = 0; i < 100000; i++) {
                        Integer r = random.nextInt(100000);
                        arrayList.add(r);
                }


                Integer[] arrayCopyForSort1 = arrayList.toArray(new Integer[arrayList.size()]);
                Integer[] arrayCopyForSort2 = arrayList.toArray(new Integer[arrayList.size()]);
                Integer[] arrayCopyForSort3 = arrayList.toArray(new Integer[arrayList.size()]);
                Integer[] arrayForQuickSort = arrayList.toArray(new Integer[arrayList.size()]);

                long start;

                start = System.currentTimeMillis();
                stringList.sort(arrayForQuickSort);
                System.out.println("quick Sort time: " + (System.currentTimeMillis() - start));

                start = System.currentTimeMillis();
                stringList.sortBubble(arrayCopyForSort1);
                System.out.println("sortBubble time: " + (System.currentTimeMillis() - start));

                start = System.currentTimeMillis();
                stringList.sortSelection(arrayCopyForSort2);
                System.out.println("sortSelection time: " + (System.currentTimeMillis() - start));

                start = System.currentTimeMillis();
                stringList.sortInsertion(arrayCopyForSort3);
                System.out.println("sortInsertion time: " + (System.currentTimeMillis() - start));


                arrayList.add(11);
                arrayList.add(12);
                arrayList.add(13);

                System.out.println("arrayList.contains(11) = " + arrayList.contains(11));
                System.out.println("arrayList.contains(13) = " + arrayList.contains(13));

        }

}
