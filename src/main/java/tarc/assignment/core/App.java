package tarc.assignment.core;

import tarc.assignment.util.Environment;

import java.util.Scanner;

public class App {
    private final ConsoleInput input;

    public App(){
        Scanner scanner=new Scanner(System.in);
        input = new ConsoleInput(scanner);
    }

    public ConsoleInput input(){
        return input;
    }
}
