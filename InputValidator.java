package com.example;

import java.util.Scanner;

public class InputValidator {

    public static int parseInteger(String input) {
        try {
            return Integer.parseInt(input.trim());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    public static int parseIntegerInRange(String input, int min, int max) {
        int value = parseInteger(input);
        if (value >= min && value <= max) {
            return value;
        }
        return -1;
    }

    public static boolean isValidString(String input) {
        return input != null && !input.trim().isEmpty();
    }

    public static boolean isValidContactNumber(String contactNumber) {
        if (contactNumber == null || contactNumber.trim().isEmpty()) {
            return false;
        }
        return contactNumber.matches("^[\\d\\s\\-\\+\\(\\)]{10,}$");
    }

    public static boolean isValidAge(int age) {
        return age >= 0 && age <= 150;
    }

    public static String getValidString(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine();
            if (isValidString(input)) {
                return input.trim();
            }
            System.out.println("Invalid input. Please enter a non-empty value.");
        }
    }

    public static int getValidInteger(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine();
            int value = parseInteger(input);
            if (value != -1) {
                return value;
            }
            System.out.println("Invalid input. Please enter a valid integer.");
        }
    }

    public static int getValidIntegerInRange(Scanner scanner, String prompt, int min, int max) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine();
            int value = parseIntegerInRange(input, min, max);
            if (value != -1) {
                return value;
            }
            System.out.println(String.format("Invalid input. Please enter a number between %d and %d.", min, max));
        }
    }
}
