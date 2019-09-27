package com.viandasya.model.user;

import org.junit.Assert;
import org.junit.Test;

public class BalanceTest {

    @Test

    public void testIfMyAmountIsHigherOrEqualICanWithdraw(){
        Balance balance = new Balance(100);
        Assert.assertTrue(balance.canWithdraw(99));
    }

    @Test
    public void testIfMyAmountIsEqualICanWithdraw(){
        Balance balance = new Balance(100);
        Assert.assertTrue(balance.canWithdraw(100));
    }

    @Test
    public void testIfMyAmountIsSmallerICantWithdraw(){
        Balance balance = new Balance(100);
        Assert.assertFalse(balance.canWithdraw(1000));
    }

    @Test
    public void testIfIDeposit100InABalanceWith0IKeep100(){
        Balance balance = new Balance(0);
        balance.deposit(100);

        Assert.assertEquals(balance.getAmount(),100,0);
    }

    @Test
    public void testIfIWithdraw100InABalanceWith100IKeep0(){
        Balance balance = new Balance(0);
        balance.deposit(100);

        Assert.assertEquals(balance.getAmount(),100,0);
    }

}
