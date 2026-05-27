package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Problem problem = new Problem(10, 2, 1, 10);

        System.out.println("Wygenerowane przedmioty:");
        System.out.println(problem.toString());
        System.out.println("-------\nWynik:");

        Result wynik = problem.Solve(15);
        System.out.println(wynik.toString());
    }
}
