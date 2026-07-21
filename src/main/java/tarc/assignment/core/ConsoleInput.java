package tarc.assignment.core;

import tarc.assignment.util.ConsolePrint;

import java.util.Scanner;

public class ConsoleInput {
    private final Scanner scanner;
    public ConsoleInput(Scanner scanner){
        this.scanner=scanner;
    }

    public int readInt(String prompt) {
        while (true) {
            ConsolePrint.print(prompt);
            String input = scanner.nextLine();
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                ConsolePrint.error("Only accept numbers.");
            }
        }
    }

    public void pressAnyKey() {
        scanner.nextLine();
    }

    public String readString(String prompt){
        ConsolePrint.print(prompt);
        return scanner.nextLine();
    }

    public char readChar(String prompt) {
        ConsolePrint.print(prompt);
        String input = scanner.nextLine();
        return input.isEmpty() ? ' ' : input.charAt(0);
    }

}