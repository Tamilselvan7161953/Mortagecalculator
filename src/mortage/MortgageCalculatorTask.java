package mortage;


public interface MortgageCalculatorTask {

  public double calculateMonthlyPayment(double principal, double yearlyRate, int term)
      throws Exception;

}
