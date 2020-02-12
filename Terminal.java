package com.daniel;

// Everything that the user user inputs and the program outputs goes in here.

import java.text.NumberFormat;
import java.util.Scanner;

public class Terminal {
    final static double monthsInAYear = 12;
    private static Scanner scanner = new Scanner(System.in);


    public static double readNumber(String prompt) {

        return scanner.nextDouble();

    }

    public static double readNumber(String prompt, double min, double max) {
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


}
