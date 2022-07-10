package Ex4a.inappropriateintimacy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LicenseTest {
    @Test
    public void licenseSummaryIncludeFullNamePoints(){
        License license = new License();
        license.addPoints(3);
        Motorist motorist = new Motorist(license, "Smith", "John", "Mr");
        assertEquals("Mr John Smith, 3 points", license.getSummary());
    }
}
