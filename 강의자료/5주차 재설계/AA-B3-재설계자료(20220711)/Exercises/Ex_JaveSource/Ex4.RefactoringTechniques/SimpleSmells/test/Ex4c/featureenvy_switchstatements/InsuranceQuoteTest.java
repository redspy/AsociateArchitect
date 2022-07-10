package Ex4c.featureenvy_switchstatements;

import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class InsuranceQuoteTest {
    @Test
    public void motoristNoPointsOver25LowRisk() throws Exception {
        assertEquals(RiskFactor.LOW_RISK, calculateMotoristRisk("1980-01-01", 0));
    }


    @Test
    public void motorist1To3PointsOver25ModerateRisk() throws Exception {
        assertEquals(RiskFactor.MODERATE_RISK, calculateMotoristRisk("1980-01-01", 3));
    }

    @Test
    public void motoristMoreThan3PointsOver25HighRisk() throws Exception {
        assertEquals(RiskFactor.HIGH_RISK, calculateMotoristRisk("1980-01-01", 4));
    }

    @Test
    public void MotoristUnder25HighRisk() throws Exception {
        assertEquals(RiskFactor.HIGH_RISK, calculateMotoristRisk("2000-01-01", 0));
    }

    @Test
    public void lowRiskMotorists2PercentPremium() throws Exception {
        InsuranceQuote quote = buildInsuranceQuote("1970-01-01", 0);
        assertEquals(200, quote.calculateInsurancePremium(10000), 0);
    }

    @Test
    public void moderateRiskMotorists4PercentPremium() throws Exception {
        InsuranceQuote quote = buildInsuranceQuote("1970-01-01", 1);
        assertEquals(400, quote.calculateInsurancePremium(10000), 0);
    }

    @Test
    public void highRiskMotorists6PercentPremium() throws Exception {
        InsuranceQuote quote = buildInsuranceQuote("2000-01-01", 0);
        assertEquals(600, quote.calculateInsurancePremium(10000), 0);
    }

    private RiskFactor calculateMotoristRisk(String dateOfBirth, int pointsOnLicense) throws ParseException {
        return buildInsuranceQuote(dateOfBirth, pointsOnLicense).calculateMotoristRisk();
    }


    private InsuranceQuote buildInsuranceQuote(String dateOfBirth,
                                               int pointsOnLicense) throws ParseException {
        return new InsuranceQuote(new Motorist(parseDate(dateOfBirth), pointsOnLicense));
    }


    private Date parseDate(String dateOfBirth) throws ParseException {
        return new SimpleDateFormat("yyyy-MM-dd").parse(dateOfBirth);
    }
}
