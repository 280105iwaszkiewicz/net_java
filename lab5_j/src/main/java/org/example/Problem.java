package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Problem {
    public int n;
    public int seed;
    public int lowerBound;
    public int upperBound;
    public List<Przedmiot> instance = new ArrayList<>();

    // konstruktor generujący instancję nieograniczonego problemu plecakowego (Zadanie 1)
    public Problem(int n, int seed, int lowerBound, int upperBound) {
        this.n = n;
        this.seed = seed;
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;

        Random rand = new Random(seed);
        int zakres = upperBound - lowerBound + 1;

        // losowanie wag i wartości
        for (int i = 0; i < n; i++) {
            int waga = rand.nextInt(zakres) + lowerBound;
            int wartosc = rand.nextInt(zakres) + lowerBound;
            instance.add(new Przedmiot(i, wartosc, waga));
        }
    }

    // metoda rozwiązująca nieograniczony problem plecakowy (Zadanie 2)
    public Result Solve(int capacity) {
        Result result = new Result();

        // kopia listy przedmiotów, aby móc ją bezpiecznie posortować
        List<Przedmiot> posortowane = new ArrayList<>(this.instance);

        // sortowanie obiektów malejąco po stosunku ich wartości do wagi (Zadanie 2)
        posortowane.sort((p1, p2) -> Double.compare(
                (double) p2.wartosc / p2.waga,
                (double) p1.wartosc / p1.waga
        ));

        int aktualnaWaga = 0;

        // algorytm zachłanny dla wersji nieograniczonej (Zadanie 2)
        // sprawdzamy każdy rodzaj przedmiotu po kolei (od najbardziej opłacalnego)
        for (Przedmiot p : posortowane) {
            // dokładamy ten sam przedmiot tak długo, jak długo mieści się w plecaku
            while (aktualnaWaga + p.waga <= capacity) {
                result.elementy.add(p);
                result.sumarycznaWaga += p.waga;
                result.sumarycznaWartosc += p.wartosc;
                aktualnaWaga += p.waga;
            }
        }
        return result;
    }

    // przeciążenie metody toString() przy użyciu @Override
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Przedmiot p : instance) {
            sb.append(p.toString()).append("\n");
        }
        return sb.toString();
    }
}