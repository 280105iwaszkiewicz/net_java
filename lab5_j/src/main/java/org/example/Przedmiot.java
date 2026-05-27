package org.example;

public class Przedmiot {
    public int id;
    public int wartosc;
    public int waga;

    public Przedmiot(int id, int wartosc, int waga) {
        this.id = id;
        this.wartosc = wartosc;
        this.waga = waga;
    }

    @Override
    public String toString() {
        return "No: " + id + " v: " + wartosc + " w: " + waga;
    }
}
