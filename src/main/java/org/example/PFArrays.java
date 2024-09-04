package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class PFArrays {
    private static ArrayList<PFArray> arrays = new ArrayList<>();
    private static Integer selectedIndex = null;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Vytvořit nové pole");
            System.out.println("2. Vybrat pole");
            System.out.println("3. Pracovat s vybraným polem");
            System.out.println("4. Vyhledat pole s největším součtem prvků");
            System.out.println("5. Vyhledat pole s nejmenším součtem prvků");
            System.out.println("6. Konec");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.println("1. Vytvořit pole s náhodnými hodnotami");
                    System.out.println("2. Vytvořit pole s manuálně zadanými hodnotami");
                    String createChoice = scanner.nextLine();

                    PFArray newArray = new PFArray();

                    if (createChoice.equals("1")) {
                        newArray.createArray(null);
                        System.out.println("Pole bylo vytvořeno s náhodnými hodnotami.");
                    } else if (createChoice.equals("2")) {
                        newArray.createManual();
                    } else {
                        System.out.println("Neplatná volba.");
                        break;
                    }

                    arrays.add(newArray);
                    System.out.println("Nové pole bylo vytvořeno.");
                    break;

                case "2":
                    if (arrays.isEmpty()) {
                        System.out.println("Žádná pole nejsou k dispozici.");
                        break;
                    }
                    for (int i = 0; i < arrays.size(); i++) {
                        System.out.println(i + ": Pole s hodnotami " + arrays.get(i));
                    }
                    System.out.print("Vyberte číslo pole: ");
                    selectedIndex = Integer.parseInt(scanner.nextLine());
                    if (selectedIndex >= 0 && selectedIndex < arrays.size()) {
                        System.out.println("Vybrali jste pole " + selectedIndex + ".");
                    } else {
                        System.out.println("Neplatné číslo pole.");
                        selectedIndex = null;
                    }
                    break;

                case "3":
                    if (selectedIndex == null || selectedIndex >= arrays.size()) {
                        System.out.println("Nejprve vyberte platné pole.");
                        break;
                    }
                    PFArray selectedArray = arrays.get(selectedIndex);
                    System.out.println("\nOperace s vybraným polem:");
                    System.out.println("1. Vytvořit nové pole (přegenerovat)");
                    System.out.println("2. Přidat číslo");
                    System.out.println("3. Vyhledat největší číslo");
                    System.out.println("4. Vyhledat nejmenší číslo");
                    System.out.println("5. Součet všech prvků");
                    System.out.println("6. Odstranit číslo");
                    System.out.println("7. Smazat celé pole");
                    System.out.println("8. Vytištění pole");
                    System.out.println("9. Vrátit pole");
                    System.out.println("10. Zpět");

                    String subChoice = scanner.nextLine();

                    switch (subChoice) {
                        case "1":
                            selectedArray.regenerateArray();
                            System.out.println("Pole bylo přegenerováno.");
                            break;

                        case "2":
                            System.out.print("Zadejte číslo k přidání: ");
                            int addNumber = Integer.parseInt(scanner.nextLine());
                            selectedArray.addNumber(addNumber);
                            System.out.println("Číslo " + addNumber + " bylo přidáno.");
                            break;

                        case "3":
                            System.out.println("Největší číslo v poli je " + selectedArray.findMax() + ".");
                            break;

                        case "4":
                            System.out.println("Nejmenší číslo v poli je " + selectedArray.findMin() + ".");
                            break;

                        case "5":
                            System.out.println("Součet všech prvků v poli je " + selectedArray.sumAll() + ".");
                            break;

                        case "6":
                            System.out.print("Zadejte číslo k odstranění: ");
                            int removeNumber = Integer.parseInt(scanner.nextLine());
                            selectedArray.removeNumber(removeNumber);
                            System.out.println("Číslo " + removeNumber + " bylo odstraněno.");
                            break;

                        case "7":
                            selectedArray.clearArray();
                            System.out.println("Pole bylo smazáno.");
                            break;

                        case "8":
                            selectedArray.printArray();
                            break;

                        case "9":
                            System.out.println("Pole: " + selectedArray.getArray());
                            break;

                        case "10":
                            continue;

                        default:
                            System.out.println("Neplatná volba.");
                            break;
                    }
                    break;

                case "4":
                    if (arrays.isEmpty()) {
                        System.out.println("Žádná pole nebyla vytvořena.");
                        break;
                    }
                    int maxSumIndex = 0;
                    int maxSum = arrays.get(0).sumAll();
                    for (int i = 1; i < arrays.size(); i++) {
                        int currentSum = arrays.get(i).sumAll();
                        if (currentSum > maxSum) {
                            maxSum = currentSum;
                            maxSumIndex = i;
                        }
                    }
                    System.out.println("Pole s největším součtem prvků je pole " + maxSumIndex + ".");
                    break;

                case "5":
                    if (arrays.isEmpty()) {
                        System.out.println("Žádná pole nebyla vytvořena.");
                        break;
                    }
                    int minSumIndex = 0;
                    int minSum = arrays.get(0).sumAll();
                    for (int i = 1; i < arrays.size(); i++) {
                        int currentSum = arrays.get(i).sumAll();
                        if (currentSum < minSum) {
                            minSum = currentSum;
                            minSumIndex = i;
                        }
                    }
                    System.out.println("Pole s nejmenším součtem prvků je pole " + minSumIndex + ".");
                    break;

                case "6":
                    System.out.println("Konec programu.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Neplatná volba.");
                    break;
            }
        }
    }
}
