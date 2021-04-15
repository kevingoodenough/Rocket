package com.rocketmiles.cash_register;

import java.io.Console;

public class CashRegisterMain {
    public static void main(String[] args) {
        CashRegister register = new CashRegister();

        boolean run = true;
        String input;
        Console console = System.console();

        System.out.println("Cash Register Ready");
        //************ADD CHECKING FOR MAX INT************************************
        while (run) {
            input = console.readLine().toLowerCase();
            String[] inputArr = input.split(" ");

            if (inputArr[0].equals("show")) {
                register.show(true);
            } else if (inputArr[0].equals("put")) {
                if (get5Ints(input) != null)
                    register.put(get5Ints(input));
            } else if (inputArr[0].equals("take")) {
                if (get5Ints(input) != null)
                    register.take(get5Ints(input));
            } else if (inputArr[0].equals("change")) {
                register.change(Integer.parseInt(inputArr[1]));
            } else if (inputArr[0].equals("quit")) {
                run = false;
                System.out.println(">> Goodbye");
            } else {
                System.out.println(">> Input not recognized.  Please enter show, put, take, change or quit.");
            }
        }
    }

    private static int[] get5Ints(String input) {
        try {
            String[] values = input.split(" ");
            //Index 0 of the values array will be the user entered command (ex. put, take)
            //This index will not be used to populate the int[] to be returned
            if(values.length != 6) {
                System.out.println(">> exactly 5 values must be input");
                System.out.println(">> example - put 2 4 6 8 10");
                System.out.println(">> example - take 1 2 3 4 5");
            } else {
                int[] nums = new int[values.length-1];
                for(int i = 0; i<values.length-1; i++){
                    nums[i] = Integer.parseInt(values[i+1]);
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
