package ch1;

import java.util.Iterator;

public class LinkedBag <Item> {
    private class Node {
        Item item;
        Node next;
    }

    private class LinkedBagIterator implements Iterator<Item> {
        private Node cur;

        LinkedBagIterator() {
            cur = first;
        }

        @Override
        public boolean hasNext() {
            return cur == null;
        }

        @Override
        public Item next() {
            Item result = cur.item;
            cur = cur.next;
            return result;
        }
    }

    private Node first;

    private int size;

    LinkedBag() {
        first = null;
        size = 0;
    }

    public void add(Item item) {
        Node node = new Node();
        node.item = item;
        node.next = first;
        first = node;
        size++;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public Iterator<Item> iterator() {
        return new LinkedBagIterator();
    }

    public static void main(String []args)
    {
        String[] strings = {"to", "be", "or", "not", "to", "-", "be", "-", "-", "that", "-", "-", "-", "is"};
        LinkedBag<String> bag = new LinkedBag<>();
        for (String s : strings) {
            if (!s.equals("-") ) {
                bag.add(s);
            }
        }

        Iterator<String> iterator = bag.iterator();
        while (!iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
    }
}
