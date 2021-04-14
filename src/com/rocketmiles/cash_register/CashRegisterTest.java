package com.rocketmiles.cash_register;

public class CashRegisterTest {
    public static void main(String[] args) {
        CashRegister register = new CashRegister();
        int[] bills = {1, 0, 3, 4, 0};
        register.put(bills);
        register.change(21);

    }
}
