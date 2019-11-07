import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        final int MONTHS_IN_YEAR = 12;
        final int PERCENT = 100;

        //create scanner
        Scanner scanner = new Scanner(System.in);
        // prompt user
        System.out.print("How big is the loan?");
        int size = scanner.nextInt();

        System.out.print("Enter annual interest rate:");
        double interestRate = scanner.nextDouble();
        // Calculate monthly interest rate.
        double monthlyRate = (interestRate / MONTHS_IN_YEAR) / PERCENT;

        System.out.print("How long is the period of repayment (in years): ");
        double repayPeriod = scanner.nextDouble();
        // Calculate the number of monthly payments
        double totalPayments = repayPeriod * MONTHS_IN_YEAR;

        // calculate expression (1+R)^n used in equation for cleaner code
        double onePlusMonthlyRate = Math.pow(1 + monthlyRate, totalPayments);
        //Calculate monthly mortgage payment
        double monthlyMortgagePayment = size * ((monthlyRate * onePlusMonthlyRate) / (onePlusMonthlyRate - 1));
        // convert to currency format
        String mortgageReadable = NumberFormat.getCurrencyInstance().format(monthlyMortgagePayment);
        System.out.println("Your monthly payment will be: " + mortgageReadable);

    }
}
