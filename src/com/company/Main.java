package com.company;

import java.time.LocalDate;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Persoon> personen = new ArrayList<>();
        System.out.print("Geef naam (<RETURN> om te stoppen): ");
        String naam =scanner.nextLine();
        while(! "".equals(naam)){
            System.out.print("Geef lengte: ");
            double lengte = Double.parseDouble(scanner.nextLine());
            System.out.print("Geef gewicht: ");
            int gewicht = Integer.parseInt(scanner.nextLine());
            personen.add(new Persoon(naam, lengte, gewicht));
            System.out.print("Geef naam (<RETURN> om te stoppen): ");
            naam =scanner.nextLine();
        }
        filterOpBMI(personen);
        System.out.println("Personen met goede BMI:");
        for(Persoon p: personen){
            System.out.printf("%s (lengte:%.2f, gewicht: %d) heeft een BMI van %.2f%n", p.getNaam(), p.getLengte(), p.getGewicht(), p.getBMI());
        }

    }

    private static void filterOpBMI(ArrayList<Persoon> personen) {
        for (int i = 0; i < personen.size(); i++) {
            if(personen.get(i).getBMI() < 18.5 || personen.get(i).getBMI() > 25){
                personen.remove(personen.get(i));
                i--;
            }
        }
    }
}
class Persoon implements Comparable<Persoon>{
    private String naam;
    private double lengte;
    private int gewicht;

    public Persoon(String naam, double lengte, int gewicht) {
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

    public int getGewicht() {
        return gewicht;
    }
    public double getBMI(){
        return gewicht / (lengte *lengte);
    }

    @Override
    public int compareTo(Persoon o) {
        if (this.getBMI() < o.getBMI()){
            return +1;
        }else if (this.getBMI() > o.getBMI()){
            return -1;
        }else {
            return 0;
        }
    }
}