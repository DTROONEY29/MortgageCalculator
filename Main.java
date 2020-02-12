package com.daniel;

public class Main {

    public static void main(String[] args) {

        System.out.println("Welcome to the mortgage Calculator!");

        double principal = Terminal.readNumber("Principal: ", 1000, 1_000_000);
        double annualInterestRate = Terminal.readNumber("Annual Interest Rate: ", 1, 30);
        int years = (int) Terminal.readNumber("Period in years: ", 1, 30);

        var calculator = new CalculationLogic(principal, annualInterestRate, years);
        var report = new MortgageReport(calculator);

        report.printMortgage();
        report.printPaymentSchedule();

    }


}












