package mortage;

import java.util.HashMap;
import java.util.Map;

public class MortgageCalculatorController {

  private MortgageCalculatorTask mortgageCalculatorTask = new FixedRateMortgageCalculatorTaskImpl();

  private Map<String, Double> result = null;

  public Map<String, Double> calculateMonthlyPayment(double principal, double yearlyRate, int term)
      throws Exception {

    result = new HashMap<>();
    double fixedResutl =
        mortgageCalculatorTask.calculateMonthlyPayment(principal, yearlyRate, term);

    mortgageCalculatorTask = new InterestOnlyMortgageCalculatorTaskImpl();

    double interestResult =
        mortgageCalculatorTask.calculateMonthlyPayment(principal, yearlyRate, term);

    result.put("fixed", fixedResutl);
    result.put("interest", interestResult);

    return result;
  }

  public static void main(String[] ags) throws Exception {
    Map<String, Double> result = new HashMap<>();
    MortgageCalculatorController mortgageCalculator = new MortgageCalculatorController();
    result = mortgageCalculator.calculateMonthlyPayment(100000.0, 8.0, 5);
    System.out.println(result);
  }
}
