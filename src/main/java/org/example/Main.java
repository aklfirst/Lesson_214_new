package org.example;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>(10);
        StringList stringList = new StringMethods(10);

        arrayList.add("one");
        arrayList.add("two");
        arrayList.add("three");
        stringList.add("one");
        stringList.add("two");
        stringList.add("three");
        stringList.add("four");
        stringList.add("five");
        stringList.add("six");
        stringList.add("seven");
        stringList.add("eight");
        stringList.add("nine");
        stringList.add("ten");
        stringList.add("eleven");
        stringList.remove(9);
        stringList.set(0, "0");
        stringList.set(9, "10");

        System.out.println(arrayList);
        System.out.println(Arrays.toString(stringList.toArray()));

        System.out.println("arrayList позиция #0: " + arrayList.get(0));
        System.out.println("stringArrayList позиция #10: " + stringList.get(10));


        arrayList.clear();
        stringList.clear();


        System.out.println(arrayList);
        System.out.println(Arrays.toString(stringList.toArray()));


        System.out.println("Size: " + stringList.size());
        System.out.println(stringList.isEmpty());
    }

}
