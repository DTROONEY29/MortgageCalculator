package com.daniel;

import java.text.NumberFormat;

public class MortgageReport {

    private final NumberFormat currency;
    private CalculationLogic calculator;


    public MortgageReport(CalculationLogic calculator) {
        this.calculator = calculator;
        currency = NumberFormat.getCurrencyInstance();
    }

    public void printPaymentSchedule() {
        System.out.println();
        System.out.println("--- PAYMENTS ---");
        System.out.println("-------------");
        for (double balance : calculator.getRemainingBalances())
            System.out.println(currency.format(balance));

    }

    public void printMortgage() {
        double result = calculator.calculateMortgage();
        System.out.println("----------");
        System.out.println("MORTGAGE");
        System.out.println("----------");
        System.out.println("Your mortgage payment is: " + currency.format(result));
    }
}
