package com.company;

import java.time.LocalDate;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        ArrayList<Persoon> personen = new ArrayList<>();
        personen.add(new Persoon("Karen", LocalDate.of(1974, 10, 28)));
        personen.add(new Persoon("Kristel", LocalDate.of(1975, 12, 10)));
        personen.add(new Persoon("Kathleen", LocalDate.of(1978, 6, 18)));
        personen.add(new Persoon("Hanne", LocalDate.of(1994, 3, 3)));
        personen.add(new Persoon("Marthe", LocalDate.of(1996, 7, 16)));
        personen.add(new Persoon("Klaasje", LocalDate.of(1995, 3, 2)));
        FilterGegevens(personen);
        for (Persoon p : personen) {
            System.out.printf("%s (%d jaar)%n", p.getNaam(), p.getLeeftijd());
        }

    }

    private static void FilterGegevens(ArrayList<Persoon> personen) {
        for (int i = 0; i < personen.size(); i++) {
            if (personen.get(i).getLeeftijd() < 30) {
                personen.remove(personen.get(i));
                i--;
            }
        }
    }

}

class Persoon implements Comparable<Persoon> {
    private String naam;
    private LocalDate geboorteDatum;

    public Persoon(String naam, LocalDate geboorteDatum) {
        this.naam = naam;
        this.geboorteDatum = geboorteDatum;
    }

    public String getNaam() {
        return naam;
    }

    public LocalDate getGeboorteDatum() {
        return geboorteDatum;
    }

    public int getLeeftijd() {
        LocalDate vandaag = LocalDate.now();
        int leeftijd = vandaag.getYear() - geboorteDatum.getYear();
        if (geboorteDatum.getDayOfYear() > vandaag.getDayOfYear()) leeftijd--;
        return leeftijd;
    }

    @Override
    public int compareTo(Persoon o) {
        return this.getLeeftijd() - o.getLeeftijd();
    }
}