import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // Variables

        final int MONTHS_IN_YEAR = 12;
        final int PERCENT = 100;
        double size = 0;
        double interestRate = 0.0;
        double monthlyRate = 0.0;
        double totalPayments = 0.0;
        double onePlusMonthlyRate = 0.0;
        // Welcome message
        System.out.println("Welcome to the simple mortgage calculator!");
        //create scanner
        Scanner scanner = new Scanner(System.in);
        // prompt user
        while (true) {
            System.out.print("How big is the loan? (£1K - £1M): ");
            size = scanner.nextInt();

            // If user enters value out of range, display prompt:
            if (size >= 1000 && size <= 1_000_000)
                break;
            System.out.println("Please enter a value between 1000 and 1 million.");


        }
        while (true) {
//  Prompt user
            System.out.print("Enter annual interest rate:");

            interestRate = scanner.nextDouble();


            if (interestRate >= 1 && interestRate <= 25) {
                // Calculate monthly interest rate.
                monthlyRate = (interestRate / MONTHS_IN_YEAR) / PERCENT;
                break;
            }
            // If user enters value out of range, display prompt:

            System.out.println("Please enter a value between 1 and 25.");

        }


        while (true) {
            //Prompt user
            System.out.print("How long is the period of repayment (in years): ");
            double repayPeriod = scanner.nextDouble();
            if (repayPeriod >= 3 && repayPeriod <= 50) {
                // Calculate the number of monthly payments
                totalPayments = repayPeriod * MONTHS_IN_YEAR;
                break;
            }
            // If user enters value out of range, display prompt:

            System.out.println("Please enter a value between 3 and 50. ");
        }

        // calculate expression (1+R)^n used in equation for cleaner code
        onePlusMonthlyRate = Math.pow(1 + monthlyRate, totalPayments);
        //Calculate monthly mortgage payment
        double monthlyMortgagePayment = size * ((monthlyRate * onePlusMonthlyRate) / (onePlusMonthlyRate - 1));
        // convert to currency format
        String mortgageReadable = NumberFormat.getCurrencyInstance().format(monthlyMortgagePayment);
        System.out.println("Your monthly payment will be: " + mortgageReadable);

    }
}
