package ch1;

public class LinkedStack<Item> {
    private int size;

    private class Node {
        Item item;
        Node next;
    }

    private Node first;

    LinkedStack() {
        size = 0;
        first = null;
    }

    public void push(Item item) {
        Node node = new Node();
        node.item = item;
        node.next = first;
        first = node;
        size++;
    }

    public Item pop() {
        if (first == null) {
            return null;
        }

        Node result = first;
        first = null;
        first = result.next;
        size--;
        return result.item;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public static void main(String []args)
    {
        String[] strings = {"to", "be", "or", "not", "to", "-", "be", "-", "-", "that", "-", "-", "-", "is"};
        LinkedStack<String> stack = new LinkedStack<>();
        for (String s : strings) {
            if (s.equals("-") && !stack.isEmpty()) {
                System.out.print(stack.pop() + " ");
            } else {
                stack.push(s);
            }
        }
    }
}
