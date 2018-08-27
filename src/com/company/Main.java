package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Product> producten = new ArrayList<>();
        System.out.print("Geef productnaam (STOP om te stoppen): ");
        String naam = scanner.nextLine();
        while (! "STOP".equalsIgnoreCase(naam)){
            double prijs;
            do {
                System.out.print("Geef prijs (niet negatief): ");
                prijs = Double.parseDouble(scanner.nextLine());
                if (prijs < 0) System.out.println("Kan niet negatief zijn. Opnieuw.");
            }while(prijs < 0);
            producten.add(new Product(naam, prijs));
            System.out.print("Geef productnaam (STOP om te stoppen): ");
            naam = scanner.nextLine();
        }
        Collections.sort(producten);
        System.out.println("Producten gesorteerd op prijs: ");
        for(Product p: producten){
            System.out.printf("%-20s: € %.2f%n", p.getNaam(), p.getPrijs());
        }
    }
}

class Product implements Comparable<Product>{
    private String naam;
    private double prijs;

    public Product(String naam, double prijs) {
        this.naam = naam;
        if (prijs < 0) throw new IllegalArgumentException("Prijs kan niet negatief zijn");
        this.prijs = prijs;
    }

    public String getNaam() {
        return naam;
    }

    public double getPrijs() {
        return prijs;
    }

    @Override
    public int compareTo(Product o) {
        if (this.prijs < o.prijs){
            return +1;
        } if (this.prijs > o.prijs)
            return -1;
        return 0;
    }
}
