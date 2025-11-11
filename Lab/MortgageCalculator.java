package Project;

import java.util.Scanner;

public class MortgageCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("=== Mortgage Calculator ===");

        double principal = 0;
        double annualRate = 0;
        int years = 0;
        double salary = 0;
        int creditScore = 0;
        boolean criminalRecord = false;

        // ===== USER INPUTS WITH VALIDATION =====
        // Salary input (must be a number)
        while (true) {
            System.out.print("Enter your monthly salary: ");
            if (input.hasNextDouble()) {
                salary = input.nextDouble();
                if (salary > 0) break;
                else System.out.println("Salary must be greater than 0!");
            } else {
                System.out.println("Please enter a valid number!");
                input.next(); // clear invalid input
            }
        }

        // Credit Score input (0 - 500)
        while (true) {
            System.out.print("Enter your credit score (0-500): ");
            if (input.hasNextInt()) {
                creditScore = input.nextInt();
                if (creditScore >= 0 && creditScore <= 500) break;
                else System.out.println("Credit score must be between 0 and 500!");
            } else {
                System.out.println("Please enter a valid number!");
                input.next();
            }
        }

        // Criminal record input (True/False)
        while (true) {
            System.out.print("Do you have any criminal record? (true/false): ");
            if (input.hasNextBoolean()) {
                criminalRecord = input.nextBoolean();
                break;
            } else {
                System.out.println("Please enter true or false!");
                input.next();
            }
        }

        // Loan eligibility check (Credit score >= 300 and no criminal record)
        boolean eligible = (creditScore >= 300 && !criminalRecord);
        System.out.println(eligible ? "Eligibility: You are eligible to apply." 
                                    : "Eligibility: You are not eligible to apply.");

        if (!eligible) {
            System.out.println("Sorry, you cannot apply for a mortgage due to eligibility criteria.");
            input.close();
            return;
        }

        // Loan amount input
        while (true) {
            System.out.print("Enter loan amount (Principal): ");
            if (input.hasNextDouble()) {
                principal = input.nextDouble();
                if (principal > 0) {
                    // Check if principal <= 2 × salary
                    if (principal <= salary * 2) break;
                    else System.out.println("Loan amount must not exceed twice your salary!");
                } else {
                    System.out.println("Loan amount must be positive!");
                }
            } else {
                System.out.println("Please enter a valid number!");
                input.next();
            }
        }

        // Interest rate input
        while (true) {
            System.out.print("Enter annual interest rate (in %): ");
            if (input.hasNextDouble()) {
                annualRate = input.nextDouble();
                if (annualRate > 0) break;
                else System.out.println("Interest rate must be greater than 0!");
            } else {
                System.out.println("Please enter a valid number!");
                input.next();
            }
        }

        // Loan term input
        while (true) {
            System.out.print("Enter loan term (in years): ");
            if (input.hasNextInt()) {
                years = input.nextInt();
                if (years > 0) break;
                else System.out.println("Years must be positive!");
            } else {
                System.out.println("Please enter a valid number!");
                input.next();
            }
        }

        // ===== CALCULATION =====
        double monthlyRate = annualRate / 100 / 12;
        int numberOfPayments = years * 12;

        double numerator = monthlyRate * Math.pow(1 + monthlyRate, numberOfPayments);
        double denominator = Math.pow(1 + monthlyRate, numberOfPayments) - 1;
        double monthlyPayment = principal * (numerator / denominator);

        System.out.println("\n=== Mortgage Summary ===");
        System.out.println("Monthly Payment: $" + String.format("%.2f", monthlyPayment));
        System.out.println("Loan Term: " + years + " years (" + numberOfPayments + " months)");
        System.out.println("Annual Interest Rate: " + annualRate + "%");

        input.close();
    }
}