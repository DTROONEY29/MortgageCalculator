package com.company;

import java.text.NumberFormat;
import java.util.Scanner;


public class Main {
    final static int monthsInAYear = 12;
    final static int percent = 100;

    public static void main(String[] args) {

        System.out.println("Welcome to the mortgage Calculator!");

        double principal = readNumber("Principal: ", 1000, 1_000_000);

        double annualInterestRate = readNumber("Annual Interest Rate: ", 1, 30);

        int years = (int) readNumber("Period in years: ", 1, 30);

        printMortgage(principal, annualInterestRate, years);
        printPaymentSchedule(principal, annualInterestRate, years);

    }

    private static void printMortgage(double principal, double annualInterestRate, int years) {
        double result = calculateMortgage(principal, annualInterestRate, years);
        System.out.println("----------");
        System.out.println("MORTGAGE");
        System.out.println("----------");
        System.out.println("Your mortgage payment is: " + NumberFormat.getCurrencyInstance().format(result));
    }

    private static void printPaymentSchedule(double principal, double annualInterestRate, int years) {
        System.out.println();
        System.out.println("--- PAYMENTS ---");
        System.out.println("-------------");
        for (int month = 1; month <= years * monthsInAYear; month++) {

            double balance = remainingBalance(principal, annualInterestRate, years, month);
            System.out.println(NumberFormat.getCurrencyInstance().format(balance));
        }
    }

    public static double readNumber(String prompt, double min, double max) {
        Scanner scanner = new Scanner(System.in);
        double value;
        while (true) {
            System.out.println(prompt);
            value = scanner.nextDouble();

            if (value >= min && value <= max)
                break;
            System.out.println("PLease enter an amount between" + min + " and " + max);

        }

        return value;
    }

    public static double calculateMortgage(
            double principal,
            double annualInterestRate,
            int years) {

        int lengthInMonths = years * monthsInAYear;
        double monthlyInterestRate = annualInterestRate / percent / monthsInAYear;

        double result = principal * (monthlyInterestRate * Math.pow(1 + monthlyInterestRate, lengthInMonths)) /
                (Math.pow(1 + monthlyInterestRate, lengthInMonths) - 1);
        return result;
    }

    public static double remainingBalance(
            double principal,
            double annualInterestRate,
            int years,
            int numberOfPaymentsMade) {

        int lengthInMonths = years * monthsInAYear;
        double monthlyInterestRate = annualInterestRate / percent / monthsInAYear;

        double balance = principal * (Math.pow(1 + monthlyInterestRate, lengthInMonths) - Math.pow(1 + monthlyInterestRate, numberOfPaymentsMade))
                / (Math.pow(1 + monthlyInterestRate, lengthInMonths) - 1);


        return balance;
    }
}













