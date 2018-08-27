package com.company;

import java.time.LocalDate;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Persoon> personen = new ArrayList<>();
        String naam;
        Double lengte;
        Double gewicht;

        System.out.print("Geef naam (<RETURN> om te stoppen): ");
        naam = scanner.nextLine();

        while (!naam.equals("")) {

            System.out.print("Geef lengte: ");
            lengte = Double.parseDouble(scanner.nextLine());

            System.out.print("Geef gewicht: ");
            gewicht = Double.parseDouble(scanner.nextLine());

            personen.add(new Persoon(naam, lengte, gewicht));

            System.out.print("Geef naam (<RETURN> om te stoppen): ");
            naam = scanner.nextLine();
        }

        Collections.sort(personen);
        System.out.println("Personen gesorteerd op BMI: ");
        for(Persoon p: personen){
            System.out.printf("%s (lengte: %.2f, gewicht: %.2f) heeft een BMI van %.2f.%n", p.getNaam(), p.getLengte(), p.getGewicht(), p.getBMI());
        }
    }
}

class Persoon implements Comparable<Persoon>{
    private String naam;
    private double lengte;
    private double gewicht;

    public Persoon(String naam, double lengte, double gewicht) {
        this.naam = naam;
        this.lengte = lengte;
        this.gewicht = gewicht;
    }

    public String getNaam() {
        return naam;
    }

    public double getLengte() {
        return lengte;
    }

    public double getGewicht() {
        return gewicht;
    }

    public double getBMI() {
        double bmi = getGewicht()/ (getLengte() * getLengte());
        return bmi;
    }


    @Override
    public int compareTo(Persoon o) {
        if (this.getBMI() - o.getBMI() < 0) {
            return +1;
        }
        if (this.getBMI() - o.getBMI() > 0) {
            return -1;
        } return 0;
    }
}
