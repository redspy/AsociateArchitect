package Ex4a.duplicatedcode;

import org.junit.jupiter.api.Test;

import java.util.Calendar;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {
    @Test
    public void creditAddToBalanceRecordTransactionUpdateDate() throws Exception {
        Account account = new Account();
        account.credit(50);
        assertEquals(50, account .getBalance(), 0);
        Transaction lastTransaction = account.getLastTransaction();
        assertEquals(50, lastTransaction.getAmount(), 0);

        Calendar calendar = Calendar.getInstance();

        assertEquals(calendar.get(Calendar.DATE) + "/" +
                        calendar.get(Calendar.MONTH) + "/" +
                        calendar.get(Calendar.YEAR),
                account.getLastTransactionDate());
    }

    @Test
    public void debitDeductFromBalanceRecordTransactionUpdateDate() throws Exception {
        Account account = new Account();
        account.credit(100);
        account.debit(50);
        assertEquals(50, account .getBalance(), 0);
        Transaction lastTransaction = account.getLastTransaction();
        assertEquals(-50, lastTransaction.getAmount(), 0);

        Calendar calendar = Calendar.getInstance();

        assertEquals(calendar.get(Calendar.DATE) + "/" +
                        calendar.get(Calendar.MONTH) + "/" +
                        calendar.get(Calendar.YEAR),
                account.getLastTransactionDate());
    }
}
