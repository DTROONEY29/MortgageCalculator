package com.daniel;


// Everything that calculates the mortgage and payment schedule goes in here.

public class CalculationLogic {
    private final static double monthsInAYear = 12;
    private final static int percent = 100;

    private double principal;
    private double annualInterestRate;
    private double years;

    public CalculationLogic(double principal, double annualInterestRate, double years) {
        this.principal = principal;
        this.annualInterestRate = annualInterestRate;
        this.years = years;
    }

    public double calculateMortgage() {

        double lengthInMonths = getLengthInMonths();
        double monthlyInterestRate = getMonthlyInterestRate();

        double result = principal * (getLengthInMonths()) /
                (Math.pow(1 + monthlyInterestRate, lengthInMonths) - 1);
        return result;
    }


    public double remainingBalance(int numberOfPaymentsMade) {

        double lengthInMonths = getLengthInMonths();
        double monthlyInterestRate = getMonthlyInterestRate();

        double balance = principal * (Math.pow(1 + monthlyInterestRate, lengthInMonths) - Math.pow(1 + monthlyInterestRate, numberOfPaymentsMade))
                / (Math.pow(1 + monthlyInterestRate, lengthInMonths) - 1);


        return balance;
    }

    public double[] getRemainingBalances() {
        var balances = new double[(int) getLengthInMonths()];
        for (int month = 1; month <= balances.length; month++)

            balances[month - 1] = remainingBalance(month);

        return balances;
    }

    private double getLengthInMonths() {
        return years * monthsInAYear;
    }


    private double getMonthlyInterestRate() {
        return annualInterestRate / percent / monthsInAYear;
    }

}
