package Ex4a.messagechains;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InvoiceTest {
    @Test
    public void shippingAddedForAddressNotInEurope() throws Exception {

        Address address = new Address(new Country(false));
        Customer customer = new Customer(address);

        Invoice invoice = new Invoice(customer);
        invoice.addItem(new InvoiceItem("Product X", 1, 100));
        assertEquals(100 + Invoice.SHIPPING_COST_OUTSIDE_EU, invoice .getTotalPrice(), 0);
    }
}
