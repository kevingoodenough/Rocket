package com.rocketmiles.cash_register;

public class CashRegister {
    private int[] bills;

    public CashRegister() {
        bills = new int[] {0, 0, 0, 0, 0};
    }

    public void show() {
        String out = "$";
        out += total(this.bills);
        out = out + " " + bills[0] + " " + bills[1] + " " + bills[2] + " " + bills[3] + " " + bills[4];
        System.out.println(out);
    }

    public void put(int[] arr) {
        for(int i = 0; i <5; i++) {
            this.bills[i] += arr[i];
        }
        this.show();
    }

    public void take(int[] arr) {
        for(int i = 0; i <5; i++) {
            if(this.bills[i] > 0)
                this.bills[i] -= arr[i];
            else
                System.out.println(">> No " + dollarName(i) + " dollar bills will be taken as there aren't any available.");
        }
        this.show();
    }

    //MAKE PRIVATE OR SOMETHING ELSE THAT CAN STILL BE ACCESSED BY TESTS
     public int total(int[] arr) {
        int total = 0;
        total += arr[0] * 20;
        total += arr[1] * 10;
        total += arr[2] * 5;
        total += arr[3] * 2;
        total += arr[4];
        return total;
    }

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
