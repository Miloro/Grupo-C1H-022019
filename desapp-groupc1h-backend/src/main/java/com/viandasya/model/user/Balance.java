package com.viandasya.model.user;

public class Balance {
     private Integer amount;

    public Balance(Integer amount) {
        this.amount = amount;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public void withdraw(Integer amountToWithdraw){
        this.amount =- amount;
    }

    public void deposit(Integer amountToDeposit){
        this.amount =+ amountToDeposit;
    }

    public boolean canWithdraw(Integer amountToWithdraw){
        return this.amount <= amountToWithdraw;
    }
}
