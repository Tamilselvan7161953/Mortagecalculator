package mortage;


import static org.junit.Assert.assertEquals;
import java.util.HashMap;
import java.util.Map;
import org.junit.BeforeClass;
import org.junit.Test;

public class MortgageCalculatorControllerTest {

  static MortgageCalculatorController mortgageCalculator;

  @BeforeClass
  public static void intialiseObject() {
    mortgageCalculator = new MortgageCalculatorController();
  }

  @Test
  public void calculate5YearPayment() throws Exception {

    Map<String, Double> result = new HashMap<>();

    result = mortgageCalculator.calculateMonthlyPayment(100000.0, 8.0, 5);

    assertEquals("{interest=666.67, fixed=2027.64}", result.toString());
  }

  @Test(expected = NullPointerException.class)
  public void calculateWithAllInvalidInput() throws Exception {

    Map<String, Double> result = new HashMap<>();
    double principle = (Double) null;
    double yearlyRate = (Double) null;
    int term = (Integer) null;

    result = mortgageCalculator.calculateMonthlyPayment(principle, yearlyRate, term);

    assertEquals("{interest=0, 0}", result.toString());
  }


}

