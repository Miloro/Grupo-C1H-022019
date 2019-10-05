package com.viandasya.model.user;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.math.BigDecimal;

@Embeddable
public class Balance {
    @Column(name = "balance")
    private BigDecimal amount;

    public Balance(BigDecimal amount) {
        this.amount = amount;
    }

    public Balance() {
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public void withdraw(BigDecimal amountToWithdraw){
        this.amount = this.amount.subtract(amountToWithdraw);
    }

    public void deposit(BigDecimal amountToDeposit){
        this.amount = this.amount.add(amountToDeposit);
    }

    public boolean canWithdraw(BigDecimal amountToWithdraw){
        return this.amount.compareTo(amountToWithdraw) > -1 ;
    }
}
