package com.rocketmiles.cash_register;

public class CashRegister {
    private int[] bills;

    //Constructor
    public CashRegister() {
        bills = new int[] {0, 0, 0, 0, 0};
    }

    //Show - displays the amount of all bills in the register and the quantity of
    //twenty, ten, five, two, and one dollar bills respectively
    void show() {
        String out = "$";
        out += total(this.bills);
        out = out + " " + bills[0] + " " + bills[1] + " " + bills[2] + " " + bills[3] + " " + bills[4];
        System.out.println(out);
    }

    //Puts the given quantities of bills into the register and adds them to the previous register total.
    //Calls the show function to display register total after adding the given bills
    //Example command - "put 3 5 3 5 1"
    void put(int[] arr) {
        for(int i = 0; i <5; i++) {
            this.bills[i] += arr[i];
        }
        this.show();
    }

    //Takes the given quantities of bills from the register and subtracts them from the previous register total.
    //Calls the show function to display register total after subtracting the given bills
    //If the requested number of a specific bill is not available, nothing is removed from that said bill
    //Example command - "put 3 5 3 5 1"
    void take(int[] arr) {
        for(int i = 0; i <5; i++) {
            //Take bills if there are at least the requested amount available.  Otherwise, take none.
            if(this.bills[i] >= arr[i])
                this.bills[i] -= arr[i];
            else
                System.out.println(">> No " + dollarName(i) + " dollar bills will be taken as the requested amount is not available.");
        }
        this.show();
    }



    //MAKE PRIVATE OR SOMETHING ELSE THAT CAN STILL BE ACCESSED BY TESTS
    //Calculates the total dollar amount in the register
    int total(int[] arr) {
        int total = 0;
        total += arr[0] * 20;
        total += arr[1] * 10;
        total += arr[2] * 5;
        total += arr[3] * 2;
        total += arr[4];
        return total;
    }

    //Used to return the name of each bill given the index of the registers bills array
    private String dollarName(int x) {
        if(x==0)
            return "twenty";
        else if(x==1)
            return "ten";
        else if(x==2)
            return "five";
        else if(x==3)
            return "two";
        else if(x==4)
            return "one";
        return null;
    }
}
