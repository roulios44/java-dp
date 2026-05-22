package org.sebsy.strategy;

import java.util.Arrays;

public class DemoTri {

    public static void main(String[] args) {
        Integer[] array1 = {12, -5, 7, 0, 8, 4, -3, 9, 15};
        Integer[] array2 = {12, -5, 7, 0, 8, 4, -3, 9, 15};
        Integer[] array3 = {12, -5, 7, 0, 8, 4, -3, 9, 15};

        Tri tri = new Tri();

        System.out.println("Avec le Bubble Sort:");
        tri.exec(SortType.BUBBLE, array1);
        Arrays.stream(array1).forEach(i -> System.out.print(i + " "));

        System.out.println("\nAvec l'Insertion Sort:");
        tri.exec(SortType.INSERTION, array2);
        Arrays.stream(array2).forEach(i -> System.out.print(i + " "));

        System.out.println("\nAvec le Selection Sort:");
        tri.exec(SortType.SELECTION, array3);
        Arrays.stream(array3).forEach(i -> System.out.print(i + " "));
    }
}
