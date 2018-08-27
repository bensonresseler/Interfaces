package com.company;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
            ArrayList<Persoon> personen = new ArrayList<>();
            personen.add(new Persoon("Karen", LocalDate.of(1974, 10, 28)));
            personen.add(new Persoon("Kristel", LocalDate.of(1975, 12, 10)));
            personen.add(new Persoon("Kathleen", LocalDate.of(1978, 6, 18)));

        Collections.sort(personen);
        System.out.println("Output: ");
        for (Persoon p : personen) {
            System.out.printf("%s(%d)%n", p.getNaam(), p.getLeeftijd());
        }
    }
}

class Persoon implements Comparable<Persoon> {
    private String naam;
    private LocalDate geboortedatum;

    public Persoon(String naam, LocalDate geboortedatum) {
        this.naam = naam;
        this.geboortedatum = geboortedatum;
    }

    public String getNaam() {
        return naam;
    }

    public LocalDate getGeboortedatum() {
        return geboortedatum;
    }

    public int getLeeftijd() {
        LocalDate vandaag = LocalDate.now();
        int leeftijd = vandaag.getYear() - geboortedatum.getYear();
        if (geboortedatum.getDayOfYear() > vandaag.getDayOfYear()) {
            leeftijd--;
        }
        return leeftijd;
    }

    @Override
    public int compareTo(Persoon o) {
        if (this.getLeeftijd() - o.getLeeftijd() < 0)
            return -1;
        if (this.getLeeftijd() - o.getLeeftijd() > 0)
            return +1;
        return 0;
    }
}
