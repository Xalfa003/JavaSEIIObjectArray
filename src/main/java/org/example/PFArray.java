package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class PFArray {
    private ArrayList<Integer> values;

    // Konstruktor pro vytvoření prázdného pole
    public PFArray() {
        this.values = new ArrayList<>();
    }

    // Konstruktor pro vytvoření pole s konkrétními hodnotami
    public PFArray(ArrayList<Integer> values) {
        this.values = new ArrayList<>(values);
    }

    // Vytvoření pole - náhodně
    public void createArray(ArrayList<Integer> values) {
        if (values == null) {
            Random rand = new Random();
            this.values.clear();
            for (int i = 0; i < 10; i++) {
                this.values.add(rand.nextInt(101)); // náhodná čísla mezi 0 a 100
            }
        } else {
            this.values = new ArrayList<>(values);
        }
    }

    // Vytvoření pole -  manuálně
    public void createManual() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Zadejte čísla pro nové pole (oddělená mezerou, například 1 2 3 4): ");
        String input = scanner.nextLine();
        String[] tokens = input.split("\\s+");
        ArrayList<Integer> newValues = new ArrayList<>();
        for (String token : tokens) {
            try {
                newValues.add(Integer.parseInt(token));
            } catch (NumberFormatException e) {
                System.out.println("Neplatné číslo: " + token);
            }
        }
        this.values = new ArrayList<>(newValues);
        System.out.println("Pole bylo vytvořeno na základě zadaných hodnot.");
    }

    // Vytištění pole
    public void printArray() {
        System.out.println(this.values);
    }

    // Vrácení pole
    public ArrayList<Integer> getArray() {
        return this.values;
    }

    // Přidání čísla do pole
    public void addNumber(int number) {
        this.values.add(number);
    }

    // Vyhledání největšího čísla
    public Integer findMax() {
        if (this.values.isEmpty()) return null;
        return Collections.max(this.values);
    }

    // Vyhledání nejmenšího čísla
    public Integer findMin() {
        if (this.values.isEmpty()) return null;
        return Collections.min(this.values);
    }

    // Vrátí součet všech prvků v poli
    public int sumAll() {
        int sum = 0;
        for (int number : this.values) {
            sum += number;
        }
        return sum;
    }

    // Odstranění čísla z pole
    public void removeNumber(int number) {
        this.values.remove(Integer.valueOf(number));
    }

    // Smazání celého pole
    public void clearArray() {
        this.values.clear();
    }

    // Přegenerování čísel v poli
    public void regenerateArray() {
        createArray(null);
    }

    @Override
    public String toString() {
        return this.values.toString();
    }
}
