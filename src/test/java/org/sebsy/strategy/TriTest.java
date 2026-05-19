package org.sebsy.strategy;

import org.junit.Test;

import junit.framework.TestCase;

public class TriTest extends TestCase {

    @Test
    public void testBubbleSortStrategy() {
        Integer[] arr = {12, -5, 7, 0, 8, 4, -3, 9, 15};
        Tri tri = new Tri(new BubbleSortStrategy());

        tri.trier(arr);

        assertSorted(arr);
    }

    @Test
    public void testInsertionSortStrategy() {
        Integer[] arr = {12, -5, 7, 0, 8, 4, -3, 9, 15};
        Tri tri = new Tri(new InsertionSortStrategy());

        tri.trier(arr);

        assertSorted(arr);
    }

    @Test
    public void testSelectionSortStrategy() {
        Integer[] arr = {12, -5, 7, 0, 8, 4, -3, 9, 15};
        Tri tri = new Tri(new SelectionSortStrategy());

        tri.trier(arr);

        assertSorted(arr);
    }

    @Test
    public void testExecWithType() {
        Integer[] arr = {12, -5, 7, 0, 8, 4, -3, 9, 15};
        Tri tri = new Tri();

        tri.exec(1, arr);
        assertSorted(arr);
    }

    private void assertSorted(Integer[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            assertTrue(arr[i] <= arr[i + 1]);
        }
    }
}
