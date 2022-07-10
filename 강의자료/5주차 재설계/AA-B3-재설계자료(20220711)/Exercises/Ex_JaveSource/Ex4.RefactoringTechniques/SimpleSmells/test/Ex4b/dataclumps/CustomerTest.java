package Ex4b.dataclumps;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {
    @Test
    public void addressSummaryIncludesHouseStreetCityPostCodeCountry() throws Exception {
        Customer customer = new Customer();
        customer.setHouse("55");
        customer.setStreet("Hanyang-ro");
        customer.setCity("Ansan");
        customer.setPostcode("15588");
        customer.setCountry("Korea");
        assertEquals("55, Hanyang-ro, Ansan, 15588, Korea", customer.getAddressSummary());
    }
}
