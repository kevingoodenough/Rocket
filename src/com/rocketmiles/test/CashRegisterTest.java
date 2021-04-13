package com.rocketmiles.test;

import com.rocketmiles.cash_register.CashRegister;

public class CashRegisterTest {
    public static void main(String[] args) {
        CashRegister register = new CashRegister();
        int[] bills = {1, 0, 0, 0, 0};
        String str = "put 0 1 1 2 2";
        //System.out.println(Arrays.toString(bills));
        System.out.println(str.substring(0,3));
        //System.out.println(register.show());
    }
}
