package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProblemTest {

    // sprawdzenie, czy jeśli co najmniej jeden przedmiot spełnia ograniczenia, to zwrócono co najmniej jeden
    @Test
    public void testCoNajmniejJedenElement() {
        Problem problem = new Problem(5, 10, 1, 10);
        Result result = problem.Solve(10);

        assertFalse(result.elementy.isEmpty(), "Plecak nie powinien być pusty.");
    }

    // sprawdzenie, czy jeśli żaden przedmiot nie spełnia ograniczeń, to zwrócono puste rozwiązanie
    @Test
    public void testZadenElementNieSpelniaOgraniczen() {
        // przedmioty mają wagi od 6 do 10
        Problem problem = new Problem(5, 10, 6, 10);
        // pojemność wynosi 2, żaden przedmiot nie wejdzie
        Result result = problem.Solve(2);

        assertTrue(result.elementy.isEmpty(), "Plecak powinien pozostać pusty.");
        assertEquals(0, result.sumarycznaWaga);
    }

    // sprawdzenie, czy waga i wartość wszystkich przedmiotów z listy mieści się w założonym przedziale
    @Test
    public void testPrzedzialWagIWartosci() {
        int dolnaGranica = 3;
        int gornaGranica = 8;
        Problem problem = new Problem(15, 42, dolnaGranica, gornaGranica);

        for (Przedmiot p : problem.instance) {
            assertTrue(p.waga >= dolnaGranica && p.waga <= gornaGranica, "Waga poza zakresem!");
            assertTrue(p.wartosc >= dolnaGranica && p.wartosc <= gornaGranica, "Wartość poza zakresem!");
        }
    }

    // sprawdzenie poprawności wyniku (sumy wag i wartości w plecaku) dla konkretnej instancji
    @Test
    public void testKonkretnejInstancji() {
        // sztywny zakres (4, 4) wymusza, że każdy przedmiot ma dokładnie wagę 4 i wartość 4
        Problem problem = new Problem(2, 1, 4, 4);
        // przy pojemności 11, zmieszczą się maksymalnie 2 takie przedmioty (waga 8, wartość 8)
        Result result = problem.Solve(11);

        assertEquals(8, result.sumarycznaWaga, "Suma wag powinna wynosić 8.");
        assertEquals(8, result.sumarycznaWartosc, "Suma wartości powinna wynosić 8.");
        assertEquals(2, result.elementy.size(), "W plecaku powinny być dokładnie 2 elementy.");
    }
}
