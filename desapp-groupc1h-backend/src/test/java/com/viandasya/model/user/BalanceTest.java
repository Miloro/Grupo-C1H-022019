package com.viandasya.model.user;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class BalanceTest {

    @Test

    public void testIfMyAmountIsHigherOrEqualICanWithdraw(){
        Balance balance = new Balance(new BigDecimal("100"));
        Assert.assertTrue(balance.canWithdraw(new BigDecimal("99")));
    }

    @Test
    public void testIfMyAmountIsEqualICanWithdraw(){
        Balance balance = new Balance(new BigDecimal("100"));
        Assert.assertTrue(balance.canWithdraw(new BigDecimal("100")));
    }

    @Test
    public void testIfMyAmountIsSmallerICantWithdraw(){
        Balance balance = new Balance(new BigDecimal("100"));
        Assert.assertFalse(balance.canWithdraw(new BigDecimal("1000")));
    }

    @Test
    public void testIfIDeposit100InABalanceWith0IKeep100(){
        Balance balance = new Balance(new BigDecimal("0"));
        balance.deposit(new BigDecimal("100"));

        Assert.assertEquals(balance.getAmount(),new BigDecimal("100"));
    }

    @Test
    public void testIfIWithdraw100InABalanceWith100IKeep0(){
        Balance balance = new Balance(new BigDecimal("100"));
        balance.withdraw(new BigDecimal("100"));

        Assert.assertEquals(balance.getAmount(),new BigDecimal("0"));
    }

}
