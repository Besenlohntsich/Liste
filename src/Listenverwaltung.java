import java.util.HashMap;
import java.util.Map;

public class Listenverwaltung<ContentType> {
    private Map<String, List<ContentType>> lists;

    public Listenverwaltung() {
        lists = new HashMap<>();
    }

    public void erstelleStack(String name) {
        lists.put(name, new List<>());
    }

    public void push(String name, ContentType element) {
        List<ContentType> list = lists.get(name);
        if (list != null) {
            list.append(element);
        }
    }

    public ContentType peek(String name) {
        List<ContentType> list = lists.get(name);
        if (list != null && list.hasAccess()) {
            return list.getContent();
        }
        return null;
    }

    public ContentType pop(String name) {
        List<ContentType> list = lists.get(name);
        if (list != null && list.hasAccess()) {
            ContentType content = list.getContent();
            list.remove();
            return content;
        }
        return null;
    }

    public List<ContentType> getList(String name) {
        return lists.get(name);
    }

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