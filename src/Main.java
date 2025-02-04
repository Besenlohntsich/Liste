import java.awt.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Listenverwaltung<String> stackVerwaltung = new Listenverwaltung<>();

        System.out.println("Willkommen zur Listen-Verwaltung!");
        boolean running = true;

        while (running) {
            System.out.println("\nBitte wählen Sie eine Option:");
            System.out.println("1. Neue Liste erstellen");
            System.out.println("2. Element hinzufügen (Push)");
            System.out.println("3. Oberstes Element anzeigen (Peek)");
            System.out.println("4. Oberstes Element entfernen (Pop)");
            System.out.println("5. Alle Elemente einer Liste anzeigen");
            System.out.println("6. Beenden");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Verbrauche den Zeilenumbruch

            switch (choice) {
                case 1:
                    System.out.print("Geben Sie den Namen der neuen Liste ein: ");
                    String stackName = scanner.nextLine();
                    stackVerwaltung.erstelleStack(stackName);
                    System.out.println("Stack '" + stackName + "' erstellt.");
                    break;
                case 2:
                    System.out.print("Geben Sie den Namen der Liste ein: ");
                    String nameZumHinzufuegen = scanner.nextLine();
                    System.out.print("Geben Sie das Element ein: ");
                    String element = scanner.nextLine();
                    stackVerwaltung.push(nameZumHinzufuegen, element);
                    System.out.println("Element '" + element + "' hinzugefügt.");
                    break;
                case 3:
                    System.out.print("Geben Sie den Namen der Liste ein: ");
                    String nameZumAnzeigen = scanner.nextLine();
                    String oberstesElement = stackVerwaltung.peek(nameZumAnzeigen);
                    if (oberstesElement != null) {
                        System.out.println("Oberstes Element: " + oberstesElement);
                    } else {
                        System.out.println("Die Liste ist leer oder existiert nicht.");
                    }
                    break;
                case 4:
                    System.out.print("Geben Sie den Namen der Liste ein: ");
                    String nameZumEntfernen = scanner.nextLine();
                    String entferntesElement = Listenverwaltung.pop(nameZumEntfernen);
                    if (entferntesElement != null) {
                        System.out.println("Entferntes Element: " + entferntesElement);
                    } else {
                        System.out.println("Die Liste ist leer oder existiert nicht.");
                    }
                    break;
                case 5:
                    System.out.print("Geben Sie den Namen des Stacks ein: ");
                    String nameZumAusgeben = scanner.nextLine();
                    List<String> stack = stackVerwaltung.getList(nameZumAusgeben);
                    if (stack != null) {
                        System.out.println("Elemente im Stack '" + nameZumAusgeben + "':");
                        stack.ausgeben();
                    } else {
                        System.out.println("Die Liste existiert nicht.");
                    }
                    break;
                case 6:
                    running = false;
                    System.out.println("Programm beendet.");
                    break;
                default:
                    System.out.println("Ungültige Auswahl. Bitte versuchen Sie es erneut.");
            }
        }

        scanner.close();
    }
}