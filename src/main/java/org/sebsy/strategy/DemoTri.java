package org.sebsy.strategy;

import java.util.Arrays;

public class DemoTri {

    public static void main(String[] args) {
        Integer[] array1 = {12, -5, 7, 0, 8, 4, -3, 9, 15};
        Integer[] array2 = {12, -5, 7, 0, 8, 4, -3, 9, 15};
        Integer[] array3 = {12, -5, 7, 0, 8, 4, -3, 9, 15};

        Tri tri = new Tri(new BubbleSortStrategy());
        System.out.println("Avec le Bubble Sort:");
        tri.trier(array1);
        Arrays.stream(array1).forEach(i -> System.out.print(i + " "));

        tri.setStrategie(new InsertionSortStrategy());
        System.out.println("\nAvec l'insertion Sort:");
        tri.trier(array2);
        Arrays.stream(array2).forEach(i -> System.out.print(i + " "));

        tri.setStrategie(new SelectionSortStrategy());
        System.out.println("\nAvec le selection Sort:");
        tri.trier(array3);
        Arrays.stream(array3).forEach(i -> System.out.print(i + " "));
    }
}
