package Ex4c.parallelinheritance;

import org.junit.jupiter.api.Test;

import java.util.Calendar;

import static org.junit.jupiter.api.Assertions.*;

class SettlementAccountTest {

    @Test
    public void debitDeductFromBalanceRecordTransactionUpdateDate() throws Exception {
        SettlementAccount account = new SettlementAccount();
        account.credit(100);
        account.debit(50);
        assertEquals(50, account .getBalance(), 0);
        Transaction lastTransaction = account.getLastTransaction();
        assertTrue(lastTransaction.isDebit());
        assertEquals(-50, lastTransaction.getAmount(), 0);

        Calendar calendar = Calendar.getInstance();

        assertEquals(calendar.get(Calendar.DATE) + "/" +
                        calendar.get(Calendar.MONTH) + "/" +
                        calendar.get(Calendar.YEAR),
                account.getLastTransactionDate());
    }


    @Test
    public void settleDeductOwingFromBalance() throws Exception {
        SettlementAccount account = new SettlementAccount();
        account.credit(100);
        account.borrow(50);
        account.settle();
        assertEquals(50, account.getBalance(), 0);
    }

}
