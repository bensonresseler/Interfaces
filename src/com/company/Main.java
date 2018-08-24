package com.company;

import java.util.ArrayList;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {
        ArrayList<Persoon> personen = new ArrayList<Persoon>();
        personen.add(new Persoon("Karen", "Damen"));
        personen.add(new Persoon("Kristel", "Aerts"));
        personen.add(new Persoon("Kathleen", "Aerts"));

        Collections.sort(personen);
        for (Persoon p :personen){
            System.out.printf("%s %s%n", p.getVoornaam(), p.getAchternaam());
        }
    }
}

class Persoon implements Comparable<Persoon>{
    private String voornaam;
    private String achternaam;

    public Persoon(String voornaam, String achternaam) {
        this.voornaam = voornaam;
        this.achternaam = achternaam;
    }

    public String getVoornaam() {
        return voornaam;
    }

    public String getAchternaam() {
        return achternaam;
    }

    @Override
    public int compareTo(Persoon o) {
        int checkAchternaam = this.achternaam.compareTo(o.achternaam);
        if (checkAchternaam == 0){
            return this.voornaam.compareTo(o.voornaam);
        } else return checkAchternaam;
    }
}
