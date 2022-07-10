package Ex4a.divergentchange;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {
    @Test
    public void debitDeductFromBalance()  {
        Account account = new Account(12345678);
        account.credit(100);
        account.debit(50);
        assertEquals(50, account.getBalance(), 0);
    }

    @Test
    public void accountXmlFormattedCorrectly()  {
        Account account = new Account(12345678);
        String expectedXml = "<account><id>12345678</id><balance>0.0</balance></account>";
        assertEquals(expectedXml , account.toXml());
    }
}
