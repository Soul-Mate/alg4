package ch1;

public class LinkedQueue<Item> {
    private class Node {
        Item item;
        Node next;
    }

    private Node first;

    private Node last;

    private int size;

    LinkedQueue() {
        first = last = null;
        size = 0;
    }

    public void enqueue(Item item) {
        Node node = new Node();
        node.item = item;
        if (first == null) {
            first = last = node;
        } else {
            last.next = node;
            last = node;
        }
        size++;
    }

    public Item dequeue() {
        if (isEmpty()) {
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
        LinkedQueue<String> queue = new LinkedQueue<>();
        for (String s : strings) {
            if (s.equals("-") && !queue.isEmpty()) {
                System.out.print(queue.dequeue() + " ");
            } else {
                queue.enqueue(s);
            }
        }
    }
}
