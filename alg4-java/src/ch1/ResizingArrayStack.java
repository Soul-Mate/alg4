package ch1;

import java.util.Iterator;

public class ResizingArrayStack<Item> {
    private class ReverseIterator implements Iterator<Item> {
        private int i = size;

        @Override
        public boolean hasNext() {
            return i > 0;
        }

        @Override
        public Item next() {
            return elements[--i];
        }

        @Override
        public void remove() {

        }
    }

    private int size;

    private Item[] elements;

    ResizingArrayStack(int cap) {
        this.elements = (Item[]) (new Object[cap]);
        this.size = 0;
    }

    public Iterator<Item> iterator() {
        return new ReverseIterator();
    }

    public void push(Item item) {
        // 触发扩容
        if (size == elements.length)
            resize(elements.length * 2);
        elements[size++] = item;
    }

    public Item pop() {
        if (size == 0)
            throw new IllegalArgumentException("stack is empty");

        // stack 的区间在 [0, size)
        Item result = elements[--size];
        elements[size] = null;

        // 触发缩容
        if (size > 0 && size == elements.length / 4)
            resize(elements.length / 2);

        return result;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    private void resize(int newCapacity) {
        Item[] newElements = (Item[]) (new Object[newCapacity]);
        for (int i = 0; i < size; i++) {
            newElements[i] = elements[i];
            elements[i] = null;
        }

        elements = newElements;
    }

    public static void main(String[] args) {
        String[] strings = {"to", "be", "or", "not", "to", "-", "be", "-", "-", "that", "-", "-", "-", "is"};
        ResizingArrayStack<String> stack = new ResizingArrayStack<>(strings.length / 2);
        for (String s : strings) {
            if (s.equals("-") && !stack.isEmpty()) {
                System.out.print(stack.pop() + " ");
            } else {
                stack.push(s);
            }
        }
    }
}
