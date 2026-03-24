Zadanie 1

Projekt przedstawia implementację problemu plecakowego jako aplikacji
konsolowej w języku C#. Celem programu jest maksymalizacja sumy wartości
wybranych przedmiotów przy ograniczonej pojemności plecaka.

GŁÓWNA LOGIKA PROGRAMU

Program tworzy instancję problemu, generuje dane, a następnie wywołuje
algorytm rozwiązujący:

Problem problem = new Problem(liczbaPrzedmiotow, seed); Result wynik =
problem.Rozwiaz(pojemnosc); Console.WriteLine(wynik);

GENEROWANIE DANYCH WEJŚCIOWYCH

Konstruktor klasy Problem odpowiada za tworzenie list wag i wartości:

Random los = new Random(seed);

for (int i = 0; i < liczbaPrzedmiotow; i++) { wartosci.Add(los.Next(1,
11)); wagi.Add(los.Next(1, 11)); }

Opis działania: 
-Tworzony jest generator liczb pseudolosowych z zadanym
ziarnem (seed). 
-Dla każdego przedmiotu losowana jest wartość i waga z
zakresu 1–10. 
-Dane zapisywane są w listach. Zastosowanie seed pozwala uzyskać powtarzalne wyniki.

ALGORYTM ZACHŁANNY

Sortowanie przedmiotów według opłacalności:

indeksy.Sort((a, b) => (wartosci[b] /
(double)wagi[b]).CompareTo(wartosci[a] / (double)wagi[a]));

Wybieranie przedmiotów do plecaka:

foreach (int i in indeksy) { if (sumaWag + wagi[i] <= pojemnosc) {
wybrane.Add(i); sumaWag += wagi[i]; sumaWartosci += wartosci[i]; } }

REPREZENTACJA WYNIKU

public Result(List przedmioty, int sumaWartosci, int sumaWag) {
this.przedmioty = przedmioty; this.sumaWartosci = sumaWartosci;
this.sumaWag = sumaWag; }


===========================================================================

Zadanie 2 — TESTY JEDNOSTKOWE

Testy jednostkowe problemu plecakowego

Projekt zawiera zestaw testów jednostkowych sprawdzających poprawność
działania aplikacji rozwiązującej problem plecakowy. Testy zostały
napisane z użyciem frameworka MSTest w środowisku Microsoft Visual
Studio.

CEL TESTÓW

Testy jednostkowe sprawdzają: 
-poprawność generowania przedmiotów, 
-przestrzeganie ograniczenia pojemności plecaka, 
-poprawność wyboru
przedmiotów,
-działanie programu w sytuacjach skrajnych.

STRUKTURA TESTÓW

[TestClass] public class TestyProblemu

TEST GENEROWANIA PRZEDMIOTÓW

Assert.AreEqual(n, problem.wartosci.Count); Assert.AreEqual(n,
problem.wagi.Count);

TEST OGRANICZENIA POJEMNOŚCI

Assert.IsTrue(wynik.sumaWag <= pojemnosc);

TEST PEŁNEGO WYPEŁNIENIA

Assert.AreEqual(5, wynik.przedmioty.Count);

TEST PUSTEGO ROZWIĄZANIA

Assert.AreEqual(0, wynik.przedmioty.Count);

ZASTOSOWANE MECHANIZMY
-Assert.AreEqual()
-Assert.IsTrue()
-atrybuty [TestClass] i [TestMethod]
