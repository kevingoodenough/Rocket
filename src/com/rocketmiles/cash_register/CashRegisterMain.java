package com.rocketmiles.cash_register;

import java.io.Console;

public class CashRegisterMain {
    public static void main(String[] args) {
        CashRegister register = new CashRegister();

        boolean run = true;
        String input;
        Console console = System.console();

        System.out.println("Cash Register Ready");

        while (run) {
            input = console.readLine();
            if (input.equals("show")) {
                register.show();
            } else if (input.substring(0, 3).equals("put")) {
                register.put(get5Ints(input, 4));
            } else if (input.substring(0, 4).equals("take")) {
                register.take(get5Ints(input, 5));
            } else if (input.equals("change")) {
                System.out.println("change");
            } else if (input.equals("quit")) {
                run = false;
            } else {
                System.out.println(">> Input not recognized.  Please enter show, put, take, change or quit.");
            }
        }
    }

    private static int[] get5Ints(String input, int startingIndex) {
        try {
            String[] values = input.substring(startingIndex,input.length()).split(" ");
            if(values.length != 5) {
                System.out.println(">> exactly 5 values must be input");
            } else {
                int[] nums = new int[values.length];
                for(int i = 0; i<values.length; i++){
                    nums[i] = Integer.parseInt(values[i]);
                }
                return nums;

            }
        }
        catch(Exception e) {
            System.out.println(">> put format incorrect");
            System.out.println(">> example - put 1 2 1 4 1");
        }
        return null;
    }
}
