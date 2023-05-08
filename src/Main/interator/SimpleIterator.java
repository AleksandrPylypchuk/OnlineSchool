package Main.interator;

import java.util.Iterator;

public class SimpleIterator<E> implements Iterator<E> {

    private  E[] elements;
    private int currentIndex = 0;

    public SimpleIterator(E[] elements) {
        this.elements = elements;
    }

    @Override
    public boolean hasNext() {
        return currentIndex < elements.length;
    }

    @Override
    public E next() {
        if (!hasNext()) {
            throw new java.util.NoSuchElementException();
        }
        return elements[currentIndex++];
    }

    @Override
    public void remove() {
        if (currentIndex <= 0) {
            throw new IllegalStateException("next() should be called before remove()");
        }
        int length = elements.length - 1;
        E[] newElements = (E[]) new Object[length];
        System.arraycopy(elements, 0, newElements, 0, currentIndex - 1);
        System.arraycopy(elements, currentIndex, newElements, currentIndex - 1, length - currentIndex + 1);
        elements = newElements;
        currentIndex--;
    }

}