package mortage;

import static org.junit.Assert.assertEquals;
import org.junit.BeforeClass;
import org.junit.Test;

public class FixedRateMortgageCalculatorTaskImplTest {

  static FixedRateMortgageCalculatorTaskImpl fixedRateCalculator;

  @BeforeClass
  public static void intialiseObject() {
    fixedRateCalculator = new FixedRateMortgageCalculatorTaskImpl();
  }

  @Test
  public void calculate30YearMonthlyPayment() throws Exception {

    double result = fixedRateCalculator.calculateMonthlyPayment(100000.0, 6.0, 30);

    assertEquals(new Double(599.55), new Double(result));
  }

  @Test
  public void calculate1YearMonthlyPayment() throws Exception {

    double result = fixedRateCalculator.calculateMonthlyPayment(100000.0, 6.0, 1);

    assertEquals(new Double(8606.64), new Double(result));
  }

  @Test(expected = NullPointerException.class)
  public void calculateWithInvalidInput() throws Exception {

    double principle = (Double) null;

    double result = fixedRateCalculator.calculateMonthlyPayment(principle, 6.0, 1);

    assertEquals(new Double(8606.64), new Double(result));
  }

  @Test(expected = NullPointerException.class)
  public void calculateWithAllInvalidInput() throws Exception {

    double principle = (Double) null;
    double yearlyRate = (Double) null;
    int term = (Integer) null;

    double result = fixedRateCalculator.calculateMonthlyPayment(principle, yearlyRate, term);

    assertEquals(new Double(8606.64), new Double(result));
  }

}
