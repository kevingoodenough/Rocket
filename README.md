# CashRegister

CashRegister is a project for Rocket Travel.

## Description

CashRegister should be run through the command line.  It includes the following functionality:
    show - show the total in the CashRegister
    put - put bills into the register
    take - take bills from the register
    change - make change for a given amount, if that amount is available

## Installation

Download and install to any location.  From the terminal within the main directory

```bash
java com.rocketmiles.cash_register.CashRegisterMain
```

## Usage

```bash

show # shows the total in the register
put 1 2 3 4 5 # puts 1 ($20 bill), 2 ($10 bill), 3 ($5 bill), 4 ($2 bill), and 5 ($1 bill) into the register
take 1 2 3 4 5 # takes 1 ($20 bill), 2 ($10 bill), 3 ($5 bill), 4 ($2 bill), and 5 ($1 bill) from the register
change 11 # will calculate how $11 in change can be made and will output the bills needed and remove them from the register total
quit # exit the application
```
