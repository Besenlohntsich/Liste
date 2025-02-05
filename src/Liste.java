public class Liste<T> {
    private Knoten<T> erster;
    private Knoten<T> current;
    private Knoten<T> letzter;

    public Liste() {
        erster = null;
        current = null;
        letzter = null;
    }

    public boolean isEmpty() {
        return erster == null;
    }

    public boolean hasAccess() {
        return current != null;
    }

    public void toFirst() {
        current = erster;
    }

    public void toLast() {
        current = letzter;
    }

    public void next() {
        if (hasAccess()) {
            current = current.getNaechster();
        }
    }

    public void insert(T pContent) {
        Knoten<T> neu = new Knoten<>(pContent);
        if (isEmpty()) {
            erster = neu;
            letzter = neu;
            current = neu;
        } else if (current == erster) {
            neu.setNaechster(erster);
            erster = neu;
            current = neu;
        } else {
            Knoten<T> previous = erster;
            while (previous.getNaechster() != current) {
                previous = previous.getNaechster();
            }
            neu.setNaechster(current);
            previous.setNaechster(neu);
            current = neu;
        }
    }

    public void append(T pContent) {
        Knoten<T> neu = new Knoten<>(pContent);
        if (isEmpty()) {
            erster = neu;
            letzter = neu;
            current = neu;
        } else {
            letzter.setNaechster(neu);
            letzter = neu;
        }
    }

    public void remove() {
        if (hasAccess()) {
            if (current == erster) {
                erster = erster.getNaechster();
                if (erster == null) {
                    letzter = null;
                }
            } else {
                Knoten<T> previous = erster;
                while (previous.getNaechster() != current) {
                    previous = previous.getNaechster();
                }
                previous.setNaechster(current.getNaechster());
                if (current == letzter) {
                    letzter = previous;
                }
            }
            current = current.getNaechster();
        }
    }

    public T getContent() {
        if (hasAccess()) {
            return current.getDaten();
        }
        return null;
    }

    public void setContent(T pContent) {
        if (hasAccess()) {
            current.setDaten(pContent);
        }
    }

    public void concat(Liste<T> pList) {
        if (pList != null && !pList.isEmpty()) {
            if (isEmpty()) {
                erster = pList.erster;
                letzter = pList.letzter;
                current = null;
            } else {
                letzter.setNaechster(pList.erster);
                letzter = pList.letzter;
            }
            pList.erster = null;
            pList.letzter = null;
            pList.current = null;
        }
    }

    public void ausgeben() {
        Knoten<T> temp = erster;
        while (temp != null) {
            System.out.println(temp.getDaten());
            temp = temp.getNaechster();
        }
    }
    public void insertAt(T pContent, int position) {
        if (position < 0) return;

        Knoten<T> neu = new Knoten<>(pContent);
        if (position == 0 || isEmpty()) {
            neu.setNaechster(erster);
            erster = neu;
            if (letzter == null) letzter = neu;
        } else {
            Knoten<T> current = erster;
            for (int i = 0; i < position - 1 && current.getNaechster() != null; i++) {
                current = current.getNaechster();
            }
            neu.setNaechster(current.getNaechster());
            current.setNaechster(neu);
            if (neu.getNaechster() == null) letzter = neu;
        }
    }

    public T removeAt(int position) {
        if (isEmpty() || position < 0) return null;

        T removedElement;
        if (position == 0) {
            removedElement = erster.getDaten();
            erster = erster.getNaechster();
            if (erster == null) letzter = null;
        } else {
            Knoten<T> current = erster;
            for (int i = 0; i < position - 1 && current.getNaechster() != null; i++) {
                current = current.getNaechster();
            }
            if (current.getNaechster() == null) return null;
            removedElement = current.getNaechster().getDaten();
            current.setNaechster(current.getNaechster().getNaechster());
            if (current.getNaechster() == null) letzter = current;
        }
        return removedElement;
    }
}
