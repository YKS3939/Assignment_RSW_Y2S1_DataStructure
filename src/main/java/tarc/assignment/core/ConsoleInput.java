package tarc.assignment.core;

import tarc.assignment.util.ConsolePrint;

import java.util.Scanner;

public class ConsoleInput {
    private final Scanner scanner;
    public final int SUCCESS = 1;
    public final int ERROR = 2;

    public ConsoleInput(Scanner scanner) {
        this.scanner = scanner;
    }

    public int readInt(String prompt) {
        while (true) {
            ConsolePrint.print(prompt);
            String input = scanner.nextLine();
            try {
                return Integer.parseInt(input.trim());
            } catch (NumberFormatException e) {
                ConsolePrint.error("Only accept numbers.");
            }
        }
    }

    public void pressAnyKey() {
        scanner.nextLine();
    }

    public void pressAnyKey(String prompt, int type) {
        switch (type) {
            case SUCCESS -> ConsolePrint.success(prompt);
            case ERROR -> ConsolePrint.error(prompt);
            default -> ConsolePrint.println(prompt);
        }

        scanner.nextLine();
    }

    public String readString(String prompt) {
        ConsolePrint.print(prompt);
        return scanner.nextLine();
    }

    public char readChar(String prompt) {
        ConsolePrint.print(prompt);
        String input = scanner.nextLine();
        return input.isEmpty() ? ' ' : input.charAt(0);
    }

    public boolean readYesNo(String prompt) {
        while (true) {
            ConsolePrint.print(prompt + " (y/n): ");
            String input = scanner.nextLine().trim().toLowerCase();
            if ("y".equals(input) || "yes".equals(input)) {
                return true;
            }
            if ("n".equals(input) || "no".equals(input)) {
                return false;
            }

            ConsolePrint.error("Only Accept 'y' or 'n'");
        }
    }

}