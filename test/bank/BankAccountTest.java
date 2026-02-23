package com.example.bank;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {

    private BankAccount account;

    @BeforeEach
    void setUp() {
        account = new BankAccount(1000);
    }

    // ✅ 1. Verify initial balance
    @Test
    void testInitialBalance() {
        assertEquals(1000, account.getBalance());
    }

    // ✅ 2. Deposit increases balance
    @Test
    void testDepositValidAmount() {
        account.deposit(500);
        assertEquals(1500, account.getBalance());
    }

    // ✅ 3. Negative deposit throws exception
    @Test
    void testDepositNegativeAmount() {
        assertThrows(IllegalArgumentException.class,
                () -> account.deposit(-100));
    }

    // ✅ 4. Withdraw decreases balance
    @Test
    void testWithdrawValidAmount() {
        account.withdraw(300);
        assertEquals(700, account.getBalance());
    }

    // ✅ 5. Withdraw more than balance throws exception
    @Test
    void testWithdrawInsufficientBalance() {
        assertThrows(IllegalArgumentException.class,
                () -> account.withdraw(2000));
    }
}