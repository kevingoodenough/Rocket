package com.rocketmiles.cash_register;

public class CashRegister {
    private int[] bills;

    //Constructor
    CashRegister() {
        bills = new int[] {0, 0, 0, 0, 0};
    }

    //Show - displays the amount of all bills in the register and the quantity of
    //twenty, ten, five, two, and one dollar bills respectively
    void show(boolean showTotal) {
        String out = "";
        if(showTotal) {
            out += "$";
            out += total(this.bills);
        }
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
        this.show(true);
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
        this.show(true);
    }

    //Attempts to make change in the given amount from the money available in this.bills
    void change(int amount) {
        CashRegister change = new CashRegister();
        boolean changeFound = false;

        changeFound = this.changeHelper(change, 0, amount);
        if(changeFound)
            return;

        //Change might not have been made on the first pass due to one too many 20, 10, or 5 dollar bills.
        //Running changeHelper while deducting one of each bill at a time to cover the remaining options
        for(int i=change.bills[0]; i>=0; i--) {
            change.bills[0] = i;
            changeFound = this.changeHelper(change, 1, amount);
            if(changeFound)
                return;
            for(int j=change.bills[1]; j>=0; j--) {
                change.bills[1] = j;
                changeFound = this.changeHelper(change, 2, amount);
                if(changeFound)
                    return;
                for(int k=change.bills[2]; k>=0; k--) {
                    change.bills[2] = k;
                    changeFound = this.changeHelper(change, 3, amount);
                    if(changeFound)
                    return;
                }
            }
        }

        if(!changeFound)
            System.out.println(">> Sorry, change could not be made.");
    }

    private boolean changeHelper (CashRegister change, int startIdx, int amount) {
        for(int i=startIdx; i<this.bills.length; i++) {
            while((total(change.bills) < amount) && change.bills[i] < this.bills[i]) {
                change.bills[i]++;
            }
            if(total(change.bills) == amount) {
                System.out.print(">> Change made - ");
                change.show(false);
                System.out.print(">> Taking change from register.  New total - ");
                this.take(change.bills);
                return true;
            } else if(total(change.bills) > amount) {
                change.bills[i]--;
            }
        }
        return false;
    }

    //Calculates the total dollar amount in the register
    private int total(int[] arr) {
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
