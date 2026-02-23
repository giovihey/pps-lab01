import example.model.AccountHolder;
import example.model.BankAccount;
import example.model.SimpleBankAccount;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * The test suite for testing the SimpleBankAccount implementation
 */
class SimpleBankAccountTest {

    public static final int EMPTY_BANK_ACCOUNT = 0;
    public static final int MAXIMUM_BANK_ACCOUNT_AMOUNT = 100;
    public static final int WITHDRAW_AMOUNT = 70;
    private AccountHolder accountHolder;
    private BankAccount bankAccount;
    int wrongId = 2;

    @BeforeEach
    void beforeEach(){
        accountHolder = new AccountHolder("Mario", "Rossi", 1);
        bankAccount = new SimpleBankAccount(accountHolder, EMPTY_BANK_ACCOUNT);
    }


    @Test
    void testInitialBalance() {
        assertEquals(EMPTY_BANK_ACCOUNT, bankAccount.getBalance());
    }

    @Test
    void testDeposit() {
        bankAccount.deposit(accountHolder.id(), MAXIMUM_BANK_ACCOUNT_AMOUNT);
        assertEquals(MAXIMUM_BANK_ACCOUNT_AMOUNT, bankAccount.getBalance());
    }

    @Test
    void testWrongDeposit() {
        bankAccount.deposit(accountHolder.id(), MAXIMUM_BANK_ACCOUNT_AMOUNT);
        bankAccount.deposit(wrongId, WITHDRAW_AMOUNT);
        assertEquals(MAXIMUM_BANK_ACCOUNT_AMOUNT, bankAccount.getBalance());
    }

    @Test
    void testWithdraw() {
        int expectedAmountAfterWithdraw = 29;
        bankAccount.deposit(accountHolder.id(), MAXIMUM_BANK_ACCOUNT_AMOUNT);
        bankAccount.withdraw(accountHolder.id(), WITHDRAW_AMOUNT);
        assertEquals(expectedAmountAfterWithdraw, bankAccount.getBalance());
    }

    @Test
    void testWrongWithdraw() {
        bankAccount.deposit(accountHolder.id(), MAXIMUM_BANK_ACCOUNT_AMOUNT);
        bankAccount.withdraw(wrongId, WITHDRAW_AMOUNT);
        assertEquals(MAXIMUM_BANK_ACCOUNT_AMOUNT, bankAccount.getBalance());
    }
}
