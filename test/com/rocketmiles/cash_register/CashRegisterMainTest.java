package com.rocketmiles.cash_register;

import org.junit.jupiter.api.Test;

class CashRegisterMainTest {

    CashRegister testRegister = new CashRegister();
    int[] arr;

    @Test
    void putAndShow() {
        arr = new int[] {1, 20, 300, 4000, 5000};
        testRegister.put(arr);
        //Will show the total twice as the put method calls show() before completing
        testRegister.show(true);
    }

    @Test
    void putAndTake() {
        arr = new int[] {1, 20, 300, 4000, 5000};
        testRegister.put(arr);
        arr = new int[] {1, 3, 40, 50, 60};
        testRegister.take(arr);
    }

    @Test
    void takeTooMuch() {
        arr = new int[] {5, 10, 15, 20, 25};
        testRegister.put(arr);
        //Too many 20s
        arr = new int[] {6, 5, 5, 10, 10};
        testRegister.take(arr);
        //Too many 10s
        arr = new int[] {1, 20, 1, 1, 1};
        testRegister.take(arr);
        //Too many 5s
        arr = new int[] {1, 1, 30, 1, 1};
        testRegister.take(arr);
        //Too many 2s
        arr = new int[] {1, 1, 1, 10, 1};
        testRegister.take(arr);
        //Too many 1s
        arr = new int[] {1, 1, 1, 1, 20};
        testRegister.take(arr);
        //Too many 20s and 1s
        arr = new int[] {200, 1, 1, 1, 200};
        testRegister.take(arr);
    }

    @Test
    void make8DollarsChange() {
        arr = new int[] {0, 0, 1, 3, 2};
        testRegister.put(arr);
        testRegister.change(8);
    }

    @Test
    void make21DollarsChangeNoOnes() {
        arr = new int[] {1, 2, 3, 3, 0};
        testRegister.put(arr);
        testRegister.change(21);
    }
}