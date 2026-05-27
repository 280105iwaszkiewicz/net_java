package org.example;

import java.util.ArrayList;
import java.util.List;

public class Result {
    public List<Przedmiot> elementy = new ArrayList<>();
    public int sumarycznaWartosc = 0;
    public int sumarycznaWaga = 0;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Przedmiot p : elementy) {
            sb.append(p.toString()).append("\n");
        }
        sb.append("Weight: ").append(sumarycznaWaga).append("\n");
        sb.append("Value: ").append(sumarycznaWartosc);
        return sb.toString();
    }
}
