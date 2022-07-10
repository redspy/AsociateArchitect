package Ex4c.longparamlist;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {
    @Test
    public void customerSummaryIncludesFullNameFillAddress() throws Exception {
        Customer customer = new Customer();
        customer.setFirstName("John");
        customer.setLastName("Smith");
        customer.setTitle("Mr");
        Address address = new Address();
        address.setCity("Ansan");
        address.setPostCode("15588");
        address.setCountry("Korea");
        customer.setAddress(address);
        assertEquals("Mr John Smith, Ansan, 15588, Korea", customer.getSummary());
    }
}
