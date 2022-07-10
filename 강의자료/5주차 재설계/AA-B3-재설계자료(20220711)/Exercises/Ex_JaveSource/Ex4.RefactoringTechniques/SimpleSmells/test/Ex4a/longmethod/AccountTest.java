package Ex4a.longmethod;

import org.junit.jupiter.api.Test;

import java.util.Calendar;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {
    @Test
    public void creditAddToBalance() throws Exception {
        Account account= new Account();
        account.credit(50);
        assertEquals(50, account.getBalance(), 0);
    }

    @Test
    public void debitDeductFromBalanceRecordTransactionUpdateDate() throws Exception {
        Account account = new Account();
        account.credit(100);
        account.debit(50);
        assertEquals(50, account .getBalance(), 0);
        Transaction lastTransaction = account.getLastTransaction();
        assertTrue(lastTransaction.isDebit());
        assertEquals(50, lastTransaction.getAmount(), 0);

        Calendar calendar = Calendar.getInstance();

        assertEquals(calendar.get(Calendar.DATE) + "/" +
                        calendar.get(Calendar.MONTH) + "/" +
                        calendar.get(Calendar.YEAR),
                account.getLastDebitDate());
    }
}
