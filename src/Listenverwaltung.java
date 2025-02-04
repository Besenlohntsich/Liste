import java.util.HashMap;
import java.util.Map;

public class Listenverwaltung<T> {
    private Map<String, List<T>> stacks;

    public Listenverwaltung() {
        stacks = new HashMap<>();
    }

    public void erstelleStack(String name) {
        stacks.put(name, new List<>());
    }

    public void push(String name, T element) {
        List<T> stack = stacks.get(name);
        if (stack != null) {
            stack.push(element);
        }
    }

    public T peek(String name) {
        List<T> stack = stacks.get(name);
        return stack != null ? stack.peek() : null;
    }

    public T pop(String name) {
        List<T> stack = stacks.get(name);
        return stack != null ? stack.pop() : null;
    }

    public List<T> getStack(String name) {
        return lists.get(name);
    }
}