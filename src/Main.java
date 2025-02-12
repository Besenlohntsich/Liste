import java.util.Scanner;


/**
 * Die Klasse Main implementiert eine Benutzeroberfläche für die Listenverwaltung.
 * Sie bietet ein menügesteuertes Interface, über das der Benutzer verschiedene Operationen
 * mit den Listen ausführen kann.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Listenverwaltung<String> listenVerwaltung = new Listenverwaltung<>();

        System.out.println("Willkommen zur Listen-Verwaltung!");
        boolean running = true;

        while (running) {
            System.out.println("\nBitte wählen Sie eine Option:");
            System.out.println("1. Neue Liste erstellen");
            System.out.println("2. Element am Ende hinzufügen ");
            System.out.println("3. Element an bestimmter Position einfügen");
            System.out.println("4. Oberstes Element anzeigen ");
            System.out.println("5. Oberstes Element entfernen ");
            System.out.println("6. Element an bestimmter Position entfernen");
            System.out.println("7. Alle Elemente einer Liste anzeigen(vorne nach hinten)");
            System.out.println("8. Beenden");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Geben Sie den Namen der neuen Liste ein: ");
                    String listeName = scanner.nextLine();
                    listenVerwaltung.erstelleStack(listeName);
                    System.out.println("Liste '" + listeName + "' erstellt.");
                    break;
                case 2:
                    System.out.print("Geben Sie den Namen der Liste ein: ");
                    String nameZumHinzufuegen = scanner.nextLine();
                    System.out.print("Geben Sie das Element ein: ");
                    String element = scanner.nextLine();
                    listenVerwaltung.push(nameZumHinzufuegen, element);
                    System.out.println("Element '" + element + "' am Ende hinzugefügt.");
                    break;
                case 3:
                    System.out.print("Geben Sie den Namen der Liste ein: ");
                    String nameZumEinfuegen = scanner.nextLine();
                    System.out.print("Geben Sie das Element ein: ");
                    String elementZumEinfuegen = scanner.nextLine();
                    System.out.print("Geben Sie die Position zum Einfügen ein(das erste element ist 0): ");
                    int positionZumEinfuegen = scanner.nextInt();
                    scanner.nextLine(); // Verbrauche den Zeilenumbruch
                    listenVerwaltung.insertAt(nameZumEinfuegen, elementZumEinfuegen, positionZumEinfuegen);
                    System.out.println("Element '" + elementZumEinfuegen + "' an Position " + positionZumEinfuegen + " eingefügt.");
                    break;
                case 4:
                    System.out.print("Geben Sie den Namen der Liste ein: ");
                    String nameZumAnzeigen = scanner.nextLine();
                    String oberstesElement = listenVerwaltung.peek(nameZumAnzeigen);
                    if (oberstesElement != null) {
                        System.out.println("Oberstes Element: " + oberstesElement);
                    } else {
                        System.out.println("Die Liste ist leer oder existiert nicht.");
                    }
                    break;
                case 5:
                    System.out.print("Geben Sie den Namen der Liste ein: ");
                    String nameZumEntfernen = scanner.nextLine();
                    String entferntesElement = listenVerwaltung.pop(nameZumEntfernen);
                    if (entferntesElement != null) {
                        System.out.println("Entferntes Element: " + entferntesElement);
                    } else {
                        System.out.println("Die Liste ist leer oder existiert nicht.");
                    }
                    break;
                case 6:
                    System.out.print("Geben Sie den Namen der Liste ein: ");
                    String nameZumEntfernenAnPosition = scanner.nextLine();
                    System.out.print("Geben Sie die Position zum Entfernen ein: ");
                    int positionZumEntfernen = scanner.nextInt();
                    scanner.nextLine();
                    String entferntesElementAnPosition = listenVerwaltung.removeAt(nameZumEntfernenAnPosition, positionZumEntfernen);
                    if (entferntesElementAnPosition != null) {
                        System.out.println("Entferntes Element an Position " + positionZumEntfernen + ": " + entferntesElementAnPosition);
                    } else {
                        System.out.println("Die Position existiert nicht oder die Liste ist leer.");
                    }
                    break;
                case 7:
                    System.out.print("Geben Sie den Namen der Liste ein: ");
                    String nameZumAusgeben = scanner.nextLine();
                    List<String> liste = listenVerwaltung.getList(nameZumAusgeben);
                    if (liste != null) {
                        System.out.println("Elemente in der Liste '" + nameZumAusgeben + "':");
                        liste.ausgeben();
                    } else {
                        System.out.println("Die Liste existiert nicht.");
                    }
                    break;
                case 8:
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