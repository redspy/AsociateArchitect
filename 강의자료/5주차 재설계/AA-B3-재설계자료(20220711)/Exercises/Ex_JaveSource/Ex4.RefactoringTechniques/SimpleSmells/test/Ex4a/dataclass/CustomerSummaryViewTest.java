package Ex4a.dataclass;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerSummaryViewTest {
    @Test
    public void customerSummaryIncludesFullNameFullAddress() throws Exception {
        Customer customer = new Customer();
        customer.setFirstName("John");
        customer.setLastName("Smith");
        customer.setTitle("Mr");
        Address address = new Address();
        address.setCity("Ansan");
        address.setPostcode("15588");
        address.setCountry("Korea");
        customer.setAddress(address);
        CustomerSummaryView order = new CustomerSummaryView(customer);
        assertEquals("Mr John Smith, Ansan, 15588, Korea", order.getCustomerSummary());
    }
}
