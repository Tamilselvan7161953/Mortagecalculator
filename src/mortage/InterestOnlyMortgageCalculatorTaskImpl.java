package mortage;

public class InterestOnlyMortgageCalculatorTaskImpl implements MortgageCalculatorTask {

  @Override
  public double calculateMonthlyPayment(double principal, double yearlyRate, int term) {

    double monthlyPayment = principal * (yearlyRate / 100) / 12;

    // round to two decimals
    monthlyPayment = (double) Math.round(monthlyPayment * 100) / 100;

    return monthlyPayment;
  }
}