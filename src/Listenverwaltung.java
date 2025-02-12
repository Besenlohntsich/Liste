import java.util.HashMap;
import java.util.Map;

/**
 * Die Klasse Listenverwaltung verwaltet mehrere Listen und bietet Methoden zur Manipulation dieser Listen.
 * Sie verwendet eine HashMap, um Listen anhand von Namen zu speichern und abzurufen.
 *
 * @param <ContentType> Der Typ der Elemente, die in den Listen gespeichert werden.
 */
public class Listenverwaltung<ContentType> {
    private Map<String, List<ContentType>> lists;
    /** HASHMap zur Speicherung der Listen, mit dem Listennamen als Schlüssel. */


    public Listenverwaltung() {
        lists = new HashMap<>();
    }

    /**
     * Erstellt eine neue leere Liste mit dem angegebenen Namen.
     *
     * @param name Der Name der neuen Liste.
     */
    public void erstelleList(String name) {
        lists.put(name, new List<>());
    }
    /**
     * Fügt ein Element am Ende der spezifizierten Liste hinzu.
     *
     * @param name Der Name der Liste.
     * @param element Das hinzuzufügende Element.
     */
    public void push(String name, ContentType element) {
        List<ContentType> list = lists.get(name);
        if (list != null) {
            list.append(element);
        }
    }
    /**
     * Gibt das oberste Element der spezifizierten Liste zurück, ohne es zu entfernen.
     *
     * @param name Der Name der Liste.
     * @return Das oberste Element oder null, wenn die Liste leer ist.
     */
    public ContentType peek(String name) {
        List<ContentType> list = lists.get(name);
        if (list != null && list.hasAccess()) {
            return list.getContent();
        }
        return null;
    }
    /**
     * Entfernt und gibt das oberste Element der spezifizierten Liste zurück.
     *
     * @param name Der Name der Liste.
     * @return Das entfernte Element oder null, wenn die Liste leer ist.
     */
    public ContentType pop(String name) {
        List<ContentType> list = lists.get(name);
        if (list != null && list.hasAccess()) {
            ContentType content = list.getContent();
            list.remove();
            return content;
        }
        return null;
    }
    /**
     * Gibt die Liste mit dem spezifizierten Namen zurück.
     *
     * @param name Der Name der Liste.
     * @return Die Liste oder null, wenn keine Liste mit diesem Namen existiert.
     */
    public List<ContentType> getList(String name) {
        return lists.get(name);
    }
    /**
     * Fügt ein Element an einer bestimmten Position in die spezifizierte Liste ein.
     *
     * @param name Der Name der Liste.
     * @param element Das einzufügende Element.
     * @param position Die Position, an der das Element eingefügt werden soll.
     */
    public void insertAt(String name, ContentType element, int position) {
        List<ContentType> list = lists.get(name);
        if (list != null) {
            list.toFirst();
            for (int i = 0; i < position && list.hasAccess(); i++) {
                list.next();
            }
            list.insert(element);
        }
    }
    /**
     * Entfernt und gibt das Element an einer bestimmten Position in der spezifizierten Liste zurück.
     *
     * @param name Der Name der Liste.
     * @param position Die Position des zu entfernenden Elements.
     * @return Das entfernte Element oder null, wenn die Position ungültig ist.
     */
    public ContentType removeAt(String name, int position) {
        List<ContentType> list = lists.get(name);
        if (list != null) {
            list.toFirst();
            for (int i = 0; i < position && list.hasAccess(); i++) {
                list.next();
            }
            if (list.hasAccess()) {
                ContentType content = list.getContent();
                list.remove();
                return content;
            }
        }
        return null;
    }
}