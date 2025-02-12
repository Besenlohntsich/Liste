public class List<ContentType> {
    private Knoten<ContentType> first;
    private Knoten<ContentType> current;
    private Knoten<ContentType> last;

    public List() {
        first = null;
        current = null;
        last = null;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public boolean hasAccess() {
        return current != null;
    }

    public void toFirst() {
        current = first;
    }

    public void toLast() {
        current = last;
    }

    public void next() {
        if (hasAccess()) {
            current = current.getNaechster();
        }
    }

    public void insert(ContentType pContent) {
        Knoten<ContentType> newKnoten = new Knoten<>(pContent);
        if (isEmpty()) {
            first = newKnoten;
            last = newKnoten;
            current = newKnoten;
        } else if (current == first) {
            newKnoten.setNaechster(first);
            first = newKnoten;
            current = newKnoten;
        } else {
            Knoten<ContentType> previous = first;
            while (previous.getNaechster() != current) {
                previous = previous.getNaechster();
            }
            newKnoten.setNaechster(current);
            previous.setNaechster(newKnoten);
            current = newKnoten;
        }
    }

    public void append(ContentType pContent) {
        Knoten<ContentType> newKnoten = new Knoten<>(pContent);
        if (isEmpty()) {
            first = newKnoten;
            last = newKnoten;
            current = newKnoten;
        } else {
            last.setNaechster(newKnoten);
            last = newKnoten;
        }
    }

    public void remove() {
        if (hasAccess()) {
            if (current == first) {
                first = first.getNaechster();
                if (first == null) {
                    last = null;
                }
            } else {
                Knoten<ContentType> previous = first;
                while (previous.getNaechster() != current) {
                    previous = previous.getNaechster();
                }
                previous.setNaechster(current.getNaechster());
                if (current == last) {
                    last = previous;
                }
            }
            current = current.getNaechster();
        }
    }

    public ContentType getContent() {
        if (hasAccess()) {
            return current.getDaten();
        }
        return null;
    }

    public void setContent(ContentType pContent) {
        if (hasAccess()) {
            current.setDaten(pContent);
        }
    }

    public void concat(List<ContentType> pList) {
        if (pList != null && !pList.isEmpty()) {
            if (isEmpty()) {
                first = pList.first;
                last = pList.last;
                current = null;
            } else {
                last.setNaechster(pList.first);
                last = pList.last;
            }
            pList.first = null;
            pList.last = null;
            pList.current = null;
        }
    }

    public void ausgeben() {
        Knoten<ContentType> temp = first;
        while (temp != null) {
            System.out.println(temp.getDaten());
            temp = temp.getNaechster();
        }
    }
}