import java.util.HashMap;
import java.util.Map;

public class Listenverwaltung<T> {
    private Map<String, Liste<T>> listen;

    public Listenverwaltung() {
        listen = new HashMap<>();
    }

    public void erstelleStack(String name) {
        listen.put(name, new Liste<>());
    }

    public void push(String name, T element) {
        Liste<T> liste = listen.get(name);
        if (liste != null) {
            liste.append(element);
        }
    }

    public T peek(String name) {
        Liste<T> liste = listen.get(name);
        if (liste != null && !liste.isEmpty()) {
            liste.toLast();
            return liste.getContent();
        }
        return null;
    }

    public T pop(String name) {
        Liste<T> liste = listen.get(name);
        if (liste != null && !liste.isEmpty()) {
            liste.toLast();
            T element = liste.getContent();
            liste.remove();
            return element;
        }
        return null;
    }

    public Liste<T> getList(String name) {
        return listen.get(name);
    }
}