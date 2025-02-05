public class List<ContentType> {
    private class Node {
        private ContentType content;
        private Node next;

        public Node(ContentType pContent) {
            content = pContent;
            next = null;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node pNext) {
            next = pNext;
        }

        public ContentType getContent() {
            return content;
        }

        public void setContent(ContentType pContent) {
            content = pContent;
        }
    }

    private Node first;
    private Node current;
    private Node last;

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
            current = current.getNext();
        }
    }

    public void insert(ContentType pContent) {
        Node newNode = new Node(pContent);
        if (isEmpty()) {
            first = newNode;
            last = newNode;
            current = newNode;
        } else if (current == first) {
            newNode.setNext(first);
            first = newNode;
            current = newNode;
        } else {
            Node previous = first;
            while (previous.getNext() != current) {
                previous = previous.getNext();
            }
            newNode.setNext(current);
            previous.setNext(newNode);
            current = newNode;
        }
    }

    public void append(ContentType pContent) {
        Node newNode = new Node(pContent);
        if (isEmpty()) {
            first = newNode;
            last = newNode;
            current = newNode;
        } else {
            last.setNext(newNode);
            last = newNode;
        }
    }

    public void remove() {
        if (hasAccess()) {
            if (current == first) {
                first = first.getNext();
                if (first == null) {
                    last = null;
                }
            } else {
                Node previous = first;
                while (previous.getNext() != current) {
                    previous = previous.getNext();
                }
                previous.setNext(current.getNext());
                if (current == last) {
                    last = previous;
                }
            }
            current = current.getNext();
        }
    }

    public ContentType getContent() {
        if (hasAccess()) {
            return current.getContent();
        }
        return null;
    }

    public void setContent(ContentType pContent) {
        if (hasAccess()) {
            current.setContent(pContent);
        }
    }

    public void concat(List<ContentType> pList) {
        if (pList != null && !pList.isEmpty()) {
            if (isEmpty()) {
                first = pList.first;
                last = pList.last;
                current = null;
            } else {
                last.setNext(pList.first);
                last = pList.last;
            }
            pList.first = null;
            pList.last = null;
            pList.current = null;
        }
    }

    public void ausgeben() {
        Node temp = first;
        while (temp != null) {
            System.out.println(temp.getContent());
            temp = temp.getNext();
        }
    }
}