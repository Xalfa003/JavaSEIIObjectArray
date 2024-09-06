package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PFArraysTest {

    @BeforeEach
    void setup() {
        // Сбрасываем массивы и индекс выбранного массива перед каждым тестом
        PFArrays.arrays = new ArrayList<>();
        PFArrays.selectedIndex = null;
    }

    @Test
    void testCreateArrayWithRandomValues() {
        PFArray pfArray = new PFArray();
        pfArray.createArray(null);
        assertEquals(10, pfArray.getArray().size(), "Array should contain 10 elements.");
    }

    @Test
    void testCreateArrayWithManualValues() {
        PFArray pfArray = new PFArray();
        ArrayList<Integer> manualValues = new ArrayList<>();
        manualValues.add(1);
        manualValues.add(2);
        manualValues.add(3);
        pfArray.createArray(manualValues);

        assertEquals(3, pfArray.getArray().size(), "Array should contain 3 elements.");
        assertEquals(1, pfArray.getArray().get(0));
        assertEquals(2, pfArray.getArray().get(1));
        assertEquals(3, pfArray.getArray().get(2));
    }

    @Test
    void testAddNumber() {
        PFArray pfArray = new PFArray();
        pfArray.createArray(null);
        int sizeBefore = pfArray.getArray().size();
        pfArray.addNumber(50);

        assertEquals(sizeBefore + 1, pfArray.getArray().size(), "Array size should increase by 1 after adding a number.");
        assertTrue(pfArray.getArray().contains(50), "Array should contain the added number.");
    }

    @Test
    void testFindMax() {
        PFArray pfArray = new PFArray();
        ArrayList<Integer> values = new ArrayList<>();
        values.add(10);
        values.add(50);
        values.add(30);
        pfArray.createArray(values);

        assertEquals(50, pfArray.findMax(), "Max value should be 50.");
    }

    @Test
    void testFindMin() {
        PFArray pfArray = new PFArray();
        ArrayList<Integer> values = new ArrayList<>();
        values.add(10);
        values.add(5);
        values.add(30);
        pfArray.createArray(values);

        assertEquals(5, pfArray.findMin(), "Min value should be 5.");
    }

    @Test
    void testSumAll() {
        PFArray pfArray = new PFArray();
        ArrayList<Integer> values = new ArrayList<>();
        values.add(10);
        values.add(20);
        values.add(30);
        pfArray.createArray(values);

        assertEquals(60, pfArray.sumAll(), "Sum of all elements should be 60.");
    }

    @Test
    void testRemoveNumber() {
        PFArray pfArray = new PFArray();
        ArrayList<Integer> values = new ArrayList<>();
        values.add(10);
        values.add(20);
        values.add(30);
        pfArray.createArray(values);

        pfArray.removeNumber(20);

        assertFalse(pfArray.getArray().contains(20), "Array should not contain removed number 20.");
        assertEquals(2, pfArray.getArray().size(), "Array size should decrease by 1 after removing a number.");
    }

    @Test
    void testClearArray() {
        PFArray pfArray = new PFArray();
        pfArray.createArray(null);
        pfArray.clearArray();

        assertTrue(pfArray.getArray().isEmpty(), "Array should be empty after calling clearArray.");
    }

    @Test
    void testFindArrayWithMaxSum() {
        PFArray array1 = new PFArray();
        array1.createArray(new ArrayList<>(List.of(1, 2, 3)));
        PFArrays.arrays.add(array1);

        PFArray array2 = new PFArray();
        array2.createArray(new ArrayList<>(List.of(10, 20, 30)));
        PFArrays.arrays.add(array2);

        PFArray array3 = new PFArray();
        array3.createArray(new ArrayList<>(List.of(5, 5, 5)));
        PFArrays.arrays.add(array3);
    }

    @Test
    void testFindArrayWithMinSum() {
        PFArray array1 = new PFArray();
        array1.createArray(new ArrayList<>(List.of(1, 2, 3)));
        PFArrays.arrays.add(array1);

        PFArray array2 = new PFArray();
        array2.createArray(new ArrayList<>(List.of(10, 20, 30)));
        PFArrays.arrays.add(array2);

        PFArray array3 = new PFArray();
        array3.createArray(new ArrayList<>(List.of(5, 5, 5)));
        PFArrays.arrays.add(array3);
    }
}

